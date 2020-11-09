package es.centroafuera.psp.ejemplosJava;

import java.util.Random;

public class Alumno extends Thread {

    Random r = new Random();
    boolean llegaTarde = false;
    int sleepingTime = 0;

    @Override
    public void run() {
        try {
            llegaTarde = r.nextBoolean();
            if (!llegaTarde) {
                sleepingTime = r.nextInt(4000);
            } else {
                sleepingTime = r.nextInt(20000) + 5000;
            }
            sleep(sleepingTime);
            System.out.println(getName() + " ha llegado a clase");
            System.out.println(getName() + " espera a ser desinfectado");
            synchronized (Principal.alumnos){
                Principal.alumnos.add(this);
                Principal.alumnos.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
