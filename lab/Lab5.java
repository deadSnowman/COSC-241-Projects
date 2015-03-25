/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import collection.MyVector;
import collection.MySort;
import java.util.Random;

/**
 *
 * @author sathomas0
 * @version 10/25/2012
 */
public class Lab5 {
    /**
     * Test and benchmark each sorting method
     */
    public static void test() {
        MyVector vec = new MyVector();
        long genTime = 0;
        
        // BUBBLE SORT
        System.out.println("===BUBBLE SORT===");
        generateRandNums(vec);
        genTime = System.currentTimeMillis();
        MySort.bubbleSort(vec);
        System.out.println("Run time: " + (System.currentTimeMillis() - genTime));
        printSomeElements(vec);
        vec.clear();
        System.out.println();
        
        // SELECTION SORT
        System.out.println("===SELECTION SORT===");
        generateRandNums(vec);
        genTime = System.currentTimeMillis();
        MySort.selectionSort(vec);
        System.out.println("Run time: " + (System.currentTimeMillis() - genTime));
        printSomeElements(vec);
        vec.clear();
        System.out.println();
        
        System.out.println("===INSERTION SORT===");
        generateRandNums(vec);
        genTime = System.currentTimeMillis();
        MySort.insertionSort(vec, 0, vec.size()-1);
        System.out.println("Run time: " + (System.currentTimeMillis() - genTime));
        printSomeElements(vec);
        vec.clear();
        System.out.println();
        
        System.out.println("===SHELL SORT===");
        generateRandNums(vec);
        genTime = System.currentTimeMillis();
        MySort.shellSort(vec);
        System.out.println("Run time: " + (System.currentTimeMillis() - genTime));
        printSomeElements(vec);
        vec.clear();
        System.out.println();
        
        // MERGE SORT
        System.out.println("===MERGE SORT===");
        generateRandNums(vec);
        Comparable[] tmp = new Comparable[20000];
        genTime = System.currentTimeMillis();
        MySort.mergeSort(vec, tmp, 0, vec.size()-1);
        System.out.println("Run time: " + (System.currentTimeMillis() - genTime));
        printSomeElements(vec);
        vec.clear();
        System.out.println();
        
        // QUICK SORT
        System.out.println("===QUICK SORT===");
        generateRandNums(vec);
        genTime = System.currentTimeMillis();
        MySort.quickSort(vec, 0, vec.size()-1);
        System.out.println("Run time: " + (System.currentTimeMillis() - genTime));
        printSomeElements(vec);
        vec.clear();
        System.out.println();
    }
    
    public static void generateRandNums(MyVector vec) {
        Random r = new Random();
        r.setSeed(20121024);
        for(int i = 0; i < 20000; i++)
            vec.append(r.nextInt(100000));
    }
    
    public static void printSomeElements(MyVector vec) {
        System.out.println("0th: \t\t" + vec.elementAt(0));
        System.out.println("1st: \t\t" + vec.elementAt(1));
        System.out.println("2nd: \t\t" + vec.elementAt(2));
        System.out.println("9999th: \t" + vec.elementAt(9999));
        System.out.println("19999th: \t" + vec.elementAt(19999));
    }
    
    public static void printVec(MyVector vec) {
        for(int i = 0; i < 20000; i++)
            System.out.println(vec.elementAt(i));
    }
}
