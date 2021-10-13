package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista3.insert(1);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new RecursiveDoubleLinkedListImpl<>();
		lista2 = new DoubleLinkedListImpl<>();
		lista3 = new RecursiveDoubleLinkedListImpl<>();
		lista4 = new RecursiveDoubleLinkedListImpl<>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
	}

	// Meus testes

	@Test
	public void myTestInsertFirst() {
		((DoubleLinkedList<Integer>) lista2).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).insertFirst(2);
		((DoubleLinkedList<Integer>) lista2).insertFirst(7);
		Assert.assertArrayEquals(new Integer[] { 7,2,4 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).insertFirst(0);
		((DoubleLinkedList<Integer>) lista2).insertFirst(1);
		Assert.assertArrayEquals(new Integer[] { 1,0,7,2,4 }, lista2.toArray());

		lista2.insert(3);
		lista2.insert(8);
		lista2.insert(5);
		Assert.assertArrayEquals(new Integer[] { 1,0,7,2,4,3,8,5 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).insertFirst(12);
		Assert.assertArrayEquals(new Integer[] { 12,1,0,7,2,4,3,8,5 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).insertFirst(null);
		Assert.assertArrayEquals(new Integer[] { 12,1,0,7,2,4,3,8,5 }, lista2.toArray());
	}

	@Test
	public void myTestRemoveFirst() {
		lista2.insert(1);
		lista2.insert(2);
		lista2.insert(3);
		lista2.insert(4);
		lista2.insert(5);
		lista2.insert(6);

		Assert.assertArrayEquals(new Integer[] { 1,2,3,4,5,6 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2,3,4,5,6 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeFirst();
		((DoubleLinkedList<Integer>) lista2).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 4,5,6 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeFirst();
		((DoubleLinkedList<Integer>) lista2).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 6 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeFirst();
		Assert.assertArrayEquals(new Integer[] {  }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeFirst();
		((DoubleLinkedList<Integer>) lista2).removeFirst();
		((DoubleLinkedList<Integer>) lista2).removeFirst();
		Assert.assertArrayEquals(new Integer[] {  }, lista2.toArray());
	}

	@Test
	public void myTestRemoveLast() {
		lista2.insert(1);
		lista2.insert(2);
		lista2.insert(3);
		lista2.insert(4);
		lista2.insert(5);
		lista2.insert(6);

		Assert.assertArrayEquals(new Integer[] { 1,2,3,4,5,6 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeLast();
		Assert.assertArrayEquals(new Integer[] { 1,2,3,4,5 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeLast();
		((DoubleLinkedList<Integer>) lista2).removeLast();
		Assert.assertArrayEquals(new Integer[] { 1,2,3 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeLast();
		((DoubleLinkedList<Integer>) lista2).removeLast();
		Assert.assertArrayEquals(new Integer[] { 1 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeLast();
		Assert.assertArrayEquals(new Integer[] {  }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeLast();
		((DoubleLinkedList<Integer>) lista2).removeLast();
		((DoubleLinkedList<Integer>) lista2).removeLast();
		Assert.assertArrayEquals(new Integer[] {  }, lista2.toArray());
	}

	@Test
	public void myTestDoubleGeral() {
		// removeFirst, removeLast e insertFirst
		lista2.insert(7);
		lista2.insert(2);
		lista2.insert(6);
		lista2.insert(6);
		lista2.insert(0);
		lista2.insert(-3);

		assertArrayEquals(new Integer[] { 7,2,6,6,0,-3 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeFirst();
		assertArrayEquals(new Integer[] { 2,6,6,0,-3 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeLast();
		assertArrayEquals(new Integer[] { 2,6,6,0 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeLast();
		((DoubleLinkedList<Integer>) lista2).removeFirst();
		assertArrayEquals(new Integer[] { 6,6 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).insertFirst(9);
		((DoubleLinkedList<Integer>) lista2).insertFirst(3);
		((DoubleLinkedList<Integer>) lista2).insertFirst(6);
		assertArrayEquals(new Integer[] { 6,3,9,6,6 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeLast();
		((DoubleLinkedList<Integer>) lista2).removeLast();
		assertArrayEquals(new Integer[] { 6,3,9 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeFirst();
		((DoubleLinkedList<Integer>) lista2).removeFirst();
		assertArrayEquals(new Integer[] { 9 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeFirst();
		assertArrayEquals(new Integer[] {  }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeFirst();
		((DoubleLinkedList<Integer>) lista2).removeLast();
		((DoubleLinkedList<Integer>) lista2).removeFirst();
		((DoubleLinkedList<Integer>) lista2).removeLast();
		assertArrayEquals(new Integer[] {  }, lista2.toArray());
	}

}