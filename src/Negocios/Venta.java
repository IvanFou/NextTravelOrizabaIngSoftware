/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;
import java.io.*;
import java.util.*;
import Datos.Conexion;
import java.sql.Connection;
import javax.swing.JOptionPane;


/**
 *
 * @author ivan_
 */
public class Venta implements Serializable {
    Conexion conn = new Conexion();
    private Venta venta[];
    private int numVenta;
    FileWriter fileVenta;

    
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
     
    public Venta(){
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
            output = new ObjectOutputStream(new FileOutputStream("fileVenta.txt"));
            output.writeObject(getVenta());
            output.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al mandar datos", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }
    }
    
     public void ReadFiles() {
      try{
            ObjectInputStream input;
            input = new ObjectInputStream(new FileInputStream("filesVenta.csv"));
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
      
         
    public void guardarVentas(int id, String excursion, int boletos, String cliente, int deposito,int total){
       try{
           Connection conexions = conn.conectar();
           java.sql.Statement st = conexions.createStatement();
           String sql = "insert into ventas(id,excursion,boletos,cliente,deposito,total) values('"+id+"','"+excursion+"','"+boletos+"','"+cliente+"','"+deposito+"','"+total+"');";
           st.execute(sql);
           st.close();
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,"No se pudo guardar", "Mensaje", JOptionPane.ERROR_MESSAGE);
       }
   }
    
        public void eliminarVentas(int id){
        try{
            Connection conexions = conn.conectar();
            java.sql.Statement st = conexions.createStatement();
            String sql = "delete from ventas where id = '"+id+"';";
            st.execute(sql);
            st.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo borrar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
