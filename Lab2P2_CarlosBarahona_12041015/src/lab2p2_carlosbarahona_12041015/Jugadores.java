/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2p2_carlosbarahona_12041015;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Jugadores {
    private String usuario;
    private ArrayList resultados;
    private int victorias;

    public Jugadores(String usuario, ArrayList resultados, int victorias) {
        this.usuario = usuario;
        this.resultados = resultados;
        this.victorias = victorias;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ArrayList getResultados() {
        return resultados;
    }

    public void setResultados(ArrayList resultados) {
        this.resultados = resultados;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    @Override
    public String toString() {
        return "Jugadores{" + "usuario=" + usuario + ", resultados=" + resultados + ", victorias=" + victorias + '}';
    }
    
    
    
}
