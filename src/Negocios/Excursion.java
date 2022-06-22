    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.Conexion;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan Fougerat
 */
public class Excursion implements Serializable{
    Conexion conn = new Conexion();
    private Excursion excursiones[];
    private int numExcursiones;
    FileWriter files;
    
    private int id;
    private String lugar;
    private String date;
    private int costo;
    private int lugares;

    
    public Excursion(int id, String lugar, String date, int costo, int lugares) {
        this.id = id;
        this.lugar = lugar;
        this.date = date;
        this.costo = costo;
        this.lugares = lugares;
    }


    public String getFecha() {
        return date;
    }

    public void setFecha(String fecha) {
        this.date = fecha;
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

    
      public Excursion(){
        //El vector excursiones permite crear un max de 20 excursiones por año
       excursiones = new Excursion[20]; 
        numExcursiones = 0;
    }
    
    //permite agregar una nueva excursion
    public void ingresarExcursion(Excursion nuevoExcursion){
        int pos=getNumExcursiones();
       excursiones[pos] = nuevoExcursion;
        numExcursiones++;
        
    }
    public void borrardato(int pos)
    {
        for(int i = pos; i < getNumExcursiones()-1;i++)
        {
            excursiones [i] = excursiones[i+1];
        }
        numExcursiones--;
         excursiones[numExcursiones]=null;
    }
    public Excursion[] getExcursiones() {
        return  excursiones;
    }

    public void setExcursion(Excursion[]  excursiones) {
        this. excursiones = excursiones;
    }

    public int getNumExcursiones() {
        return numExcursiones;
    }

    public void setNumExcursiones(int numExcursion) {
        this.numExcursiones = numExcursion;
    }
    
       //Metodo para guardar el archivo  
    public void guardarArchivo() {
        try {
            ObjectOutputStream output;
            output = new ObjectOutputStream(new FileOutputStream("files.txt"));
            output.writeObject(getExcursiones());
            output.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al mandar datos", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }
    }
     public void ReadFile() {
      try{
            ObjectInputStream input;
            input=new ObjectInputStream(new FileInputStream("files.txt"));
            excursiones=(Excursion[])input.readObject();
            setNumExcursiones(nExcursiones());
            input.close();         
        }
      catch (IOException | ClassNotFoundException e) {}
    }
    
    public int nExcursiones(){
        int i;
        for(i=0; i< excursiones.length; i++){
                try{
                    String cadena = String.valueOf( excursiones[i].getId());
                }
                catch(Exception e){
                    return i;
                }
            }
        return i;
    }
    
     public void guardarExcursion(int id, String lugar, String date, int costo, int lugares){
       try{
           Connection conexions = conn.conectar();
           java.sql.Statement st = conexions.createStatement();
           String sql = "insert into excursiones(id,lugar,date,costo,lugares) values('"+id+"','"+lugar+"','"+date+"','"+costo+"','"+lugares+"');";
           st.execute(sql);
           st.close();
           
       }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo guardar", "Mensaje", JOptionPane.ERROR_MESSAGE);
       }
   }
     
    public void eliminarExcursiones(int id){
        try{
            Connection conexions = conn.conectar();
            java.sql.Statement st = conexions.createStatement();
            String sql = "delete from excursiones where id='"+id+"';";
            st.execute(sql);
            st.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo borrar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
