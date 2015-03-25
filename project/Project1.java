/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.lang.Math;
import collection.MySet;
import collection.MySort;

/**
 *
 * @author seththomas
 */
public class Project1 {
    
    /**
     * A method for testing Project1
     */
    public static void test() {
        
        MySet perfectSquareSet = new MySet();
        MySet fibonacciNumSet = new MySet();
        
        //CALCULATE AND PRINT FIBONACCI SET
        for(int i = 0; i < 25; i++)
            fibonacciNumSet.append((Object)fibonacci(i));
        System.out.println("Fibonacci set: ");
        for(int i = 0; i < fibonacciNumSet.size(); i++)
            System.out.println(fibonacciNumSet.elementAt(i));
        System.out.println();
        
        
        //CALCULATE AND PRINT PERFECT SQUARE SET
        int count = 0;
        for(int i = 0; count < 25; i++)
            if(perfectSquare(i))
            {
                perfectSquareSet.append((Object)i);
                count++;
            }

        System.out.println("Perfect square set: ");
        for(int i = 0; i < perfectSquareSet.size(); i++)
            System.out.println(perfectSquareSet.elementAt(i));
        System.out.println();
                
        
        //INTERSECTION OF BOTH SETS
        System.out.println("Intersection of both sets: ");
        MySet intersection = new MySet();
        intersection = perfectSquareSet.intersection(fibonacciNumSet);
        for(int i = 0; i < intersection.size(); i++)
            System.out.println(intersection.elementAt(i));
        System.out.println();
        
        
        //SYMMETRIC DIFFERENCE OF BOTH SETS
        System.out.println("Symmetric difference of both sets: ");
        MySet symDif = new MySet();
        symDif = perfectSquareSet.symmetricDifference(fibonacciNumSet);
        MySort.selectionSort(symDif);
        for(int i = 0; i < symDif.size(); i++)
            System.out.println(symDif.elementAt(i));
        System.out.println();
        
        
        //UNION OF BOTH SETS
        System.out.println("Union of both sets: ");
        MySet union = new MySet();
        union = perfectSquareSet.union(fibonacciNumSet);
        MySort.selectionSort(union);
        for(int i = 0; i < union.size(); i++)
            System.out.println(union.elementAt(i));
        System.out.println();
        
    }
    
    /**
     * calculate the fibonacci number recursively 
     * @param n each number in the fibonacci set
     * @return the fibonacci number derived from the input
     */
    public static int fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n - 2);
    }
    
    /**
     * Check if a number is a perfect square.  Return true
     * if it is and false if it is not
     * @param n number that is checked
     * @return true if a perfect square and false if not
     */
    public static boolean perfectSquare(int n) {
        long closestRoot = (long) Math.sqrt(n);
        return n == closestRoot*closestRoot;
    }
}
