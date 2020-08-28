package sorting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSorting {

	private static Comparator<Integer> comp1 = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	};
	
	private ArraySortingAlgorithm<Integer> 	arraySort;
	private TestData						testData;
	private int 							elements = 10000;
	private int                             valueUpperBound = 100;
	
	public TestSorting(ArraySortingAlgorithm<Integer> sortingAlgo) {
		super();
		arraySort = sortingAlgo;
	}
	
	@Parameters
	public static Collection<Object[]> values() {
		Object[][] data = new Object[][] {
				{new BubbleSort<Integer>(comp1)},
				{new HeapSort<Integer>(comp1)},
				{new InsertionSort<Integer>(comp1)},
				//{new IntroSort<Integer>(comp1)},
				{new MergeInsertionSort<Integer>(comp1)},
				{new MergeSelectionSort<Integer>(comp1)},
				{new MergeSort<Integer>(comp1)},
				{new QuickInsertionSort<Integer>(comp1)},
				{new QuickInsertionSortMedian<Integer>(comp1)},
				{new QuickSelectionSort<Integer>(comp1)},
				{new QuickSort<Integer>(comp1)},
				{new QuickSortMedian<Integer>(comp1)},
				{new SelectionSort<Integer>(comp1)},
				{new ShakerSort<Integer>(comp1)}
		};
		return Arrays.asList(data);
	}
	
	
	@Before
	public void setUp() throws Exception {
		testData	= TestData.getTestData();
		testData.createRandomArray(elements, valueUpperBound);
	}
	
	
	@Test
	public void testSortNull() {
		Integer[] array = testData.getNullArray();
		arraySort.sort(array);
		assertNull(array);
	}
	@Test
	public void testSortEmpty() {
		Integer[] array = testData.getEmptyArray();
		arraySort.sort(array);
		assertTrue(array.length == 0);
	}
	@Test
	public void testSortSize1() {
		Integer[] array = testData.getSize1Array();
		arraySort.sort(array);
		assertTrue(array.length == 1);
	}
	@Test
	public void testSortAscending() {
		Integer[] array = testData.getAscendingArray(elements);
		arraySort.sort(array);
		assertTrue(array.length == elements);
		for(int i=0; i<elements; i++) {
			assertTrue(array[i].equals(i));
		}
	}
	@Test
	public void testSortDescending() {
		Integer[] array = testData.getDescendingArray(elements);
		arraySort.sort(array);
		assertTrue(array.length == elements);
		for(int i=0; i<elements; i++) {
			assertTrue(array[i].equals(i));
		}
	}
	@Test
	public void testSortRandom() {
		Integer[] array = testData.getRandomArray();
		arraySort.sort(array);
		assertTrue(array.length == elements);
		for(int i=0; i<elements-1; i++) {
			assertTrue(comp1.compare(array[i], array[i+1]) <= 0);
		}
	}
	
}
