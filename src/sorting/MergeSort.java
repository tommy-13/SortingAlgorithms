package sorting;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class MergeSort<T> extends ArraySortingAlgorithm<T>{

	/**
	 * Creates a new MergeSort with <code>comparator</code> to compare to objects
	 * in the array.
	 * @param comparator
	 */
	public MergeSort(Comparator<T> comparator) {
		super("MergeSort", comparator);
	}
	
	
	
	/**
	 * Sorts an array by the divide-and-conquer approach.
	 * @param array
	 */
	public void sort(T[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		mergeSort(array, 0, array.length-1);
	}
	
	
	private void mergeSort(T[] array, int p, int r) {
		if(p<r) {
			int q = (int) ((p + r) / 2);
			// divide into two subarrays
			mergeSort(array, p, q);
			mergeSort(array, q + 1, r);
			// merge the two ordered subarrays
			merge(array, p, q, r);
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
