package Polizas.Marcas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Polizas.General.Conexion;
import Polizas.General.Conexion;
import Polizas.General.DAO;
import Polizas.General.DAO;

public class MarcasModelo extends Conexion implements DAO {

    public MarcasModelo() {
        super();
    }

    // Cierra la conexión (solo si se alcanzó a abrir)
    private void cerrar() {
        try {
            if (cnx != null) {
                cnx.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // SELECT: trae todas las marcas
    @Override
    public List read() {
        List<Marca> lista = new ArrayList<>();
        try {
            this.conectar();
            ps = cnx.prepareStatement("SELECT * FROM marca");
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Marca(rs.getInt("idMarca"), rs.getString("nombreMarca")));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            cerrar();
        }
        return lista;
    }

    // INSERT: agrega una marca nueva
    @Override
    public int create(Object obj) {
        int resultado = 0;
        try {
            this.conectar();
            Marca marca = (Marca) obj;
            ps = cnx.prepareStatement("INSERT INTO marca(nombreMarca) VALUES (?)");
            ps.setString(1, marca.getNombre());
            resultado = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            cerrar();
        }
        return resultado;
    }

    // UPDATE: cambia el nombre de la marca que tenga ese id
    @Override
    public int update(Object obj) {
        int resultado = 0;
        try {
            this.conectar();
            Marca marca = (Marca) obj;
            ps = cnx.prepareStatement("UPDATE marca SET nombreMarca = ? WHERE idMarca = ?");
            ps.setString(1, marca.getNombre());
            ps.setInt(2, marca.getId());
            resultado = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            cerrar();
        }
        return resultado;
    }

    // DELETE: borra la marca que tenga ese id
    @Override
    public int delete(Object obj) {
        int resultado = 0;
        try {
            this.conectar();
            Marca marca = (Marca) obj;
            ps = cnx.prepareStatement("DELETE FROM marca WHERE idMarca = ?");
            ps.setInt(1, marca.getId());
            resultado = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            cerrar();
        }
        return resultado;
    }

    // Devuelve true si ya hay una marca con ese nombre
    public boolean existe(String nombre) {
        boolean existe = false;
        try {
            this.conectar();
            ps = cnx.prepareStatement("SELECT COUNT(*) FROM marca WHERE nombreMarca = ?");
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                existe = rs.getInt(1) > 0; // si el conteo es mayor a 0, ya existe
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            cerrar();
        }
        return existe;
    }
}