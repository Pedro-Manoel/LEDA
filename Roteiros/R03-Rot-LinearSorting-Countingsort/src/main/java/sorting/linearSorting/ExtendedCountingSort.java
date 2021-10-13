package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	private boolean verificaIndices (Integer[] array, int leftIndex, int rightIndex) {
		return leftIndex < rightIndex && leftIndex >= 0 && rightIndex <= array.length - 1;
	}

	private int[] getMaiorMenorValorArray (Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];
		int menor = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
			if (array[i] < menor) {
				menor = array[i];
			}
		}

		return new int[]{maior, menor};
	}

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (verificaIndices(array, leftIndex, rightIndex)) {
			int[] maiorMenorValorArray = this.getMaiorMenorValorArray(array, leftIndex, rightIndex);
			int maiorValor = maiorMenorValorArray[0];
			int menorValor = maiorMenorValorArray[1];

			int[] C = new int[maiorValor - menorValor + 1];
			int[] B = new int[rightIndex - leftIndex + 1];

			// Preenchendo C com as frequências dos elementos de array
			for (int i = leftIndex; i <= rightIndex; i++) {
				C[array[i] - menorValor]++;
			}

			// Calculando a soma cumulativa em C
			for (int i = 1; i < C.length; i++) {
				C[i] += C[i - 1];
			}

			// Registrando no B os elementos ordenados
			for (int i = rightIndex; i >= leftIndex; i--) {
				B[C[array[i] - menorValor] - 1] = array[i];
				C[array[i] - menorValor]--;
			}

			// Atribuindo o B em array
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = B[i - leftIndex];
			}
		}
	}

}
