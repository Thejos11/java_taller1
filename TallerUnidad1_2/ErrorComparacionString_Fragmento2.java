package org.example;

public class ErrorComparacionString_Fragmento2 {
    public static void main(String[] args) {
    String proveedor1 = new String("OneTrust");
    String proveedor2 = "OneTrust";
    if (proveedor1.equals(proveedor2)) {
        System.out.println("Los proveedores coinciden exactamente.");
    } else {
        System.out.println("Los proveedores son distintos.");
    }
}
}
