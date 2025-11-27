public class Mesa {
       private Ingrediente ing1 = null;
       private Ingrediente ing2 = null;

    private boolean mesaOcupada = false;
    private boolean cerrado = false;

    public synchronized void ponerIngrediente(Ingrediente a, Ingrediente b) {
        this.ing1 = a;
        this.ing2 = b;
        mesaOcupada = true;
        System.out.println("[Mesa] El estanquero ha puesto: " + a + " y " + b );
        notifyAll();

    }

    public synchronized void esperarIngredientesPara(Ingrediente miIngrediente)throws InterruptedException{

        while (true){
            if (cerrado && !mesaOcupada){
                return;
            }
            if (mesaOcupada) {
                if (ing1 != miIngrediente && ing2 != miIngrediente){
                    return;
                }

            }
            wait();
        }
    }

    public synchronized void recogerIngredientes(int id){
        System.out.println(" [Fumador " + id + "] recoge ingredientes y se pone a fumar");

        ing1 = null;
        ing2 = null;
        mesaOcupada = false;

        notifyAll();
    }
    public synchronized void cerrar(){
        cerrado = true;
        notifyAll();
    }


}
