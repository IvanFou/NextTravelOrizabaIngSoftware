/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.io.*;
import java.util.*;
import Datos.Excursion;
import Datos.Cliente;


/**
 *
 * @author ivan_
 */
public class Venta implements Serializable {
    private int id;
    private String excursion;
    private String cliente;
    private int boletos;
    private int deposito;
    private int total;
    
    
    public Venta(int id, String excursion, String cliente, int boletos, int deposito, int total){
        this.id = id;
        this.excursion = excursion;
        this.cliente = cliente;
        this.boletos = boletos;
        this.deposito = deposito;
        this.total = total; 
    }
    
      
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getExcursion(){
        return excursion;
    }
    
    public void setExcursion(String excursion){
        this.excursion = excursion;
    }
    
    public String getCliente(){
        return cliente;
    }
    
    public void setCliente(String cliente){
        this.cliente = cliente;
    }
    
    public int getBoletos(){
        return boletos;
    }
    
    public void setBoletos(int boletos){
        this.boletos = boletos;
    }
    
    public int getDeposito(){
        return deposito;
    }
    
    public void setDeposito(int deposito){
        this.deposito = deposito;
    }
    
    public int getTotal(){
        return total;
    }
    
    public void setTotal(int total){
        this.total = total;
    }
    
}
