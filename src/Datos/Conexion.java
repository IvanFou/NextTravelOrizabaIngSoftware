/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;



/**
 *
 * @author ivan_
 */
public class Conexion {
    Connection conn = null;
    String url = "jdbc:postgresql://localhost/nextTravelOrizaba";
    String user = "postgres";
    String clave = "Ivangarcia12";
    
    public Connection conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,user,clave);            
        }catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"La conexion fallo"+e,"Conexion Fallida",JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
    
}
