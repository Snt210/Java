package zoo;

import java.util.Scanner;

public class Leon extends Animal implements Terreste {

    private Integer tamManada;

    Leon(String nombre, Integer edad, Double peso, Integer manada) {
        super(nombre, edad, peso);
        this.tamManada = manada;
        Scanner input = new Scanner(System.in);
    }

    public Integer getManada() {
        return this.tamManada;
    }

    public void setManada() {
        this.tamManada = this.input.nextInt();
    }

    public void rugir() {
        System.out.println("RAAAAAAW");
    }

    @Override
    public void emitirSonido() {
        System.out.println("raww");
    }

    @Override
    public void caminar() {
        System.out.println("when caminas");
    }

    @Override
    public void correr() {
        System.out.println("Correle gordo");
    }

    @Override
    public void moverse() {
        System.out.println("me toca ir a acostarme");
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
            System.out.println("9. rugir");
            System.out.println("10. tamaño de la manada");
            System.out.println("11. cambiar manada");
            System.out.println("12. editar datos generales");
            System.out.println("13. data");
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
                    rugir();
                case 10 ->
                    getManada();
                case 11 -> {
                    System.out.println("escriba el tamaño de la manada");
                    setManada();
                }
                case 12 ->
                    editarDatosGenerales();
                case 13 -> {
                    System.out.println("nombre:" + getNombre());

                    System.out.println("edad" + getEdad());

                    System.out.println("Peso" + getPeso());

                    System.out.println("tamaño manada" + getManada());

                }
                default ->
                    System.out.println("eso no esta");
            }

        } while (flag);
    }

}
