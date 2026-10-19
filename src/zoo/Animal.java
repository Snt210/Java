package zoo;

import java.util.Scanner;

public abstract class Animal {

    Scanner input = new Scanner(System.in);
    private String nombre;
    private Integer edad;
    private Double peso;

    Animal(String nombre, Integer edad, Double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    public abstract void emitirSonido();

    public abstract void moverse();

    public void comer() {
        System.out.println("nam nam nam");
    }

    public void comer(String alimento) {
        System.out.println("nam nam que rico " + alimento);
    }

    public void dormir() {
        System.out.println("Zzz");
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre() {
        this.nombre = this.input.next();
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad() {
        this.edad = this.input.nextInt();
    }

    public Double getPeso() {
        return this.peso;
    }

    public void setPeso() {
        this.peso = this.input.nextDouble();
    }

    public void editarDatosGenerales() {
        System.out.println("Editando datos");

        System.out.println("Escriba el nuevo nombre:");
        setNombre();

        System.out.println("Escriba la nueva edad:");
        setEdad();

        System.out.println("Escriba el nuevo peso:");
        setPeso();

        System.out.println("Datos actualizados con éxito, Nuevo nombre: " + getNombre());
    }
}
