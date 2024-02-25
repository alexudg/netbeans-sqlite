package user;

import main.Context;
import main.Message;
import user.User;
import sqlite.SQLiteConnection;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.ini4j.Wini;

/**
 *
 * @author Alejandro Ramirez Macias
 */
public class FrmUserInput extends javax.swing.JDialog {

    /**
     * Creates new form FrmTest
     * @param parent
     * @param modal
     */
    public FrmUserInput(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setIconImage(parent.getIconImage());        
        this.setTitle("Ingreso de usuario");
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(btnOk);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        pnlDatabase = new javax.swing.JPanel();
        btnDbTest = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        txtFindDb = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Usuario");

        jLabel2.setText("Contraseña");

        btnOk.setText("Entrar");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancel.setText("Cerrar app");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        pnlDatabase.setBorder(javax.swing.BorderFactory.createTitledBorder("Base de datos"));

        btnDbTest.setText("Probar BD");
        btnDbTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDbTestActionPerformed(evt);
            }
        });

        jLabel3.setText("Ruta");

        txtFindDb.setText("...");
        txtFindDb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindDbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatabaseLayout = new javax.swing.GroupLayout(pnlDatabase);
        pnlDatabase.setLayout(pnlDatabaseLayout);
        pnlDatabaseLayout.setHorizontalGroup(
            pnlDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatabaseLayout.createSequentialGroup()
                .addGroup(pnlDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatabaseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFindDb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatabaseLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnDbTest, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDatabaseLayout.setVerticalGroup(
            pnlDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatabaseLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFindDb))
                .addGap(15, 15, 15)
                .addComponent(btnDbTest))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pnlDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addComponent(jLabel1)
                            .addGap(6, 6, 6)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOk)
                    .addComponent(btnCancel))
                .addGap(29, 29, 29)
                .addComponent(pnlDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if (txtUserName.getText().isEmpty()) {
            txtUserName.requestFocus();
            return;
        }
        if (txtPass.getText().isEmpty()) {
            txtPass.requestFocus();
            return;
        }

        if (_isDbConnected()) {
            int id = User.getIdFromNameAndPass(txtUserName.getText(), txtPass.getText());
            System.out.println("id found: " + id);
            if (id == -1) {
                txtPass.setText("");
                txtPass.requestFocus();
                Message.showError("Usuario y/o contraseña incorrecta");
                return;
            }

            // get current user OK
            Context.user = User.get(id);

            this.dispose();
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelActionPerformed

    private boolean _isDbConnected() {
        boolean isConnected = SQLiteConnection.isExistsConnection(txtPath.getText());
                
        try {
            File f = new File("c:\\data.ini");
            Wini ini = new Wini(f);
            if (isConnected) {           
               // save path OK to INI
                ini.put("DB", "path", txtPath.getText());
                ini.store();
            }
            else {
                // restore from INI
                txtPath.setText(ini.get("DB", "path"));
            }
        } catch (IOException ex) {
            Message.showError("Error:\n" + ex.getMessage());
        }   
        return isConnected;
    }    
    
    private void btnDbTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDbTestActionPerformed
        if (_isDbConnected()) {
            Message.showInformation("Conexión exitosa con la base de datos");            
        }
    }//GEN-LAST:event_btnDbTestActionPerformed

    private void txtFindDbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindDbActionPerformed
        final var fc = new JFileChooser();
        fc.setDialogTitle("Abrir base de datos");
        fc.setAcceptAllFileFilterUsed(false);
        var filter = new FileNameExtensionFilter("Base de datos", "db");
        fc.addChoosableFileFilter(filter);
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            txtPath.setText(fc.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_txtFindDbActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        File file = new File("c:\\data.ini");
        
        // not exists
        try {
            if (file.createNewFile()) { 
                //Message.showError(this, "no existe INI");
                Wini ini = new Wini(file);
                ini.add("DB", "path", "c:\\database.db");
                ini.store();                
            }
            else {
                //Message.showInformation(this, "Ya existe INI");
            }
        }                                
        catch (IOException e) {
           Message.showError("Error al crear archivo INI");
        }
        
        if (file.exists()) {
            try {
                Wini ini = new Wini(file);
                txtPath.setText(ini.get("DB", "path"));                
            } catch (IOException e) { 
                Message.showError("Error al leer archivo INI");
            }            
        }
        
        // express start
        txtUserName.setText("admin");
        txtPass.setText("1");
        //btnOk.doClick();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDbTest;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel pnlDatabase;
    private javax.swing.JButton txtFindDb;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPath;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
