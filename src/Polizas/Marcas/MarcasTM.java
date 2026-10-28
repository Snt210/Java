package Polizas.Marcas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MarcasTM extends AbstractTableModel {

    protected List<Marca> marcasLista;
    protected String[] encabezados = {"id", "nombre"};

    public MarcasTM() {
        marcasLista = new ArrayList<>();
    }

    @Override
    public String getColumnName(int columna) {
        return encabezados[columna];
    }

    public void vaciarLista() {
        marcasLista.clear();
    }

    @Override
    public int getRowCount() {
        return marcasLista.size();
    }

    @Override
    public int getColumnCount() {
        return encabezados.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Marca m = marcasLista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return m.getId();
            case 1:
                return m.getNombre();
            default:
                return null;
        }
    }

    public void llenar(List<Marca> lista) {
        marcasLista.addAll(lista);
    }
}