
package Usuarios;


import Negocios.GestorCliente;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Negocios.GestorVenta;

/**
 *
 * @author Ivan Fougerat
 */
public class ListarVentas extends javax.swing.JInternalFrame {

     private GestorVenta objGVentas;
     int posicion;
     String pos = null;
     int ind;
     int cont;
     int nCoincidencias = 0;
     DefaultTableModel Tablas;
    
    
    
    public ListarVentas(GestorVenta objGVenta) {
        this.Tablas = new DefaultTableModel();
        
        this.cont = 0;
        this.posicion = 0;
        this.objGVentas = objGVenta;
        initComponents();
        Tablas.addColumn("Id");
        Tablas.addColumn("Excursion");
        Tablas.addColumn("Boletos");
        Tablas.addColumn("Cliente");
        Tablas.addColumn("Deposito");
        Tablas.addColumn("Total");
        tabMaestro.setModel(Tablas);
       
        llenarDatosTablas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableVentas = new javax.swing.JScrollPane();
        tabMaestro = new javax.swing.JTable();
        txtClaveBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCancelarConsulta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnBorrarDatos = new javax.swing.JButton();

        tabMaestro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableVentas.setViewportView(tabMaestro);

        txtClaveBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveBusquedaActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelarConsulta.setText("Cancelar");
        btnCancelarConsulta.setEnabled(false);
        btnCancelarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarConsultaActionPerformed(evt);
            }
        });

        jLabel1.setText("Matricula:");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBorrarDatos.setText("Borrar datos");
        btnBorrarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClaveBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrarDatos)
                .addGap(8, 8, 8)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tableVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarConsulta)
                    .addComponent(btnBuscar)
                    .addComponent(txtClaveBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnSalir)
                    .addComponent(btnBorrarDatos))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClaveBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveBusquedaActionPerformed

    }//GEN-LAST:event_txtClaveBusquedaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

   int noElemento;
        
        //mostrarDatos();
        if(txtClaveBusqueda.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese una id valida", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        else {         
            noElemento=busqueda(txtClaveBusqueda.getText());
            if(noElemento>=0)
            {
               borrarDatosTabla();
               llenarDatosTabla(noElemento);
               btnCancelarConsulta.setEnabled(true);
               btnBuscar.setEnabled(false);
            
            }else{    
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Mensaje", JOptionPane.INFORMATION_MESSAGE);           
            } 
            
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarConsultaActionPerformed
      borrarDatosTabla();
     llenarDatosTablas();
      btnCancelarConsulta.setEnabled(false);
               btnBuscar.setEnabled(true);
     
    }//GEN-LAST:event_btnCancelarConsultaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
       this.dispose();
        objGVentas.guardarArchivo();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBorrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDatosActionPerformed
         // TODO add your handling code here:
        int fila = tabMaestro.getSelectedRow();
        if(fila>=0)
        {
            objGVentas.borrardato(fila);
            borrarDatosTabla(); 
            llenarDatosTablas();
        }
        else{
            JOptionPane.showMessageDialog(null,"Hey selecciona la fila ");
        }
    }//GEN-LAST:event_btnBorrarDatosActionPerformed

public int busqueda(String claveBusqueda) throws ExceptionInInitializerError{
    int noElemento = -1;
         try{
        int i = 0;
         while(ind<objGVentas.getVenta().length){
           
             if(claveBusqueda.equals(objGVentas.getVenta()[ind].getId())){
                 System.out.println("El usuario con el id buscado es: "+objGVentas
                         .getVenta()[ind].getCliente()+ " \n");
                 noElemento=ind;
                 ind=objGVentas.getVenta().length;
             } else {   
             }
             ind++;
         }
         
         }catch(Exception e) {
             System.out.println("");
         }
         return noElemento;
     }
     
    
     private void borrarDatosTabla(){
      int numVentas = Tablas.getRowCount();
          
        for (int i = 0;i<numVentas; i++) {
                Tablas.removeRow(0);
            } 
     }
    
    public void llenarDatosTabla(int pos){
        
         borrarDatosTabla();
         Tablas.addRow(new Object[] {objGVentas.getVenta()[pos].getId(),
                objGVentas.getVenta()[pos].getExcursion(),
                objGVentas.getVenta()[pos].getCliente(),
                objGVentas.getVenta()[pos].getDeposito(),
                objGVentas.getVenta()[pos].getTotal(),
            });
    } 
     
    public void llenarDatosTablas() {
       int numVentas = objGVentas.getNumVenta();
       
        for(int i = 0; i<numVentas;i++){
            Tablas.addRow(new Object[]{ objGVentas.getVenta()[i].getId(),
                objGVentas.getVenta()[i].getExcursion(),
                objGVentas.getVenta()[i].getCliente(),
                objGVentas.getVenta()[i].getBoletos(),
                objGVentas.getVenta()[i].getDeposito(),
                objGVentas.getVenta()[i].getTotal(),
                
            });
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarDatos;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelarConsulta;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable tabMaestro;
    private javax.swing.JScrollPane tableVentas;
    private javax.swing.JTextField txtClaveBusqueda;
    // End of variables declaration//GEN-END:variables
}
