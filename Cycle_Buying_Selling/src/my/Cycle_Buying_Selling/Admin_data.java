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

/**
 *
 * @author aakash
 */
public class Admin_data extends javax.swing.JFrame {

    /**
     * Creates new form Admin_data
     */
    Vector columnNames = new Vector();
    Vector data = new Vector(); 
    
    public void delete_function(String roll_number)
    {
      try{
                String sql= "delete from User_name where Roll_Number=?" ;
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details","root","J@g@tRam"); 
                PreparedStatement pst= con.prepareStatement(sql);
                pst=con.prepareStatement(sql);
                pst.setString(1,roll_number);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Deleted");
                 
                
          }
           catch(Exception e){
               JOptionPane.showMessageDialog(null,e);
              }   
    }
    
    
    public Admin_data() throws SQLException, InstantiationException, IllegalAccessException{
        initComponents();
        try{
            //JOptionPane.showMessageDialog(null,"incorrect");
        
              //  Connect to the Database
               Object newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details","root","J@g@tRam");  
              //  Read data from a table
              String sql2 = "SELECT * FROM User_name";
               try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery( sql2 )) {
               admin_database.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
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
        }catch(ClassNotFoundException cnfe)
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
        admin_database = new javax.swing.JTable();
        Delete = new javax.swing.JButton();
        Roll_Number = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(154, 95, 35));

        admin_database.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        admin_database.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Roll_Number", " Hall_of_Residence", " Mobile_Number"
            }
        ));
        jScrollPane1.setViewportView(admin_database);

        Delete.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel1.setText("Roll number");

        jLabel2.setBackground(new java.awt.Color(182, 125, 68));
        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel2.setText("ADMIN DATABASE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Delete)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Roll_Number, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(75, 75, 75))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Roll_Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public int check_database(String roll_number)
    {
         int password=0;
    try{
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details","root","J@g@tRam");  
             Statement st=con.createStatement();
                    String pass = null;
             ResultSet rs=st.executeQuery("select * from User_name where Roll_Number='"+roll_number+"'" );
            
            
                  while(rs.next())
                  {
                    password=1; 
                  }
      
                  }
                  catch(Exception e)
                         {
                             JOptionPane.showMessageDialog(null,e);
                         }
        return password;
}
    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
          
         
   String roll_number=Roll_Number.getText();
   delete_function(roll_number);
          

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
            java.util.logging.Logger.getLogger(Admin_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Admin_data().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Admin_data.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Admin_data.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Admin_data.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JTextField Roll_Number;
    private javax.swing.JTable admin_database;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
