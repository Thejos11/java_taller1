package org.example;

public class Reto3Calculo {
    public static void main(String[] args) {
        String tipoEntrada = "ESTUDIANTE";
        double precioBase = 100.0;
        double precioFinal;
        if (tipoEntrada.equals("VIP")) {
            precioFinal = precioBase + precioBase * 0.10;
        } else if (tipoEntrada.equals("ESTUDIANTE")) {
            precioFinal = precioBase - precioBase * 0.50;
        } else if (tipoEntrada.equals("ADULTO_MAYOR")) {
            precioFinal = precioBase - precioBase * 0.40;
        } else {
            precioFinal = precioBase;
        }
        System.out.println("Tipo de entrada: " + tipoEntrada);
        System.out.println("Monto a pagar: $" + precioFinal);
    }
}
