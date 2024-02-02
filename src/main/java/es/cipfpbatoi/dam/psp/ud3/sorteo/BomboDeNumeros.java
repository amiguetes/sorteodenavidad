package es.cipfpbatoi.dam.psp.ud3.sorteo;

public class BomboDeNumeros implements Runnable{

    private Contenedor contenedor;

    public BomboDeNumeros(Contenedor c) {
        this.contenedor = c;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) { // Simula la producción de 10 números de sorteo
            contenedor.ponerNumero(i);
            System.out.println("Productor pone: " + i);
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) { }
        }
    }
}
