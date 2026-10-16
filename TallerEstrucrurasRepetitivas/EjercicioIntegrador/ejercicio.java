package org.example.EjercicioIntegrador;
import java.util.Locale;
import java.util.Scanner;
public class ejercicio {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in).useLocale(Locale.US);
            final int CAPACIDAD_MAXIMA = 500;

            int totalUnidades = 0;
            int productosRegistrados = 0;
            int productosDescontinuados = 0;
            double valorInventario = 0;
            int opcion;

            do {
                System.out.println("\n===== ALMACÉN LOGÍSTICO =====");
                System.out.println("1. Registrar Lote de Productos");
                System.out.println("2. Ver Estado del Almacén");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("¿Cuántos productos componen el lote? ");
                        int n = sc.nextInt();

                        for (int i = 1; i <= n; i++) {
                            System.out.println("\n--- Producto " + i + " de " + n + " ---");

                            System.out.print("¿Está descontinuado? (s/n): ");
                            String resp = sc.next();
                            if (resp.equalsIgnoreCase("s")) {
                                productosDescontinuados++;
                                System.out.println("Producto descontinuado: se omite.");
                                continue;
                            }

                            System.out.print("Precio unitario (> 0): $");
                            double precio = sc.nextDouble();
                            while (precio <= 0) {
                                System.out.print("Valor inválido. Ingrese un precio mayor a 0: $");
                                precio = sc.nextDouble();
                            }

                            System.out.print("Cantidad en stock (> 0): ");
                            int stock = sc.nextInt();
                            while (stock <= 0) {
                                System.out.print("Valor inválido. Ingrese una cantidad mayor a 0: ");
                                stock = sc.nextInt();
                            }

                            totalUnidades += stock;
                            valorInventario += precio * stock;
                            productosRegistrados++;

                            if (totalUnidades > CAPACIDAD_MAXIMA) {
                                System.out.println("\n¡ALERTA! Sobrecupo: " + totalUnidades
                                        + " unidades superan la capacidad de " + CAPACIDAD_MAXIMA + ".");
                                System.out.println("Se aborta el procesamiento del resto del lote.");
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("\n--- Estado del Almacén ---");
                        System.out.println("Productos registrados: " + productosRegistrados);
                        System.out.println("Productos descontinuados omitidos: " + productosDescontinuados);
                        System.out.println("Unidades totales: " + totalUnidades + " / " + CAPACIDAD_MAXIMA);
                        System.out.printf("Valor total del inventario: $%,.2f%n", valorInventario);
                        break;
                    case 3:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 3);

            sc.close();
        }
}
