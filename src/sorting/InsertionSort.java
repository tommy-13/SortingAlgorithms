package sorting;

import java.util.Comparator;


public class InsertionSort<T> extends ArraySortingAlgorithm<T>{
	

	/**
	 * Creates a new InsertionSort with <code>comparator</code> to compare to objects
	 * in the array.
	 * @param comparator
	 */
	public InsertionSort(Comparator<T> comparator) {
		super("InsertionSort", comparator);
	}
	
	
	
	/**
	 * Sorts an array incrementally: Given a sorted array up to position j
	 * the algorithm inserts the element at position j+1 into the sorted array
	 * such that after this operation the array is sorted up to position j+1.
	 * @param array Array to be sorted.
	 */
	public void sort(T[] array) {
		if(array == null || array.length <= 1) {
			// no need for sorting
			return;
		}
		
		for(int j=1; j<array.length; j++) {
			T key = array[j];
			
			// insert key into the sorted sequence array[0..j-1]
			int i = j-1;
			while(i >= 0 && comparator.compare(array[i], key) > 0) {
				array[i+1] = array[i]; // move element to the right
				i--;
			}
			array[i+1] = key; // insert key
		}
	}
	
}
