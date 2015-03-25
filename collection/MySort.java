/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author seththomas
 * @version 10/25/2012
 */
public class MySort {
    
    /**
     * Sorts a MyVector object using a bubble sort
     * @param vec
     * @return true
     */
    public static boolean bubbleSort(MyVector vec) {
        int i, j, n = vec.size();
        Comparable first, second;
        for(i = 1; i < n; ++i)
        {
            for(j = n - 1; j >= i; --j)
            {
                first = (Comparable)vec.elementAt(j-1);
                second = (Comparable)vec.elementAt(j);
                if(first.compareTo(second) > 0)
                    swap(vec, j-1, j);
            }
        }
            return true;
    }
    
    /**
     * Sorts a MyVector object using a selection sort
     * @param vec
     * @return true
     */
    public static boolean selectionSort (MyVector vec) {
        
        int i, j, n = vec.size();
        int smallPos;
        Comparable smallest, current;
        for(i = 0; i < n-1; ++i)
        {
            smallPos = i;
            smallest = (Comparable)(vec.elementAt(i));
            for(j = i+1; j < n; ++j)
            {
                current = (Comparable)(vec.elementAt(j));
                if(current.compareTo(smallest) < 0) // if current is smaller than smallest
                {
                    smallPos = j;
                    smallest = current;
                }
            } // end of inner for loop
        
            if(smallPos != i)
                swap(vec, i, smallPos);
            
        } // end of outer for loop
        
        return true;
    }
    
    /**
     * Sorts a MyVector object using a merge sort
     * @param vec the vector being sorted
     * @param tmp a temporary vector to be used in the sort
     * @param left the 1st index of interest
     * @param right the ending index of interest
     */
    public static void mergeSort(MyVector vec, Comparable[] tmp, int left, int right) {
        if(left == right) return;
        int mid = (left + right)/2, i, j, k;
        mergeSort(vec, tmp, left, mid);
        mergeSort(vec, tmp, mid+1, right);
        for(j = left; j <= right; j++)
            tmp[j] = (Comparable)vec.elementAt(j);
        i = left;
        k = mid+1;
        
        for(j = left; j <= right; j++)
        {
            if(i == mid+1)
                vec.replace(j, tmp[k++]);
            else if(k > right)
                vec.replace(j, tmp[i++]);
            else if((tmp[i]).compareTo(tmp[k]) < 0)
                vec.replace(j, tmp[i++]);
            else
                vec.replace(j, tmp[k++]);
        }
    }
    
    /**
     * Sorts a MyVector object using a shell sort
     * @param vec the vector to be sorted
     */
    public static void shellSort(MyVector vec) {
        int inner, outer;
        Object target;
        int h = 1;
        while(h <= vec.size()/3)
        {
            h = 3 * h + 1;
        }
        while(h > 0)
        {
            for(outer = h; outer < vec.size(); outer++)
            {
                target = vec.elementAt(outer);
                inner = outer;
                while(inner > h-1 && ((Comparable) vec.elementAt(inner-h)).compareTo(target) > 0)
                {
                    vec.replace(inner, vec.elementAt(inner-h));
                    inner = inner - h;
                }
                vec.replace(inner, target);
            } // end for loop
            h = (h-1)/3;
        } //end outer while loop
    } // end method shellSort
    
    /**
     * Sorts a MyVector object using an insertion sort
     * @param vec the vector to be sorted
     * @param left the 1st index of interest
     * @param right the ending index of interest
     */
    public static void insertionSort(MyVector vec, int left, int right) {
        int inner, outer;
        Object target;
        for(outer = left + 1; outer <= right; outer++)
        {
            target = vec.elementAt(outer);
            inner = outer;
            while(inner > left && ((Comparable)vec.elementAt(inner-1)).compareTo(target) > 0)
            {
                vec.replace(inner, vec.elementAt(inner-1));
                inner--;
            }
            vec.replace(inner, target);
        }
    }
    
    /**
     * Sorts a MyVector object using a quick sort
     * @param vec the vector to be sorted
     * @param left the 1st index of interest
     * @param right the ending index of interest
     */
    public static void quickSort(MyVector vec, int left, int right) {
        if(right - left < 10)
            insertionSort(vec, left, right);
        else
        {
            medianOf3(vec, left, right);
            int leftPar = partition(vec, left, right);
            quickSort(vec, left, leftPar-1);
            quickSort(vec, leftPar, right);
        }
    }
    
    /**
     * Swap based on pivot value
     * @param vec vec perform swapping operation
     * @param left the 1st index of interest
     * @param right the ending index of interest
     */
    public static void medianOf3(MyVector vec, int left, int right) {
        int middle = (left + right)/2;
        if(((Comparable) vec.elementAt(left)).compareTo(vec.elementAt(middle)) > 0)
            swap(vec, left, middle);
        if(((Comparable)vec.elementAt(middle)).compareTo(vec.elementAt(right)) > 0)
            swap(vec, middle, right);
        if(((Comparable)vec.elementAt(left)).compareTo(vec.elementAt(middle)) > 0)
            swap(vec, left, middle);
    }
    
    /**
     * Partition a vector (split into 2)
     * @param vec the vector to be partitioned
     * @param left the 1st index of interest
     * @param right the ending index of interest
     * @return 
     */
    public static int partition(MyVector vec, int left, int right) {
        Object pivot = vec.elementAt((left+right)/2);
        while(true) {
            while(((Comparable)vec.elementAt(++left)).compareTo(pivot) < 0);
            while(((Comparable)vec.elementAt(--right)).compareTo(pivot) > 0);
        if(left > right)
            break;
        else
            swap(vec, left, right);
        }
        return left;
    }

    /**
     * Swaps two elements in a MyVector object
     * @param vec
     * @param first
     * @param second 
     */
    public static void swap(MyVector vec, int first, int second) {
        Object tmp = vec.elementAt(first);
        vec.replace(first, vec.elementAt(second));
        vec.replace(second, tmp);
    }
        
}