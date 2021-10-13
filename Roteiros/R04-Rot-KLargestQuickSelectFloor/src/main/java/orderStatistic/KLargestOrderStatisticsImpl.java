package orderStatistic;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Voce pode modificar o array original
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 *   ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 *   Este metodo NUNCA deve retornar null.
 * 
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	private boolean verifyArrayAndK (T[] array, int k) {
		return k <= array.length && k >= 1;
	}

	@Override
	public T[] getKLargest (T[] array, int k) {
		if (this.verifyArrayAndK(array, k)) {
			if (k == array.length) { return array; }

			T[] arrayKLargest = (T[]) new Comparable[k];
			T orderStatistic = this.orderStatistics(array, array.length - k);

			for (int i = 0; i < array.length; i++) {
				if (array[i].compareTo(orderStatistic) > 0) {
					arrayKLargest[i - (array.length - k)] = array[i];
				}
			}

			return arrayKLargest;
		}
		return (T[]) new Comparable[0];
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics (T[] array, int k){
		if (verifyArrayAndK(array, k)) {
			for (int i = 0; i < k; i++) {
				int indexMinor = i;

				for (int j = i + 1; j < array.length; j++) {
					if (array[j].compareTo(array[indexMinor]) < 0) {
						indexMinor = j;
					}
				}
				Util.swap(array, i, indexMinor);
			}
			return array[k - 1];
		}
		return null;
	}

}
