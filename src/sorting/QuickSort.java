package sorting;

import java.util.Comparator;


public class QuickSort<T> extends ArraySortingAlgorithm<T>{

	/**
	 * Creates a new QuickSort with <code>comparator</code> to compare to objects
	 * in the array.
	 * @param comparator
	 */
	public QuickSort(Comparator<T> comparator) {
		super("QuickSort", comparator);
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
			/* if quicksort performs badly on the array change to insertion sort */
			insertionSort(array, 0, array.length-1);
		}
	}
	
	
	private void quickSort(T[] array, int left, int right) throws StackOverflowError {
		if(left < right) {
			/* partition the array and get the pivot element */
			int pivot = partition(array, left, right);
			/* recursively sort the left part and the right part of the array */
			quickSort(array, left, pivot-1);
			quickSort(array, pivot+1, right);
		}
	}
	
	/**
	 * Sorts <code>array</code> with insertion sort.
	 * @param array
	 * @param left
	 * @param right
	 */
	private void insertionSort(T[] array, int left, int right) {
		for(int j=left+1; j<=right; j++) {
			T key = array[j];
			
			// insert key into the sorted sequence array[p..j-1]
			int i = j-1;
			while(i >= left && comparator.compare(array[i], key) > 0) {
				array[i+1] = array[i]; // move element to the right
				i--;
			}
			array[i+1] = key; // insert key
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
		
		// set the pivot element at the 'right' position
		if(comparator.compare(array[i], pivotValue) > 0) {
			array[right]	= array[i];
			array[i]		= pivotValue;
		}
		
		return i;
	}
	
}
