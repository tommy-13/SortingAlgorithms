package sorting;

import java.util.Comparator;


public class ShakerSort<T> extends ArraySortingAlgorithm<T> {
	
	/**
	 * Creates a new ShakerSort with <code>comparator</code> to compare to objects
	 * in the array.
	 * @param comparator
	 */
	public ShakerSort(Comparator<T> comparator) {
		super("ShakerSort", comparator);
	}
	
	
	/**
	 * Sorts an array by repeatedly swapping adjacent elements that are out of order.
	 * Sweeps over the array repeatedly from left to right and right to left.
	 * @param array
	 */
	@Override
	public void sort(T[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		
		int start		= -1;
		int end			= array.length - 2;
		boolean swapped = true;
		
		while(swapped) {
			swapped = false;
			start++;
			
			// sweeping from left to right
			for(int i=start; i<=end; i++) {
				if(comparator.compare(array[i], array[i+1]) > 0) {
					// swap elements
					T temp 		= array[i];
					array[i]	= array[i+1];
					array[i+1]	= temp;
					swapped		= true;
				}
			}
			
			if(!swapped) {
				// elements are in order
				break;
			}
			
			swapped = false;
			end--;
			
			// sweeping from right to left
			for(int i=end; i>=start; i--) {
				if(comparator.compare(array[i], array[i+1]) > 0) {
					// swap elements
					T temp 		= array[i];
					array[i]	= array[i+1];
					array[i+1]	= temp;
					swapped		= true;
				}
			}
		}
	}
}
