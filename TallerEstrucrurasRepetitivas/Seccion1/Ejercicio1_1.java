package org.example.Seccion1;

import java.util.Scanner;

public class Ejercicio1_1 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final int CENTINELA = -99;
    long acumulador = 0;
    int contador = 0;
    System.out.print("Ingrese un número entero (" + CENTINELA + " para terminar): ");
    int numero = sc.nextInt();
    while (numero != CENTINELA) {
        acumulador += numero;
        contador++;
        System.out.print("Ingrese un número entero (" + CENTINELA + " para terminar): ");
        numero = sc.nextInt();
    }
    System.out.println("\n--- Resultados ---");
    System.out.println("Total acumulado: " + acumulador);
    System.out.println("Cantidad de números procesados: " + contador);
    sc.close();
}
}