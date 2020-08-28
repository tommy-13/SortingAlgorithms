package sorting;

import java.util.Comparator;


public class BubbleSort<T> extends ArraySortingAlgorithm<T> {
	
	/**
	 * Creates a new BubbleSort with <code>comparator</code> to compare to objects
	 * in the array.
	 * @param comparator
	 */
	public BubbleSort(Comparator<T> comparator) {
		super("BubbleSort", comparator);
	}
	
	
	/**
	 * Sorts an array by repeatedly swapping adjacent elements that are out of order
	 * @param array
	 */
	@Override
	public void sort(T[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		
		for(int i=0; i<array.length - 1; i++) {
			for(int j=array.length-1; j>i; j--) {
				if(comparator.compare(array[j], array[j-1]) < 0) {
					// swap elements
					T temp		= array[j];
					array[j]	= array[j-1];
					array[j-1]	= temp;
				}
			}
		}
	}
}
