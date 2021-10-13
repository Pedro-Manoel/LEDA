package problems;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FloorBinarySearchImplTest {

    private FloorBinarySearchImpl floorBinarySearch;

    @Before
    public void criaClasse () { this.floorBinarySearch = new FloorBinarySearchImpl(); }

    public void verificaFloor (Integer[] array, int x, Integer retornoEsperado) {
        assertEquals(retornoEsperado, floorBinarySearch.floor(array, x));
    }

    public void verificaFloor (Integer[] array, int x, int retornoEsperado) {
        assertEquals(Integer.valueOf(retornoEsperado), floorBinarySearch.floor(array, x));
    }

    @Test
    public void testFloorArrayVazio () {
        verificaFloor(new Integer[]{}, 1, null);
        verificaFloor(new Integer[0], 1, null);
    }

    @Test
    public void testFloorXMenorQueTodoArray () {
        Integer[] array = new Integer[]{4,15,25,30,38,84,96};

        verificaFloor(array, 3, null);
        verificaFloor(array, 2, null);
        verificaFloor(array, 1, null);
        verificaFloor(array, 0, null);
        verificaFloor(array, -1, null);
        verificaFloor(array, -2, null);
        verificaFloor(array, -3, null);
    }

    @Test
    public void testFloorArrayOrdenado () {
        Integer[] array = new Integer[]{4,15,25,30,38,84,96};

        verificaFloor(array, 38, 38);
        verificaFloor(array, 17, 15);
        verificaFloor(array, 200, 96);
        verificaFloor(array, 60, 38);
    }

    @Test
    public void testFloorArrayNaoOrdenado () {
        Integer[] array = new Integer[]{25,38,15,96,4,30,84};

        verificaFloor(array, 38, 38);
        verificaFloor(array, 17, 15);
        verificaFloor(array, 200, 96);
        verificaFloor(array, 60, 38);
    }

    @Test
    public void testFloorArrayComUmElemento () {
        Integer[] array = new Integer[]{2};

        verificaFloor(array, 1, null);
        verificaFloor(array, 2, 2);
        verificaFloor(array, 3, 2);
        verificaFloor(array, 100, 2);
        verificaFloor(array, 100000, 2);
    }


    @Test
    public void testFloor01 () {
        Integer[] array = new Integer[]{-2,0,4,6,8,10,94,96,102};

        verificaFloor(array, 1, 0);
        verificaFloor(array, 0, 0);
        verificaFloor(array,-1, -2);
        verificaFloor(array, 5, 4);
        verificaFloor(array, 6, 6);
        verificaFloor(array, 9, 8);
        verificaFloor(array, 150, 102);
        verificaFloor(array, 1000, 102);
        verificaFloor(array, 95, 94);
        verificaFloor(array, 97, 96);
    }

    @Test
    public void testFloor02 () {
        Integer[] array = new Integer[]{-8,-4,-2,0,5,8,12,58,87,174};

        verificaFloor(array, -8, -8);
        verificaFloor(array, -7, -8);
        verificaFloor(array, -6, -8);
        verificaFloor(array, -5, -8);
        verificaFloor(array, -4, -4);
        verificaFloor(array, -3, -4);
        verificaFloor(array, -1, -2);
        verificaFloor(array, 0, 0);
        verificaFloor(array, 1, 0);
        verificaFloor(array, 4, 0);
        verificaFloor(array, 6, 5);
        verificaFloor(array, 7, 5);
        verificaFloor(array, 9, 8);
        verificaFloor(array, 32, 12);
        verificaFloor(array, 65, 58);
        verificaFloor(array, 90, 87);
        verificaFloor(array, 170, 87);
        verificaFloor(array, 173, 87);
        verificaFloor(array, 174, 174);
        verificaFloor(array, 175, 174);
        verificaFloor(array, 999, 174);
        verificaFloor(array, 999999999, 174);
    }
}