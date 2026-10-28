package Polizas.Marcas;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MarcasVista extends JPanel {

    protected JButton btn1, btn_a;
    protected JTextField txt1;
    protected JLabel lbl1, lbl2;

    protected JTable tabla;
    protected MarcasTM marcasModelo;

    protected JComboBox<Marca> cmbMarcas;

    public MarcasVista() {
        setLayout(null);

        lbl1 = new JLabel("Welcome to Marcas Admin.");
        lbl1.setBounds(350, 5, 200, 30);

        lbl2 = new JLabel("Ingresa tu nombre: ");
        lbl2.setBounds(50, 40, 150, 30);

        txt1 = new JTextField("Marca 1");
        txt1.setBounds(170, 40, 250, 30);

        cmbMarcas = new JComboBox<>();
        cmbMarcas.setBounds(500, 40, 250, 30);

        btn1 = new JButton("Consultar");
        btn1.setBounds(150, 90, 100, 30);

        btn_a = new JButton("Agregar");
        btn_a.setBounds(250, 90, 100, 30);

        marcasModelo = new MarcasTM();
        tabla = new JTable(marcasModelo);
        JScrollPane sc = new JScrollPane(tabla);
        sc.setBounds(200, 150, 800, 500);

        add(lbl1);
        add(lbl2);
        add(txt1);
        add(cmbMarcas);
        add(btn1);
        add(btn_a);
        add(sc);
    }

    public void actualizarVista(List<Marca> lista) {
        marcasModelo.vaciarLista();
        marcasModelo.llenar(lista);
        marcasModelo.fireTableDataChanged();

        cmbMarcas.removeAllItems();
        for (Marca m : lista) {
            cmbMarcas.addItem(m);
        }
    }
}