package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import countingSort.CountingSort;
import countingSort.RadixSort;
import countingSort.Sortable;
import countingSort.SortableSortingAlgorithm;
import countingSort.TestSortable;

public class ArraySortRunningTime {
	
	private final int	size 	= 1000000;
	private final int	maxRand = 1000000;
	private TestData 	testData;

	private Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	};
	
	@SuppressWarnings("rawtypes")
	private ArraySortingAlgorithm[] sortingAlgos = {
//		new BubbleSort<Integer>(comp),
		new HeapSort<Integer>(comp),
//		new InsertionSort<Integer>(comp),
		//new IntroSort<Integer>(comp),
//		new MergeInsertionSort<Integer>(comp),
//		new MergeSelectionSort<Integer>(comp),
		new MergeSort<Integer>(comp),
//		new QuickInsertionSort<Integer>(comp),
//		new QuickInsertionSortMedian<Integer>(comp),
//		new QuickSelectionSort<Integer>(comp),
		new QuickSort<Integer>(comp),
//		new QuickSortMedian<Integer>(comp),
//		new SelectionSort<Integer>(comp),
//		new ShakerSort<Integer>(comp)
	};
	
	private SortableSortingAlgorithm[] intSortAlgos = {
			new CountingSort(),
			new RadixSort()
	};
	
	
	private Sortable[] sortArr;
	private void setUp() {
		testData = TestData.getTestData();
		testData.createRandomArray(size, maxRand);
		Integer[] array = testData.getRandomArray();
		sortArr			= new Sortable[array.length];
		for(int i=0; i<array.length; i++) {
			sortArr[i] = new TestSortable(array[i]);
		}
	}
	
	
	private void runAlgo(ArraySortingAlgorithm<Integer> asa) {
		long timeStart	= 0;
		long timeEnd	= 0;
		long duration	= 0;

		Integer[] array = testData.getRandomArray();
		timeStart 		= System.currentTimeMillis();
		asa.sort(array);
		timeEnd 		= System.currentTimeMillis();
		duration 		= timeEnd - timeStart;
		System.out.println("Time " + asa.getName() + " (ms): " + duration);
	}
	
	private void runIntSortAlgo(SortableSortingAlgorithm ssa) {
		long timeStart	= 0;
		long timeEnd	= 0;
		long duration	= 0;
		
		timeStart 		= System.currentTimeMillis();
		ssa.sort(sortArr);
		timeEnd 		= System.currentTimeMillis();
		duration 		= timeEnd - timeStart;
		System.out.println("Time " + ssa.getName() + " (ms): " + duration);
	}
	
	@SuppressWarnings("unchecked")
	private void runAlgos() {
		for(ArraySortingAlgorithm<Integer> asa : sortingAlgos) {
			runAlgo(asa);
		}
		for(SortableSortingAlgorithm ssa : intSortAlgos) {
			runIntSortAlgo(ssa);
		}
	}
	
	private void runJavaAlgo() {
		long timeStart	= 0;
		long timeEnd	= 0;
		long duration	= 0;
		
		Integer[] array 	= testData.getRandomArray();
		List<Integer> list 	= new ArrayList<Integer>();
		for(int i=0; i<array.length; i++) {
			list.add(array[i]);
		}
		
		timeStart 		= System.currentTimeMillis();
		Collections.sort(list, comp);
		timeEnd 		= System.currentTimeMillis();
		duration 		= timeEnd - timeStart;
		System.out.println("Time JAVA Collection.sort (ms): " + duration);
	}
	
	
	public static void main(String[] args) {
		ArraySortRunningTime asrt = new ArraySortRunningTime();
		asrt.setUp();
		asrt.runAlgos();
		asrt.runJavaAlgo();
	}
}
