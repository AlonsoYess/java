
package IU;

import BEAN.*;
import DAO.*;
import UTIL.Util;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmMantUser extends javax.swing.JInternalFrame {

    RolDAO rolDao;
    UserDAO userDao;
    DefaultTableModel dtm;
    Integer IdUser;
    
    public FrmMantUser() throws SQLException {
        initComponents();
        rolDao = new RolDAO();
        userDao = new UserDAO();
        dtm = (DefaultTableModel)this.tblUsuario.getModel();
        llenaTablaUsuario(false,"");
        cmbRol.removeAllItems();
        llenaCmbRol();
        cmbEmpleado.removeAllItems();
        llenaEmpleado();
        //cmbRol.addActionListener(this::cmbRolActionPerformed); 
    }

    private void llenaEmpleado() throws SQLException{
        
        Vector<Employee> listaEmpleado;
        listaEmpleado = userDao.listarEmpleadoCombo();
        cmbEmpleado.addItem(new Employee());
        for (Employee employee : listaEmpleado) {
            cmbEmpleado.addItem(employee);
        }
        
    }
    
    private void llenaCmbRol() throws SQLException{
        Vector<Rol> listaRol;
        listaRol = rolDao.listarRol();
        cmbRol.addItem(new Rol());
        for (Rol rol : listaRol) {
            cmbRol.addItem(rol);
        }
    }
    
    private void limpiarFormulario() throws SQLException{
        this.txtIdUsuario.setText("");
        this.txtUsuario.setText("");
        this.txtPassword.setText("");
        cmbRol.removeAllItems();
        llenaCmbRol();
        cmbEmpleado.removeAllItems();
        llenaEmpleado();
        this.btnGrabar.setText("Grabar");
    }
    
    private boolean validaFormulario(){
        boolean sw = false;
        String msj = "";
        if(this.txtUsuario.getText().isEmpty()){
            msj = "Debe registrar el nombre de usuario";
        }
        
        if(this.txtPassword.getText().isEmpty()){
            msj = msj + "\nDebe registrar contraseña para el usuario";
        }
        
        Rol selectedRol = (Rol) cmbRol.getSelectedItem();
        if (selectedRol == null || selectedRol.getRolId() == 0) {
            msj = msj + "\nDebe seleccionar un rol para el usuario";
        }
        
        Employee selectedEmployee = (Employee) cmbEmpleado.getSelectedItem();
        if (selectedEmployee == null || selectedEmployee.getEmployeeId()== 0) {
            msj = msj + "\nDebe seleccionar un Empleado para el usuario";
        }
        
        if(msj.isEmpty()){
            sw = true;
        }else{
            JOptionPane.showMessageDialog(this, msj);
        }
        
        return sw;
    }
    
    private void llenaTablaUsuario(boolean sw, String cad) {
         try{
             Vector<User> listaUser;
             listaUser = userDao.listarUser(sw,cad);
             dtm.setRowCount(0);
             for(int i=0;i < listaUser.size();i++){
                Vector vec = new Vector();
                vec.addElement(listaUser.get(i).getUserId());
                vec.addElement(listaUser.get(i).getUsername());
                vec.addElement(listaUser.get(i).getEmployee().getFirstName());
                vec.addElement(listaUser.get(i).getRol().getNombre());
                dtm.addRow(vec);
             }
         }catch(java.sql.SQLException e){
              e.printStackTrace();
         }  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        cmbEmpleado = new javax.swing.JComboBox<>();
        cmbRol = new javax.swing.JComboBox<>();
        btnGrabar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("MANTENIMIENTO USUARIOS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Id Usuario");

        txtIdUsuario.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Usuario");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Empleado");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Rol");

        cmbEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEmpleadoActionPerformed(evt);
            }
        });

        cmbRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRolActionPerformed(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

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

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Usuario", "Usuario", "Empleado", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblUsuario);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(btnGrabar)
                .addGap(33, 33, 33)
                .addComponent(btnEliminar)
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdUsuario)
                    .addComponent(cmbRol, 0, 216, Short.MAX_VALUE)
                    .addComponent(txtPassword))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbEmpleado, 0, 213, Short.MAX_VALUE)
                    .addComponent(txtUsuario))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(171, 171, 171))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnEliminar)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRolActionPerformed
        Rol selectedRol = (Rol) cmbRol.getSelectedItem();
        int selectedRolId = selectedRol.getRolId();
        System.out.println("Rol seleccionado: " + selectedRolId);
    }//GEN-LAST:event_cmbRolActionPerformed

    private void cmbEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEmpleadoActionPerformed
        Employee selectedEmployee = (Employee) cmbEmpleado.getSelectedItem();
        int selectedRolEmployeeId = selectedEmployee.getEmployeeId();
        System.out.println("Empleado seleccionado: " + selectedRolEmployeeId);
    }//GEN-LAST:event_cmbEmpleadoActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed

        if(validaFormulario() == true){
            
            User user;
            Util util = new Util();
            user = new User();
            
            user.setUsername(this.txtUsuario.getText());
            user.setPassword(this.txtPassword.getText());
            
            Employee selectedEmployee = (Employee) cmbEmpleado.getSelectedItem();
            user.setEmployee(selectedEmployee);
            
            Rol selectedRol = (Rol) cmbRol.getSelectedItem();
            user.setRol(selectedRol);
            
            if(this.btnGrabar.getText().equals("Grabar")){
             
                this.IdUser = util.idNext("[User]", "UserId");
                user.setUserId(this.IdUser);
                this.userDao.insertaUser(user);
            }else{
                user.setUserId(this.IdUser);
                this.userDao.actualizaUser(user);
            }
            
            llenaTablaUsuario(false,"");
            try {
                limpiarFormulario();
            } catch (SQLException ex) {
                Logger.getLogger(FrmMantUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        if(this.txtBuscar.getText().isEmpty()){
            this.llenaTablaUsuario(false, "");           
        }else{
            this.llenaTablaUsuario(true, this.txtBuscar.getText());
        }

    }//GEN-LAST:event_txtBuscarKeyReleased

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JComboBox<Employee> cmbEmpleado;
    private javax.swing.JComboBox<Rol> cmbRol;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
