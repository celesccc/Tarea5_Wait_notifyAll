package es.centroafuera.psp.ejemplosJava;

import java.util.ArrayList;

public class Principal {

    final int TOTAL_ALUMNOS = 10;

    public static final ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

    public Principal() {
        for (int i = 1; i <= TOTAL_ALUMNOS; i++) {
            Alumno alumno = new Alumno();
            alumno.setName("Alumno " + i);
            alumno.start();
        }

        Profesor profesor = new Profesor();
        profesor.start();
    }
}
