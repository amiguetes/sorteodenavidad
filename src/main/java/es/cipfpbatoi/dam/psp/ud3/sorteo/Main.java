package es.cipfpbatoi.dam.psp.ud3.sorteo;

public class Main {
    public static void main(String[] args) {

        Contenedor contenedor = new Contenedor();
        Thread bombo = new Thread(new BomboDeNumeros(contenedor),"Bombo1");
        Thread ninya1 = new Thread(new NinyoDeSanIldefonso(contenedor),"Aya");

        bombo.start();
        ninya1.start();

        try {
            bombo.join();
            ninya1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}