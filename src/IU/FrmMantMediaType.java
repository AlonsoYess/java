
package IU;

import BEAN.*;
import DAO.*;
import UTIL.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmMantMediaType extends javax.swing.JInternalFrame {
    
    MediaTypeDAO mediaTypeDao;
    DefaultTableModel dtm;
    Integer idMediaType;

    public FrmMantMediaType() {
        initComponents();
        mediaTypeDao = new MediaTypeDAO();
        dtm = (DefaultTableModel)this.tblMediaType.getModel();
        llenaTablaMediaType(false,"");
        this.btnEliminar.setEnabled(false);
    }
    
    private void llenaTablaMediaType(boolean sw, String cad) {
         try{
             Vector<MediaType> listaMediaType;
             listaMediaType = mediaTypeDao.listarMediaType(sw,cad);
             dtm.setRowCount(0);
             for(int i=0;i < listaMediaType.size();i++){
                Vector vec = new Vector();
                vec.addElement(listaMediaType.get(i).getMediaTypeId());
                vec.addElement(listaMediaType.get(i).getName());
                dtm.addRow(vec);
             }
         }catch(java.sql.SQLException e){
              e.printStackTrace();
         }  
    }
    
    private void limpiarFormulario(){
        this.txtIdMediaType.setText("");
        this.txtNombreMediaType.setText("");
        this.btnGrabar.setText("Grabar");
    }
    
    private boolean validaFormulario(){
        boolean sw = false;
        String msj = "";
        if(this.txtNombreMediaType.getText().isEmpty()){
            msj = "Debe registrar el nombre de la Media Type";
        }
        
        if(msj.isEmpty()){
            sw = true;
        }else{
            JOptionPane.showMessageDialog(this, msj);
        }
        
        return sw;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtIdMediaType = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        txtNombreMediaType = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMediaType = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nombe Media");

        txtIdMediaType.setEnabled(false);

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblMediaType.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Media Type", "Nombre Media Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMediaType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMediaTypeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMediaType);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("MANTENIMIENTO TIPO DE MEDIA");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Buscar");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Id Media");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btnGrabar)
                        .addGap(33, 33, 33)
                        .addComponent(btnEliminar)
                        .addGap(38, 38, 38)
                        .addComponent(jButton1)
                        .addGap(32, 32, 32)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNombreMediaType, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdMediaType, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscar)))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdMediaType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreMediaType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnEliminar)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        this.mediaTypeDao.eliminarMediaType(this.idMediaType);
        limpiarFormulario();
        this.btnEliminar.setEnabled(false);
        llenaTablaMediaType(false,"");

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.limpiarFormulario();
        this.btnEliminar.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed

        if(validaFormulario() == true){

            MediaType mediaType;
            Util util = new Util();
            mediaType = new MediaType();

            mediaType.setName(this.txtNombreMediaType.getText());

            if(this.btnGrabar.getText().equals("Grabar")){

                this.idMediaType = util.idNext("MediaType", "MediaTypeId");
                mediaType.setMediaTypeId(this.idMediaType);
                this.mediaTypeDao.insertaMediaType(mediaType);
            }else{
                mediaType.setMediaTypeId(this.idMediaType);
                this.mediaTypeDao.actualizaMediaType(mediaType);
            }

            llenaTablaMediaType(false,"");
            limpiarFormulario();

        }

    }//GEN-LAST:event_btnGrabarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblMediaTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMediaTypeMouseClicked

        int indice;
        indice = this.tblMediaType.getSelectedRow();
        this.txtIdMediaType.setText(dtm.getValueAt(indice, 0).toString());
        this.idMediaType = Integer.parseInt(dtm.getValueAt(indice, 0).toString());
        this.txtNombreMediaType.setText(dtm.getValueAt(indice, 1).toString());
        this.btnEliminar.setEnabled(true);
        this.btnGrabar.setText("Actualizar");
    }//GEN-LAST:event_tblMediaTypeMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        if(this.txtBuscar.getText().isEmpty()){
            this.llenaTablaMediaType(false, "");
        }else{
            this.llenaTablaMediaType(true, this.txtBuscar.getText());
        }

    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMediaType;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIdMediaType;
    private javax.swing.JTextField txtNombreMediaType;
    // End of variables declaration//GEN-END:variables
}
