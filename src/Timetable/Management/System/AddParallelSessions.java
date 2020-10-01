/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timetable.Management.System;

import DB.DBconnection;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author user
 */
public class AddParallelSessions extends javax.swing.JFrame {

    String sessionDuration = "";
    String selectedSession = "";
    String gId = "";
    int sHour = 0;
    int sMin = 0;
    String amPm = "";
    String sessionDay = "";
    String mcode = "";
    String mtag = "";
    Object[] column = new Object[1];
    DefaultTableModel table;
    ArrayList<Integer> sessions = new ArrayList<>();
    tableCellAlignment centerAlign = new tableCellAlignment();

    public AddParallelSessions() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        showDetails();
        tableSettings();

    }

    public void createDBTable() throws SQLException, ClassNotFoundException {

        Connection con = new DBconnection().getDB();
        Statement stmt = con.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS parallelsessions  "
                + "(id int NOT NULL AUTO_INCREMENT, "
                + " startTime TIME, "
                + " day VARCHAR(150), "
                + " duration int, "
                + " sessionIdList VARCHAR(150), "
                + " PRIMARY KEY ( id ))";
        String sql1 = "ALTER TABLE parallelsessions AUTO_INCREMENT=10;";
        stmt.executeUpdate(sql);
        stmt.executeUpdate(sql1);
        con.close();

    }

    public void showDetails() throws SQLException {

        Connection con = new DBconnection().getDB();
        Statement stmt = con.createStatement();
        String sql = "SELECT DISTINCT hours from session ";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {

            duration.addItem(rs.getString("hours"));

        }
   con.close();
    }

    public void tableSettings() {

        //table header alignment to center
        TableCellRenderer rendererFromHeader = jTable1.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getTableHeader().setFont(new Font("TimesNewRoman", Font.PLAIN, 12));

        //table row alignments to center
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerAlign);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        viewlist1 = new javax.swing.JButton();
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
        ampm = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        duration = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        day = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tag = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        group = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        code = new javax.swing.JComboBox<>();
        session = new javax.swing.JComboBox<>();
        addSession1 = new javax.swing.JButton();
        remove1 = new javax.swing.JButton();
        save1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Parallel Sessions");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1200, 650));
        setMaximumSize(new java.awt.Dimension(1200, 650));
        setMinimumSize(new java.awt.Dimension(1200, 650));
        setPreferredSize(new java.awt.Dimension(1200, 650));

        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 650));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/addparallel.jpg"))); // NOI18N

        viewlist1.setBackground(new java.awt.Color(255, 255, 255));
        viewlist1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        viewlist1.setText("View Parallel Sessions");
        viewlist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewlist1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Start Time");

        ampm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Select Day");

        duration.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Group ID");

        day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday ", "Saturday", "Sunday" }));
        day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Duration");

        tag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        tag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("Session");

        group.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupActionPerformed(evt);
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
        jTable1.setRowHeight(20);
        jScrollPane1.setViewportView(jTable1);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("Session Tag");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Module Code");

        code.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeActionPerformed(evt);
            }
        });

        session.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        session.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionActionPerformed(evt);
            }
        });

        addSession1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        addSession1.setText("Add Session");
        addSession1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSession1ActionPerformed(evt);
            }
        });

        remove1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        remove1.setText("Remove Session");
        remove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove1ActionPerformed(evt);
            }
        });

        save1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        save1.setText("Save Parallel Session");
        save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(viewlist1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(startHour, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(startMin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(ampm, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(group, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(session, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(17, 17, 17)
                        .addComponent(addSession1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(remove1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(437, 437, 437)
                .addComponent(save1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(viewlist1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startHour, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startMin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ampm, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(group, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(session, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addSession1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(remove1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(save1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void durationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationActionPerformed
        
        group.removeAllItems();
        
        try {
            
            sessionDuration = (String) duration.getSelectedItem();

            Connection con = new DBconnection().getDB();
            Statement stmt = con.createStatement();
            String sql = "SELECT DISTINCT groups from session where hours =  '" + sessionDuration + "';";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                group.addItem(rs.getString("groups"));

            }
            stmt = null;
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddParallelSessions.class.getName()).log(Level.SEVERE, null, ex);
        }
        


    }//GEN-LAST:event_durationActionPerformed

    private void dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayActionPerformed

    private void tagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagActionPerformed
        try {
            // TODO add your handling code here:
            
            session.removeAllItems();
            
            mtag = (String) tag.getSelectedItem();
            
            int id = 00;
            
            Connection con = new DBconnection().getDB();
            Statement stmt = con.createStatement();
            String sql = "SELECT  id  from session where subcode =  '" + mcode + "' and groups = '"+gId+"' and tags ='"+mtag+"';";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                id = rs.getInt("id");

            }
            
            
            int sId=00;
            String idToString = Integer.toString(id);
            String[] sessionsArrays = {};
            Statement stmt1 = con.createStatement();
            String sql1 = "SELECT  id,sessionIdList  from shouldnotoverlapsessions ";
            ResultSet rs1 = stmt1.executeQuery(sql1);

            while (rs1.next()) {
                 
                 
                 String[] sessionsArray = rs1.getString("sessionIdList").split(",");
                 
                 
                 
                 for(int i=0;i<sessionsArray.length;++i){
                 
                   if(idToString.equals(sessionsArray[i])){
                       
                        sId = rs1.getInt("id");
                        sessionsArrays = sessionsArray;
                        break;
                   }
                 
                 }
                 

            }
            
            
            
            //------------------------------------------------------------------------------------------------------
            if(sessionsArrays.length != 0){
            for(int j=0;j<sessionsArrays.length;++j){
            
           
            Statement stmt2 = con.createStatement();
            String sql2 = "SELECT  subcode,tags,groups from session where id =  "+sessionsArrays[j];
            System.out.println(sql2);
            ResultSet rs2 = stmt2.executeQuery(sql2);

            while (rs2.next()) {

                session.addItem(rs2.getString("subcode")+"/"+rs2.getString("tags")+"/"+rs2.getString("groups"));

            }
            
            }
            }
            
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddParallelSessions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tagActionPerformed

    private void groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupActionPerformed
        try {
            code.removeAllItems();

            gId = (String) group.getSelectedItem();

            Connection con = new DBconnection().getDB();
            Statement stmt = con.createStatement();
            String sql = "SELECT  subcode  from session where groups =  '" + gId + "';";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                code.addItem(rs.getString("subcode") );

            }
           con.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(AddParallelSessions.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_groupActionPerformed

    private void viewlist1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewlist1ActionPerformed
        try {
            // TODO add your handling code here:
            new ViewParallelSessions().setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(AddParallelSessions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewlist1ActionPerformed

    private void codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeActionPerformed
        try {
            // TODO add your handling code here:
            
            tag.removeAllItems();
            mcode = (String) code.getSelectedItem();
        
            Connection con = new DBconnection().getDB();
            Statement stmt = con.createStatement();
            String sql = "SELECT distinct tags  from session where subcode =  '" + mcode + "' and groups = '"+gId+"';";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                tag.addItem(rs.getString("tags") );

            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddParallelSessions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_codeActionPerformed

    private void sessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sessionActionPerformed

    private void addSession1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSession1ActionPerformed

       
        if (duration.getSelectedItem().equals("Select") || group.getSelectedItem().equals("Select") || tag.getSelectedItem().equals("Select")) {

            JOptionPane.showMessageDialog(this, "Please Select Required Information", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            try {
                selectedSession = (String) session.getSelectedItem();
                gId = (String) group.getSelectedItem();
                table = (DefaultTableModel) jTable1.getModel();
                column[0] = selectedSession;
                table.addRow(column);
                
                String[] str = selectedSession.split("/",3);

                Connection con = new DBconnection().getDB();
                Statement stmt = con.createStatement();
                String sql = "SELECT  id  from session where subcode = '" + str[0] + "' and tags = '" + str[1] + "' and groups = '" + str[2] + "'";
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {

                    sessions.add(rs.getInt("id"));

                }
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddParallelSessions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addSession1ActionPerformed

    private void remove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove1ActionPerformed
      int index = jTable1.getSelectedRow();
        if (index != -1) {
            int modelIndex = jTable1.convertRowIndexToModel(index); // converts the row index in the view to the appropriate index in the model
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(modelIndex);

            sessions.remove(index);
        } else {

            JOptionPane.showMessageDialog(this, "Please select a record", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_remove1ActionPerformed

    private void save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ActionPerformed

       sHour = (int) startHour.getValue();
        sMin = (int) startMin.getValue();
        amPm = (String) ampm.getSelectedItem();

        if (day.getSelectedItem().equals("Select") || duration.getSelectedItem().equals("Select") || sHour == 0) {

            JOptionPane.showMessageDialog(this, "Please Select Required Information", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (sessions.size() == 0) {
            JOptionPane.showMessageDialog(this, "Please add sessions first", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            try {

                createDBTable();
                String uniqueID = UUID.randomUUID().toString();
                String sessionList = "";

                for (Integer se : sessions) {
                    
                    sessionList = se + "," + sessionList;
                }

                if (amPm.equals("PM")) {

                    if (sHour == 1) {
                        sHour = 13;
                    } else if (sHour == 2) {

                        sHour = 14;
                    } else if (sHour == 3) {

                        sHour = 15;
                    } else if (sHour == 4) {

                        sHour = 16;
                    } else if (sHour == 5) {

                        sHour = 17;
                    } else if (sHour == 6) {

                        sHour = 18;
                    } else if (sHour == 7) {

                        sHour = 19;
                    } else if (sHour == 8) {

                        sHour = 20;
                    } else if (sHour == 9) {

                        sHour = 21;
                    } else if (sHour == 10) {

                        sHour = 22;
                    } else if (sHour == 11) {

                        sHour = 23;
                    }

                } else if (amPm.equals("AM") && sHour == 12) {
                    sHour = 00;
                }

                String time = sHour + ":" + sMin + ":" + "00";
                sessionDay = (String) day.getSelectedItem();
                Connection con = new DBconnection().getDB();

                Statement stmt = con.createStatement();

                String sql = "INSERT INTO  parallelsessions(startTime,day,duration, sessionIdList)  "
                + " VALUES ("
                + "'" + time + "',"
                + "'" + sessionDay + "',"
                + sessionDuration + ","
                + "'" + sessionList + "')";
                
                stmt.executeUpdate(sql);

                //succes msg
                JOptionPane.showMessageDialog(this, " Details added succesfully", "Succesful", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Logger.getLogger(AddConsecutiveSession.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddConsecutiveSession.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_save1ActionPerformed

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
            java.util.logging.Logger.getLogger(AddParallelSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddParallelSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddParallelSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddParallelSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddParallelSessions().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AddParallelSessions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSession1;
    private javax.swing.JComboBox<String> ampm;
    private javax.swing.JComboBox<String> code;
    private javax.swing.JComboBox<String> day;
    private javax.swing.JComboBox<String> duration;
    private javax.swing.JComboBox<String> group;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton remove1;
    private javax.swing.JButton save1;
    private javax.swing.JComboBox<String> session;
    private javax.swing.JSpinner startHour;
    private javax.swing.JSpinner startMin;
    private javax.swing.JComboBox<String> tag;
    private javax.swing.JButton viewlist1;
    // End of variables declaration//GEN-END:variables
}
