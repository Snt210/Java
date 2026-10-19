package zoo;

import java.util.Scanner;

public class Zoo {

    Scanner input = new Scanner(System.in);

    Gato ninha = new Gato("mishi", 3, 2.5, true);
    Leon simba = new Leon("Alex", 5, 120.0, 5);
    Pato cerdo = new Pato("patillo", 2, 3.0);
    Ornitorrinco perri = new Ornitorrinco("perry", 3, 4.5, true);

    Zoo() {

        System.out.println("Bienvenido al Zoo padre");
        menuPrincipal();
    }

    public void menuPrincipal() {
        boolean flag = false;

        do {
            System.out.println("Menu del Zoologico!");
            System.out.println("0. salir del programa");
            System.out.println("1. visitar a mishi (gato)");
            System.out.println("2. Visitar a Alex (Leon)");
            System.out.println("3. Visitar a patillo (pato)");
            System.out.println("4. Visitar a Perry (Ornitorrinco)");
            System.out.println("TYPE AN OPTION:");

            switch (this.input.nextInt()) {
                case 0 ->
                    System.exit(0);
                case 1 ->
                    ninha.menu();
                case 2 ->
                    simba.menu();
                case 3 ->
                    cerdo.menu();
                case 4 ->
                    perri.menu();
                default ->
                    System.out.println("opcion no validas");
            }
        } while (!flag);
    }

    public static void main(String[] args) {
      

        Zoo zoo = new Zoo();

    }
}
