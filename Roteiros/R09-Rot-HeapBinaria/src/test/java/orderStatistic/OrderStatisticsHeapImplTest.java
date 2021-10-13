package orderStatistic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderStatisticsHeapImplTest {

    private OrderStatisticsHeapImpl<Integer> orderStatisticsHeap;

    @Before
    public void criaClasses () {
        this.orderStatisticsHeap = new OrderStatisticsHeapImpl<>();
    }

    public void verificaEstatisticaDeOrdem (Integer[] array, int k, Integer retornoEsperado) {
        assertEquals(retornoEsperado, this.orderStatisticsHeap.getOrderStatistics(array, k));
    }

    public void verificaEstatisticaDeOrdem (Integer[] array, int k, int retornoEsperado) {
        assertEquals(Integer.valueOf(retornoEsperado), this.orderStatisticsHeap.getOrderStatistics(array, k));
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
        Integer[] array = new Integer[]{25,15,38,4,30,96,84}; // {4,15,25,30,38,84,96}

        verificaEstatisticaDeOrdem(array, -1, null);
        verificaEstatisticaDeOrdem(array, 0, null);
        verificaEstatisticaDeOrdem(array, 1, 4);
        verificaEstatisticaDeOrdem(array, 2, 15);
        verificaEstatisticaDeOrdem(array, 3, 25);
        verificaEstatisticaDeOrdem(array, 4, 30);
        verificaEstatisticaDeOrdem(array, 5, 38);
        verificaEstatisticaDeOrdem(array, 6, 84);
        verificaEstatisticaDeOrdem(array, 7, 96);
        verificaEstatisticaDeOrdem(array, 8, null);
    }

}