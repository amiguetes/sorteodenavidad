package es.cipfpbatoi.dam.psp.ud3.sorteo;

public class NinyoDeSanIldefonso implements Runnable{

    private Contenedor contenedor;

    public NinyoDeSanIldefonso(Contenedor c) {
        this.contenedor = c;
    }

    public void run() {
        Integer valor;
        for (int i = 1; i <= 10; i++) {
            valor = contenedor.tomarNumero();
            System.out.println("Consumidor toma: " + valor);
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) { }
        }
    }
}
