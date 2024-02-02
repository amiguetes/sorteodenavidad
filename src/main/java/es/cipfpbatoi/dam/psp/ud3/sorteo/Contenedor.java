package es.cipfpbatoi.dam.psp.ud3.sorteo;

public class Contenedor {

    private Integer numeroSorteo;
    private boolean disponible = false; // Indica si hay o no un número de sorteo disponible

    public synchronized void ponerNumero(int numero) {
        if (disponible) {
            try {
                wait(); // Espera a que el consumidor tome el número anterior
            } catch (InterruptedException e) { }
        }
        this.numeroSorteo = numero;
        disponible = true;
        notify(); // Notifica al consumidor que ya hay un número
    }

    public synchronized Integer tomarNumero() {
        if (!disponible) {
            try {
                wait(); // Espera a que el productor coloque un número
            } catch (InterruptedException e) { }
        }
        disponible = false;
        notify(); // Notifica al productor que el número ha sido tomado
        return numeroSorteo;
    }

}
