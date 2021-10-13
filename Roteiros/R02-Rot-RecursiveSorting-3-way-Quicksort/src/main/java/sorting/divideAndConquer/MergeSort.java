package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private void merge (T[] array, int leftIndex, int middle, int rightIndex) {
		T[] arrayCopy = array.clone();
		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;

		while (i <= middle && j <= rightIndex) {
			if (arrayCopy[i].compareTo(arrayCopy[j]) <= 0) {
				array[k++] = arrayCopy[i++];
			} else {
				array[k++] = arrayCopy[j++];
			}
		}

		while (i <= middle) {
			array[k++] = arrayCopy[i++];
		}

		while (j <= rightIndex) {
			array[k++] = arrayCopy[j++];
		}
	}

	@Override
	public void sort (T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex <= array.length - 1) {
			if (leftIndex < rightIndex) {
				int middle = (leftIndex + rightIndex) / 2;
				this.sort(array, leftIndex, middle);
				this.sort(array, middle + 1, rightIndex);
				this.merge(array, leftIndex, middle, rightIndex);
			}
		}
	}

}
