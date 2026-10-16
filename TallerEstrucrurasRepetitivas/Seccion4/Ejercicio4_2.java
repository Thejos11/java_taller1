package org.example.Seccion4;

public class Ejercicio4_2 {
    public static void main(String[] args) {

    System.out.println("Pares que no son múltiplos de 5 (1 a 50):");
    for (int i = 1; i <= 50; i++) {
        if (i % 2 != 0) {
            continue;
        }

        if (i % 5 == 0) {
            continue;
        }
        System.out.print(i + " ");
    System.out.println();
    }
    }
}