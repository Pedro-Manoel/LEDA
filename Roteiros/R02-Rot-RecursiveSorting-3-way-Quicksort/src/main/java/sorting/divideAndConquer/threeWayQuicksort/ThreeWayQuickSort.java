package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private int[] partition (T[] array, int leftIndex, int rightIndex) {
		T pivot = array[leftIndex];
		int lp = leftIndex;
	    int i = leftIndex;
		int rp = rightIndex;

		while (i <= rp) {
			if (array[i].compareTo(pivot) < 0) {
				Util.swap(array, lp++, i++);
			}
			else if (array[i].compareTo(pivot) > 0) {
				Util.swap(array, rp--, i);
			}
        	else {
				i++;
			}
		}

		return new int[]{lp, rp};
	}

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitos elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex <= array.length - 1) {
			if (leftIndex < rightIndex) {
				int[] indicesPivot = this.partition(array, leftIndex, rightIndex);
				this.sort(array, leftIndex, indicesPivot[0] - 1);
				this.sort(array, indicesPivot[1] + 1, rightIndex);
			}
		}
	}

}
