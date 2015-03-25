/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import collection.MyVector;
import collection.MySearch;
import collection.MySort;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author seththomas
 * @version 10/5/2012
 */
public class Lab3 {
    public static void test() {

        MyVector numVec = new MyVector();
        int input = 0;
        
        Random r = new Random(System.nanoTime());
        
        for(int i = 0; i < 61; i++)
            numVec.append(r.nextInt(899) + 100);
        
        MySort.bubbleSort(numVec);
        
        printVector(numVec);
                
        input = Integer.parseInt(JOptionPane.showInputDialog("Please enter a number to search for"));
        System.out.println("Index of number: " + MySearch.linearSearchSorted(numVec, input));
        
        numVec.removeRange(2, 22);
        numVec.reverse();
        
        MySort.selectionSort(numVec);
        
        printVector(numVec);
        
        input = Integer.parseInt(JOptionPane.showInputDialog("Please enter a another number to search for"));
        System.out.println("Index of number: " + MySearch.binarySearch(numVec, input));
    }
    
    public static void printVector(MyVector vector) {
        System.out.println("Vector contents: ");
        for(int i = 0; i < vector.size(); i++)
            //System.out.print("[" + vector.elementAt(i) + "],");
            System.out.println(vector.elementAt(i));
        System.out.println();
        System.out.println();

    }
    
}
