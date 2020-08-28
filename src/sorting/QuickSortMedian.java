package sorting;

import java.util.Comparator;


public class QuickSortMedian<T> extends ArraySortingAlgorithm<T>{

	/**
	 * Creates a new QuickSort with <code>comparator</code> to compare to objects
	 * in the array.
	 * @param comparator
	 */
	public QuickSortMedian(Comparator<T> comparator) {
		super("QuickSortMedian", comparator);
	}
	
	
	
	/**
	 * Sorts an array by the divide-and-conquer approach with quicksort.
	 * @param array
	 */
	public void sort(T[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		quickSort(array, 0, array.length-1);
	}
	
	
	private void quickSort(T[] array, int left, int right) {
		int delta = right - left;
		
		if(delta > 1) {
			int pivot = partition(array, left, right);
			quickSort(array, left, pivot-1);
			quickSort(array, pivot+1, right);
		}
		else if(delta > 0 && comparator.compare(array[left], array[right]) > 0) {
			// switch elements
			T temp			= array[left];
			array[left]		= array[right];
			array[right]	= temp;
		}
	}
	
	/**
	 * Partitions the array. After the partitioning all elements left of the
	 * pivot index are smaller than the pivot value and all elements right of
	 * the pivot index are bigger than the pivot value.
	 * @param array
	 * @param left
	 * @param right
	 * @return 
	 */
	private int partition(T[] array, int left, int right) {
		int pivotIndex	= right;
		T 	pivotValue	= array[pivotIndex];
		
		// Median-of-3
		int middle = (left + right) / 2;
		if(comparator.compare(array[left], array[middle]) >= 0) {
			if(comparator.compare(array[middle], array[right]) >= 0) {
				pivotIndex = middle;
			}
			else if(comparator.compare(array[right], array[left]) >= 0) {
				pivotIndex = left;
			}
		}
		else if(comparator.compare(array[right], array[middle]) >= 0) {
			pivotIndex = middle;
		}
		else if(comparator.compare(array[left], array[right]) > 0) {
			pivotIndex = left;
		}
		
		if(pivotIndex != right) {
			// switch pivot element to the right
			pivotValue			= array[pivotIndex];
			array[pivotIndex]	= array[right];
			array[right]		= pivotValue;
		}
		
		
		int i	= left;
		int j	= right - 1;
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
