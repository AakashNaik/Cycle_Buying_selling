/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.table.TableModel;

/**
 *
 * @author aakash
 */
public class Buyer_Display extends javax.swing.JFrame {

    Vector columnNames = new Vector();
    Vector data = new Vector();  
    String buyer_roll_number,buyer_pass;  
    /**
     * Creates new form Buyer_Display
     * 
     * 
     */
    
    public int check_update(String roll, String name)
    {
        int password=0;
        try{
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details","root","J@g@tRam");  
             Statement st=con.createStatement();
                    String pass = null;
             ResultSet rs=st.executeQuery("select * from Cycle_Details where Seller_Roll_Number='"+roll+"' and Cycle_Name='"+name+"'");
             
                  while(rs.next())
                  {
                    String status;
                    status=rs.getString("Status");
                    if(status=="SOLD")
                    {
                        password=1;
                    }
                  }
                }
              catch(Exception e){
                 JOptionPane.showMessageDialog(null,e);}
          return password;
    }
    
  
public void buyer_update(String roll,String name)
    {
        try{Object newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details","root","J@g@tRam");  
           //  Read data from a table
           String sql2 = "update  Cycle_Details set Status='SOLD' where Seller_Roll_Number='"+roll+"' and Cycle_Name='"+name+"'";
            PreparedStatement stmt = con.prepareStatement(sql2); 
             stmt.executeUpdate(  );
             Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details","root","J@g@tRam");   
             
            String sql3="select Name,Mobile_number from User_name where password='"+buyer_pass+"'and Roll_Number='"+buyer_roll_number+"'";
            PreparedStatement stmt3 = con2.prepareStatement(sql3);
            ResultSet rs;
           rs = stmt3.executeQuery(  );
           String buyer_name="";
            String buyer_mobile_number="";
            while(rs.next())
            { buyer_name=rs.getString("Name");
              buyer_mobile_number=rs.getString("Mobile_Number");}
           Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details","root","J@g@tRam");  
            String sql4 = "update  cycle_buyer set Status='SOLD',Buyer_Name='"+buyer_name+"',Mobile_number='"+buyer_mobile_number+"' where Seller_Roll_Number='"+roll+"' and Cycle_Name='"+name+"'";
            PreparedStatement stmt4 = con3.prepareStatement(sql4); 
             stmt4.executeUpdate(  );
            JOptionPane.showMessageDialog(null,"done");
           }
             catch(Exception e){
                 JOptionPane.showMessageDialog(null,e);
             }
    }
    public Buyer_Display(String roll_number,String pass) throws InstantiationException, IllegalAccessException, SQLException {
        initComponents();
        try
        {          
            buyer_roll_number=roll_number;
            buyer_pass=pass;
            //  Connect to the Database
            Object newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details","root","J@g@tRam");  
           //  Read data from a table
           String sql = "SELECT Seller_Name,Seller_Roll_Number,Cycle_Name,Cycle_age,Cycle_Cost,Description FROM Cycle_Details";
            try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery( sql )) {
                
                Buyer_Table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Buyer_Table = new javax.swing.JTable();
        Seller_Roll_Number_Text = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Cycle_Name_Text = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(178, 104, 31));

        Buyer_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Seller_name", "Seller_Roll_Number", "Cycle_Name", "Cycle_Age", "Cycle_Cost", "Description"
            }
        ));
        jScrollPane1.setViewportView(Buyer_Table);

        Seller_Roll_Number_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seller_Roll_Number_TextActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel2.setText("Cycle_Name");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel3.setText("Seller_Roll_Number");

        Cycle_Name_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cycle_Name_TextActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(Cycle_Name_Text))
                    .addComponent(Seller_Roll_Number_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Seller_Roll_Number_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(Cycle_Name_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Seller_Roll_Number_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seller_Roll_Number_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Seller_Roll_Number_TextActionPerformed

    private void Cycle_Name_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cycle_Name_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cycle_Name_TextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       String roll= Seller_Roll_Number_Text.getText();
       String name= Cycle_Name_Text.getText();
       buyer_update(roll,name);
       check_update(roll,name);
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
         
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
            java.util.logging.Logger.getLogger(Buyer_Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buyer_Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buyer_Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buyer_Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buyer_Display().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Buyer_Table;
    private javax.swing.JTextField Cycle_Name_Text;
    private javax.swing.JTextField Seller_Roll_Number_Text;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
