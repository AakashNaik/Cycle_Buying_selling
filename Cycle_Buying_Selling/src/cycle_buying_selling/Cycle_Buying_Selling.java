/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycle_buying_selling;

/**
 *
 * @author aakash
 */
public class Cycle_Buying_Selling implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cycle_Buying_Selling test= new Cycle_Buying_Selling();  
            
            Thread thread=new Thread(test);
            thread.start();
                   // TODO code application logic here
    }
    
}
