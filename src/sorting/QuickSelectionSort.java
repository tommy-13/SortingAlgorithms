package sorting;

import java.util.Comparator;


public class QuickSelectionSort<T> extends ArraySortingAlgorithm<T>{
	
	private final int MIN_DIST = 6;
	
	
	/**
	 * Creates a new QuickSelectionSort with <code>comparator</code> to compare to objects
	 * in the array.
	 * @param comparator
	 */
	public QuickSelectionSort(Comparator<T> comparator) {
		super("QuickSelectionSort", comparator);
	}
	
	
	
	/**
	 * Sorts an array by the divide-and-conquer approach with quicksort.
	 * @param array
	 */
	public void sort(T[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		try {
			quickSort(array, 0, array.length-1);
		} catch(StackOverflowError e) {
			selectionSort(array, 0, array.length-1);
		}
	}
	
	
	private void quickSort(T[] array, int left, int right) throws StackOverflowError {
		if(right - left > MIN_DIST) {
			int pivot = partition(array, left, right);
			quickSort(array, left, pivot-1);
			quickSort(array, pivot+1, right);
		}
		else {
			selectionSort(array, left, right);
		}
	}
	
	private void selectionSort(T[] array, int left, int right) {
		for(int i=left; i<right; i++) {
			// find minimum
			int posOfMin	= i;
			T	valueOfMin	= array[i];
			for(int j=i+1; j<=right; j++) {
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
	
	/**
	 * Partitions the array. After the partitioning all elements left of the
	 * pivot index are smaller than the pivot value and all elements right of
	 * the pivot index are bigger than the pivot value.
	 * @param array
	 * @param left
	 * @param right
	 */
	private int partition(T[] array, int left, int right) {
		T pivotValue	= array[right];
		int i			= left;
		int j			= right - 1;
		
		while(i < j) {
			// search element from the left which is bigger than pivot
			while(comparator.compare(array[i], pivotValue) <= 0 && i < right) {
				i++;
			}
			// search element from the right which is smaller than pivot
			while(comparator.compare(array[j], pivotValue) >= 0 && j > left) {
				j--;
			}
			
			if(i < j) {
				// switch elements
				T temp 		= array[i];
				array[i]	= array[j];
				array[j]	= temp;
			}
		}
		
		// set the pivot element at the right position
		if(comparator.compare(array[i], pivotValue) > 0) {
			array[right]	= array[i];
			array[i]		= pivotValue;
		}
		
		return i;
	}
	
}
