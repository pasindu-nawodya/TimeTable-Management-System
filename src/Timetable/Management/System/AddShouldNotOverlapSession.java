/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timetable.Management.System;

import DB.DBconnection;
import java.awt.Font;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author user
 */
public class AddShouldNotOverlapSession extends javax.swing.JFrame {

    String gtype = "";
    String gId = "";
    String selectedSession = "";
    DefaultTableModel table ;
    Object[] column = new Object[3];
    ArrayList<Integer> sessions = new ArrayList<>(); 
    tableCellAlignment centerAlign = new tableCellAlignment();
    
    public AddShouldNotOverlapSession() {
        initComponents();
        setLocationRelativeTo(null);
        tableSettings();
       
    }

    
    public void tableSettings(){
   
      
        //table header alignment to center
        TableCellRenderer rendererFromHeader = jTable1.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getTableHeader().setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
        
       
                  
        //table row alignments to center
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerAlign);
        
      
   
   }
    public void createDBTable() throws SQLException, ClassNotFoundException {

        Connection con = new DBconnection().getDB();
        Statement stmt = con.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS shouldnotoverlapsessions  "
                + "(id int NOT NULL AUTO_INCREMENT, "
                + " sessionIdList VARCHAR(150), "
                + " PRIMARY KEY ( id ))";
        String sql1 = "ALTER TABLE shouldnotoverlapsessions AUTO_INCREMENT=120;";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        stmt.executeUpdate(sql1);

    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        gLable = new javax.swing.JLabel();
        group = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        session = new javax.swing.JComboBox<>();
        addSession = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        save = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        viewlist2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Should Not Overlap Sessions");
        setLocationByPlatform(true);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1200, 650));
        setMinimumSize(new java.awt.Dimension(1200, 650));

        jPanel2.setMaximumSize(new java.awt.Dimension(1200, 650));
        jPanel2.setMinimumSize(new java.awt.Dimension(1200, 650));
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 650));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/addshouldnot.jpg"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Group Type");

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Main Group", "Sub-Group" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });

        gLable.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        gLable.setText("Group ID");

        group.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("Session");

        session.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        session.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionActionPerformed(evt);
            }
        });

        addSession.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        addSession.setText("Add Session");
        addSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSessionActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sesssion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        save.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        save.setText("Save Should Not Overlap Session");
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

        viewlist2.setBackground(new java.awt.Color(255, 255, 255));
        viewlist2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        viewlist2.setText("View Should Not Overlap Sessions");
        viewlist2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewlist2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(viewlist2)
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(gLable, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(group, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(addSession)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(478, 478, 478))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(432, 432, 432))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(viewlist2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gLable, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(group, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addSession, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
       
            gtype = (String) type.getSelectedItem();
            group.removeAllItems();
            
            if(gtype.equals("Main Group")){
            
                   
                try {
                    Connection con = new DBconnection().getDB();
                    Statement stmt = con.createStatement();
                    String sql = "SELECT  groupid  from groupids";
                    ResultSet rs = stmt.executeQuery(sql);
                    
                    while(rs.next()){
                        
                        group.addItem(rs.getString("groupid"));
                        
                    }   } catch (SQLException ex) {
                    Logger.getLogger(AddShouldNotOverlapSession.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
                
                
            
            }else if(gtype.equals("Sub-Group")){
            
                try {
                    gLable.setText("Sub-Group ID");
                    
                    Connection con = new DBconnection().getDB();
                    Statement stmt = con.createStatement();
                    String sql = "SELECT  subgroupid  from subgroupids";
                    ResultSet rs = stmt.executeQuery(sql);
                    
                    while(rs.next()){
                        
                        group.addItem(rs.getString("subgroupid"));
                        
                    } 
                } catch (SQLException ex) {
                    Logger.getLogger(AddShouldNotOverlapSession.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             
        
    }//GEN-LAST:event_typeActionPerformed

    private void groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupActionPerformed
        try {
            // TODO add your handling code here:
            session.removeAllItems();
            gId = (String) group.getSelectedItem();
            
            Connection con = new DBconnection().getDB();
            Statement stmt = con.createStatement();
            String sql = "SELECT  subcode,tags  from session where groups = '"+gId+"';";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                
               session.addItem(rs.getString("subcode")+"/"+rs.getString("tags"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddShouldNotOverlapSession.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_groupActionPerformed

    private void sessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sessionActionPerformed

    private void addSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSessionActionPerformed

        if(type.getSelectedItem().equals("Select") || group.getSelectedItem().equals("Select") || session.getSelectedItem().equals("Select") ){

            JOptionPane.showMessageDialog(this,"Please Select Required Information","Error",JOptionPane.ERROR_MESSAGE);

        }else{

            try {
                selectedSession = (String) session.getSelectedItem();
                gId = (String) group.getSelectedItem();
                table = (DefaultTableModel) jTable1.getModel();
                column[0] = selectedSession;
                table.addRow(column);
                String[] str = selectedSession.split("/",2);

                Connection con = new DBconnection().getDB();
                Statement stmt = con.createStatement();
                String sql = "SELECT  id  from session where subcode = '"+str[0]+"' and tags = '"+str[1]+"' and groups = '"+gId+"'";
                ResultSet rs = stmt.executeQuery(sql);

                while(rs.next()){

                    sessions.add(rs.getInt("id"));

                }} catch (SQLException ex) {
                    Logger.getLogger(AddParallelSessions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_addSessionActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        

         if(sessions.size() == 0){

            JOptionPane.showMessageDialog(this,"Please Select Required Information","Error",JOptionPane.ERROR_MESSAGE);

        }
        else{
            try {

                createDBTable();
                String uniqueID = UUID.randomUUID().toString();
                String sessionList = "";

                for(Integer se:sessions){

                    sessionList = se+","+sessionList;
                }

                
                
                Connection con = new DBconnection().getDB();

                Statement stmt = con.createStatement();

                String sql = "INSERT INTO  shouldnotoverlapsessions(sessionIdList)  "
                +" VALUES ("
                +"'"+sessionList+"')";
                System.out.println(sql);
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

    private void viewlist2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewlist2ActionPerformed
        // TODO add your handling code here:
        new ViewShouldNotOverlapSessions().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_viewlist2ActionPerformed

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
            java.util.logging.Logger.getLogger(AddShouldNotOverlapSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddShouldNotOverlapSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddShouldNotOverlapSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddShouldNotOverlapSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddShouldNotOverlapSession().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSession;
    private javax.swing.JLabel gLable;
    private javax.swing.JComboBox<String> group;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton remove;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> session;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JButton viewlist2;
    // End of variables declaration//GEN-END:variables
}
