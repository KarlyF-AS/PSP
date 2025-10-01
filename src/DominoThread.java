public class DominoThread extends Thread{
    public static void main(String[] args) {
        Thread ficha5 = new DominoThread("Hilo-5", null);
        Thread ficha4 = new DominoThread("Hilo-4", ficha5);
        Thread ficha3 = new DominoThread("Hilo-3", ficha4);
        Thread ficha2 = new DominoThread("Hilo-2", ficha3);
        Thread ficha1 = new DominoThread("Hilo-1", ficha2);
        ficha1.start();
    }
        private String nome;
        private Thread fichaSiguiente;

        public DominoThread(String nome, Thread fichaSiguiente){
            this.nome = nome;
            this.fichaSiguiente = fichaSiguiente;
        }
        @Override
        public void run(){
            if (fichaSiguiente != null){
                fichaSiguiente.start();
            }
            for (int i = 1; i < 5; i++){
                System.out.println("["+ nome + "] "+ "Iteracion " + i);
                try {
                    int math = (int) (Math.random() * 500) + 100;
                    Thread.sleep(math);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (fichaSiguiente != null){
                try {
                    fichaSiguiente.join();
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Acabó hilo " + nome);
        }
}



