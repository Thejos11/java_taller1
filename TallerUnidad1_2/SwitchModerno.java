package org.example;

public class SwitchModerno {
    public static void main(String[] args) {
    int dia = 6;
    String jornada = switch (dia) {
        case 1, 2, 3, 4, 5 -> "Jornada laboral completa";
        case 6 -> "Media jornada (sabado)";
        case 7 -> "Dia de descanso (domingo)";
        default -> "Dia invalido";
    };
    System.out.println("Dia " + dia + ": " + jornada);
}
}
