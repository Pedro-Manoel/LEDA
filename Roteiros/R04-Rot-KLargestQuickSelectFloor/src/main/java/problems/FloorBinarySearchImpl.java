package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	public void applyMedianOfThree (Integer[] array, int leftIndex, int rightIndex) {
		int middle = (leftIndex + rightIndex) / 2;

		if (array[rightIndex].compareTo(array[leftIndex]) < 0) {
			Util.swap(array, rightIndex, leftIndex);
		}
		if (array[middle].compareTo(array[leftIndex]) < 0) {
			Util.swap(array, middle, leftIndex);
		}
		if (array[rightIndex].compareTo(array[middle]) < 0) {
			Util.swap(array, rightIndex, middle);
		}

		Util.swap(array, leftIndex, middle);
	}

	private int partition (Integer[] array, int leftIndex, int rightIndex) {
		this.applyMedianOfThree(array, leftIndex, rightIndex);

		Integer pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				Util.swap(array, j, ++i);
			}
		}
		Util.swap(array, leftIndex, i);

		return i;
	}

	private void quickSort (Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int indexPivot = this.partition(array, leftIndex, rightIndex);
			this.quickSort(array, leftIndex, indexPivot - 1);
			this.quickSort(array, indexPivot + 1, rightIndex);
		}
	}

	private int floorBinarySearch (Integer[] array, int value, int leftIndex, int rightIndex) {
		if (leftIndex <= rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;

			if (array[middle] == value) {
				return middle;
			} else if (array[middle] < value) {
				int result = floorBinarySearch(array, value, middle + 1, rightIndex);
				return result == -1 ? middle : result;
			} else {
				return floorBinarySearch(array, value, leftIndex , middle - 1);
			}
		}

		return -1;
	}

	@Override
	public Integer floor (Integer[] array, Integer x) {
		this.quickSort(array, 0, array.length - 1);
		int floorIndex = this.floorBinarySearch(array, x, 0, array.length - 1);
		return floorIndex == -1 ? null : array[floorIndex];
	}

}
