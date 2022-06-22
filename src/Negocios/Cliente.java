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
public class Cliente implements Serializable{
    Conexion conn = new Conexion();
    private Cliente clientes[];
    private int numCliente;
    FileWriter archivos;
    

    private int id;
    private String nombre;
    private String apellidos;
    private String correo;
    private int telefono;
    
    
    
    public Cliente(int id, String nombre, String apellidos, String correo, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
      
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getcorreo() {
        return correo;
    }

    public void setcorreo(String correo) {
        this.correo = correo;
    }
     public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public Cliente(){
        
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
            output = new ObjectOutputStream(new FileOutputStream("archivos.txt"));
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
            input=new ObjectInputStream(new FileInputStream("archivos.txt"));
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
    
     public void guardarCliente(int id, String nombre, String apellidos, String correo, int telefono){
      try{
         Connection conexions = conn.conectar();
         java.sql.Statement st = conexions.createStatement();
         String sql = "insert into clientes(id,nombre,apellidos,correo,telefono) "
                 + "values('"+id+"','"+nombre+"','"+apellidos+"','"+correo+"','"+telefono+"');";
         st.execute(sql);
         st.close();
         JOptionPane.showMessageDialog(null,"Se guardo correctamente el cliente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
         
      }catch(Exception e){
         JOptionPane.showMessageDialog(null,"No se pudo guardar", "Mensaje", JOptionPane.ERROR_MESSAGE);
      }
    }
     
     public void eliminarCliente(int id){
         try{
              Connection conexions = conn.conectar();
             java.sql.Statement st = conexions.createStatement();
             String sql = "delete from clientes where id = '"+id+"';";
             st.execute(sql);
             st.close();
         }catch(Exception e){
             JOptionPane.showMessageDialog(null,"No se pudo borrar","Error", JOptionPane.ERROR_MESSAGE);
         }
    }
    
}
