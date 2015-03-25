package main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*import lab.Lab2;
import lab.Lab3;
import lab.Lab4;
import lab.Lab5;
import project.Project1;*/
import project.Project2;

/**
 *
 * @author sathomas0
 * @version 10/27/2012
 */
public class Main {
    
    public static void main(String args[])
    {
        //Lab2.test();
        //Lab3.test();
        //Project1.test();
        
        /*try {
            Lab4.test();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        //Lab5.test();
        
        try {
            Project2.test();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
