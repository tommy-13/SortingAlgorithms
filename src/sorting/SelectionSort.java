package sorting;

import java.util.Comparator;

public class SelectionSort<T> extends ArraySortingAlgorithm<T>{

	/**
	 * Creates a new SelectionSort with <code>comparator</code> to compare to objects
	 * in the array.
	 * @param comparator
	 */
	public SelectionSort(Comparator<T> comparator) {
		super("SelectionSort", comparator);
	}
	
	
	/**
	 * Sorts the array by searching for the minimal element in the array an switch
	 * it with the element at position 0. Then the algorithm does the same for
	 * the subarray from position 1 to array.length-1. And so on.
	 * @param array Array to be sorted.
	 */
	@Override
	public void sort(T[] array) {
		if(array == null || array.length <= 1) {
			// an array of length 1 is already sorted
			return;
		}
		
		for(int i=0; i<array.length-1; i++) {
			// find minimum
			int posOfMin	= i;
			T	valueOfMin	= array[i];
			for(int j=i+1; j<array.length; j++) {
				// compare
				if(comparator.compare(array[j], valueOfMin) < 0) {
					posOfMin	= j;
					valueOfMin	= array[j];
				}
			}
			
			// switch elements
			T temp			= array[i];
			array[i]		= valueOfMin;
			array[posOfMin]	= temp;
		}
	}
	
}
