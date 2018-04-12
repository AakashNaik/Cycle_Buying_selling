/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.Cycle_Buying_Selling;
import java.awt.Toolkit ;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import java.sql.*;


/**
 *
 * @author aakash
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public Boolean login_details(String roll_number,String pass,int selection)
    {
       
        try{
            
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details","root","J@g@tRam");
           String sql="Select name,password from User_name where name=? ,password=?";
           PreparedStatement pst= conn.prepareStatement(sql);
           
            ResultSet rs = pst.executeQuery();
           if(pass.equals(rs.getString("password")))
           {
                JOptionPane.showMessageDialog(null,"correct");
           }
          
           conn.close();
        }
        catch(Exception e){
                    
                      JOptionPane.showMessageDialog(null,e);      
        }// TODO add your handling code here:*/
        /* try {
          if (user != null && pass != null) {
            String sql = "Select * from User_name Where username='" + user + "' and password='" + pass + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                //in this case enter when at least one result comes it means user is valid
            } else {
                //in this case enter when  result size is zero  it means user is invalid
            }
          }
           catch (SQLException err) {
                JOptionPane.showMessageDialog(this, err.getMessage());
              }
         }*/
        try{
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details","root","J@g@tRam");  
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from User_name where Roll_Number='"+roll_number+"' and password='"+pass+"'");
             int count=0;
             String user_name="";
             while(rs.next()){
               count++;
                 user_name= rs.getString("Name");
               }
             if(count>0 ){
                    if(selection==0){
                        //JOptionPane.showMessageDialog(null,pass);
                        if(roll_number.equals("16CS30001")&& pass.equals("J@g@tRam")){
                        
                         
                         JOptionPane.showMessageDialog(null,"correct");
                         try{
                             /*source_data z= new source_data();
                             z.setVisible(true);
                             this.setVisible(false);*/
                             Admin_data z = new Admin_data();
                             z.setVisible(true);
                             this.setVisible(false);
                             return true;
                             
                         }
                         catch(Exception e)
                         {
                             JOptionPane.showMessageDialog(null,e);
                         }
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"not admin");
                            return false;
                        }
                    }
                      
                    
                        if(selection==1)
                        {
                            JOptionPane.showMessageDialog(null,"correct");
                         try{
                             /*source_data z= new source_data();
                             z.setVisible(true);
                             this.setVisible(false);*/
                             
                             seller_display z = new seller_display(roll_number,user_name);
                             z.setVisible(true);
                             this.setVisible(false);
                             return true;
                         }
                         catch(Exception e)
                         {
                             JOptionPane.showMessageDialog(null,e);
                         }
                        }                         
                          if(selection==2)
                                  {
                                      JOptionPane.showMessageDialog(null,"correct");
                                     try{
                                     /*source_data z= new source_data();
                                       z.setVisible(true);
                                        this.setVisible(false);*/
                                         Buyer_Display z = new Buyer_Display(roll_number,pass);
                                        z.setVisible(true);
                                       this.setVisible(false);
                                       return true;
                                       }
                                      catch(Exception e)
                                     {
                                       JOptionPane.showMessageDialog(null,e);
                                      }
                                  
                                  }
                        
                        }
                         
                         else{
                           JOptionPane.showMessageDialog(null,"incorrect");
                           return false;
                           } 
             }
                        /* dm = new DefaultTableModel(0, 0);  
                         String s[] = new String[]{"Name", "Roll_Number","Hall_of_Residence","Mobile_Number","password"};  
                         dm.setColumnIdentifiers(s);  
                          jTable1.setModel(dm);
                            
                               
                             PreparedStatement pst = con.prepareStatement("select * from User_name");  
                             ResultSet rs = pst.executeQuery();  
                             while (rs.next()) {  
                                                 String Name = rs.getString(1);  
                                                 String Roll_Number = rs.getString(2);
                                                 String Hall_of_Residence = rs.getString(3);
                                                 String Mobile_Number = rs.getString(4);
                                                 String password = rs.getString(5);
                                                 
                                                 Vector<String> vector = new Vector<String>();  
                                                 //     vector.add(name);  
                                                 vector.add(Name);  
                                                 vector.add(Roll_Number);
                                                 vector.add(Hall_of_Residence);
                                                 vector.add(Mobile_Number);
                                                 vector.add(password);
                                                 dm.addRow(vector);  
                                                 }  
                                             } catch (SQLException ex) {  
                                              JOptionPane.showMessageDialog(null,ex);
                                         } */
                         
                  
               
           
             catch(Exception e){
               JOptionPane.showMessageDialog(null,e);
               }
        return false;
    }
    public login() {
        initComponents();
            }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        Login = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Roll_Number_Text = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Seller = new javax.swing.JRadioButton();
        Buyer = new javax.swing.JRadioButton();
        Admin = new javax.swing.JRadioButton();
        Password_Text = new javax.swing.JPasswordField();
        Forgot_Password = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Login.setBackground(new java.awt.Color(149, 92, 35));

        jLabel1.setBackground(new java.awt.Color(116, 43, 44));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel1.setText("Roll_Number");

        Roll_Number_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Roll_Number_TextActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel2.setText("Password");

        jButton1.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jButton3.setText("Login");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(Seller);
        Seller.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        Seller.setText("Seller");
        Seller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SellerActionPerformed(evt);
            }
        });

        buttonGroup1.add(Buyer);
        Buyer.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        Buyer.setText("Buyer");

        buttonGroup1.add(Admin);
        Admin.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        Admin.setText("Admin");

        Password_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Password_TextActionPerformed(evt);
            }
        });

        Forgot_Password.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        Forgot_Password.setText("Forgot password");
        Forgot_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Forgot_PasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LoginLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(29, 29, 29)
                            .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Roll_Number_Text, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                .addComponent(Password_Text)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Seller)
                            .addGap(18, 18, 18)
                            .addComponent(Buyer)))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(Forgot_Password))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jButton3)
                        .addGap(219, 219, 219)
                        .addComponent(jButton1)))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Roll_Number_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Password_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buyer)
                    .addComponent(Admin)
                    .addComponent(Seller))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(Forgot_Password)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Roll_Number_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Roll_Number_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Roll_Number_TextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Cycle_Buying_Selling z= new Cycle_Buying_Selling();
         z.setVisible(true);
        this.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SellerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SellerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SellerActionPerformed

    private void Password_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Password_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Password_TextActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        String roll_number=Roll_Number_Text.getText();
        String pass=Password_Text.getText();
        int selection=-1;
        if(Admin.isSelected())
        {
            selection=0;
        }
        if(Seller.isSelected())
        {
            selection =1;
        }
        if(Buyer.isSelected())
        {
            selection=2;
        }
        login_details(roll_number,pass,selection);

       this.login_details(roll_number,pass,selection);
        
        
        
          

    }//GEN-LAST:event_jButton3ActionPerformed

    private void Forgot_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Forgot_PasswordActionPerformed
           
        forgot_password z= new forgot_password();
         z.setVisible(true);
        this.setVisible(false);
         
        //dd your handling code here:
    }//GEN-LAST:event_Forgot_PasswordActionPerformed
  
         
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Admin;
    private javax.swing.JRadioButton Buyer;
    private javax.swing.JButton Forgot_Password;
    private javax.swing.JPanel Login;
    private javax.swing.JPasswordField Password_Text;
    private javax.swing.JTextField Roll_Number_Text;
    private javax.swing.JRadioButton Seller;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
