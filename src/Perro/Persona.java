package Perro;

import java.util.Scanner;

public class Persona {

    Scanner teclado;
    public String nombre = "Juan";
    public Integer velocidad = 0;

    Persona() {
        teclado = new Scanner(System.in);
    }

    public void menu(Perro perro) {
        boolean salir = true;
        while (salir) {
            System.out.println("\nGestor de personas.."
                    + "\n0. Salir"
                    + "\n1. Ver nombre"
                    + "\n2. Cambiar nombre"
                    + "\n3. Ver velocidad"
                    + "\n4. Cambiar velocidad"
                    + "\n5. Gritar"
                    + "\n6. Morder al perro"
                    + "\nSeleccciona la opcion:"
            );
            switch (this.teclado.nextInt()) {
                case 0 ->
                    salir = false;
                case 1 ->
                    System.out.println("El nombre es: " + this.getNombre());
                case 2 ->
                    this.setNombre();
                case 3 ->
                    System.out.println("La velocidad es: " + this.getVelocidad());
                case 4 ->
                    this.setVelocidad();
                case 5 ->
                    this.Gritar();
                case 6 ->
                    this.Morder(perro);

                default ->
                    System.out.println("Opcion no valida");
            }
        }
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

    public void Morder(Perro perro) {
        if (this.velocidad >= perro.getVelocidad()) {
            System.out.println("La persona " + this.nombre + " mordio a el perro " + perro.getNombre());
        } else {
            System.out.println("La persona no alcanzo a " + perro.getNombre());

        }
    }

    public void Gritar() {
        System.out.println(this.nombre + " Esta gritando");
    }
}

    
