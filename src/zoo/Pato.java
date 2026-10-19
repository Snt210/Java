package zoo;

import java.util.Scanner;

public class Pato extends Animal implements Terreste, Aereo, Acuatico {

    public Pato(String nombre, Integer edad, Double peso) {
        super(nombre, edad, peso);
        Scanner input = new Scanner(System.in);
    }

    @Override
    public void emitirSonido() {
        System.out.println(" cuak y eso ");
    }

    @Override
    public void caminar() {
        System.out.println("camino como de pato");
    }

    @Override
    public void volar() {
        System.out.println("mira como vuelo");
    }

    @Override
    public void correr() {
        emitirSonido();
        System.out.println("corro bien papoi");
        emitirSonido();
    }

    @Override
    public void moverse() {
        System.out.println("nado y duermo si o q");
        dormir();
    }

    @Override
    public void nadar() {
        System.out.println("Nado como el del subnautica");
    }

    public void menu() {
        Boolean flag = true;

        do {
            System.out.println("menu de " + getNombre() + " ;");
            System.out.println("1. comer");
            System.out.println("2. comer alimento");
            System.out.println("3. poner a dormir");
            System.out.println("4. emitir sonido");
            System.out.println("5. moverse");
            System.out.println("6. cazar");
            System.out.println("7. caminar");
            System.out.println("8. correr");
            System.out.println("9. volar");
            System.out.println("10. nadar");
            System.out.println("11. editar datos generales");
            System.out.println("12. data");
            System.out.println("0. salir");

            switch (this.input.nextInt()) {
                case 0 ->
                    flag = !flag;
                case 1 ->
                    comer();
                case 2 ->
                    comer(this.input.next());
                case 3 ->
                    dormir();
                case 4 ->
                    emitirSonido();
                case 5 ->
                    moverse();
                case 6 ->
                    caminar();
                case 7 ->
                    caminar();
                case 8 ->
                    correr();
                case 9 ->
                    volar();
                case 10 ->
                    nadar();
                case 11 ->
                    editarDatosGenerales();
                case 13 -> {
                    System.out.println("nombre:" + getNombre());

                    System.out.println("edad" + getEdad());

                    System.out.println("Peso" + getPeso());

                }
                default ->
                    System.out.println("eso no esta");
            }

        } while (flag);
    }

}
