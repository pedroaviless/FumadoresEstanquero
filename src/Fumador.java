public class Fumador extends Thread{

    private int id;
    private Ingrediente ingrediente;
    private Mesa mesa;

    public Fumador(int id, Ingrediente ingrediente, Mesa mesa){
        this.id = id;
        this.ingrediente = ingrediente;
        this.mesa = mesa;

    }

    @Override
    public void run() {
        try{
            while (true){
                mesa.esperarIngredientesPara(ingrediente);
                if (Thread.interrupted())return;
                mesa.recogerIngredientes(id);

                System.out.println(" [Fumador " + id + "] fumando...");
                Thread.sleep((int)(Math.random()*600 +400));
            }
        } catch (InterruptedException e){
            System.out.println("[Fumador " + id + "] finaliza");
        }
    }



}
