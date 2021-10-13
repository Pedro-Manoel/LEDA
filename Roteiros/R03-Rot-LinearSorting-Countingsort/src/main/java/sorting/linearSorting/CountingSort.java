package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	private boolean verificaIndices (Integer[] array, int leftIndex, int rightIndex) {
		return leftIndex < rightIndex && leftIndex >= 0 && rightIndex <= array.length - 1;
	}

	private int getMaiorValorArray (Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}

		return maior;
	}

	@Override
	public void sort (Integer[] array, int leftIndex, int rightIndex) {
		if (verificaIndices(array, leftIndex, rightIndex)) {
			int[] C = new int[this.getMaiorValorArray(array, leftIndex, rightIndex) + 1];
			int[] B = new int[rightIndex - leftIndex + 1];

			// Preenchendo C com as frequências dos elementos de array
			for (int i = leftIndex; i <= rightIndex; i++) {
				C[array[i]]++;
			}

			// Calculando a soma cumulativa em C
			for (int i = 1; i < C.length; i++) {
				C[i] += C[i - 1];
			}

			// Registrando no B os elementos ordenados
			for (int i = rightIndex; i >= leftIndex; i--) {
				B[C[array[i]] - 1] = array[i];
				C[array[i]]--;
			}

			// Atribuindo o B em array
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = B[i - leftIndex];
			}
		}
	}

}