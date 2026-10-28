package Polizas.Marcas;

import java.util.List;
import javax.swing.JOptionPane;

public class MarcasControl {

    private MarcasVista mv;
    private MarcasModelo mm;
    private List<Marca> lista;

    public MarcasControl(MarcasVista marcasVista) {
        this.mv = marcasVista;
        this.mm = new MarcasModelo();
        marcasEventos();
    }

    public void marcasEventos() {
        // Botón Consultar
        mv.btn1.addActionListener(e -> {
            lista = mm.read();
            mv.actualizarVista(lista);
        });

        // Botón Agregar
        mv.btn_a.addActionListener(e -> {
            Marca marca = new Marca(0, mv.txt1.getText());
            int resultado = mm.create(marca);
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Marca agregada");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar");
            }
            mv.actualizarVista(mm.read());
        });

        // Al seleccionar una fila, pone el nombre en el campo de texto
        mv.tabla.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int fila = mv.tabla.getSelectedRow();
                if (fila != -1) {
                    mv.txt1.setText((String) mv.tabla.getValueAt(fila, 1));
                }
            }
        });
    }
}