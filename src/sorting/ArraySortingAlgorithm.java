package sorting;

import java.util.Comparator;

public abstract class ArraySortingAlgorithm<T> {

	private		String			name;
	protected 	Comparator<T> 	comparator;
	
	public ArraySortingAlgorithm(String name, final Comparator<T> comparator) {
		this.comparator = comparator;
		this.name		= name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void sort(T[] array);
	
}