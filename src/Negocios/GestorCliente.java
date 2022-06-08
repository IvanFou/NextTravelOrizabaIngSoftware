/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

/**
 *
 * @author Ivan Fougerat
 */
/*
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;*/
import Datos.Cliente;
import java.io.*;
import javax.swing.JOptionPane;

public class GestorCliente  implements Serializable{
    
      
    private Cliente clientes[];
    private int numCliente;
    FileWriter archivor;
    
    public Cliente cliente; 
    
    public GestorCliente(){
        
        clientes = new Cliente[20]; 
        numCliente = 0;
    }
    public void ingresarCliente(Cliente nuevoClientes){
        clientes[getNumCliente()] = nuevoClientes;
        numCliente++;
    }
    
     public void borrardato(int pos)
    {
        for(int i = pos; i < getNumCliente()-1;i++)
        {
            clientes[i] = clientes[i+1];
            
        }
        numCliente--;
        clientes[numCliente]=null;
    }
    public Cliente[] getCliente() {
        return clientes;
    }

    public void setCliente(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numClientes) {
        this.numCliente = numClientes;
    }
    
     public void guardarArchivo() 
    {
        try 
        {
            ObjectOutputStream output;
            output = new ObjectOutputStream(new FileOutputStream("archivor.txt"));
            output.writeObject(getCliente());
            output.close();
        } catch (IOException e) 
           {
           JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo", "Alerta", JOptionPane.WARNING_MESSAGE);
           } 
    }

    public void leerArchivo() {
      try{
            ObjectInputStream input;
            input=new ObjectInputStream(new FileInputStream("archivor.txt"));
             clientes =(Cliente[])input.readObject();
            setNumCliente(clientex());
            input.close();
           
          
        }
        catch (IOException | ClassNotFoundException e) {}
    }
      
    public int clientex(){
        int i;
        for(i=0; i<clientes.length; i++){
                try{
                    String cadena = String.valueOf(clientes[i].getId());
                }
                catch(Exception e){
                    return i;
                }
            }
        return i;
    }
}
