public class Estanquero extends Thread{

    private Mesa mesa;


    public Estanquero(Mesa mesa){
        this.mesa = mesa;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 15; i++) {
                Ingrediente [] valores = Ingrediente.values();
                Ingrediente a,b;
                do{
                    a = valores[(int)(Math.random()*3)];
                    b = valores[(int)(Math.random()*3)];

                }while (a == b);
                mesa.ponerIngrediente(a, b);

                Thread.sleep((int)(Math.random()*500 + 300));

            }

            System.out.println(" [Estanquero] No se pondrán más ingredientes ");
            mesa.cerrar();

        } catch (InterruptedException e){
            System.out.println(" [Estanquero] finaliza");
            mesa.cerrar();
        }
    }

}
