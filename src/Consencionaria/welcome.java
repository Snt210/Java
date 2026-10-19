package Consencionaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class welcome extends JFrame implements ActionListener {
    
    
    JMenuBar bm;
    JMenu mArchivo, mBD;
    JMenuItem mBD_C, mBD_R;
    
    JLabel lb1, lbId, lbNombre;
    JTextField txtId, txtNombre;
    JButton consultar, agregar, actualizar, eliminar;
    JTable tabla;
    JScrollPane scrollpane;

   
    public welcome() {
        this.setBounds(150, 50, 800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        
        bm = new JMenuBar();
        this.setJMenuBar(bm);
        
        mArchivo = new JMenu("Archivo");
        bm.add(mArchivo);
        
        mBD = new JMenu("Base de datos");
        bm.add(mBD);
        
        this.mBD_C = new JMenuItem("Crear");
        mBD.add(mBD_C);
        
        this.mBD_R = new JMenuItem("Consultar");
        this.mBD_R.addActionListener(e -> {
        JOptionPane.showMessageDialog(this, "Mensajes capturado");
        consultar();
        });
        
        this.mBD_C = new JMenuItem("Actualizar");
        mBD.add(mBD_C);
        
        this.mBD_C = new JMenuItem("Eliminar");
        mBD.add(mBD_C);
        
        
        
        
        
        this.lb1 = new JLabel("Welcome to Casita.....");
        this.lb1.setBounds(300, 20, 250, 30);
        this.add(lb1);

      
        this.lbId = new JLabel("Id");
        this.lbId.setBounds(150, 50, 100, 30);
        this.add(lbId);

        this.txtId = new JTextField();
        this.txtId.setBounds(255, 50, 200, 30);
        this.add(txtId);

        // Campo Nombre
        this.lbNombre = new JLabel("Nombre");
        this.lbNombre.setBounds(150, 90, 100, 30);
        this.add(lbNombre);

        this.txtNombre = new JTextField();
        this.txtNombre.setBounds(255, 90, 200, 30);
        this.add(txtNombre);

        // Botones
        this.agregar = new JButton("Agregar...");
        this.agregar.setBounds(100, 140, 130, 30);
        this.add(agregar);

        this.consultar = new JButton("Consultar...");
        this.consultar.setBounds(240, 140, 130, 30);
        this.add(consultar);

        this.actualizar = new JButton("Actualizar...");
        this.actualizar.setBounds(380, 140, 130, 30);
        this.add(actualizar);

        this.eliminar = new JButton("Eliminar...");
        this.eliminar.setBounds(520, 140, 130, 30);
        this.add(eliminar);

        // Tabla y Scroll
        this.tabla = new JTable();
        this.scrollpane = new JScrollPane(this.tabla);
        this.scrollpane.setBounds(180, 180, 420, 220);
        this.add(scrollpane);

        // Eventos
        this.agregar.addActionListener(this);
        this.consultar.addActionListener(this);
        this.actualizar.addActionListener(this);
        this.eliminar.addActionListener(this);

        // Cargar datos al abrir la ventana
        this.consultar();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        welcome welcome = new welcome();
    }

    // Control de eventos de los botones
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

    // --- MÉTODOS CRUD ---

    public void agregar() {
        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/Polizas", "root", "");
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO marca (id, nombre) VALUES (?, ?)");

            ps.setInt(1, Integer.parseInt(this.txtId.getText()));
            ps.setString(2, this.txtNombre.getText());

            ps.executeUpdate();
            cnx.close();

            this.consultar();
        } catch (SQLException ex) {
            System.out.println("Error al agregar: " + ex.getMessage());
        }
    }

    public void consultar() {
        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/Polizas", "root", "");
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM marca");
            ResultSet rs = ps.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Marca");

            while (rs.next()) {
                Object[] fila = new Object[2];
                fila[0] = rs.getInt("id");
                fila[1] = rs.getString("nombre");
                modelo.addRow(fila);
            }

            this.tabla.setModel(modelo);
            cnx.close();
        } catch (SQLException ex) {
            System.out.println("Error al consultar: " + ex.getMessage());
        }
    }

    public void actualizar() {
        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/Polizas", "root", "");
            PreparedStatement ps = cnx.prepareStatement("UPDATE marca SET nombre = ? WHERE id = ?");

            ps.setString(1, this.txtNombre.getText());
            ps.setInt(2, Integer.parseInt(this.txtId.getText()));

            ps.executeUpdate();
            cnx.close();

            this.consultar();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar: " + ex.getMessage());
        }
    }

    public void eliminar() {
        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/Polizas", "root", "");
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM marca WHERE id = ?");

            ps.setInt(1, Integer.parseInt(this.txtId.getText()));

            ps.executeUpdate();
            cnx.close();

            this.consultar();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar: " + ex.getMessage());
        }
    }
}
