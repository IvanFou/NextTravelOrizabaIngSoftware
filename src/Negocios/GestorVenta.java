/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.Excursion;
import Datos.Venta;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author ivan_
 */
public class GestorVenta implements Serializable{
    
      private Venta venta[];
      private int numVenta;
      FileWriter fileVentas;
      
      public Venta ventas;
    
      public GestorVenta(){
       venta = new Venta[100]; 
        numVenta = 0;
    }
      
      public void ingresarVenta(Venta nuevaVenta){
        int pos= getNumVenta();
        venta[pos] = nuevaVenta;
        numVenta++;
    }
      
       public void borrardato(int pos){
        for(int i = pos; i < getNumVenta()-1;i++)
        {
            venta [i] = venta[i+1];
        }
        numVenta--;
         venta[numVenta]=null;
    }
  
    public Venta[] getVenta() {
        return  venta;
    }
        
    public void setVenta(Venta[]  venta) {
        this.venta = venta;
    }

    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }
    
    public void guardarArchivo() {
        try {
            ObjectOutputStream output;
            output = new ObjectOutputStream(new FileOutputStream("fileVentas.txt"));
            output.writeObject(getVenta());
            output.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al mandar datos", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }
    }
    
     public void ReadFiles() {
      try{
            ObjectInputStream input;
            input = new ObjectInputStream(new FileInputStream("filesVentas.csv"));
            venta =(Venta[])input.readObject();
            setNumVenta(nVenta());
            input.close();         
        }
      catch (IOException | ClassNotFoundException e) {}
    }
     
      public int nVenta(){
        int i;
        for(i=0; i< venta.length; i++){
                try{
                    String cadena = String.valueOf( venta[i]);
                }
                catch(Exception e){
                    return i;
                }
            }
        return i;
    }
}
