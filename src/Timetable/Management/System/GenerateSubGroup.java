/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timetable.Management.System;

import DB.DBconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class GenerateSubGroup extends javax.swing.JFrame {

    /**
     * Creates new form GenerateSubGroup
     */
    public GenerateSubGroup() throws SQLException {
        initComponents();
        showGroupId();
        subGroupNumber();
         setLocationRelativeTo(null);
    }

   public void showGroupId() throws SQLException{
    
    Statement stmt = null;
       Connection con = new DBconnection().getDB();
       stmt = con.createStatement();
       String sql = "SELECT groupid from GroupIDs";
       
       ResultSet result = stmt.executeQuery(sql);
 
       
       while(result.next()){
             
          groupid.addItem(result.getString("groupid"));
             
       
       }
    
    
    }
    
     public void subGroupNumber() throws SQLException{
    
    Statement stmt = null;
       Connection con = new DBconnection().getDB();
       stmt = con.createStatement();
       String sql = "SELECT SubGroupNumber from SubGroupNumbers ";
       
       ResultSet result = stmt.executeQuery(sql);
 
       
       while(result.next()){
             
          subgroup.addItem(result.getString("SubGroupNumber"));
             
       
       }
    
    
    }
     
      public void createTable() throws SQLException{
     
      Connection con = new DBconnection().getDB();
          Statement stmt = con.createStatement();
          String sql = "CREATE TABLE IF NOT EXISTS SubGroupIDs  " +
                   "(id VARCHAR(225) not NULL, " +
                   " subgroupid VARCHAR(20) UNIQUE, " + 
                   " PRIMARY KEY ( id ))"; 
          
          
          stmt.executeUpdate(sql);
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        groupid = new javax.swing.JComboBox<>();
        subgroup = new javax.swing.JComboBox<>();
        genSubGroup = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        viewlist1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generate Sub Group IDs");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1200, 650));
        setMinimumSize(new java.awt.Dimension(1200, 650));

        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 650));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Select sub group number");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Select Group ID");

        groupid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupidActionPerformed(evt);
            }
        });

        subgroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subgroupActionPerformed(evt);
            }
        });

        genSubGroup.setBackground(new java.awt.Color(204, 204, 204));
        genSubGroup.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        genSubGroup.setText("Generate Sub-group ID");
        genSubGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genSubGroupActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/genSubGroupId.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(1200, 371));
        jLabel1.setMinimumSize(new java.awt.Dimension(1200, 371));
        jLabel1.setPreferredSize(new java.awt.Dimension(1200, 371));

        viewlist1.setBackground(new java.awt.Color(255, 255, 255));
        viewlist1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        viewlist1.setText("View Generated Sub Group IDs");
        viewlist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewlist1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(groupid, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subgroup, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(335, 335, 335))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(genSubGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(489, 489, 489))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(viewlist1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, Short.MAX_VALUE)
                .addGap(41, 41, 41)
                .addComponent(viewlist1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subgroup, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(81, 81, 81)
                .addComponent(genSubGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void groupidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupidActionPerformed
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_groupidActionPerformed

    private void subgroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subgroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subgroupActionPerformed

    private void genSubGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genSubGroupActionPerformed
         try {
            createTable();
        } catch (SQLException ex) {
            Logger.getLogger(GenerateGroups.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String groupId = (String) groupid.getSelectedItem();
        String sub = (String) subgroup.getSelectedItem();
        
        String groupid = "";
       
        groupid = groupId+"."+sub;
        
       try{ 
        String uniqueID = UUID.randomUUID().toString();
          
           
          Connection con = new DBconnection().getDB();
           
         Statement stmt = con.createStatement();
           
             String sql = "INSERT INTO SubGroupIDs "
                                +" VALUES ("
                                +"'"+uniqueID+"' ,"
                                +"'"+groupid+"')";
              System.out.println(sql);
             
             stmt.executeUpdate(sql);
                            
            
        //succes msg
        JOptionPane.showMessageDialog(this,groupid+" has added succesfully","Succesful",JOptionPane.INFORMATION_MESSAGE);
        // System.out.println(groupid);
       }catch(Exception e){
       
       JOptionPane.showMessageDialog(this, "Error","Error",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_genSubGroupActionPerformed

    private void viewlist1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewlist1ActionPerformed
        try {
            // TODO add your handling code here:
            new ViewGeneratedSubGroups().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AddTags.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewlist1ActionPerformed

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
            java.util.logging.Logger.getLogger(GenerateSubGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateSubGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateSubGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateSubGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GenerateSubGroup().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GenerateSubGroup.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton genSubGroup;
    private javax.swing.JComboBox<String> groupid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> subgroup;
    private javax.swing.JButton viewlist1;
    // End of variables declaration//GEN-END:variables
}
