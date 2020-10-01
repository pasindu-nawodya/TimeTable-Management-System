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
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author user
 */
public class AddNotAvailableTime extends javax.swing.JFrame {

    String type = "";
    String day = "";
    String xxx = "";
    String sessionId = "";
    
    public AddNotAvailableTime() {
        initComponents();
        setLocationRelativeTo(null);
    }

    
    public void createDBTable() throws SQLException, ClassNotFoundException{
        
          Connection con = new DBconnection().getDB();
          Statement stmt = con.createStatement();
          String sql = "CREATE TABLE IF NOT EXISTS NotAvailableTime  " +
                   "(id int NOT NULL AUTO_INCREMENT, " +
                   " type VARCHAR(25), " + 
                   " typeId VARCHAR(100), " + 
                   " Day VARCHAR(10) , " + 
                   " startTime TIME , " + 
                   " endTime TIME , " +  
                   " PRIMARY KEY ( id ))"; 
        String sql1 = "ALTER TABLE NotAvailableTime AUTO_INCREMENT=1000;";
        stmt.executeUpdate(sql);
        stmt.executeUpdate(sql1);
        con.close();  
          
      
    }
    public void showDetails() throws SQLException{
    
        selectbox.removeAllItems();
        if(type.equals("Lecturer")){
            
              System.out.println("l");
       Statement stmt = null;
       Connection con = new DBconnection().getDB();
       stmt = con.createStatement();
       String sql = "SELECT lecid from lecturer";
       
       ResultSet result = stmt.executeQuery(sql);
 
       
       while(result.next()){
             
         selectbox.addItem(result.getString("lecid"));
             
       
       }
       con.close();
       }else if(type.equals("Session")){
     System.out.println("s");
       Statement stmt = null;
       Connection con = new DBconnection().getDB();
       stmt = con.createStatement();
       String sql = "SELECT subcode,tags,groups from session";
       
       ResultSet result = stmt.executeQuery(sql);
 
       
       while(result.next()){
             
         selectbox.addItem(result.getString("subcode")+"/"+result.getString("tags")+"/"+result.getString("groups"));
           
       }
           con.close();
       }else if(type.equals("Group")){
           System.out.println("g");
       Statement stmt = null;
       Connection con = new DBconnection().getDB();
       stmt = con.createStatement();
       String sql = "SELECT groupid from groupids";
       
       ResultSet result = stmt.executeQuery(sql);
 
       
       while(result.next()){
             
         selectbox.addItem(result.getString("groupid"));
           
       }
       con.close();
       }else if(type.equals("Sub-group")){
           System.out.println("sub");
        Statement stmt = null;
       Connection con = new DBconnection().getDB();
       stmt = con.createStatement();
       String sql = "SELECT subgroupid from subgroupids";
       
       ResultSet result = stmt.executeQuery(sql);
 
       
       while(result.next()){
             
         selectbox.addItem(result.getString("subgroupid"));
           
       }
       con.close();
       }
    
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        viewlist1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        typebox = new javax.swing.JComboBox<>();
        stype = new javax.swing.JLabel();
        selectbox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        daybox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        SpinnerModel spinnerModel = new SpinnerNumberModel(00, //initial value
            0, //min
            12, //max
            1);//step
        startHour = new javax.swing.JSpinner(spinnerModel);
        SpinnerModel spinnerModel1 = new SpinnerNumberModel(00, //initial value
            0, //min
            59, //max
            1);//step
        startMin = new javax.swing.JSpinner(spinnerModel1);
        amPm = new javax.swing.JComboBox<>();
        amPm1 = new javax.swing.JComboBox<>();
        SpinnerModel spinnerModel3 = new SpinnerNumberModel(00, //initial value
            0, //min
            59, //max
            1);//step
        endMin = new javax.swing.JSpinner(spinnerModel3);
        SpinnerModel spinnerModel2 = new SpinnerNumberModel(00, //initial value
            0, //min
            12, //max
            1);//step
        endHour = new javax.swing.JSpinner(spinnerModel2);
        jLabel2 = new javax.swing.JLabel();
        add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Not Available Time");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1200, 650));
        setMinimumSize(new java.awt.Dimension(1200, 650));

        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 650));

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/addnotavailable.jpg"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(1200, 371));
        jLabel1.setMinimumSize(new java.awt.Dimension(1200, 371));
        jLabel1.setPreferredSize(new java.awt.Dimension(1600, 371));

        viewlist1.setBackground(new java.awt.Color(255, 255, 255));
        viewlist1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        viewlist1.setText("View Not Available Times");
        viewlist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewlist1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Select Type");

        typebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Lecturer", "Session", "Group", "Sub-group" }));
        typebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeboxActionPerformed(evt);
            }
        });

        stype.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        stype.setText("Select ID");

        selectbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        selectbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectboxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Select Day");

        daybox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday ", "Saturday", "Sunday" }));
        daybox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayboxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Select Start Time");

        amPm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        amPm1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Select End Time");

        add.setBackground(new java.awt.Color(204, 204, 204));
        add.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        add.setText("Add Not Available Time");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(viewlist1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stype, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(106, 106, 106)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typebox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(daybox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(endHour, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(startHour))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(startMin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(amPm, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(endMin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(amPm1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(360, 360, 360))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(438, 438, 438)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typebox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(viewlist1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stype, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daybox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startHour, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startMin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amPm, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endHour, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endMin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amPm1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
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

    private void viewlist1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewlist1ActionPerformed
        new ViewNotAvailable().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_viewlist1ActionPerformed

    private void typeboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeboxActionPerformed
        // TODO add your handling code here:

        type = (String) typebox.getSelectedItem();
        System.out.println(type);
        if(type.equals("Select")){
            stype.setText("Select ID");
            
        }else if(type.equals("Lecturer")){
            stype.setText("Select Lecturer ID");
            
        }else if(type.equals("Session")){
            stype.setText("Select Session");
            
        }else if(type.equals("Group")){
            stype.setText("Select Group ID");
        }else if(type.equals("Sub-group")){
            stype.setText("Select Sub-group ID");
        }
        try {
            System.out.println("1");
            showDetails();
        } catch (SQLException ex) {
           // Logger.getLogger(this.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_typeboxActionPerformed

    private void selectboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectboxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_selectboxActionPerformed

    private void dayboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayboxActionPerformed
        day = (String) selectbox.getSelectedItem();

    }//GEN-LAST:event_dayboxActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try {
            // TODO add your handling code here:
            createDBTable();
        } catch (SQLException ex) {
            Logger.getLogger(AddNotAvailableTime.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddNotAvailableTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        day = (String) daybox.getSelectedItem();
        int sHour = (int) startHour.getValue();
        int eHour = (int) endHour.getValue();
        int sMin  = (int) startMin.getValue();
        int eMin  = (int) endMin.getValue();
        String ampm = (String) amPm.getSelectedItem();
        String ampm1 = (String) amPm1.getSelectedItem();
        String startTime = "";
        String endTime = "";
        String id = (String) selectbox.getSelectedItem();

        if(type.equals("") ||day.equals("") || sHour == 0 || eHour == 0  ){

            JOptionPane.showMessageDialog(this,"Please Select Required Information","Error",JOptionPane.ERROR_MESSAGE);
           
        }
        else{

            try {
                if(ampm.equals("PM")){
                    
                    if(sHour == 1){
                        sHour = 13;
                    }else if(sHour == 2){
                        
                        sHour = 14;
                    }else if(sHour == 3){
                        
                        sHour = 15;
                    }else if(sHour == 4){
                        
                        sHour = 16;
                    }else if(sHour == 5){
                        
                        sHour = 17;
                    }else if(sHour == 6){
                        
                        sHour = 18;
                    }else if(sHour == 7){
                        
                        sHour = 19;
                    }else if(sHour == 8){
                        
                        sHour = 20;
                    }else if(sHour == 9){
                        
                        sHour = 21;
                    }else if(sHour == 10){
                        
                        sHour = 22;
                    }else if(sHour == 11){
                        
                        sHour = 23;
                    }
                    
                }else if(ampm.equals("AM") && sHour == 12){
                    sHour = 00;
                }
                //------------------------------------------------------------------------------------------
                if(ampm1.equals("PM")){
                    
                    if(eHour == 1){
                        eHour = 13;
                    }else if(eHour == 2){
                        
                        eHour = 14;
                    }else if(eHour == 3){
                        
                        eHour = 15;
                    }else if(eHour == 4){
                        
                        eHour = 16;
                    }else if(eHour == 5){
                        
                        eHour = 17;
                    }else if(eHour == 6){
                        
                        eHour = 18;
                    }else if(eHour == 7){
                        
                        eHour = 19;
                    }else if(eHour == 8){
                        
                        eHour = 20;
                    }else if(eHour == 9){
                        
                        eHour = 21;
                    }else if(eHour == 10){
                        
                        eHour = 22;
                    }else if(eHour == 11){
                        
                        eHour = 23;
                    }
                    
                }else if(ampm1.equals("AM") && eHour == 12){
                    eHour = 00;
                }
                
                
                //----------------------------------------------------------------------------------
                if(sHour > eHour){
                    
                 startHour.setValue(0);
                 endHour.setValue(0);
                 startMin.setValue(0);
                 endMin.setValue(0);
                 throw new ArithmeticException("exception");
                
                }else if(sHour == eHour && sMin > eMin){
                
                 startHour.setValue(0);
                 endHour.setValue(0);
                 startMin.setValue(0);
                 endMin.setValue(0);
                 throw new ArithmeticException("exception");
                
                }
                
                
                //----------------------------------------------------------------------------------
                
                
                
                
                startTime = sHour+":"+sMin+":00";
                endTime = eHour+":"+eMin+":00";
                
                if(type.equals("Session")){
                    
                    
                    try {
                        String[] sessionArray = id.split("/",3);
                        
                        
                        
                        Statement stmt = null;
                        Connection con = new DBconnection().getDB();
                        stmt = con.createStatement();
                        String sql = "SELECT id from session where subcode = '"+sessionArray[0]+"' and tags = '"+sessionArray[1]+"' and groups = '"+sessionArray[2]+"'";
                        System.out.println(sql);
                        ResultSet result = stmt.executeQuery(sql);
                        
                        
                        while(result.next()){
                            
                            id = result.getString("id");
                            
                            
                            
                        }      
                    con.close();
                    } catch (Exception ex) {
                            Logger.getLogger(AddNotAvailableTime.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                }
                
                
                
                String uniqueID = UUID.randomUUID().toString();
                
                
                Connection con = new DBconnection().getDB();
                
                Statement stmt = con.createStatement();
                
                String sql = "INSERT INTO NotAvailableTime(type,typeId,Day,startTime,endTime)  "
                        +" VALUES ("
                        +"'"+type+"' ,"
                        +"'"+id+"' ,"
                         +"'"+day+"' ,"
                         +"'"+startTime+"' ,"
                         +"'"+endTime+"' )";
                       
                
                
                stmt.executeUpdate(sql);
                con.close();
                
                //succes msg
                JOptionPane.showMessageDialog(this," Details added succesfully","Succesful",JOptionPane.INFORMATION_MESSAGE);
                
            } catch (SQLException ex) {
                Logger.getLogger(AddNotAvailableTime.class.getName()).log(Level.SEVERE, null, ex);
               
            }catch (ArithmeticException ex) {
               JOptionPane.showMessageDialog(this, "Start time should be less than end time","Error",JOptionPane.ERROR_MESSAGE);
               
            }
          
    }//GEN-LAST:event_addActionPerformed
    }
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
            java.util.logging.Logger.getLogger(AddNotAvailableTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNotAvailableTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNotAvailableTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNotAvailableTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNotAvailableTime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JComboBox<String> amPm;
    private javax.swing.JComboBox<String> amPm1;
    private javax.swing.JComboBox<String> daybox;
    private javax.swing.JSpinner endHour;
    private javax.swing.JSpinner endMin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> selectbox;
    private javax.swing.JSpinner startHour;
    private javax.swing.JSpinner startMin;
    private javax.swing.JLabel stype;
    private javax.swing.JComboBox<String> typebox;
    private javax.swing.JButton viewlist1;
    // End of variables declaration//GEN-END:variables
}
