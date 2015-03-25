package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author seththomas
 * @version 10//18/2012
 */
public class Lab4 {
    /**
     * The class's tester method that tests the other methods in this class
     * @throws IOException
     */
    public static void test() throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        
        input = br.readLine();
        
        //For a quick test, try:
        //input = "god a red nugget, a fat egg under a dog";
        
        //if the input is blank, exit
        if(input.trim().equals(""))
            return;
            
        System.out.println("The string is: " + input + "\n" + "The reverse is: " + reverse(input));
        if(verifyPalindrome(input) == true)
            System.out.println("The string is a palindrome.");
        else
            System.out.println("The string is not a palindrome.");

        
    }
    
    /**
     * Verifies if the string is a palindrome
     * @param s the input string
     * @return true if the string is a palindrome, and false if it is not
     */
    public static boolean verifyPalindrome(String s) {
        
        if(s.replaceAll("\\W","").equals(reverse(s).replaceAll("\\W","")))
            return true;
        else
            return false;
    }
    
    /**
     * Reverse the string recursively
     * @param s the input string
     * @return the reversed string
     */
    public static String reverse(String s) {
        /*
         * substring everythin but the first letter, and tack the 1st letter onto the end
         * call this new string until the substring eventually reaches 0
         */
        if(s.length() == 0)
            return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }
    
}
