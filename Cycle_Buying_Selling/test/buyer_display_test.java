/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import my.Cycle_Buying_Selling.Buyer_Display;
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
public class buyer_display_test {
    
    public buyer_display_test() {
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
    public void check() throws InstantiationException, IllegalAccessException, SQLException{
        Buyer_Display a=new Buyer_Display("16CS30001","J@g@tRam");
        a.buyer_update("16cs30003","herculus");
        int value=a.check_update("16cs30003","herculus");
        
        assertEquals(0,value);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
