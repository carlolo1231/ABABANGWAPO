
package ababangui;

import config.DbConnect;
import config.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AdminDashboard extends javax.swing.JFrame {

    
    public AdminDashboard() {
        setUndecorated(true);
        initComponents();
        
    }
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lname = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lname.setBackground(new java.awt.Color(204, 0, 51));
        lname.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lname.setForeground(new java.awt.Color(255, 255, 255));
        lname.setText("Lname");
        jPanel2.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 110, 32));

        fname.setBackground(new java.awt.Color(204, 0, 51));
        fname.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        fname.setForeground(new java.awt.Color(255, 255, 255));
        fname.setText("Fname");
        jPanel2.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 32));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton6.setText("LOGOUT");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 5));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 140, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 60));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 5));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton5.setText("Users");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 5, true));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 290, 80));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 730, 430));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 951, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        UserS userControl = new UserS();
        userControl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session sess = Session.getInstance();
       
       if(sess.getuid() == 0){
           JOptionPane.showMessageDialog(null,"No account found , Log in First!");
           LoginPage lf = new LoginPage();
           lf.setVisible(true);
           this.dispose();
       System.out.println("Session User ID: " + sess.getuid());
       }
       
       fname.setText(""+sess.getFname());
       lname.setText(""+sess.getLname());
    }//GEN-LAST:event_formWindowActivated

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
          int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "You have successfully logged out!", "Logout", JOptionPane.INFORMATION_MESSAGE);

            LoginPage li = new LoginPage();
            li.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fname;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lname;
    // End of variables declaration//GEN-END:variables
}
