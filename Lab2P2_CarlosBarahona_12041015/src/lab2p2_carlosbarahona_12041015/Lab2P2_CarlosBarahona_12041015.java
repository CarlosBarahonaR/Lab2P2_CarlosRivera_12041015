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
            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese el nombre del usuario");
                    String nombre=s.next();
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
                  ArrayList resultados=new ArrayList();
                  jugadores.add(new Jugadores(nombre, resultados, 0));
                }
            }
        }
    }

}
