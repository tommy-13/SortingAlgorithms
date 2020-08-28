package sorting;

import java.util.Comparator;

public class HeapSort<T> extends ArraySortingAlgorithm<T>{
	
	private int				heapSize	= 0;
	

	/**
	 * Creates a new MergeSort with <code>comparator</code> to compare to objects
	 * in the array.
	 * @param comparator
	 */
	public HeapSort(Comparator<T> comparator) {
		super("HeapSort", comparator);
	}
	
	
//	/**
//	 * Returns position of parent of the element at position <code>pos</code>. 
//	 * @param pos
//	 * @return
//	 */
//	private int parent(int pos) {
//		return (pos - 1) >> 1;
//	}
	
	/**
	 * Returns position of the left child of the element at position <code>pos</code>.
	 * @param pos
	 * @return
	 */
	private int left(int pos) {
		return (pos << 1) | 0x0001;
	}
	
	/**
	 * Returns position of the right child of the element at position <code>pos</code>.
	 * @param pos
	 * @return
	 */
	private int right(int pos) {
		return (pos + 1) << 1;
	}
	
	
	/**
	 * Maintains the heap property. It is assumed, that the binary trees at left(pos)
	 * and right(pos) are max-heaps, but that array[pos] might be smaller than its
	 * children. The element at array[pos] 'floats down' in the heap until the heap
	 * property is satisfied.
	 * @param array
	 * @param pos
	 */
	private void maxHeapify(T[] array, int pos) {
		int l 		= left(pos);
		int r 		= right(pos);
		int largest = pos;
		
		if(l < heapSize && comparator.compare(array[l], array[largest]) > 0) {
			largest = l;
		}
		if(r < heapSize && comparator.compare(array[r], array[largest]) > 0) {
			largest = r;
		}
		if(largest != pos) {
			// exchange array[pos] with array[largest]
			T temp			= array[pos];
			array[pos]		= array[largest];
			array[largest]	= temp;
			maxHeapify(array, largest);
		}
	}
	
	
	/**
	 * Converts <code>array</code> into a max-heap.
	 * @param array
	 */
	private void buildMaxHeap(T[] array) {
		int start = (heapSize - 2) >> 1;
		for(int i=start; i>=0; i--) {
			maxHeapify(array, i);
		}
	}



	@Override
	public void sort(T[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		heapSize = array.length;
		buildMaxHeap(array);
		
		while(heapSize > 1) {
			// decrease heap size
			heapSize--;
			// exchange array[0] with array[heapSize]
			T temp			= array[0];
			array[0]		= array[heapSize];
			array[heapSize]	= temp;
			maxHeapify(array, 0);
		}
	}
	
	
}
