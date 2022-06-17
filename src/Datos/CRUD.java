/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author ivan_
 */
public class CRUD {
    Conexion conn = new Conexion();
    
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
