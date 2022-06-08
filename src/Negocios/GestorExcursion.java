/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;


import Datos.Excursion;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */
public class GestorExcursion implements Serializable{
   
    private Excursion excursiones[];
    private int numExcursiones;
    FileWriter file;
    
    public Excursion excursion; 

    
    public GestorExcursion(){
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
            output = new ObjectOutputStream(new FileOutputStream("file.txt"));
            output.writeObject(getExcursiones());
            output.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al mandar datos", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }
    }
     public void ReadFile() {
      try{
            ObjectInputStream input;
            input=new ObjectInputStream(new FileInputStream("file.txt"));
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
    
}
