/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import javax.swing.JOptionPane;
import my.Cycle_Buying_Selling.Admin_data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aakash
 */
public class Admin_data_check {
    
    public Admin_data_check() {
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
    public void check() throws SQLException, InstantiationException, IllegalAccessException{
        Admin_data a=new Admin_data();
        a.delete_function("16CS30002");
        int get=a.check_database("16CS30002");
        JOptionPane.showMessageDialog(null,get);
        assertEquals(0,get);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
