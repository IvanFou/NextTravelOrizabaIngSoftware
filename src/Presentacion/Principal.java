/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Usuarios.AgregarClientes;
import Usuarios.ListarExcursiones;
import Usuarios.ListarClientes;
import Negocios.GestorExcursion;
import Negocios.GestorCliente;
import Usuarios.AgregarExcursion;
import Usuarios.PuntoVenta;
import Negocios.GestorVenta;
import Usuarios.ListarVentas;

/**
 *
 * @author Ivan Fougerat
 */
public class Principal extends javax.swing.JFrame {
    private GestorExcursion objGExcursion;
     private GestorCliente objGCliente;
     private GestorVenta objGVentas;
     
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        objGCliente = new GestorCliente();
        objGCliente.leerArchivo();
        objGExcursion = new GestorExcursion();
        objGExcursion.ReadFile();
        objGVentas = new GestorVenta();
        objGVentas.ReadFiles();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mnuSalir = new javax.swing.JMenuItem();
        mnuEditar = new javax.swing.JMenu();
        mnuAgregarExcursiones = new javax.swing.JMenuItem();
        mnuListarExcursiones = new javax.swing.JMenuItem();
        mnCliente = new javax.swing.JMenu();
        mnuAgregarClientes = new javax.swing.JMenuItem();
        ListarClientes = new javax.swing.JMenuItem();
        mnuVenta = new javax.swing.JMenu();
        mnuAgregarVenta = new javax.swing.JMenuItem();
        mnuListaVentas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnuArchivo.setText("Archivo");

        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuSalir);

        jMenuBar1.add(mnuArchivo);

        mnuEditar.setText("Excursiones");
        mnuEditar.setToolTipText("");

        mnuAgregarExcursiones.setText("Agregar");
        mnuAgregarExcursiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAgregarExcursionesActionPerformed(evt);
            }
        });
        mnuEditar.add(mnuAgregarExcursiones);

        mnuListarExcursiones.setText("Listar");
        mnuListarExcursiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListarExcursionesActionPerformed(evt);
            }
        });
        mnuEditar.add(mnuListarExcursiones);

        jMenuBar1.add(mnuEditar);

        mnCliente.setText("Clientes");

        mnuAgregarClientes.setText("Agregar Clientes");
        mnuAgregarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAgregarClientesActionPerformed(evt);
            }
        });
        mnCliente.add(mnuAgregarClientes);

        ListarClientes.setText("Listar Clientes");
        ListarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarClientesActionPerformed(evt);
            }
        });
        mnCliente.add(ListarClientes);

        jMenuBar1.add(mnCliente);

        mnuVenta.setText("Punto de Venta");
        mnuVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVentaActionPerformed(evt);
            }
        });

        mnuAgregarVenta.setText("Agregar Venta");
        mnuAgregarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAgregarVentaActionPerformed(evt);
            }
        });
        mnuVenta.add(mnuAgregarVenta);

        mnuListaVentas.setText("Listar Ventas");
        mnuListaVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListaVentasActionPerformed(evt);
            }
        });
        mnuVenta.add(mnuListaVentas);

        jMenuBar1.add(mnuVenta);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAgregarExcursionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAgregarExcursionesActionPerformed
        // TODO add your handling code here:
       AgregarExcursion vExcursion=new AgregarExcursion(objGExcursion);
        escritorio.add(vExcursion);
        vExcursion.setVisible(true);
        
    }//GEN-LAST:event_mnuAgregarExcursionesActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        this.dispose();
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuAgregarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAgregarClientesActionPerformed
        // TODO add your handling code here:
        AgregarClientes Clientes = new AgregarClientes(objGCliente);
        escritorio.add(Clientes);
       Clientes.setVisible(true);
    }//GEN-LAST:event_mnuAgregarClientesActionPerformed

    private void mnuListarExcursionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListarExcursionesActionPerformed
        // TODO add your handling code here:
         ListarExcursiones ListaExcursiones;
       ListaExcursiones = new ListarExcursiones(objGExcursion);
        escritorio.add(ListaExcursiones);
        ListaExcursiones.setVisible(true);
    }//GEN-LAST:event_mnuListarExcursionesActionPerformed

    private void ListarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarClientesActionPerformed
        // TODO add your handling code here:
       ListarClientes ListaClientes;
       ListaClientes = new ListarClientes(objGCliente);
        escritorio.add(ListaClientes);
        ListaClientes.setVisible(true);
    }//GEN-LAST:event_ListarClientesActionPerformed

    private void mnuVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVentaActionPerformed
     
    }//GEN-LAST:event_mnuVentaActionPerformed

    private void mnuAgregarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAgregarVentaActionPerformed
       PuntoVenta Venta = new PuntoVenta(objGVentas);
       escritorio.add(Venta);
       Venta.setVisible(true);
    }//GEN-LAST:event_mnuAgregarVentaActionPerformed

    private void mnuListaVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListaVentasActionPerformed
        ListarVentas ListaVentas;
        ListaVentas = new ListarVentas(objGVentas);
        escritorio.add(ListaVentas);
        ListaVentas.setVisible(true);
    }//GEN-LAST:event_mnuListaVentasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ListarClientes;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnCliente;
    private javax.swing.JMenuItem mnuAgregarClientes;
    private javax.swing.JMenuItem mnuAgregarExcursiones;
    private javax.swing.JMenuItem mnuAgregarVenta;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuEditar;
    private javax.swing.JMenuItem mnuListaVentas;
    private javax.swing.JMenuItem mnuListarExcursiones;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenu mnuVenta;
    // End of variables declaration//GEN-END:variables
}
