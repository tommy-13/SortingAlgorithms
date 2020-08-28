package countingSort;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSorting {
	
	private SortableSortingAlgorithm	arraySort;
	private TestData					testData;
	private int 						n = 1000;
	
	public TestSorting(SortableSortingAlgorithm sortingAlgo) {
		super();
		arraySort = sortingAlgo;
	}
	
	@Parameters
	public static Collection<Object[]> values() {
		Object[][] data = new Object[][] {
				{new CountingSort()},
				{new RadixSort()}
		};
		return Arrays.asList(data);
	}
	
	
	@Before
	public void setUp() throws Exception {
		testData	= TestData.getTestData();
		testData.setMaxRandom(100);
		testData.createRandomArray(n);
	}
	
	
	@Test
	public void testSortNull() {
		Sortable[] array = testData.getNullArray();
		array = arraySort.sort(array);
		assertNull(array);
	}
	@Test
	public void testSortEmpty() {
		Sortable[] array = testData.getEmptyArray();
		array = arraySort.sort(array);
		assertTrue(array.length == 0);
	}
	@Test
	public void testSortSize1() {
		Sortable[] array = testData.getSize1Array();
		array = arraySort.sort(array);
		assertTrue(array.length == 1);
	}
	@Test
	public void testSortAscending() {
		Sortable[] array = testData.getAscendingArray(n);
		array = arraySort.sort(array);
		assertTrue(array.length == n);
		for(int i=0; i<n; i++) {
			assertTrue(array[i].getKey() == i);
		}
	}
	@Test
	public void testSortDescending() {
		Sortable[] array = testData.getDescendingArray(n);
		array = arraySort.sort(array);
		assertTrue(array.length == n);
		for(int i=0; i<n; i++) {
			assertTrue(array[i].getKey() == i);
		}
	}
	@Test
	public void testSortRandom() {
		Sortable[] array = testData.getRandomArray();
		array = arraySort.sort(array);
		assertTrue(array.length == n);
		for(int i=0; i<n-1; i++) {
			assertTrue(array[i].getKey() <= array[i+1].getKey());
		}
	}
	
}
