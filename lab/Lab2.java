/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import collection.MyVector;

/**
 *
 * @author seththomas
 */
public class Lab2 {
    public static void test() {
        
        MyVector testVec = new MyVector();
        
        // Add first 30 of Fibonacci numbers into vector
        System.out.println("Add first 30 of Fibonacci numbers into vector");
        for(int i = 0; i < 30; i++)
            testVec.append((Object)fibonacci(i));
        
        // Print out original vector
        printVector(testVec);
        
        // Reverse vector
        System.out.println("Reverse vector");
        testVec.reverse();
        
        // Make a clone
        
        MyVector clone = (MyVector)testVec.clone();
        
        // Print out original vector
        printVector(testVec);
        
        // Remove all elements at any odd index of the original vector
        System.out.println("Remove all elements at any odd index of the original vector");
        for(int i = 0; i < testVec.size(); i++)
            if((Integer)testVec.elementAt(i) % 2 != 0)
                testVec.removeAt(i);
        
        // Print out original vector
        printVector(testVec);
        
        // Reverse cloned vector
        System.out.println("Reverse cloned vector");
        printVector(clone);
        
        // Merge cloned vector with original
        System.out.println("Merge cloned vector with original");
        testVec.merge(clone);
        
        printVector(testVec);
    }
    
    public static int fibonacci(int n)
    {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n - 2);
    }
    
    public static void printVector(MyVector vector) {
        System.out.println("Vector contents: ");
        for(int i = 0; i < vector.size(); i++)
            System.out.print("[" + vector.elementAt(i) + "],");
        System.out.println();
        System.out.println();

    }
    
    
    
}
