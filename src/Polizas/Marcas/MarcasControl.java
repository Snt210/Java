package Polizas.Marcas;

import javax.swing.JOptionPane;

public class MarcasControl {

    private MarcasVista mv;
    private MarcasModelo mm;

    public MarcasControl(MarcasVista marcasVista) {
        this.mv = marcasVista;
        this.mm = new MarcasModelo();
        marcasEventos();
        consultar(); // al abrir la pantalla ya se muestran las marcas
    }

    // Conecta cada botón con su método
    public void marcasEventos() {
        mv.btn1.addActionListener(e -> consultar());
        mv.btn_a.addActionListener(e -> agregar());
        mv.btn_m.addActionListener(e -> modificar());
        mv.btn_e.addActionListener(e -> eliminar());

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

    // CONSULTAR: lee la base de datos y llena la tabla
    private void consultar() {
        mv.actualizarVista(mm.read());
    }

    // AGREGAR
    private void agregar() {
        String nombre = mv.txt1.getText().trim(); // trim quita espacios de los lados

        // Validación 1: que no esté vacío
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío");
            return;
        }

        // Validación 2: que no esté repetido
        if (mm.existe(nombre)) {
            JOptionPane.showMessageDialog(null, "Esa marca ya existe");
            return;
        }

        int resultado = mm.create(new Marca(0, nombre));
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Marca agregada");
            mv.txt1.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo agregar");
        }
        consultar();
    }

    // MODIFICAR
    private void modificar() {
        // Primero hay que tener una fila seleccionada
        int fila = mv.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona una marca de la tabla");
            return;
        }

        int id = (int) mv.tabla.getValueAt(fila, 0);
        String nombreActual = (String) mv.tabla.getValueAt(fila, 1);
        String nombreNuevo = mv.txt1.getText().trim();

        // Validación 1: que no esté vacío
        if (nombreNuevo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío");
            return;
        }

        // Validación 2: que no esté repetido
        // (si es el mismo nombre que ya tenía, no se revisa)
        if (!nombreNuevo.equalsIgnoreCase(nombreActual) && mm.existe(nombreNuevo)) {
            JOptionPane.showMessageDialog(null, "Esa marca ya existe");
            return;
        }

        int resultado = mm.update(new Marca(id, nombreNuevo));
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Marca modificada");
            mv.txt1.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo modificar");
        }
        consultar();
    }

    // ELIMINAR
    private void eliminar() {
        // Primero hay que tener una fila seleccionada
        int fila = mv.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona una marca de la tabla");
            return;
        }

        int id = (int) mv.tabla.getValueAt(fila, 0);
        String nombre = (String) mv.tabla.getValueAt(fila, 1);

        // Pregunta antes de borrar
        int opcion = JOptionPane.showConfirmDialog(null,
                "¿Seguro que quieres eliminar " + nombre + "?",
                "Confirmar", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            int resultado = mm.delete(new Marca(id, nombre));
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Marca eliminada");
                mv.txt1.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");
            }
            consultar();
        }
    }
}