package Perro;

import java.util.Scanner;


public class Perro {

    Scanner teclado;
    public String nombre = "paquito";
    public Integer velocidad = 0;

    Perro() {
        teclado = new Scanner(System.in);

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre() {
        System.out.println("Ingresa el nombre: ");
        this.nombre = this.teclado.next();
    }

    public Integer getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad() {
        System.out.println("Ingresa la velocidad: ");
        this.velocidad = this.teclado.nextInt();
    }

    public void Morder(Persona persona) {
        if (this.velocidad >= persona.getVelocidad()) {
            System.out.println("El perro " + this.nombre + " mordio a " + persona.getNombre());
        } else {
            System.out.println("El perro no alcanzo a " + persona.getNombre());
        }
    }

    public void menu(Persona persona) {
        boolean salir = true;

        while (salir) {

            System.out.println("\nGestor de perros.."
                    + "\n0. Salir"
                    + "\n1. Ver nombre"
                    + "\n2. Cambiar nombre"
                    + "\n3. Ver velocidad"
                    + "\n4. Cambiar velocidad"
                    + "\n5. Morder a la persona"
                    + "\nSeleciona la opcion:");
            switch (this.teclado.nextInt()) {
                case 0 ->
                    salir = false;
                case 1 ->
                    System.out.println("El nombre es " + this.getNombre());
                case 2 ->
                    this.setNombre();
                case 3 ->
                    System.out.println("La velocidad es " + this.getVelocidad());
                case 4 ->
                    this.setVelocidad();
                case 5 ->
                    this.Morder(persona);
                default ->
                    System.out.println("Opcion no valida");

            }
        }

    }

    static class Zoo {

        public Zoo() {
        }

        static class Gato {

            public Gato() {
            }
        }
    }
}