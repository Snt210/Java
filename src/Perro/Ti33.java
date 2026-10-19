package Perro;

public class Ti33 {

    public class Persona {

        private String nombre;
        private Integer velocidad = 10;

        public String getNombre() {
            return this.nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Integer getVelocidad() {
            return this.velocidad;
        }

        public void setVelocidad(Integer velocidad) {
            this.velocidad = velocidad;
        }

        public void correr() {
            System.out.println(getNombre() + " esta corriendo y va a " + getVelocidad());
        }

        public void gritar(Perro perro) {
            System.out.println("ya viene el perro con");
             perro.getNombre();
        }
        
        public void morder(Persona persona) {
        if (this.getVelocidad() > persona.getVelocidad()) {
            System.out.println(this.getNombre() + " alcanzo y mordio a " + persona.getNombre());
        } else {
            System.out.println(persona.getNombre() + " fue mas rapido y " + this.getNombre() + " no pudo morderlo");
            }
        }
        
        
        
        
    }
}
