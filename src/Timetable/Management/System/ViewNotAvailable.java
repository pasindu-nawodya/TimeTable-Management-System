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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author user
 */
public class ViewNotAvailable extends javax.swing.JFrame {

    DefaultTableModel table ;
    String editable1 = "";
    String editable2= "";
    String editable3 = "";
    String editable4 = "";
    tableCellAlignment centerAlign = new tableCellAlignment();
   
   
   public ViewNotAvailable() {
        initComponents();
        setLocationRelativeTo(null);
        try{
        showDetails();
        selectRow();
        
        }catch(Exception e){
            System.out.println(e);
          JOptionPane.showMessageDialog(this, "No records found.Please add records.","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void showDetails() throws SQLException{
     
        //table header alignment to center
        TableCellRenderer rendererFromHeader = jTable1.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
         jTable1.getTableHeader().setFont(new Font("TimesNewRoman", Font.PLAIN, 16));
         
        //table row alignments to center
      jTable1.getColumnModel().getColumn(0).setCellRenderer(centerAlign);
      jTable1.getColumnModel().getColumn(1).setCellRenderer(centerAlign);
      jTable1.getColumnModel().getColumn(2).setCellRenderer(centerAlign);
      jTable1.getColumnModel().getColumn(3).setCellRenderer(centerAlign);
      jTable1.getColumnModel().getColumn(4).setCellRenderer(centerAlign);
       
        
       Statement stmt = null;
       Connection con = new DBconnection().getDB();
       stmt = con.createStatement();
       String sql = "SELECT * from notavailabletime";
       
       ResultSet result = stmt.executeQuery(sql);
        table = (DefaultTableModel) jTable1.getModel(); 
       Object[] column = new Object[5];
       
      
       
       while(result.next()){
             
             column[0] = result.getString("type");
             
             if(result.getString("type").equals("Session")){
             
             stmt = con.createStatement();
             String sql1 = "SELECT subcode,tags,groups from session where id = '"+result.getString("typeId")+"'";
             System.out.println(sql1);
             ResultSet result1 = stmt.executeQuery(sql1);
             
             if(result1.next()){
              column[1] = result1.getString("subcode")+" | "+result1.getString("tags")+" | "+result1.getString("groups");
             }
            
             
             }else{
             
             column[1] = result.getString("typeId");
             
             }
             column[2] = result.getString("day");
             column[3] = result.getString("startTime");
             column[4] = result.getString("endTime");
   
             table.addRow(column);
             
       
       }
       
       con.close();
    
    }
    
    
    
    
    
     public void selectRow(){
     jTable1.addMouseListener(new MouseAdapter(){
     
           public void mousePressed(MouseEvent me) {
                jTable1 = (JTable)me.getSource();
                int row = jTable1.getSelectedRow();
                
                
                 editable1 = String.valueOf(jTable1.getValueAt(row, 1)) ;
                 editable2 = String.valueOf(jTable1.getValueAt(row, 2)) ;
                 editable3 = String.valueOf(jTable1.getValueAt(row, 3)) ;
                 editable4 = String.valueOf(jTable1.getValueAt(row, 4)) ;
                 
                 
                
            }
     });
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Not Available Time");
        setLocationByPlatform(true);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1200, 650));
        setMaximumSize(new java.awt.Dimension(1200, 650));
        setMinimumSize(new java.awt.Dimension(1200, 650));

        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 650));

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/viewNotAvailable.jpg"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(1200, 371));
        jLabel1.setMinimumSize(new java.awt.Dimension(1200, 371));
        jLabel1.setPreferredSize(new java.awt.Dimension(1600, 371));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "ID", "Day", "Start Time", "End Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(0, 102, 255));
        jScrollPane1.setViewportView(jTable1);

        add.setBackground(new java.awt.Color(204, 204, 204));
        add.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        add.setText("Add Not Available Time");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(204, 204, 204));
        delete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        delete.setText("Remove Not Available Time");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(add)
                .addGap(27, 27, 27)
                .addComponent(delete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        new AddNotAvailableTime().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
        System.out.println("cc"+editable1);
        int index = jTable1.getSelectedRow();
       if(index != -1) {
            try{
            int a = JOptionPane.showConfirmDialog(this, "Are you sure?");
            if(a==JOptionPane.YES_OPTION){  
      
 
        int modelIndex = jTable1.convertRowIndexToModel(index); // converts the row index in the view to the appropriate index in the model
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.removeRow(modelIndex);
        
        
        Statement stmt = new DBconnection().getDB().createStatement();
                
                String sql = "DELETE FROM notavailabletime" +
                   " WHERE typeId = '"+editable1+"' and Day = '"+editable2+"' and startTime = '"+editable3+"' and endTime = '"+editable4+"'";
                
                stmt.executeUpdate(sql);
                
            //success msg
            JOptionPane.showMessageDialog(this, "Record deleted succesfully","Successful",JOptionPane.INFORMATION_MESSAGE);
            
        }
       }catch(Exception e){
       JOptionPane.showMessageDialog(this, "Error","Error",JOptionPane.ERROR_MESSAGE);
       
       }
    }else{
       
       JOptionPane.showMessageDialog(this, "Please select a record","Error",JOptionPane.ERROR_MESSAGE);
       }
       
       
    }//GEN-LAST:event_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(ViewNotAvailable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewNotAvailable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewNotAvailable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewNotAvailable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewNotAvailable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
