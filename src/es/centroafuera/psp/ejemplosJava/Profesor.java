package es.centroafuera.psp.ejemplosJava;

import java.util.ArrayList;

public class Profesor extends Thread {

    @Override
    public void run() {
        try {
            sleep(5000);
            System.out.println("===== Empiezo la PRIMERA desinfección =====");
            desinfectarAlumno(Principal.alumnos);
            comenzarDesinfeccion();

            sleep(31000);
            System.out.println("===== Empiezo la SEGUNDA desinfección =====");
            desinfectarAlumno(Principal.alumnos);
            comenzarDesinfeccion();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void comenzarDesinfeccion() {
        synchronized (Principal.alumnos){
            Principal.alumnos.notifyAll();
        }
    }

    public void desinfectarAlumno(ArrayList<Alumno> alumno) {
        try {
            while (true) {
                System.out.println("El profesor empieza a desinfectar al " + alumno.get(0).getName());
                sleep(1000);
                System.out.println(alumno.get(0).getName() + " desinfectado");
                alumno.remove(0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (Exception e) {
        }
    }
}
