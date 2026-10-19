package Datos_Personales;

public class sixseven {
    private int id;
    private String nombre;
    private String NumTelefonico; 
    private String Direccion;
    private String RFC;               
   
    
    public sixseven(int id, String nombre, String NumTelefonico, String Direccion, String RFC) {
        this.id = id;
        this.nombre = nombre;
        this.NumTelefonico = NumTelefonico;
        this.Direccion = Direccion;
        this.RFC = RFC;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNumTelefonico() {
        return NumTelefonico;
    }

    public void setNumTelefonico(String NumTelefonico) {
        this.NumTelefonico = NumTelefonico;
    }

    public String getDireccion(){
        return Direccion;
    }
    
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getRFC() {
        return RFC;
    }
        
    public void setRFC(String RFC){
        this.RFC = RFC;
    }
}


