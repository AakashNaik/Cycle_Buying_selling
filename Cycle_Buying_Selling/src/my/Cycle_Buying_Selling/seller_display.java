package my.Cycle_Buying_Selling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aakash
 */
public class seller_display extends javax.swing.JFrame {

    Vector columnNames = new Vector();
    Vector data = new Vector(); 
    String roll,name;
     String id;
    /**
     * Creates new form java
     */
    public seller_display() throws InstantiationException, IllegalAccessException, SQLException {
        initComponents();
       
    }
    
    public seller_display(String roll_number,String user_name ) throws InstantiationException, IllegalAccessException, SQLException {
        initComponents();
       
             roll=roll_number;
             name=user_name;
             
            
     try
        {          
            //JOptionPane.showMessageDialog(null,"incorrect");
            //  Connect to the Database
            Object newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details","root","J@g@tRam");  
           //  Read data from a table
           String sql = "SELECT Cycle_name,Status,Buyer_Name,Mobile_number FROM cycle_buyer where Seller_Roll_Number='"+roll+"'";
            try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery( sql )) {
                
                seller_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
                ResultSetMetaData md = rs.getMetaData();
                int columns = md.getColumnCount();
                
                //  Get column names
                for (int i = 1; i <= columns; i++)
                {
                    columnNames.addElement( md.getColumnName(i) );
                }
                
                //  Get row data
                while (rs.next())
                {
                    Vector row = new Vector(columns);
                    for (int i = 1; i <= columns; i++)
                    {
                        row.addElement(rs.getObject(i));
                    }
                    data.addElement(row);
                }
            }
        }
        catch(ClassNotFoundException cnfe)
        {
        }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        seller_table = new javax.swing.JTable();
        Cycle_Name_Text = new javax.swing.JTextField();
        Cycle_Age_Text = new javax.swing.JTextField();
        Cycle_Cost_Text = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Cycle_Name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Description_Text = new javax.swing.JTextField();
        Ok_Text = new javax.swing.JButton();
        Delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(178, 112, 47));

        seller_table.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        seller_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cycle_Name", "Status", "Buyer_Name", "mobile_Number"
            }
        ));
        jScrollPane1.setViewportView(seller_table);

        Cycle_Name_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cycle_Name_TextActionPerformed(evt);
            }
        });

        Cycle_Cost_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cycle_Cost_TextActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel2.setText("Add/Update new cycle");

        Cycle_Name.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        Cycle_Name.setText("Cycle_Name");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel4.setText("Cycle_age");

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel5.setText("Cycle_Cost");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel3.setText("Description");

        Description_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Description_TextActionPerformed(evt);
            }
        });

        Ok_Text.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        Ok_Text.setText("OK");
        Ok_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ok_TextActionPerformed(evt);
            }
        });

        Delete.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        Delete.setText("Update");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(Cycle_Name)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Cycle_Cost_Text, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(Cycle_Age_Text, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Cycle_Name_Text)
                            .addComponent(Description_Text))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Delete)
                        .addGap(51, 51, 51)
                        .addComponent(Ok_Text)
                        .addGap(110, 110, 110)))
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cycle_Name_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cycle_Name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cycle_Age_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cycle_Cost_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Description_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ok_Text)
                    .addComponent(Delete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cycle_Name_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cycle_Name_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cycle_Name_TextActionPerformed

    private void Description_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Description_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Description_TextActionPerformed

    private void Cycle_Cost_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cycle_Cost_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cycle_Cost_TextActionPerformed

    private void Ok_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ok_TextActionPerformed

           
                  try{
            
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details","root","J@g@tRam");
           String sql="Insert into Cycle_Details(Cycle_Name,Cycle_age,Cycle_Cost,Description,Status,Seller_Name,Seller_Roll_Number) values (?,?,?,?,?,?,?)";
           PreparedStatement pst= conn.prepareStatement(sql);
           pst.setString(7,roll);
           pst.setString(1,Cycle_Name_Text.getText());
           pst.setString(2,Cycle_Age_Text.getText());
           pst.setString(3,Cycle_Cost_Text.getText());
           pst.setString(4,Description_Text.getText());
           pst.setString(5,"No");
           pst.setString(6,name);
           
           pst.executeUpdate();
           String sql2="Insert into cycle_buyer(Cycle_name,Status,Buyer_Name,Mobile_Number,Seller_Roll_Number) values (?,?,?,?,?)";
           PreparedStatement pst2= conn.prepareStatement(sql2);
           pst2.setString(1,Cycle_Name_Text.getText());
           pst2.setString(4,"No Buyer");
           pst2.setString(3,"No Buyer");
           pst2.setString(2,"No");
           pst2.setString(5,roll);
           
           pst2.executeUpdate();
           JOptionPane.showMessageDialog(null,"Insertion Succesful");
           conn.close();
        }
        catch(Exception e){
                    
                      JOptionPane.showMessageDialog(null,e);      
        }        // TODO add your handling code here:
    }//GEN-LAST:event_Ok_TextActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        Connection con3 = null;  
        try {
            con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details","root","J@g@tRam");
        } catch (SQLException ex) {
            Logger.getLogger(seller_display.class.getName()).log(Level.SEVERE, null, ex);
        }
        String a=Description_Text.getText();
        String b=Cycle_Cost_Text.getText();
        String c = Cycle_Age_Text.getText();
        String d =Cycle_Name_Text.getText();
            String sql4 = "update  Cycle_Details set Description='"+a+"', Cycle_Cost='"+b+"', Cycle_age='"+c+"' where Cycle_name='"+d+"'and Seller_Name='"+name+"'and Seller_Roll_Number='"+roll+"' ";
            PreparedStatement stmt4 = null; 
        try {
            stmt4 = con3.prepareStatement(sql4);
        } catch (SQLException ex) {
            Logger.getLogger(seller_display.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt4.executeUpdate(  );
        } catch (SQLException ex) {
            Logger.getLogger(seller_display.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            JOptionPane.showMessageDialog(null,"done");
           
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteActionPerformed

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
            java.util.logging.Logger.getLogger(java.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(java.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(java.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(java.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new java().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cycle_Age_Text;
    private javax.swing.JTextField Cycle_Cost_Text;
    private javax.swing.JLabel Cycle_Name;
    private javax.swing.JTextField Cycle_Name_Text;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField Description_Text;
    private javax.swing.JButton Ok_Text;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable seller_table;
    // End of variables declaration//GEN-END:variables
}