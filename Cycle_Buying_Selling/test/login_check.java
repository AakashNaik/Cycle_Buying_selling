/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import my.Cycle_Buying_Selling.login;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.Toolkit ;
import java.awt.event.WindowEvent;

/**
 *
 * @author aakash
 */
public class login_check {
    
    public login_check() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
   @Test
    public void testlogin_details()
    {
        login a= new login();
        Boolean expected=true;
        assertEquals(expected,a.login_details("16CS30002","J@g@tRam",0));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
