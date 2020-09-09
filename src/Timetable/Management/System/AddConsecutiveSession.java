/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timetable.Management.System;

import DB.DBconnection;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author user
 */
public class AddConsecutiveSession extends javax.swing.JFrame {
    
ArrayList<String> sessions = new ArrayList<>();

 String subcode = "Select";
 String mtag = "";
 String gId = "";
 DefaultTableModel table ;
 Object[] column = new Object[3];
 tableCellAlignment centerAlign = new tableCellAlignment();

    public AddConsecutiveSession() throws SQLException {
        
        initComponents();
        setLocationRelativeTo(null);
        try{
        getSubjectList();
        tableSettings();
        }catch(Exception e){
        JOptionPane.showMessageDialog(this, "Please add sessions first","Error",JOptionPane.ERROR_MESSAGE);
        
        }
    }

   public void createDBTable() throws SQLException, ClassNotFoundException{
        
          Connection con = new DBconnection().getDB();
          Statement stmt = con.createStatement();
          String sql = "CREATE TABLE IF NOT EXISTS ConsecutiveSessions  " +
                   "(id int NOT NULL AUTO_INCREMENT, " +
                   " sessionIdList VARCHAR(150), " +
                   " PRIMARY KEY ( id ))"; 
          String sql1 = "ALTER TABLE ConsecutiveSessions AUTO_INCREMENT=100;";
          System.out.println(sql);
          stmt.executeUpdate(sql);
          stmt.executeUpdate(sql1);
         
      
    }
   
   
   public void getSubjectList() throws SQLException{
   
    Connection con = new DBconnection().getDB();
    Statement stmt = con.createStatement();
    String sql = "SELECT DISTINCT subcode from session "; 
    ResultSet rs = stmt.executeQuery(sql);
    
    while(rs.next()){
    
     subject.addItem(rs.getString("subcode"));
     
    
     
    }  
   }
   
  
   
