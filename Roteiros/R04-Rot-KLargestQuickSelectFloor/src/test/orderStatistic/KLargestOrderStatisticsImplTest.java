package orderStatistic;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class KLargestOrderStatisticsImplTest {

    private KLargestOrderStatisticsImpl<Integer> algorithm;

    @Before
    public void criaClasse () {
        this.algorithm = new KLargestOrderStatisticsImpl<>();
    }

    public void verificaEstatisticaDeOrdem (Integer[] array, int k, Integer retornoEsperado) {
        assertEquals(retornoEsperado, this.algorithm.orderStatistics(array.clone(), k));
    }

    public void verificaEstatisticaDeOrdem (Integer[] array, int k, int retornoEsperado) {
        assertEquals(Integer.valueOf(retornoEsperado), this.algorithm.orderStatistics(array.clone(), k));
    }

    public void verificaKLargest (Integer[] array, int k, String retornoEsperado) {
        Comparable<Integer>[] kLargest = this.algorithm.getKLargest(array, k);
        Arrays.sort(kLargest);

        assertEquals(retornoEsperado, Arrays.toString(kLargest));
    }

    @Test
    public void testEstatisticaDeOrdemDeArrayVazio () {
        verificaEstatisticaDeOrdem(new Integer[]{}, 1, null);
        verificaEstatisticaDeOrdem(new Integer[0], 1, null);
    }

    @Test
    public void testEstatisticaDeOrdemComPosicaoForaDoArray () {
        Integer[] array = new Integer[]{4,8,3,7,6};

        verificaEstatisticaDeOrdem(array, -1, null);
        verificaEstatisticaDeOrdem(array, -2, null);
        verificaEstatisticaDeOrdem(array, -3, null);
        verificaEstatisticaDeOrdem(array, 0, null);
        verificaEstatisticaDeOrdem(array, 6, null);
        verificaEstatisticaDeOrdem(array, 7, null);
        verificaEstatisticaDeOrdem(array, 8, null);
    }

    @Test
    public void testEstatisticaDeOrdem01 () {
        Integer[] array = new Integer[]{4,8,3,7,6}; // {3,4,6,7,8}

        verificaEstatisticaDeOrdem(array, 1, 3);
        verificaEstatisticaDeOrdem(array, 2, 4);
        verificaEstatisticaDeOrdem(array, 3, 6);
        verificaEstatisticaDeOrdem(array, 4, 7);
        verificaEstatisticaDeOrdem(array, 5, 8);
    }

    @Test
    public void testEstatisticaDeOrdem02 () {
        Integer[] array = new Integer[]{3,4,6,7,8}; // {3,4,6,7,8}

        verificaEstatisticaDeOrdem(array, 1, 3);
        verificaEstatisticaDeOrdem(array, 2, 4);
        verificaEstatisticaDeOrdem(array, 3, 6);
        verificaEstatisticaDeOrdem(array, 4, 7);
        verificaEstatisticaDeOrdem(array, 5, 8);
    }

    @Test
    public void testEstatisticaDeOrdem3 () {
        Integer[] array = new Integer[]{8,-9,2,0,-4,7,3,5,1}; // {-9,-4,0,1,2,3,5,7,8}

        verificaEstatisticaDeOrdem(array, 1,-9);
        verificaEstatisticaDeOrdem(array, 2,-4);
        verificaEstatisticaDeOrdem(array, 3, 0);
        verificaEstatisticaDeOrdem(array, 4, 1);
        verificaEstatisticaDeOrdem(array, 5, 2);
        verificaEstatisticaDeOrdem(array, 6, 3);
        verificaEstatisticaDeOrdem(array, 7, 5);
        verificaEstatisticaDeOrdem(array, 8, 7);
        verificaEstatisticaDeOrdem(array, 9, 8);
    }

    @Test
    public void testEstatisticaDeOrdem04 () {
        Integer[] array = new Integer[]{4,8,6,9,12,1}; // {1,4,6,8,9,12}

        verificaEstatisticaDeOrdem(array, 3, 6);
        verificaEstatisticaDeOrdem(array, 6, 12);
        verificaEstatisticaDeOrdem(array, 1, 1);
        verificaEstatisticaDeOrdem(array, 5, 9);
    }

    @Test
    public void testEstatisticaDeOrdem05 () {
        Integer[] array = new Integer[]{1,2,3,4,5,6,7};

        verificaEstatisticaDeOrdem(array, 1, 1);
    }

    @Test
    public void testEstatisticaDeOrdem06 () {
        Integer[] array = new Integer[]{1};

        verificaEstatisticaDeOrdem(array, 1, 1);
    }

    @Test
    public void testEstatisticaDeOrdem07 () {
        Integer[] array = new Integer[]{2,2,2};

        verificaEstatisticaDeOrdem(array, 1, 2);
        verificaEstatisticaDeOrdem(array, 2, 2);
        verificaEstatisticaDeOrdem(array, 3, 2);
    }

    @Test
    public void testEstatisticaDeOrdem08 () {
        Integer[] array = new Integer[]{8,2,5,2,9}; // 2,2,5,8,9

        verificaEstatisticaDeOrdem(array, 1, 2);
        verificaEstatisticaDeOrdem(array, 2, 2);
        verificaEstatisticaDeOrdem(array, 3, 5);
        verificaEstatisticaDeOrdem(array, 4, 8);
        verificaEstatisticaDeOrdem(array, 5, 9);
    }

    @Test
    public void testGetKLargestArrayVazio () {
        verificaKLargest(new Integer[]{},2, "[]");
        verificaKLargest(new Integer[0], 2, "[]");
    }

    @Test
    public void testGetKLargestComKInvalido () {
        Integer[] array = new Integer[]{4,8,6,9,12,1}; // {1,4,6,8,9,12}

        verificaKLargest(array, -2, "[]");
        verificaKLargest(array, -1, "[]");
        verificaKLargest(array, 0,  "[]");
        verificaKLargest(array, 7,  "[]");
        verificaKLargest(array, 8,  "[]");
        verificaKLargest(array, 9,  "[]");
    }

    @Test
    public void testGetKLargest01 () {
        Integer[] array = new Integer[]{30,28,7,29,11,26,4,22,23,31}; // {4,7,11,22,23,26,28,29,30,31}

        verificaKLargest(array,1, "[31]");
        verificaKLargest(array,2, "[30, 31]");
        verificaKLargest(array,3, "[29, 30, 31]");
        verificaKLargest(array,4, "[28, 29, 30, 31]");
        verificaKLargest(array,5, "[26, 28, 29, 30, 31]");
        verificaKLargest(array,6, "[23, 26, 28, 29, 30, 31]");
        verificaKLargest(array,7, "[22, 23, 26, 28, 29, 30, 31]");
        verificaKLargest(array,8, "[11, 22, 23, 26, 28, 29, 30, 31]");
        verificaKLargest(array,9, "[7, 11, 22, 23, 26, 28, 29, 30, 31]");
        verificaKLargest(array,10,"[4, 7, 11, 22, 23, 26, 28, 29, 30, 31]");
    }

    @Test
    public void testGetKLargest02 () {
        Integer[] array = new Integer[]{8,-9,2,0,-4,7,3,-8,5,1}; // {-9,-8,-4,0,1,2,3,5,7,8}

        verificaKLargest(array,1, "[8]");
        verificaKLargest(array,2, "[7, 8]");
        verificaKLargest(array,3, "[5, 7, 8]");
        verificaKLargest(array,4, "[3, 5, 7, 8]");
        verificaKLargest(array,5, "[2, 3, 5, 7, 8]");
        verificaKLargest(array,6, "[1, 2, 3, 5, 7, 8]");
        verificaKLargest(array,7, "[0, 1, 2, 3, 5, 7, 8]");
        verificaKLargest(array,8, "[-4, 0, 1, 2, 3, 5, 7, 8]");
        verificaKLargest(array,9, "[-8, -4, 0, 1, 2, 3, 5, 7, 8]");
        verificaKLargest(array,10,"[-9, -8, -4, 0, 1, 2, 3, 5, 7, 8]");
    }

    @Test
    public void testGetKLargest03 () {
        Integer[] array = new Integer[]{4,9,1,4,7,5,4}; // {1,4,4,4,5,7,9}

        verificaKLargest(array,1, "[9]");
        verificaKLargest(array,2, "[7, 9]");
        verificaKLargest(array,3, "[5, 7, 9]");
        // verificaKLargest(array,4, "[4, 5, 7, 9]");
        // verificaKLargest(array,5, "[4, 4, 5, 7, 9]");
        // verificaKLargest(array,6, "[4, 4, 4, 5, 7, 9]");
        // verificaKLargest(array,7, "[1, 4, 4, 4, 5, 7, 9]");
    }

}