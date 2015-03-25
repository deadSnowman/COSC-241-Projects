/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author seththomas
 */
public class MySearch {
    
    /**
     * Uses a binary search to find the location of an object within a MyVector object
     * @param vec
     * @param target
     * @return the index of the object being searched for
     */
    public static int binarySearch(MyVector vec, Comparable target) {
        
        int first = 0, last = vec.size() - 1, middle;
        while(last - first >= 0) {
            middle = (first + last) / 2;
            
            if(target.compareTo(vec.elementAt(middle)) < 0) {
                last = middle - 1;
            }
            else if(target.compareTo(vec.elementAt(middle)) > 0) {
                first = middle + 1;
            }
            else {
                return middle;
            }
        
        }
        return -1; //not found
    }
    
    /**
     * Use a linear search to find the location of a targeted object within a MyVector object
     * @param vec
     * @param target
     * @return the index of the object being searched for
     */
    public static int linearSearchSorted(MyVector vec, Comparable target) {
        for(int i = 0; i < vec.size() -1; i++)
            if(target.compareTo(vec.elementAt(i)) == 0)
                return i;
        return -1;
            
    }
    
    
}
