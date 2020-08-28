package sorting;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class MergeInsertionSort<T> extends ArraySortingAlgorithm<T>{
	
	private final int MIN_DIST = 6;
	

	/**
	 * Creates a new MergeInsertionSort with <code>comparator</code> to compare to objects
	 * in the array.
	 * @param comparator
	 */
	public MergeInsertionSort(Comparator<T> comparator) {
		super("MergeInsertionSort", comparator);
	}
	
	
	
	/**
	 * Sorts an array by the divide-and-conquer approach.
	 * For small subarrays selection sort is used.
	 * @param array
	 */
	public void sort(T[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		mergeSort(array, 0, array.length-1);
	}
	
	
	private void mergeSort(T[] array, int p, int r) {
		if(r - p > MIN_DIST) {
			int q = (int) ((p + r) / 2);
			// divide into two subarrays
			mergeSort(array, p, q);
			mergeSort(array, q + 1, r);
			// merge the two ordered subarrays
			merge(array, p, q, r);
		}
		else {
			for(int j=p+1; j<=r; j++) {
				T key = array[j];
				
				// insert key into the sorted sequence array[p..j-1]
				int i = j-1;
				while(i >= p && comparator.compare(array[i], key) > 0) {
					array[i+1] = array[i]; // move element to the right
					i--;
				}
				array[i+1] = key; // insert key
			}
		}
	}
	
	/**
	 * Merges the subarrays from positions p to q (inclusively) and from p+1 to r.
	 * @param array
	 * @param p
	 * @param q
	 * @param r
	 */
	private void merge(T[] array, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		
		// copy elements
		List<T> left	= new LinkedList<T>();
		List<T> right	= new LinkedList<T>();
		for(int i=0; i<n1; i++) {
			left.add(array[p + i]);
		}
		for(int i=0; i<n2; i++) {
			right.add(array[q+i+1]);
		}
		
		// merge elements
		int pos = p;
		while(!left.isEmpty()) {
			while(!right.isEmpty() && comparator.compare(right.get(0), left.get(0)) <= 0) {
				array[pos] = right.remove(0);
				pos++;
			}
			
			array[pos] = left.remove(0);
			pos++;
		}
		// left is empty
		while(!right.isEmpty()) {
			array[pos] = right.remove(0);
			pos++;
		}
	}
	
}
