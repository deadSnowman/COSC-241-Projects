/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author seththomas
 */
public class MyVector implements Cloneable{
    
    protected Object[] vec;
    protected int size;
    
    public MyVector() {
        vec = new Object[100];
        size = 0;
    }
    
    /**
     * doubles the size of the vector
     */
    public void expand() {
        Object[] tmpVec = new Object[vec.length];
        
        for(int i = 0; i < vec.length; i++)
            tmpVec[i] = vec[i];
        
        vec = new Object[tmpVec.length*2];
        
        for(int i = 0; i < tmpVec.length; i++)
            vec[i] = tmpVec[i];
    }
    
    /**
     * adds two vectors together
     * @param obj the vector being added to the first
     * @return true
     */
    public boolean append(Object obj) {
        if(isFull())
            expand();
        
        vec[size] = obj;
        size++;
        
        return true;
    }
    
    /**
     * clears the elements in the vector
     * @return true
     */
    public boolean clear() {
        for(int i = 0; i < vec.length; i++)
            vec[i] = null;
        size = 0;
        return true;
    }
    
    /**
     * check of the vector contains a specific element
     * @param obj
     * @return true if the vector contains the element
     * and false if it doesn't
     */
    public boolean contains(Object obj) {
        for(int i = 0; i < vec.length; i++)
            if(vec[i].equals(obj))
                return true;
         return false;
    }
    
    /**
     * return the element at a specified index
     * @param index the index specified
     * @return the element at index
     */
    public Object elementAt(int index) {
        return vec[index];
    }
    
    /**
     * Find the first index of an element specified in the vector
     * @param obj the element being searched for
     * @return in first index of the element or -1 if not found
     */
    public int indexOf(Object obj) {
        for(int i = 0; i < vec.length; i++)
            if(vec[i].equals(obj))
                return i;
        return -1;
    }
    
    /**
     * Insert an element at a specified index
     * @param index the insert location
     * @param obj the object to be inserted
     * @return true
     */
    public boolean insertAt(int index, Object obj) {
        if(isFull() || index < 0 || index > size-1)
            return false;
        
        for(int j = size-1; j >= index; j--)
        {
            vec[index] = obj;
            size++;
        }
        return true;
    }
    
    /**
     * Check if the vector is empty
     * @return true if it is empty or false if it isn't
     */
    public boolean isEmpty() {
        boolean flag = true;
        
        for(int i = 0; i < vec.length; i++)
        {
            if(vec[i] != null)
                flag = false;
        }
        return flag;
    }
    
    /**
     * remove the element at a specified index and shift all elements over
     * @param index location of element to be removed
     * @return the object removed (pop)
     */
    public Object removeAt(int index) {
        if(index < 0 || index > size - 1)
            return null;
        
        Object temp = vec[index];
        
        while(index < size - 1)
        {
            vec[index] = vec[index+1];
            index++;            
        }
        vec[size] = null;
        return temp;
    }
    
    /**
     * remove a specified element in the vector
     * @param obj the element to be removed
     * @return the object that is removed
     */
    public Object remove(Object obj) {
        int tmp = indexOf(obj);
        removeAt(tmp);
        return vec[tmp];
    }
    
    /**
     * Replace an element with another
     * @param index the index to switch elements
     * @param obj the element to be removed
     * @return true
     */
    public boolean replace(int index, Object obj) {
        if(index < 0 || index > size-1)
            return false;
        vec[index] = obj;
        return true;
    }
    
    /**
     * Get the size of the vector (number of elements it contains)
     * @return size
     */
    public int size() {
        return size;
    }
    
    /**
     * Return a copy of the vector
     * @return the cloned vector
     */
    public Object clone() {
        try
        {
            MyVector cloned = (MyVector)super.clone();
            return cloned;
        }
        catch(CloneNotSupportedException e) {
            System.out.println(e);
        }
        return null;
    }
    
    /**
     * Remove elements in the vector in a given range
     * @param fromIndex starting pont of the range
     * @param toIndex ending point of the range
     * @return true
     */
    public boolean removeRange(int fromIndex, int toIndex) {
        for(int i = fromIndex; i < toIndex; i++)
        {
            removeAt(i);
            size--;
        }
        
        //shift elements
        for(int i = 0; i < size - 1; i++)
        {
            vec[i] = vec[i+1];          
        }
        
        return true;
    }
    
    /**
     * Return a string representation of the vector
     * that contains the contents and size
     * @return a string representation of the vector
     */
    public String toString() {
        String returnString = "Vector contents: ";
        
        for(int i = 0; i < vec.length; i++)
            returnString += vec[i];
        
        returnString+= "vector size: " + size;
        
        return returnString;
        
    }
    
    /**
     * Reverse the vector
     * @return true
     */
    public boolean reverse() {
        Object tmp;
        
        for(int i = 0; i < size/2; i++)
        {
            tmp = vec[i];
            vec[i] = vec[size -i -1];
            vec[size -i -1] = tmp;
        }
        return true;
    }
    
    /**
     * Merge two vectors together
     * @param vector2 the vector to be merged with the first
     * @return the merged vector
     */
    public boolean merge(MyVector vector2) {
        int pos = 0;
        int newSize = size + vector2.size();
        Object[] vector3 = new Object[newSize];
        
        for(int i = 0; i < size; i++)
        {
            vector3[i] = vec[i];
            pos = i;
        }

        
        for(int i = 0; i < vector2.size(); i++)
        {
            vector3[pos+1] = vector2.elementAt(i);
            pos++;
        }
        
        vec = new Object[newSize];
        for(int i = 0; i < vec.length; i++)
            vec[i] = vector3[i];
        
        size = newSize;
        
        
        //shift elements
        for(int i = 0; i < size - 1; i++)
        {
            vec[i] = vec[i+1];          
        }
        
        return true;
    }
    
    /**
     * Test if the vector is full
     * @return true if the vector is full and false if it isn't
     */
    public boolean isFull() {
        if (vec.length == size)
            return true;
        else
            return false;
    }
    
}
