package sorting;

import java.util.Comparator;
import java.util.Random;

public class TestData {
	
	private final Comparator<Integer> compInt = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	};
	
	private Integer[] randomArray;
	
	
	private TestData() {
		createRandomArray(100, 1000);
	}
	
	private static TestData testArray = new TestData();
	public static TestData getTestData() {
		return testArray;
	}
	
	
	public void createRandomArray(int size, int maxRand) {
		randomArray 	= new Integer[size];
		Random random 	= new Random();
		for(int i=0; i<size; i++) {
			randomArray[i] = random.nextInt(maxRand);
		}
	}
	
	
	private Integer[] copyArray(final Integer[] array) {
		if(array == null) {
			return null;
		}
		Integer[] copy = new Integer[array.length];
		for(int i=0; i<array.length; i++) {
			copy[i] = new Integer(array[i]);
		}
		return copy;
	}
	
	
	public Comparator<Integer> getIntComparator() {
		return compInt;
	}
	public Integer[] getNullArray() {
		Integer[] nullArray = null;
		return nullArray;
	}
	public Integer[] getEmptyArray() {
		Integer[] emptyArray = {};
		return emptyArray;
	}
	public Integer[] getSize1Array() {
		Integer[] size1Array = {1};
		return size1Array;
	}
	public Integer[] getAscendingArray(int size) {
		Integer[] ascendingArray = new Integer[size];
		for(int i=0; i<size; i++) {
			ascendingArray[i] = i;
		}
		return ascendingArray;
	}
	public Integer[] getDescendingArray(int size) {
		Integer[] descendingArray = new Integer[size];
		for(int i=0; i<size; i++) {
			descendingArray[i] = size - i - 1;
		}
		
		return descendingArray;
	}
	public Integer[] getRandomArray() {
		return copyArray(randomArray);
	}
	
}
