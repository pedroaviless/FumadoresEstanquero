
public class Lanzador {
    public static void main(String[] args) throws InterruptedException {
       Mesa mesa = new Mesa();

       Fumador f1 = new Fumador(1, Ingrediente.PAPEL, mesa);
       Fumador f2 = new Fumador (2, Ingrediente.TABACO, mesa);
       Fumador f3 = new Fumador (3, Ingrediente.CERILLAS, mesa);

       Estanquero estanquero = new Estanquero(mesa);

        f1.start();
        f2.start();
        f3.start();
        estanquero.start();

        estanquero.join();

        f1.interrupt();
        f2.interrupt();
        f3.interrupt();

        System.out.println("Proceso terminado correctamente,");



    }
}