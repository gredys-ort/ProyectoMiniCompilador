/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisadorlexico3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author MABY
 */
public class teclado {

    static private String cadena;
    static private BufferedReader in;

    // métodos públicos
    public static String lecturaCadena(String prompt) {
        return leerCadena(prompt);
    }

    public static String lecturaCadena() {
        return leerCadena("");
    }

    public static int lecturaEntero(String prompt) {
        return leerEntero(prompt);
    }

    public static int lecturaEntero() {
        return leerEntero("");
    }

    public static double lecturaDouble(String prompt) {
        return leerDouble(prompt);
    }

    public static double lecturaDouble() {
        return leerDouble("");
    }

    // métodos privados!
    private static void inicializar() {
        if (in == null) {
            in = new BufferedReader(new InputStreamReader(System.in));
        }
    }

    private static String leerCadena(String prompt) {
        try {
            inicializar();
            if (prompt.compareTo("") == 0) {
                System.out.print(" >");
            } else {
                System.out.print(prompt);
            }
            cadena = in.readLine();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: ");
        }
        return cadena;
    }

    private static int leerEntero(String prompt) {
        int i = 0;
        boolean ok;
        try {
            inicializar();
            do {
                if (prompt.compareTo("") == 0) {
                    System.out.print(" >");
                } else {
                    System.out.print(prompt);
                }
                try {
                    i = Integer.parseInt(in.readLine());
                    ok = true;
                } catch (java.lang.NumberFormatException e) {
                    System.out.println("Ha ocurrido un error: " + e.toString());
                    ok = false;
                }
            } while (!ok);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.toString());
        }
        return i;
    }

    private static double leerDouble(String prompt) {
        double d = 0.0;
        boolean ok;
        try {
            inicializar();
            do {
                if (prompt.compareTo("") == 0) {
                    System.out.print(" >");
                } else {
                    System.out.print(prompt);
                }
                try {
                    d = (Double.valueOf(in.readLine())).doubleValue();
                    ok = true;
                } catch (java.lang.NumberFormatException e) {
                    System.out.println("Ha ocurrido un error: " + e.toString());
                    ok = false;
                }
            } while (!ok);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.toString());
        }
        return d;
    }

}
