package zoo;

import java.util.Scanner;

public class Ornitorrinco extends Animal implements Acuatico, Terreste {

    private boolean esVenenoso;

    public Ornitorrinco(String nombre, Integer edad, Double peso, Boolean veneno) {
        super(nombre, edad, peso);
        this.esVenenoso = veneno;
        Scanner input = new Scanner(System.in);
    }

    public void preguntar() {
        System.out.println("Oye y perri");
    }

    public void esVenenoso() {
        if (esVenenoso) {
            System.out.println("si es venenoso");
        } else {
            System.out.println("no es venenoso");
        }
    }

    public void getVenenoso() {
        if (esVenenoso) {
            System.out.println("si es venenoso");
        } else {
            System.out.println("NO es venenoso");
        }
    }

    public void setVenenoso() {
        this.esVenenoso = !esVenenoso;
        System.out.println("listo");
    }

    @Override
    public void emitirSonido() {
        System.out.println("prrrrrr");
    }

    @Override
    public void nadar() {
        System.out.println("nadanding");
    }

    @Override
    public void caminar() {
        System.out.println("caminanding");
    }

    @Override
    public void correr() {
        System.out.println("corriending");
    }

    @Override
    public void moverse() {
        System.out.println("me toca irme a dormir");
        dormir();
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
            System.out.println("9. es Venenoso?");
            System.out.println("10. cambiar glandulas");
            System.out.println("11.preguntar");
            System.out.println("12. editar Datos Generales");
            System.out.println("13. DATA");
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
                    getVenenoso();
                case 10 ->
                    setVenenoso();
                case 11 ->
                    preguntar();
                case 12 ->
                    editarDatosGenerales();
                case 13 -> {
                    System.out.println("nombre:" + getNombre());

                    System.out.println("edad" + getEdad());

                    System.out.println("Peso" + getPeso());

                    System.out.println("venenoso?");
                    getVenenoso();

                }

                default ->
                    System.out.println("eso no esta");
            }

        } while (flag);
    }

}
