/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2p2_carlosbarahona_12041015;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab2P2_CarlosBarahona_12041015 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner s = new Scanner(System.in);
        Random r = new Random();
        ArrayList<Jugadores> jugadores = new ArrayList();
        int opcion = 11;
        while (opcion != 0) {
            System.out.println("Bienvenido\n"
                    + "¿Qué desea hacer?\n"
                    + "0) Salir\n"
                    + "1) Crear Jugador\n"
                    + "2) Listar Jugador Por Posición\n"
                    + "3) Listar Jugadores\n"
                    + "4) Jugar");
            opcion = s.nextInt();
            boolean ganar = false;
            while (true != ganar) {
                switch (opcion) {
                    case 1: {
                        System.out.println("Ingrese el nombre del usuario");
                        String nombre = s.next();
                        for (int x = 0; x < jugadores.size(); x++) {
                            String verificicarN = "";

                            if (jugadores.get(x) instanceof Jugadores) {
                                verificicarN = ((Jugadores) jugadores.get(x)).getUsuario();
                            }

                            while (nombre.equals(verificicarN)) {
                                System.out.println("Ingrese un nombre de usuario que no este tomado");
                                nombre = s.next();
                            }
                        }
                        ArrayList resultados = new ArrayList();
                        jugadores.add(new Jugadores(nombre, resultados, 0));
                        ganar = true;
                        break;
                    }
                    case 2: {
                        System.out.println("Ingrese la posición del jugador que desea ver");
                        int posicion = s.nextInt();
                        System.out.println(jugadores.get(posicion));
                        ganar = true;
                        break;
                    }
                    case 3: {
                        imprimirArreglo(jugadores, 0);
                        ganar = true;
                        break;
                    }
                    case 4: {
                        for (int i = 0; i < jugadores.size(); i++) {
                            jugadores.get(i).getResultados().clear();
                        }

                        String numeroSecreto = "";
                        for (int i = 0; i < 4; i++) {
                            int x = r.nextInt((7 - 0) + 1) + 0;
                            String y = Integer.toString(x);
                            numeroSecreto += y;
                        }
                        for (int u = 0; u < 8; u++) {
                            System.out.println("Intento: "+u);
                            for (int i = 0; i < jugadores.size(); i++) {

                                String salida = "";

                                System.out.println(jugadores.get(i).getUsuario() + " ingrese 4 digitos para encontrar el numero");

                                String adivinar = s.next();
                                jugadores.get(i).getResultados().add(adivinar);
                                for (int j = 0; j < adivinar.length(); j++) {
                                    String car = Character.toString(adivinar.charAt(j));

                                    boolean h = numeroSecreto.contains(car);
                                    if (h == true) {
                                        int o = numeroSecreto.indexOf(car);
                                        int p = adivinar.indexOf(car);
                                        if (o == p) {
                                            salida += "+";
                                        } else {
                                            salida += "-";
                                        }

                                    } else {
                                        salida += "x";
                                    }

                                }
                                String inicio = "";
                                String medio = "";
                                String finall = "";
                                for (int t = 0; t < salida.length(); t++) {
                                    String var = Character.toString(salida.charAt(t));

                                    if (null == var) {
                                        finall = "x";
                                    } else {
                                        switch (var) {
                                            case "+":

                                                inicio += "+";
                                                break;
                                            case "-":

                                                medio += "-";
                                                break;
                                            default:

                                                finall += "x";
                                                break;
                                        }
                                    }

                                }
                                salida = inicio + medio + finall;
                                System.out.println(salida);
                                if ("++++".equals(salida)) {
                                    System.out.println("Ganó: " + jugadores.get(i).getUsuario());
                                    jugadores.get(i).setVictorias(+1);
                                    ganar = true;

                                    break;
                                }

                            }
                        }
                        ganar=true;
                    }

                    break;
                }
            }
        }
    }

    public static void imprimirArreglo(ArrayList jugadores, int posicion) {

        if (posicion != jugadores.size()) {
            System.out.print("Posicion " + posicion + ")");
            System.out.println(jugadores.get(posicion));
            imprimirArreglo(jugadores, posicion + 1);
        }
    }

}
