package adt.avltree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AVLCountAndFillImplTest {

    protected AVLCountAndFill<Integer> tree1;
    protected AVLCountAndFill<Integer> tree2;
    protected AVLCountAndFill<Integer> tree3;
    protected static int SIZE = 10;

    @Before
    public void setUp() throws Exception {
        tree1 = new AVLCountAndFillImpl<Integer>();
        tree2 = new AVLCountAndFillImpl<Integer>();
        for (int i = 0; i < SIZE; i++) {
            tree1.insert(i);
            tree2.insert(SIZE - i);
        }
        tree3 = new AVLCountAndFillImpl<Integer>();
        Integer[] data = { 8, 4, 6, 12, 10 };
        for (Integer integer : data) {
            tree3.insert(integer);
        }
    }

    @Test
    public void testLLcount() {
        assertEquals(0, tree1.LLcount());
        assertEquals(6, tree2.LLcount());
        assertEquals(0, tree3.LLcount());
    }

    @Test
    public void testRRcount() {
        assertEquals(6, tree1.RRcount());
        assertEquals(0, tree2.RRcount());
        assertEquals(0, tree3.RRcount());
    }

    @Test
    public void testLRcount() {
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree2.LRcount());
        assertEquals(1, tree3.LRcount());
    }

    @Test
    public void testRLcount() {
        assertEquals(0, tree1.RLcount());
        assertEquals(0, tree2.RLcount());
        assertEquals(1, tree3.RLcount());
    }

    @Test
    public void testFillWithoutRebalance() {
        tree1 = new AVLCountAndFillImpl<Integer>();
        Integer[] keys = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15 };
        tree1.fillWithoutRebalance(keys);
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());
    }

    // MEUS TESTES

    @Test
    public void testContadores() {

        tree1 = new AVLCountAndFillImpl<Integer>();

        tree1.insert(null);
        tree1.insert(null);
        assertTrue(tree1.isEmpty());

        assertEquals(null, tree1.getRoot().getData());
        assertEquals(0, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());
        assertArrayEquals(new Integer[] {}, tree1.preOrder());
        assertTrue(tree1.isEmpty());

        tree1.insert(30);
        assertEquals(new Integer(30), tree1.getRoot().getData());
        assertEquals(1, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());
        assertArrayEquals(new Integer[] {30}, tree1.preOrder());
        assertFalse(tree1.isEmpty());

        tree1.insert(78);
        assertEquals(new Integer(30), tree1.getRoot().getData());
        assertEquals(2, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());
        assertArrayEquals(new Integer[] {30, 78}, tree1.preOrder());
        assertFalse(tree1.isEmpty());

        tree1.insert(60);
        assertEquals(new Integer(60), tree1.getRoot().getData());
        assertEquals(3, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(1, tree1.RLcount());
        assertArrayEquals(new Integer[] {60, 30, 78}, tree1.preOrder());
        assertFalse(tree1.isEmpty());

        tree1.insert(96);
        assertEquals(new Integer(60), tree1.getRoot().getData());
        assertEquals(4, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(1, tree1.RLcount());
        assertArrayEquals(new Integer[] {60, 30, 78, 96}, tree1.preOrder());

        tree1.insert(3);
        assertEquals(new Integer(60), tree1.getRoot().getData());
        assertEquals(5, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(1, tree1.RLcount());
        assertArrayEquals(new Integer[] {60, 30, 3, 78, 96}, tree1.preOrder());

        tree1.insert(58);
        assertEquals(new Integer(60), tree1.getRoot().getData());
        assertEquals(6, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(1, tree1.RLcount());
        assertArrayEquals(new Integer[] {60, 30, 3, 58, 78, 96}, tree1.preOrder());

        tree1.insert(47);
        assertEquals(new Integer(60), tree1.getRoot().getData());
        assertEquals(7, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(1, tree1.RLcount());
        assertArrayEquals(new Integer[] {60, 30, 3, 58, 47, 78, 96}, tree1.preOrder());

        tree1.insert(48);
        assertEquals(new Integer(60), tree1.getRoot().getData());
        assertEquals(8, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(1, tree1.RLcount());
        assertArrayEquals(new Integer[] {60, 30, 3, 48, 47, 58, 78, 96}, tree1.preOrder());

        tree1.insert(100);
        assertEquals(new Integer(60), tree1.getRoot().getData());
        assertEquals(9, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(1, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(1, tree1.RLcount());
        assertArrayEquals(new Integer[] {60, 30, 3, 48, 47, 58, 96, 78, 100}, tree1.preOrder());

        tree1.insert(90);
        assertEquals(new Integer(60), tree1.getRoot().getData());
        assertEquals(10, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(1, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(1, tree1.RLcount());
        assertArrayEquals(new Integer[] {60, 30, 3, 48, 47, 58, 96, 78, 90, 100}, tree1.preOrder());

        tree1.insert(93);
        assertEquals(new Integer(60), tree1.getRoot().getData());
        assertEquals(11, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(2, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(1, tree1.RLcount());
        assertArrayEquals(new Integer[] {60, 30, 3, 48, 47, 58, 96, 90, 78, 93, 100}, tree1.preOrder());

        tree1.insert(77);
        assertEquals(new Integer(60), tree1.getRoot().getData());
        assertEquals(12, tree1.size());
        assertEquals(1, tree1.LLcount());
        assertEquals(2, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(1, tree1.RLcount());
        assertArrayEquals(new Integer[] {60, 30, 3, 48, 47, 58, 90,78,77,96,93,100}, tree1.preOrder());

        tree1.insert(70);
        assertEquals(new Integer(60), tree1.getRoot().getData());
        assertEquals(13, tree1.size());
        assertEquals(2, tree1.LLcount());
        assertEquals(2, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(1, tree1.RLcount());
        assertArrayEquals(new Integer[] {60, 30, 3, 48, 47, 58, 90,77,70,78,96,93,100}, tree1.preOrder());

        tree1.insert(79);
        assertEquals(new Integer(60), tree1.getRoot().getData());
        assertEquals(14, tree1.size());
        assertEquals(2, tree1.LLcount());
        assertEquals(2, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(1, tree1.RLcount());
        assertArrayEquals(new Integer[] {60,30,3,48,47,58,90,77,70,78,79,96,93,100}, tree1.preOrder());

        tree1.insert(92);
        assertEquals(new Integer(60), tree1.getRoot().getData());
        assertEquals(15, tree1.size());
        assertEquals(2, tree1.LLcount());
        assertEquals(2, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(1, tree1.RLcount());
        assertArrayEquals(new Integer[] {60,30,3,48,47,58,90,77,70,78,79,96,93,92,100}, tree1.preOrder());

        tree1.insert(65);
        assertEquals(new Integer(60), tree1.getRoot().getData());
        assertEquals(16, tree1.size());
        assertEquals(2, tree1.LLcount());
        assertEquals(2, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(1, tree1.RLcount());
        assertArrayEquals(new Integer[] {60,30,3,48,47,58,90,77,70,65,78,79,96,93,92,100}, tree1.preOrder());

        tree1.insert(71);
        assertEquals(new Integer(60), tree1.getRoot().getData());
        assertEquals(17, tree1.size());
        assertEquals(2, tree1.LLcount());
        assertEquals(2, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(1, tree1.RLcount());
        assertArrayEquals(new Integer[] {60,30,3,48,47,58,90,77,70,65,71,78,79,96,93,92,100}, tree1.preOrder());

        tree1.insert(66);
        assertEquals(new Integer(77), tree1.getRoot().getData());
        assertEquals(18, tree1.size());
        assertEquals(2, tree1.LLcount());
        assertEquals(2, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(2, tree1.RLcount());
        assertArrayEquals(new Integer[] {77,60,30,3,48,47,58,70,65,66,71,90,78,79,96,93,92,100}, tree1.preOrder());

        tree1.insert(67);
        assertEquals(new Integer(77), tree1.getRoot().getData());
        assertEquals(19, tree1.size());
        assertEquals(2, tree1.LLcount());
        assertEquals(3, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(2, tree1.RLcount());
        assertArrayEquals(new Integer[] {77,60,30,3,48,47,58,70,66,65,67,71,90,78,79,96,93,92,100}, tree1.preOrder());

        tree1.remove(71);
        assertEquals(new Integer(77), tree1.getRoot().getData());
        assertEquals(18, tree1.size());
        assertEquals(3, tree1.LLcount());
        assertEquals(3, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(2, tree1.RLcount());
        assertArrayEquals(new Integer[] {77,60,30,3,48,47,58,66,65,70,67,90,78,79,96,93,92,100}, tree1.preOrder());

        tree1.remove(60);
        assertEquals(new Integer(77), tree1.getRoot().getData());
        assertEquals(17, tree1.size());
        assertEquals(3, tree1.LLcount());
        assertEquals(3, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(3, tree1.RLcount());
        assertArrayEquals(new Integer[] {77,65,30,3,48,47,58,67,66,70,90,78,79,96,93,92,100}, tree1.preOrder());

        tree1.remove(30);
        assertEquals(new Integer(77), tree1.getRoot().getData());
        assertEquals(16, tree1.size());
        assertEquals(3, tree1.LLcount());
        assertEquals(3, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(3, tree1.RLcount());
        assertArrayEquals(new Integer[] {77,65,47,3,48,58,67,66,70,90,78,79,96,93,92,100}, tree1.preOrder());

        tree1.remove(3);
        assertEquals(new Integer(77), tree1.getRoot().getData());
        assertEquals(15, tree1.size());
        assertEquals(3, tree1.LLcount());
        assertEquals(4, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(3, tree1.RLcount());
        assertArrayEquals(new Integer[] {77,65,48,47,58,67,66,70,90,78,79,96,93,92,100}, tree1.preOrder());

        tree1.remove(70);
        assertEquals(new Integer(77), tree1.getRoot().getData());
        assertEquals(14, tree1.size());
        assertEquals(3, tree1.LLcount());
        assertEquals(4, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(3, tree1.RLcount());
        assertArrayEquals(new Integer[] {77,65,48,47,58,67,66,90,78,79,96,93,92,100}, tree1.preOrder());

        tree1.remove(66);
        assertEquals(new Integer(77), tree1.getRoot().getData());
        assertEquals(13, tree1.size());
        assertEquals(3, tree1.LLcount());
        assertEquals(4, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(3, tree1.RLcount());
        assertArrayEquals(new Integer[] {77,65,48,47,58,67,90,78,79,96,93,92,100}, tree1.preOrder());

        tree1.remove(67);
        assertEquals(new Integer(77), tree1.getRoot().getData());
        assertEquals(12, tree1.size());
        assertEquals(4, tree1.LLcount());
        assertEquals(4, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(3, tree1.RLcount());
        assertArrayEquals(new Integer[] {77,48,47,65,58,90,78,79,96,93,92,100}, tree1.preOrder());

        tree1.remove(58);
        assertEquals(new Integer(90), tree1.getRoot().getData());
        assertEquals(11, tree1.size());
        assertEquals(4, tree1.LLcount());
        assertEquals(5, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(3, tree1.RLcount());
        assertArrayEquals(new Integer[] {90,77,48,47,65,78,79,96,93,92,100}, tree1.preOrder());

        tree1.remove(90);
        assertEquals(new Integer(92), tree1.getRoot().getData());
        assertEquals(10, tree1.size());
        assertEquals(4, tree1.LLcount());
        assertEquals(5, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(3, tree1.RLcount());
        assertArrayEquals(new Integer[] {92,77,48,47,65,78,79,96,93,100}, tree1.preOrder());

        tree1.remove(92);
        assertEquals(new Integer(93), tree1.getRoot().getData());
        assertEquals(9, tree1.size());
        assertEquals(4, tree1.LLcount());
        assertEquals(5, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(3, tree1.RLcount());
        assertArrayEquals(new Integer[] {93,77,48,47,65,78,79,96,100}, tree1.preOrder());

        tree1.remove(93);
        assertEquals(new Integer(77), tree1.getRoot().getData());
        assertEquals(8, tree1.size());
        assertEquals(5, tree1.LLcount());
        assertEquals(5, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(3, tree1.RLcount());
        assertArrayEquals(new Integer[] {77,48,47,65,96,78,79,100}, tree1.preOrder());

        tree1.remove(77);
        assertEquals(new Integer(78), tree1.getRoot().getData());
        assertEquals(7, tree1.size());
        assertEquals(5, tree1.LLcount());
        assertEquals(5, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(3, tree1.RLcount());
        assertArrayEquals(new Integer[] {78,48,47,65,96,79,100}, tree1.preOrder());

        tree1.remove(100);
        assertEquals(new Integer(78), tree1.getRoot().getData());
        assertEquals(6, tree1.size());
        assertEquals(5, tree1.LLcount());
        assertEquals(5, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(3, tree1.RLcount());
        assertArrayEquals(new Integer[] {78,48,47,65,96,79}, tree1.preOrder());

        tree1.remove(96);
        assertEquals(new Integer(78), tree1.getRoot().getData());
        assertEquals(5, tree1.size());
        assertEquals(5, tree1.LLcount());
        assertEquals(5, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(3, tree1.RLcount());
        assertArrayEquals(new Integer[] {78,48,47,65,79}, tree1.preOrder());

        tree1.remove(96);
        assertEquals(new Integer(78), tree1.getRoot().getData());
        assertEquals(5, tree1.size());
        assertEquals(5, tree1.LLcount());
        assertEquals(5, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(3, tree1.RLcount());
        assertArrayEquals(new Integer[] {78,48,47,65,79}, tree1.preOrder());

        tree1.remove(79);
        assertEquals(new Integer(48), tree1.getRoot().getData());
        assertEquals(4, tree1.size());
        assertEquals(6, tree1.LLcount());
        assertEquals(5, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(3, tree1.RLcount());
        assertArrayEquals(new Integer[] {48,47,78,65}, tree1.preOrder());

        tree1.remove(47);
        assertEquals(new Integer(65), tree1.getRoot().getData());
        assertEquals(3, tree1.size());
        assertEquals(6, tree1.LLcount());
        assertEquals(5, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(4, tree1.RLcount());
        assertArrayEquals(new Integer[] {65,48,78}, tree1.preOrder());

        tree1.remove(47);
        assertEquals(new Integer(65), tree1.getRoot().getData());
        assertEquals(3, tree1.size());
        assertEquals(6, tree1.LLcount());
        assertEquals(5, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(4, tree1.RLcount());
        assertArrayEquals(new Integer[] {65,48,78}, tree1.preOrder());

        tree1.remove(78);
        assertEquals(new Integer(65), tree1.getRoot().getData());
        assertEquals(2, tree1.size());
        assertEquals(6, tree1.LLcount());
        assertEquals(5, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(4, tree1.RLcount());
        assertArrayEquals(new Integer[] {65,48}, tree1.preOrder());

        tree1.remove(65);
        assertEquals(new Integer(48), tree1.getRoot().getData());
        assertEquals(1, tree1.size());
        assertEquals(6, tree1.LLcount());
        assertEquals(5, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(4, tree1.RLcount());
        assertArrayEquals(new Integer[] {48}, tree1.preOrder());
        assertFalse(tree1.isEmpty());

        tree1.remove(11);
        tree1.remove(10);
        tree1.remove(48);
        assertEquals(null, tree1.getRoot().getData());
        assertEquals(0, tree1.size());
        assertEquals(6, tree1.LLcount());
        assertEquals(5, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(4, tree1.RLcount());
        assertArrayEquals(new Integer[] {}, tree1.preOrder());
        assertTrue(tree1.isEmpty());

        tree1.insert(null);
        assertEquals(null, tree1.getRoot().getData());
        assertEquals(0, tree1.size());
        assertEquals(6, tree1.LLcount());
        assertEquals(5, tree1.RRcount());
        assertEquals(1, tree1.LRcount());
        assertEquals(4, tree1.RLcount());
        assertArrayEquals(new Integer[] {}, tree1.preOrder());
        assertTrue(tree1.isEmpty());

    }

    @Test
    public void testFIll() {
        tree1 = new AVLCountAndFillImpl<Integer>();

        tree1.insert(15);
        tree1.insert(6);
        tree1.insert(50);
        tree1.insert(4);
        tree1.insert(7);
        tree1.insert(23);
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());

        tree1.fillWithoutRebalance(new Integer[] {60, 81, 80, 70});

        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());
    }

    @Test
    public void testFillArrayVazio() {
        tree1.fillWithoutRebalance(new Integer[] {});
        assertEquals(0, tree1.LLcount());
        assertEquals(6, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());

        tree1 = new AVLCountAndFillImpl<Integer>();

        tree1.fillWithoutRebalance(new Integer[] {});
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());
    }

    @Test
    public void testFillArrayElementosRepetidos() {

        assertEquals(10, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(6, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());

        tree1.fillWithoutRebalance(new Integer[] {5,5,5,5,5,5,5});

        assertEquals(10, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(6, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());

        tree1.fillWithoutRebalance(new Integer[] {15,15,15,15,15});

        assertEquals(11, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(6, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());

        tree1 = new AVLCountAndFillImpl<Integer>();

        assertEquals(0, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());

        tree1.fillWithoutRebalance(new Integer[] {1,1,1,1,1,1});

        assertEquals(1, tree1.size());
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());
    }
}