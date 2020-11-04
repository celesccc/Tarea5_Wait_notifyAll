package es.centroafuera.psp.ejemplosJava;

public class Profesor extends Thread {

    @Override
    public void run() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
