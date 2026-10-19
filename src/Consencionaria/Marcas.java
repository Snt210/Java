package Consencionaria;
public class Marcas {
    private String nombre;
    private int id;
    
    public Marcas (int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
