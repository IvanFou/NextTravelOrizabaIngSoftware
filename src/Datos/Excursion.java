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
    private String id;
    private String nombre;
    private String apellido;
    private int costo;
    private int lugares;

    
    public Excursion(String id, String nombre, String apellido, int costo, int lugares) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.costo = costo;
        this.lugares = lugares;
    }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLugares() {
        return lugares;
    }

    public void setLugares(int lugares) {
        this.lugares = lugares;
    }

}
