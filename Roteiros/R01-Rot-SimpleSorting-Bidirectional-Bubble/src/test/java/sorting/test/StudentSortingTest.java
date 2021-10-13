package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.simpleSorting.BubbleSort;
import sorting.simpleSorting.InsertionSort;
import sorting.simpleSorting.SelectionSort;
import sorting.variationsOfBubblesort.BidirectionalBubbleSort;
import sorting.variationsOfBubblesort.RecursiveBubbleSort;
import sorting.variationsOfSelectionsort.RecursiveSelectionSort;
import util.Util;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new RecursiveSelectionSort<>();
		//Assert.fail("Implementation not provided");
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */

	public void testOrdenaSomenteAsTresPrimeirasPosicoes (Integer[] array) {
		Integer[] copy1;
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
			implementation.sort(array, 0, 2);
			Arrays.sort(copy1, 0, 3);
			Assert.assertArrayEquals(copy1, array);
		}
	}

	public void testOrdenaSomenteAsTresUltimasPosicoes (Integer[] array) {
		Integer[] copy1;
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
			implementation.sort(array, array.length-3, array.length-1);
			Arrays.sort(copy1, array.length-3, array.length);
			Assert.assertArrayEquals(copy1, array);
		}
	}

	public void testOrdenaSomenteTresPosicoesNoMeio (Integer[] array) {
		Integer[] copy1;
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
			implementation.sort(array, (array.length/2) - 2, (array.length/2));
			Arrays.sort(copy1, (array.length/2) - 2, (array.length/2) + 1);
			Assert.assertArrayEquals(copy1, array);
		}
	}

	public void testLeftIndexMenorQueZero (Integer[] array) {
		Integer[] copy1;
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
			implementation.sort(array, -1, array.length - 1);
			Assert.assertArrayEquals(copy1, array);
		}
	}

	public void testLeftIndexMaiorQueTamanhoDoArray (Integer[] array) {
		Integer[] copy1;
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
			implementation.sort(array, array.length, array.length - 1);
			Assert.assertArrayEquals(copy1, array);
		}
	}

	public void testRightIndexMaiorQueTamanhoDoArray (Integer[] array) {
		Integer[] copy1;
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
			implementation.sort(array, 0, array.length);
			Assert.assertArrayEquals(copy1, array);
		}
	}

	public void testRightIndexMenorQueLeftIndex (Integer[] array) {
		Integer[] copy1;
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
			implementation.sort(array, 2, 1);
			Assert.assertArrayEquals(copy1, array);
		}
	}

	public void testRightIndexIgualLeftIndex (Integer[] array) {
		Integer[] copy1;
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
			implementation.sort(array, 2, 2);
			Assert.assertArrayEquals(copy1, array);
		}
	}
	
	@Test
	public void insertionSort() { // apagar
		this.implementation = new InsertionSort<>();
		this.implementation.sort(new Integer[]{3,5,2,1});
	}

	@Test
	public void testSort06 () {
		testOrdenaSomenteAsTresPrimeirasPosicoes(vetorTamPar);
	}

	@Test
	public void testSort07 () {
		testOrdenaSomenteAsTresUltimasPosicoes(vetorValoresRepetidos);
	}

	@Test
	public void testSort08 () {
		testOrdenaSomenteTresPosicoesNoMeio(vetorTamPar);
	}

	@Test
	public void testSort09 () {
		testLeftIndexMenorQueZero(vetorTamPar);
	}

	@Test
	public void testSort10 () {
		testLeftIndexMaiorQueTamanhoDoArray(vetorTamPar);
	}

	@Test
	public void testSort11 () {
		testRightIndexMaiorQueTamanhoDoArray(vetorTamPar);
	}

	@Test
	public void testSort12 () {
		testRightIndexMenorQueLeftIndex(vetorTamPar);
	}

	@Test
	public void testSort13 () {
		testRightIndexIgualLeftIndex(vetorTamPar);
	}

}