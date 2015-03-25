/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author seththomas
 * @version 10/6/2012
 */
public class MySet extends MyVector {
    
    /**
     * The default constructor
     */
    public MySet() {
        super();
    }
    
    /**
     * Get the cardinality of the set
     * @return card the cardinality
     */
    public int cardinality() {
        return size; //not allowing duplicate elements in the array makes these the same
    }
    
    //clear inherited
    
    /**
     * Find A - B or (A U B')
     * @param B the set being subtracted from another
     * @return a set representing A - B
     */
    public MySet complement(MySet B) {
        int len = 0;
        MySet tmp = new MySet();
        
        // the size of both of the arrays
        len = size + B.size();
        
        // Test every element from A against B.  If the elemnt in A is not contained in B,
        // then add it to the temporary set.  Otherwise, set a flag that prevents this.
        for(int i = 0; i < size; i++)
        {
            boolean flag = true;
            for(int j = 0; j < B.size(); j++)
                if(vec[i] == B.elementAt(j))
                    flag = false;
            
            if(flag)
                tmp.insert(vec[i]);
        }
        
        return tmp;
    }
    
    //contains(element) inherited
    
    /**
     * Inserts an object into the set if the object is not already present in the set
     * @param obj
     * @return true
     */
    public boolean insert(Object obj) {
        if(isFull())
            expand();
        
        //don't add element if it exists
        for(int i = 0; i < vec.length; i++)
            if(vec[i] == obj)
                return true;
        
        vec[size] = obj;
        size++;
        
        return true;
    }
    
    /**
     * Find the union of two sets and return a set of the union
     * @param B the second set specified
     * @return the union of 2 sets specified
     */
    public MySet intersection(MySet B) {
        int len = 0;
        MySet tmp = new MySet();
        
        for(int i = 0; i < size; i++)
            for(int j = 0; j < B.size(); j++)
                if(B.elementAt(j).equals(vec[i]))
                    tmp.insert(vec[i]);
        
        return tmp;
    }
    
    //isEmpty() inherited
    
    //remove(element) inherited
    
    /**
     * Check if A is a subset of B
     * @param B the set A is being checked against
     * @return true if A is a subset of B and false if A is not a subset of B
     */
    public boolean subsetOf(MySet B) {
        int count = 0;
        
        /*
         * If A U B = A, then A is a subset of B
         * These loops adds 1 to count ever time it finds an element in A that
         * is in B.  If count is the same number as the initial size of A, then it
         * is a subset
         */
        for(int i = 0; i < size; i++)
            for(int j = 0; j < B.size(); j++)
                if(vec[i] == B.elementAt(j))
                    count++;
        
        if(count == size)
            return true;
        else
            return false;
    }
    
    /**
     * Find the symmetric difference of two sets
     * @param B the second set
     * @return the symmetric difference of set A and B
     */
    public MySet symmetricDifference(MySet B) {
        MySet vecSet = new MySet();
        MySet first = new MySet();
        MySet second = new MySet();
        
        for(int i = 0; i < size; i++)
            vecSet.insert(vec[i]);
        
        first = vecSet.complement(B);
        second = B.complement(vecSet);
        
        return first.union(second);
    }
    
    /**
     * Return the union of two vectors
     * @param B the second vector
     * @return the union of vector B and the other specified
     */
    public MySet union(MySet B) {
        int len = 0;
        MySet tmp = new MySet();
        
        //length at most is the size of both
        len = size + B.size();
        
        // add all elements to temporary array
        for(int i = 0; i < size; i++)
            tmp.insert(vec[i]);
        for(int i = 0; i < B.size(); i++)
            tmp.insert(B.elementAt(i));
        
        return tmp;
    }
    
    /**
     * Return a string representation of the vector that includes the
     * vector contents, size, and cardinality
     * @return 
     */
    public String toString() {
        String returnString = "Set contents: ";
        
        for(int i = 0; i < vec.length; i++)
            returnString += vec[i];
        
        returnString+= "set size: " + size;
        
        returnString+= "cardinality: " + size;
        
        return returnString;
        
    }
      
}
