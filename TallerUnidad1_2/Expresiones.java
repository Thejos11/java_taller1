package org.example;

public class Expresiones {
    public static void main(String[] args){
    int seg = 86400 % 3600;
    System.out.println("Segundo: " + seg);
    int x = 7;
    int y = ++x + x++;
    System.out.println(y);
    double div1 = 15 / 2; double div2
            = 15.0 / 2;
    System.out.println(div1);
    System.out.println(div2);
    boolean flag = false;
    boolean res = flag && (++x > 0);
    System.out.println(res);
}
}
