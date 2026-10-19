package zoo;

import java.util.Scanner;

public class Gato extends Animal implements Terreste {

    private Boolean esDomestico = false;

    Gato(String nombre, Integer edad, Double peso, Boolean domestico) {
        super(nombre, edad, peso);
        this.esDomestico = domestico;
        Scanner input = new Scanner(System.in);
    }

    @Override
    public void emitirSonido() {
        System.out.println("meow");
    }

    @Override
    public void caminar() {
        System.out.println("mira como camino");
    }

    @Override
    public void correr() {
        System.out.println("mira como corro");
    }

    @Override
    public void moverse() {
        System.out.println("mira como me muevo");
        emitirSonido();
        System.out.println("Zzz...");
        dormir();
    }

    public void cazar() {
        System.out.println("Cazo que cazo");
        emitirSonido();
    }

    public Boolean getDomestic() {
        return this.esDomestico;
    }

    public void setDomestic() {
        System.out.println("");
        this.esDomestico = this.input.nextBoolean();
    }

    public void loEs() {

        if (esDomestico) {
            System.out.println("el gato es domestico");
        } else {
            System.out.println("tu gato NO es domestico");
        }
    }

    public void cambiarGato() {
        esDomestico = !esDomestico;
        if (esDomestico) {
            System.out.println("Domesticao");
        } else {
            System.out.println("Salio mal");
        }
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
            System.out.println("9. es domestico?");
            System.out.println("10. cambiar gato");
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
                    loEs();
                case 10 ->
                    cambiarGato();
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
