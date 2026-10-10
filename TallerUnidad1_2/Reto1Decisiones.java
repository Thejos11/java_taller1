package org.example;

public class Reto1Decisiones {
    public static void main(String[] args){
        int edadUsuario = 28;
        if (edadUsuario < 12) {
            System.out.println("Categoria: Infante");
        } else if (edadUsuario <= 17) {
            System.out.println("Categoria: Adolescente");
        } else if (edadUsuario <= 64) {
            System.out.println("Categoria: Adulto");
        } else {
            System.out.println("Categoria: Adulto Mayor");
        }
    }

}
