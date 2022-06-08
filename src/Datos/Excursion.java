    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.Serializable;

/**
 *
 * @author Ivan Fougerat
 */
public class Excursion implements Serializable{
    private int id;
    private String lugar;
    private String fecha;
    private int costo;
    private int lugares;

    
    public Excursion(int id, String lugar, String fecha, int costo, int lugares) {
        this.id = id;
        this.lugar = lugar;
        this.fecha = fecha;
        this.costo = costo;
        this.lugares = lugares;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setNombre(String nombre) {
        this.lugar = lugar;
    }

    public int getLugares() {
        return lugares;
    }

    public void setLugares(int lugares) {
        this.lugares = lugares;
    }

}