   public void tableSettings(){
   
      
        //table header alignment to center
        TableCellRenderer rendererFromHeader = jTable1.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getTableHeader().setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
        
       
                  
        //table row alignments to center
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerAlign);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(centerAlign);
         jTable1.getColumnModel().getColumn(2).setCellRenderer(centerAlign);
      
   
   }
   
   
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        viewlist1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        subject = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        group = new javax.swing.JComboBox<>();
        addTag = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tag = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        save = new javax.swing.JButton();
        remove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Consecutive Sessions");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1200, 650));
        setMinimumSize(new java.awt.Dimension(1200, 650));

        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 650));

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/addconsecutive.jpg"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(1200, 371));
        jLabel1.setMinimumSize(new java.awt.Dimension(1200, 371));
        jLabel1.setPreferredSize(new java.awt.Dimension(1600, 371));

        viewlist1.setBackground(new java.awt.Color(255, 255, 255));
        viewlist1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        viewlist1.setText("View Consecutive Sessions");
        viewlist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewlist1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Group ID");

        subject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        subject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subjectMouseClicked(evt);
            }
        });
        subject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setText("Module Code");

        group.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        group.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groupMouseClicked(evt);
            }
        });
        group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupActionPerformed(evt);
            }
        });

        addTag.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        addTag.setText("Add Session");
        addTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTagActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setText("Session Tag");

        tag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        tag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tagMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tagMouseReleased(evt);
            }
        });
        tag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagActionPerformed(evt);
            }
        });
        tag.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tagPropertyChange(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Module Code", "Session Tag", "Group ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        save.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        save.setText("Save Consecutive Session");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        remove.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        remove.setText("Remove Session");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(482, 482, 482)
                .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(viewlist1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(group, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(addTag))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(258, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(viewlist1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(group, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addTag, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1220, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewlist1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewlist1ActionPerformed
    try {
        new ViewConsecutiveSessions().setVisible(true);
        this.setVisible(false);
    } catch (SQLException ex) {
        Logger.getLogger(AddConsecutiveSession.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_viewlist1ActionPerformed

    private void subjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectActionPerformed
    try {
        // TODO add your handling code here:
        tag.removeAllItems();
        subcode  = (String) subject.getSelectedItem();
        
        Connection con = new DBconnection().getDB();
        Statement stmt = con.createStatement();
        String sql = "SELECT DISTINCT tags from session where subcode = '"+subcode+"'";
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            
           tag.addItem(rs.getString("tags"));
            
            
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(AddConsecutiveSession.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        
    }//GEN-LAST:event_subjectActionPerformed

    private void groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupActionPerformed

    private void tagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagActionPerformed
        // TODO add your handling code here:
        try {
        // TODO add your handling code here:
        group.removeAllItems();
        mtag  = (String) tag.getSelectedItem();
        
        Connection con = new DBconnection().getDB();
        Statement stmt = con.createStatement();
        String sql = "SELECT DISTINCT groups from session where subcode = '"+subcode+"' and tags = '"+mtag+"'";
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            
          group.addItem(rs.getString("groups"));
            
            
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(AddConsecutiveSession.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_tagActionPerformed

    private void groupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupMouseClicked
        // TODO add your handling code here:
        System.out.println("c");
    }//GEN-LAST:event_groupMouseClicked

    private void tagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tagMouseClicked
        // TODO add your handling code here:
         
    }//GEN-LAST:event_tagMouseClicked

    private void subjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_subjectMouseClicked

    private void tagMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tagMouseReleased
        // TODO add your handling code here:
      
    }//GEN-LAST:event_tagMouseReleased

    private void tagPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tagPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tagPropertyChange

    private void addTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTagActionPerformed
        // TODO add your handling code here:
       
        if(subcode.equals("Select")){
        
         JOptionPane.showMessageDialog(this,"Please Select Required Information","Error",JOptionPane.ERROR_MESSAGE);
        
        }else{
        
            try {
                subcode = (String) subject.getSelectedItem();
                mtag = (String) tag.getSelectedItem();
                gId = (String) group.getSelectedItem();
                
                table = (DefaultTableModel) jTable1.getModel();
                column[0] = subcode;
                column[1] = mtag;
                column[2] = gId;
                
                table.addRow(column);
                
                
                
                
                Connection con = new DBconnection().getDB();
                Statement stmt = con.createStatement();
                String sql = "SELECT DISTINCT id from session where subcode = '"+subcode+"' and tags = '"+mtag+"' and groups = '"+gId+"'";
                ResultSet rs = stmt.executeQuery(sql);
                
                while(rs.next()){
                    
                    sessions.add(rs.getString("id"));
                    
                    
                    
                }   } catch (SQLException ex) {
                Logger.getLogger(AddConsecutiveSession.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        
        }
         
    }//GEN-LAST:event_addTagActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    
         if(subcode.equals("Select") ){
        
         JOptionPane.showMessageDialog(this,"Please Select Required Information","Error",JOptionPane.ERROR_MESSAGE);
        
        }else if(sessions.size() == 0){
        JOptionPane.showMessageDialog(this,"Please add sessions first","Error",JOptionPane.ERROR_MESSAGE);
        
        }
        else{
        try {
        // TODO add your handling code here:
        createDBTable();
        String uniqueID = UUID.randomUUID().toString();
        String sessionList = "";
        
        for(String s:sessions){
        
        sessionList = s+","+sessionList;
        }
        
              
                
                Connection con = new DBconnection().getDB();
                
                Statement stmt = con.createStatement();
                
                String sql = "INSERT INTO  ConsecutiveSessions(sessionIdList)  "
                        +" VALUES ("
                        +"'"+sessionList+"' )";
                       
                       
                
                
                stmt.executeUpdate(sql);
                
                
                //succes msg
                JOptionPane.showMessageDialog(this," Details added succesfully","Succesful",JOptionPane.INFORMATION_MESSAGE);
                
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(AddConsecutiveSession.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this,"Error","Error",JOptionPane.ERROR_MESSAGE);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(AddConsecutiveSession.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this,"Error","Error",JOptionPane.ERROR_MESSAGE);
    }
             
         }        
   
    }//GEN-LAST:event_saveActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        if(index != -1) {   
        int modelIndex = jTable1.convertRowIndexToModel(index); // converts the row index in the view to the appropriate index in the model
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.removeRow(modelIndex);
        
        sessions.remove(index);
        }else{
        
        JOptionPane.showMessageDialog(this, "Please select a record","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_removeActionPerformed
   
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
            java.util.logging.Logger.getLogger(AddConsecutiveSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddConsecutiveSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddConsecutiveSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddConsecutiveSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddConsecutiveSession().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AddConsecutiveSession.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTag;
    private javax.swing.JComboBox<String> group;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton remove;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> subject;
    private javax.swing.JComboBox<String> tag;
    private javax.swing.JButton viewlist1;
    // End of variables declaration//GEN-END:variables
}
