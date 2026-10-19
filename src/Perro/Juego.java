package Perro;

import Perro.Perro.Zoo.Gato;
import java.util.Scanner;

public class Juego {

    Scanner teclado;
    Persona persona;
    Perro perro;
    Gato michi;

    Juego() {
        this.teclado = new Scanner(System.in);
        this.persona = new Persona();
        this.perro = new Perro();
        this.menu();
        this.michi = new Gato();
    }

    public void menu() {
        do {
            System.out.println("\nWelcome to Juego..."
                    + "\n0. Salir"
                    + "\n1. Gestor de Personas."
                    + "\n2. Gestor de Perros"
                    + "\nSelecciona opcion: ");
            switch (this.teclado.nextInt()) {
                case 0 ->
                    System.exit(0);
                case 1 ->
                    this.persona.menu(this.perro);
                case 2 ->
                    this.perro.menu(this.persona);
                default ->
                    System.out.println("Opcion no valida.");
            }
        } while (true);
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
    }
}