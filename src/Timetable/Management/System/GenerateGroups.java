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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class GenerateGroups extends javax.swing.JFrame {

    /**
     * Creates new form GenerateGroups
     */
    public GenerateGroups() throws SQLException {
        initComponents();
       showAcademicYear();
       showProgram();
       showGroup();
        setLocationRelativeTo(null);
        
    }

    
    public void showAcademicYear() throws SQLException{
    
    Statement stmt = null;
       Connection con = new DBconnection().getDB();
       stmt = con.createStatement();
       String sql = "SELECT Name from AcademicYear";
       
       ResultSet result = stmt.executeQuery(sql);
 
       
       while(result.next()){
             
          academic.addItem(result.getString("Name"));
             
       
       }
    
    
    }
    
     public void showProgram() throws SQLException{
    
    Statement stmt = null;
       Connection con = new DBconnection().getDB();
       stmt = con.createStatement();
       String sql = "SELECT Program from Program";
       
       ResultSet result = stmt.executeQuery(sql);
 
       
       while(result.next()){
             
          program.addItem(result.getString("Program"));
             
       
       }
    
    
    }
    
    
     
     public void showGroup() throws SQLException{
    
    Statement stmt = null;
       Connection con = new DBconnection().getDB();
       stmt = con.createStatement();
       String sql = "SELECT GroupNumber from GroupNumbers";
       
       ResultSet result = stmt.executeQuery(sql);
 
       
       while(result.next()){
             
          group.addItem(result.getString("GroupNumber"));
             
       
       }
    
    
    }
     
     public void createTable() throws SQLException{
     
      Connection con = new DBconnection().getDB();
          Statement stmt = con.createStatement();
          String sql = "CREATE TABLE IF NOT EXISTS GroupIDs  " +
                   "(id VARCHAR(225) not NULL, " +
                   " groupid VARCHAR(20) UNIQUE, " + 
                   " PRIMARY KEY ( id ))"; 
          
          
          stmt.executeUpdate(sql);
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        group = new javax.swing.JComboBox<>();
        program = new javax.swing.JComboBox<>();
        academic = new javax.swing.JComboBox<>();
        genId = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        viewlist1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generate Group IDs");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1200, 650));
        setMinimumSize(new java.awt.Dimension(1200, 650));

        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 650));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Select Academic Year andSemester");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Select Group Number");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Select Program");

        group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupActionPerformed(evt);
            }
        });

        program.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programActionPerformed(evt);
            }
        });

        academic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                academicActionPerformed(evt);
            }
        });

        genId.setBackground(new java.awt.Color(204, 204, 204));
        genId.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        genId.setText("Generate Group ID");
        genId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genIdActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/genGroupId.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(1200, 371));
        jLabel1.setMinimumSize(new java.awt.Dimension(1200, 371));
        jLabel1.setPreferredSize(new java.awt.Dimension(1200, 371));

        viewlist1.setBackground(new java.awt.Color(255, 255, 255));
        viewlist1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        viewlist1.setText("View Generated Group IDs");
        viewlist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewlist1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(viewlist1)
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(program, 0, 246, Short.MAX_VALUE)
                                .addComponent(group, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(academic, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(257, 257, 257)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(genId, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(442, 442, 442))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, Short.MAX_VALUE)
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(academic, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(viewlist1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(program, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(group, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(genId, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addGap(123, 123, 123))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1212, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupActionPerformed

    private void programActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_programActionPerformed

    private void academicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_academicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_academicActionPerformed

    private void genIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genIdActionPerformed
        try {
            createTable();
        } catch (SQLException ex) {
            Logger.getLogger(GenerateGroups.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String academicYear = (String) academic.getSelectedItem();
        String programIn = (String) program.getSelectedItem();
         int groupIn = Integer.parseInt((String) group.getSelectedItem());
        String groupid = "";
        if(groupIn <=9){
        
        groupid = academicYear+"."+programIn+".0"+groupIn;
        System.out.println(groupid);
        }else{
         groupid = academicYear+"."+programIn+"."+groupIn;
        
        }
       try{ 
        String uniqueID = UUID.randomUUID().toString();
          
           
          Connection con = new DBconnection().getDB();
           
         Statement stmt = con.createStatement();
           
             String sql = "INSERT INTO GroupIDs "
                                +" VALUES ("
                                +"'"+uniqueID+"' ,"
                                +"'"+groupid+"')";
             
             stmt.executeUpdate(sql);
                            
            
        //succes msg
        JOptionPane.showMessageDialog(this,groupid+" has added succesfully","Succesful",JOptionPane.INFORMATION_MESSAGE);
        // System.out.println(groupid);
       }catch(Exception e){
       
       JOptionPane.showMessageDialog(this, "Error","Error",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_genIdActionPerformed

    private void viewlist1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewlist1ActionPerformed
        try {
            // TODO add your handling code here:
            new ViewGeneratedGroups().setVisible(true);
            this.setVisible(false);
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
            java.util.logging.Logger.getLogger(GenerateGroups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateGroups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateGroups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateGroups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GenerateGroups().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GenerateGroups.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> academic;
    private javax.swing.JButton genId;
    private javax.swing.JComboBox<String> group;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> program;
    private javax.swing.JButton viewlist1;
    // End of variables declaration//GEN-END:variables
}
