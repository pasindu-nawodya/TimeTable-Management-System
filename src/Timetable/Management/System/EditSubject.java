/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timetable.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author swpas
 */
public class EditSubject extends javax.swing.JFrame {

    /**
     * Creates new form EditSubject
     */
    public EditSubject() {
        initComponents();
        getSubidCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idcombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        eval = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        EditSubject = new javax.swing.JButton();
        BacSubject = new javax.swing.JButton();
        lec = new javax.swing.JTextField();
        lab = new javax.swing.JTextField();
        tute = new javax.swing.JTextField();
        submitID = new javax.swing.JButton();
        semcombo1 = new javax.swing.JComboBox<>();
        yearcombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Time Table Management System");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/EditSub.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("Select Subject Code :");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Offered Year      :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Offered Sem       :");

        name.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        name.setDropMode(javax.swing.DropMode.INSERT);
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("Subject Name    :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Lecture Hour    :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Tute Hours        :");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("Lab Hours         :");

        eval.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Eval. Hours       :");

        EditSubject.setBackground(new java.awt.Color(204, 204, 204));
        EditSubject.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        EditSubject.setText("Edit");
        EditSubject.setMaximumSize(new java.awt.Dimension(63, 29));
        EditSubject.setMinimumSize(new java.awt.Dimension(63, 29));
        EditSubject.setPreferredSize(new java.awt.Dimension(63, 29));
        EditSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditSubjectActionPerformed(evt);
            }
        });

        BacSubject.setBackground(new java.awt.Color(204, 204, 204));
        BacSubject.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BacSubject.setText("Back");
        BacSubject.setMaximumSize(new java.awt.Dimension(63, 29));
        BacSubject.setMinimumSize(new java.awt.Dimension(63, 29));
        BacSubject.setPreferredSize(new java.awt.Dimension(63, 29));
        BacSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BacSubjectActionPerformed(evt);
            }
        });

        lec.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lec.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lec.setDropMode(javax.swing.DropMode.INSERT);
        lec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecActionPerformed(evt);
            }
        });

        lab.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lab.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lab.setDropMode(javax.swing.DropMode.INSERT);
        lab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labActionPerformed(evt);
            }
        });

        tute.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tute.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tute.setDropMode(javax.swing.DropMode.INSERT);
        tute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuteActionPerformed(evt);
            }
        });

        submitID.setBackground(new java.awt.Color(204, 204, 204));
        submitID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        submitID.setText("submit");
        submitID.setMaximumSize(new java.awt.Dimension(63, 29));
        submitID.setMinimumSize(new java.awt.Dimension(63, 29));
        submitID.setPreferredSize(new java.awt.Dimension(63, 29));
        submitID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitIDActionPerformed(evt);
            }
        });

        semcombo1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        semcombo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Semester", "2nd Semester" }));

        yearcombo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        yearcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st year", "2nd year", "3rd year", "4th year" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(idcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(submitID, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(443, 443, 443))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(eval)
                                    .addComponent(lec)
                                    .addComponent(lab)
                                    .addComponent(tute, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(EditSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(32, 32, 32)
                                            .addComponent(BacSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(semcombo1, 0, 503, Short.MAX_VALUE)
                                        .addComponent(yearcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(343, 343, 343))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(submitID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(yearcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semcombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(eval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BacSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    Connection con;
    PreparedStatement show;
    
    //get id list to combo
    private void getSubidCombo(){
        try { 
             Class.forName("com.mysql.jdbc.Driver");

             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/timetablems","root","1234");

             Statement statement = connection.createStatement();
             String query = "SELECT code FROM subject";
             ResultSet rs = statement.executeQuery(query);

             while (rs.next())
             {      
                String lid = rs.getString("code");         
                idcombo.addItem(rs.getString("code"));
             }//end while
             connection.close();
             } catch (Exception e) {
                  e.printStackTrace();
             }
    }
    
    
    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void EditSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditSubjectActionPerformed
        // TODO add your handling code here:
        Connection con;
        PreparedStatement update;
        
        String selectedIDs = (String)idcombo.getSelectedItem();
        
        String year = (String)yearcombo.getSelectedItem( );        
        String sem = (String)semcombo1.getSelectedItem( );
        String sname = name.getText();
        String slec = lec.getText();
        String stute = tute.getText();
        String slab = lab.getText();
        String seval = eval.getText();        

        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/timetablems","root","1234");
            
            update = con.prepareStatement("update subject set year=?,semester=?,name=?,lec=?,tute=?,lab=?,eval=? where code=?");
            update.setString(1, year);
            update.setString(2, sem);
            update.setString(3, sname);
            update.setString(4, slec);
            update.setString(5, stute);
            update.setString(6, slab);
            update.setString(7, seval);
            update.setString(8, selectedIDs);
            
            update.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Subject "+ selectedIDs +" updated successfully!");
            
            new subjectlist().setVisible(true);
            dispose();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(AddLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_EditSubjectActionPerformed

    private void BacSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BacSubjectActionPerformed
        // TODO add your handling code here:
        new SystemSubject().setVisible(true);
        dispose();
    }//GEN-LAST:event_BacSubjectActionPerformed

    private void lecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lecActionPerformed

    private void labActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_labActionPerformed

    private void tuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tuteActionPerformed

    private void submitIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitIDActionPerformed
        // TODO add your handling code here:
            String selectedID = (String)idcombo.getSelectedItem();
               
             try {
            
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/timetablems","root","1234");

                show = con.prepareStatement("select * from subject where code = '"+ selectedID+"'");
                ResultSet rs = show.executeQuery();
                               
                while (rs.next())
                {      
                   yearcombo.setSelectedItem(rs.getString("year"));
                   semcombo1.setSelectedItem(rs.getString("semester"));
                   name.setText(rs.getString("name"));
                   lec.setText(rs.getString("lec"));
                   tute.setText(rs.getString("tute"));
                   lab.setText(rs.getString("lab"));
                   eval.setText(rs.getString("eval"));
                }//end while        
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(subjectlist.class.getName()).log(Level.SEVERE, null, ex);
            }catch (SQLException ex) {
                Logger.getLogger(subjectlist.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_submitIDActionPerformed

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
            java.util.logging.Logger.getLogger(EditSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditSubject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BacSubject;
    private javax.swing.JButton EditSubject;
    private javax.swing.JTextField eval;
    private javax.swing.JComboBox<String> idcombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lab;
    private javax.swing.JTextField lec;
    private javax.swing.JTextField name;
    private javax.swing.JComboBox<String> semcombo1;
    private javax.swing.JButton submitID;
    private javax.swing.JTextField tute;
    private javax.swing.JComboBox<String> yearcombo;
    // End of variables declaration//GEN-END:variables
}
