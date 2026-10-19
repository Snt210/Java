package Datos_Personales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Welcome extends JFrame implements ActionListener {      
    
    JMenuBar bm;
    
    JLabel lb1, lbId, lbNombre, lbTelefono, lbDireccion, lbRfc;
    JTextField txtId, txtNombre, txtTelefono, txtDireccion, txtRfc;
    JButton consultar, agregar, actualizar, eliminar;
    JTable tabla;
    JScrollPane scrollpane;

    public Welcome() {
        this.setBounds(150, 50, 800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        
        bm = new JMenuBar();
        this.setJMenuBar(bm);
        
        this.lb1 = new JLabel("Welcome to Data Consultor");
        this.lb1.setBounds(310, 20, 220, 30);
        this.add(lb1);

        this.lbId = new JLabel("Id");
        this.lbId.setBounds(150, 60, 100, 25);
        this.add(lbId);

        this.txtId = new JTextField();
        this.txtId.setBounds(260, 60, 250, 25);
        this.add(txtId);

        this.lbNombre = new JLabel("Nombre");
        this.lbNombre.setBounds(150, 95, 100, 25);
        this.add(lbNombre);

        this.txtNombre = new JTextField();
        this.txtNombre.setBounds(260, 95, 250, 25);
        this.add(txtNombre);

        this.lbTelefono = new JLabel("Num. Telefonico");
        this.lbTelefono.setBounds(150, 130, 100, 25);
        this.add(lbTelefono);

        this.txtTelefono = new JTextField();
        this.txtTelefono.setBounds(260, 130, 250, 25);
        this.add(txtTelefono);

        this.lbDireccion = new JLabel("Direccion");
        this.lbDireccion.setBounds(150, 165, 100, 25);
        this.add(lbDireccion);

        this.txtDireccion = new JTextField();
        this.txtDireccion.setBounds(260, 165, 250, 25);
        this.add(txtDireccion);

        this.lbRfc = new JLabel("RFC");
        this.lbRfc.setBounds(150, 200, 100, 25);
        this.add(lbRfc);

        this.txtRfc = new JTextField();
        this.txtRfc.setBounds(260, 200, 250, 25);
        this.add(txtRfc);

        this.agregar = new JButton("Agregar...");
        this.agregar.setBounds(90, 250, 125, 30);
        this.add(agregar);

        this.consultar = new JButton("Consultar...");
        this.consultar.setBounds(225, 250, 125, 30);
        this.add(consultar);

        this.actualizar = new JButton("Actualizar...");
        this.actualizar.setBounds(360, 250, 125, 30);
        this.add(actualizar);

        this.eliminar = new JButton("Eliminar...");
        this.eliminar.setBounds(495, 250, 125, 30);
        this.add(eliminar);

        this.tabla = new JTable();
        this.scrollpane = new JScrollPane(this.tabla);
        this.scrollpane.setBounds(90, 300, 530, 220);
        this.add(scrollpane);
        
        this.agregar.addActionListener(this);
        this.consultar.addActionListener(this);
        this.actualizar.addActionListener(this);
        this.eliminar.addActionListener(this);

        this.consultar();
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        Welcome Welcome = new Welcome();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.agregar) {
            this.agregar();
        } 
        if (e.getSource() == this.consultar) {
            this.consultar();
        } 
        if (e.getSource() == this.actualizar) {
            this.actualizar();
        } 
        if (e.getSource() == this.eliminar) {
            this.eliminar();
        }
    }
    
    public void agregar() {
        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/DatosPersonalesDB", "root", "");
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO datos (id, nombre, telefono, direccion, rfc) VALUES (?, ?, ?, ?, ?)");

            ps.setInt(1, Integer.parseInt(this.txtId.getText()));
            ps.setString(2, this.txtNombre.getText());
            ps.setString(3, this.txtTelefono.getText());    
            ps.setString(4, this.txtDireccion.getText());  
            ps.setString(5, this.txtRfc.getText());        

            ps.executeUpdate();
            cnx.close();

            this.consultar();
        } catch (SQLException ex) {
            System.out.println("Error al agregar: " + ex.getMessage());
        }
    }
    
public void consultar() {
        try {
            System.out.println("Intentando conectar a la base de datos...");
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/DatosPersonalesDB", "root", "");
            
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM datos");
            ResultSet rs = ps.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Num. Telefonico");
            modelo.addColumn("Direccion");
            modelo.addColumn("RFC");

            int totalFilas = 0;
            while (rs.next()) {
                totalFilas++;
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("id");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("telefono");
                fila[3] = rs.getString("direccion");
                fila[4] = rs.getString("rfc");
                
                modelo.addRow(fila);
            }
            System.out.println("+++++Registros encontrados en la tabla: " + totalFilas);

            this.tabla.setModel(modelo);
            cnx.close();
        } catch (SQLException ex) {
            System.out.println("ERROR AL CONSULTAR: " + ex.getMessage());
        }
    }

    public void actualizar() {
        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/DatosPersonalesDB", "root", "");
            PreparedStatement ps = cnx.prepareStatement("UPDATE datos SET nombre = ?, telefono = ?, direccion = ?, rfc = ? WHERE id = ?");

            ps.setString(1, this.txtNombre.getText());
            ps.setString(2, this.txtTelefono.getText());
            ps.setString(3, this.txtDireccion.getText());
            ps.setString(4, this.txtRfc.getText());
            ps.setInt(5, Integer.parseInt(this.txtId.getText())); 

            ps.executeUpdate();
            cnx.close();

            this.consultar();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar: " + ex.getMessage());
        }
    }

    public void eliminar() {
        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/DatosPersonalesDB", "root", "");
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM datos WHERE id = ?");

            ps.setInt(1, Integer.parseInt(this.txtId.getText()));

            ps.executeUpdate();
            cnx.close();

            this.consultar();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar: " + ex.getMessage());
        }
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    



