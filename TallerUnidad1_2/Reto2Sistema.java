package org.example;

public class Reto2Sistema {
    public static void main(String[] args) {
        double calificacionFinal = 65.0;
        int porcentajeAsistencia = 75;
        boolean entregoProyectoFinal = true;
        if (calificacionFinal >= 70.0 && porcentajeAsistencia >= 80) {
            System.out.println("Dictamen: Aprobado");
        } else if (entregoProyectoFinal == true && calificacionFinal >= 60.0) {
            System.out.println("Dictamen: Pendiente de Examen Extraordinario");
        } else {
            System.out.println("Dictamen: Reprobado");
        }
    }
}