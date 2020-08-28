package countingSort;

import java.util.Random;

public class TestData {
	
	private Sortable[] 	randomArray;
	private int			maxRandom	= 100; 
	
	
	private TestData() {
		createRandomArray(100);
	}
	
	private static TestData testArray = new TestData();
	public static TestData getTestData() {
		return testArray;
	}
	
	
	public void setMaxRandom(int maxValue) {
		maxRandom = maxValue;
	}
	
	public void createRandomArray(int size) {
		randomArray 	= new Sortable[size];
		Random random 	= new Random();
		for(int i=0; i<size; i++) {
			randomArray[i] = new TestSortable(random.nextInt(maxRandom));
		}
	}
	
	
	private Sortable[] copyArray(final Sortable[] array) {
		if(array == null) {
			return null;
		}
		Sortable[] copy = new Sortable[array.length];
		for(int i=0; i<array.length; i++) {
			copy[i] = new TestSortable(array[i].getKey());
		}
		return copy;
	}
	
	
	public Sortable[] getNullArray() {
		Sortable[] nullArray = null;
		return nullArray;
	}
	public Sortable[] getEmptyArray() {
		Sortable[] emptyArray = {};
		return emptyArray;
	}
	public Sortable[] getSize1Array() {
		Sortable[] size1Array = {new TestSortable(1)};
		return size1Array;
	}
	public Sortable[] getAscendingArray(int size) {
		Sortable[] ascendingArray = new Sortable[size];
		for(int i=0; i<size; i++) {
			ascendingArray[i] = new TestSortable(i);
		}
		return ascendingArray;
	}
	public Sortable[] getDescendingArray(int size) {
		Sortable[] descendingArray = new Sortable[size];
		for(int i=0; i<size; i++) {
			descendingArray[i] = new TestSortable(size - i - 1);
		}
		
		return descendingArray;
	}
	public Sortable[] getRandomArray() {
		return copyArray(randomArray);
	}
	
}
