package org.example.AhorcadodeConsola;
    import java.util.Random;
    import java.util.Scanner;
public class Ahorcado {
    static final int MAX_INTENTOS = 6;

    static final String[] PALABRAS = {
            "JAVA", "VARIABLE", "BUCLE", "CADENA", "METODO", "CONSTANTE",
            "INTELLIJ", "COMPILADOR", "OBJETO", "ARREGLO", "ENTERO", "BOOLEANO"
    };
    static int partidasJugadas = 0;
    static int victorias = 0;
    static double puntajeAcumulado = 0.0;
    static double mejorPuntaje = 0.0;

    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcionMenu();

            switch (opcion) {
                case 1:
                    jugarPartida();
                    break;
                case 2:
                    mostrarEstadisticas();
                    break;
                case 3:
                    System.out.println("\n¡Gracias por jugar! Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción no reconocida.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    static void mostrarMenu() {
        System.out.println("\n==============================");
        System.out.println("   AHORCADO DE CONSOLA");
        System.out.println("==============================");
        System.out.println("1. Jugar");
        System.out.println("2. Ver Estadísticas");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }
    static int leerOpcionMenu() {
        int opcion = -1;
        boolean valida = false;

        while (!valida) {
            String entrada = scanner.nextLine().trim();
            try {
                opcion = Integer.parseInt(entrada);
                if (opcion >= 1 && opcion <= 3) {
                    valida = true;
                } else {
                    System.out.print("⚠ Opción fuera de rango. Ingrese 1, 2 o 3: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("⚠ Entrada no válida (\"" + entrada + "\"). Ingrese solo números 1, 2 o 3: ");
            }
        }
        return opcion;
    }
    static String leerNombreJugador() {
        String nombre = "";
        while (nombre.length() == 0) {
            System.out.print("\nIngrese su nombre: ");
            nombre = scanner.nextLine().trim().toUpperCase(); // limpieza + estandarización
            if (nombre.length() == 0) {                       // validación de contenido
                System.out.println("⚠ El nombre no puede estar vacío.");
            }
        }
        return nombre;
    }
    static void jugarPartida() {
        String nombreJugador = leerNombreJugador();
        String palabraSecreta = PALABRAS[new Random().nextInt(PALABRAS.length)];
        int maxIntentosPartida = MAX_INTENTOS;
        if (palabraSecreta.length() <= 4) {
            maxIntentosPartida = MAX_INTENTOS - 1;
        } else if (palabraSecreta.length() >= 8) {
            maxIntentosPartida = MAX_INTENTOS + 2;
        }
        int intentosRestantes = maxIntentosPartida;
        double puntaje = 0.0;
        boolean juegoGanado = false;
        char ultimaLetra = ' ';
        int aciertos = 0;
        int fallos = 0;
        int turnos = 0;
        boolean rendido = false;
        boolean pistaMostrada = false;
        StringBuilder mascara = new StringBuilder();
        for (int i = 0; i < palabraSecreta.length(); i++) {
            mascara.append(i == 0 ? "_" : " _");
        }
        StringBuilder historial = new StringBuilder();

        System.out.printf("%n¡Bienvenido, %s! Tu palabra tiene %d letras y dispones de %d intentos.%n",
                nombreJugador, palabraSecreta.length(), maxIntentosPartida);
        System.out.println("(Escribe 0 para rendirte)");

        while (intentosRestantes > 0 && !juegoGanado) {
            System.out.println("\n----------------------------------");
            System.out.println("Palabra : " + mascara);
            System.out.println("Usadas  : " + (historial.length() == 0 ? "-" : historial));
            System.out.println("Intentos restantes: " + intentosRestantes);
            if (intentosRestantes == 1 && !pistaMostrada) {
                System.out.println("💡 Pista: la palabra empieza con \"" + palabraSecreta.substring(0, 1) + "\"");
                pistaMostrada = true;
            }

            System.out.print("Ingrese una letra: ");
            String entrada = scanner.nextLine().trim();
            if (entrada.equals("0")) {
                rendido = true;
                System.out.println("Te has rendido.");
                break;
            }
            if (entrada.length() == 0) {
                System.out.println("⚠ No ingresó nada. Intente de nuevo.");
                continue;
            }
            char letra = Character.toUpperCase(entrada.charAt(0));

            if (!Character.isLetter(letra)) {
                System.out.println("⚠ Carácter inválido. Ingrese una letra del alfabeto.");
                continue;
            }
            if (historial.indexOf(String.valueOf(letra)) != -1) {
                System.out.println("⚠ Ya intentó la letra '" + letra + "'.");
                continue;
            }

            ultimaLetra = letra;
            turnos++;
            historial.append(historial.length() == 0 ? "" : ", ").append(ultimaLetra);
            boolean acierto = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                String caracterSecreto = String.valueOf(palabraSecreta.charAt(i));
                if (caracterSecreto.equalsIgnoreCase(String.valueOf(ultimaLetra))) {
                    mascara.setCharAt(i * 2, ultimaLetra);
                    acierto = true;
                }
            }

            if (acierto) {
                aciertos++;
            } else {
                fallos++;
                intentosRestantes--;
            }
            System.out.println(acierto ? "✔ ¡Bien! La letra '" + ultimaLetra + "' está en la palabra."
                    : "✘ La letra '" + ultimaLetra + "' no está en la palabra.");
            if (mascara.indexOf("_") == -1) {
                juegoGanado = true;
                break;
            }
        }
        if (juegoGanado) {
            double base = 100.0 + intentosRestantes * 10.0;
            double multiplicador = Math.max(1.0, 2.0 - 0.1 * fallos - 0.02 * turnos);
            puntaje = base * multiplicador;
        } else {
            puntaje = aciertos * 5.0;
        }
        partidasJugadas++;
        if (juegoGanado) {
            victorias++;
        }
        puntajeAcumulado += puntaje;
        if (puntaje > mejorPuntaje) {
            mejorPuntaje = puntaje;
        }
        String estadoFinal = juegoGanado ? "¡VICTORIA!" : (rendido ? "RENDICIÓN" : "DERROTA");
        mostrarResumen(nombreJugador, estadoFinal, palabraSecreta,
                intentosRestantes, maxIntentosPartida, aciertos, fallos, puntaje);
    }
    static void mostrarResumen(String jugador, String estado, String palabra,
                               int restantes, int maxIntentos,
                               int aciertos, int fallos, double puntaje) {
        int totalJugadas = aciertos + fallos;
        double porcentajeAciertos = totalJugadas == 0 ? 0.0 : (double) aciertos / totalJugadas * 100;

        System.out.println();
        System.out.println("====================================================");
        System.out.printf("%25s%n", "RESUMEN DE LA PARTIDA");
        System.out.println("====================================================");
        System.out.printf("%-20s %s%n", "Jugador:", jugador);
        System.out.printf("%-20s %s%n", "Estado Final:", estado);
        System.out.printf("%-20s %s%n", "Palabra Secreta:", palabra);
        System.out.printf("%-20s %d / %d%n", "Intentos Restantes:", restantes, maxIntentos);
        System.out.printf("%-20s %.2f%%%n", "Porcentaje Aciertos:", porcentajeAciertos);
        System.out.printf("%-20s %.2f pts%n", "Puntaje Final:", puntaje);
        System.out.println("====================================================");
    }
    static void mostrarEstadisticas() {
        System.out.println("\n========== ESTADÍSTICAS ==========");
        if (partidasJugadas == 0) {
            System.out.println("Aún no has jugado ninguna partida.");
        } else {
            double porcentajeVictorias = (double) victorias / partidasJugadas * 100;
            double promedio = puntajeAcumulado / partidasJugadas;
            System.out.printf("%-22s %d%n", "Partidas jugadas:", partidasJugadas);
            System.out.printf("%-22s %d%n", "Victorias:", victorias);
            System.out.printf("%-22s %.2f%%%n", "% de victorias:", porcentajeVictorias);
            System.out.printf("%-22s %.2f pts%n", "Puntaje promedio:", promedio);
            System.out.printf("%-22s %.2f pts%n", "Mejor puntaje:", mejorPuntaje);
        }
        System.out.println("==================================");
    }
}
