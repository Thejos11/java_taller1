package org.example;

public class SwitchTradicional {
    public static void main(String[] args) {
    System.out.println("--- Switch tradicional ---");
    int dia = 6;
    String jornada;
    switch (dia) {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
            jornada = "Jornada laboral completa";
            break;
        case 6:
            jornada = "Media jornada (sabado)";
            break;
        case 7:
            jornada = "Dia de descanso (domingo)";
            break;
        default:
            jornada = "Dia invalido";
            break;
    }
    System.out.println("Dia " + dia + ": " + jornada);
}
}
