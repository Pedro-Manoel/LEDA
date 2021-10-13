package adt.avltree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTestAVLCountAndFill {

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

    @Test
    public void testFillWithoutRebalance01() {
        tree1 = new AVLCountAndFillImpl<>();
        Integer[] keys = { 15,16,17,18,19,20 };
        tree1.fillWithoutRebalance(keys);
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());
    }

    @Test
    public void testFillWithoutRebalance02() {
        tree1 = new AVLCountAndFillImpl<>();
        Integer[] keys = { 15,14,13,12,11,10 };
        tree1.fillWithoutRebalance(keys);
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());
    }

    @Test
    public void testFillWithoutRebalance03() {
        tree1 = new AVLCountAndFillImpl<>();
        Integer[] keys = { 18,15,20,17,16,19 };
        tree1.fillWithoutRebalance(keys);
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());
    }

    @Test
    public void testFillWithoutRebalance04() {
        tree1 = new AVLCountAndFillImpl<>();
        Integer[] keys = { 15,12,11,14,10,13 };
        tree1.fillWithoutRebalance(keys);
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());
    }

    @Test
    public void testFillWithoutRebalance05() {
        tree1 = new AVLCountAndFillImpl<>();
        Integer[] keys = { 15,12,11,14,10,13,18,25,20,17,16,19 };
        tree1.fillWithoutRebalance(keys);
        assertEquals(0, tree1.LLcount());
        assertEquals(0, tree1.RRcount());
        assertEquals(0, tree1.LRcount());
        assertEquals(0, tree1.RLcount());
    }

	@Test
	public void testFillWithoutRebalance06() {
		tree1 = new AVLCountAndFillImpl<>();
		tree1.insert(8);
		tree1.insert(6);
		tree1.insert(2); // causa balanceamento LL
		tree1.insert(3);
		tree1.insert(9);
		Integer[] keys = { 15,12,11,14,10,13,18,25,20,17,16,19 };
		tree1.fillWithoutRebalance(keys);
		assertEquals(1, tree1.LLcount()); // assertEquals(1, tree1.LLcount()); não sei se zera ou não
		assertEquals(0, tree1.RRcount());
		assertEquals(0, tree1.LRcount());
		assertEquals(0, tree1.RLcount());
	}

	@Test
	public void testFillWithoutRebalanceComElementosNaTree() {
		tree1 = new AVLCountAndFillImpl<>();

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
		assertArrayEquals(new Integer[]{50,7,6,4,23,15,80,70,60,81}, tree1.preOrder());
	}
}
