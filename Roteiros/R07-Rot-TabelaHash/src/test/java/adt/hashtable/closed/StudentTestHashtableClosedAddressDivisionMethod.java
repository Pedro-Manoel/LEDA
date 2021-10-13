package adt.hashtable.closed;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.hashtable.closed.AbstractHashtableClosedAddress;
import adt.hashtable.closed.HashtableClosedAddressImpl;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;

public class StudentTestHashtableClosedAddressDivisionMethod {

	protected AbstractHashtableClosedAddress<Integer> table1;
	protected AbstractHashtableClosedAddress<Integer> table2;

	protected final int PROPOSED_SIZE = 100;

	@Before
	public void setUp() throws Exception {
		table1 = new HashtableClosedAddressImpl<Integer>(PROPOSED_SIZE,
				HashFunctionClosedAddressMethod.DIVISION);

		Integer initialValue = 200;
		int increment = 5;
		while (initialValue < 600) {
			table1.insert(initialValue);
			initialValue = initialValue + increment;
		}

		table2 = new HashtableClosedAddressImpl<Integer>(PROPOSED_SIZE,
				HashFunctionClosedAddressMethod.DIVISION);
	}

	@Test
	public void testInsert() {
		assertEquals(0, table1.getCOLLISIONS());
		table1.insert(105); // nao produz colisao
		assertEquals(0, table1.getCOLLISIONS());
		assertEquals(4, table1.indexOf(105));
		table1.insert(110); // nao produz colisao
		assertEquals(0, table1.getCOLLISIONS());
		assertEquals(9, table1.indexOf(110));
		table1.insert(101); // produz colisao no 0
		assertEquals(1, table1.getCOLLISIONS());
		assertEquals(0, table1.indexOf(101));

		table2.insert(103); // nao produz colisao inserindo 1 elemento na talbe
							// vazia
		assertEquals(0, table2.getCOLLISIONS());
		assertEquals(2, table2.indexOf(103));
	}

	@Test
	public void testRemove() {
		int currentSize = table1.size();
		table1.remove(200); // elemento existente
		assertEquals(currentSize - 1, table1.size());
		assertEquals(-1, table1.indexOf(200));
	}

	@Test
	public void testSearch() {
		// busca um elemento inexistente. compara a posicao
		assertNull(table1.search(100));
		assertEquals(-1, table1.indexOf(100));

		// busca um elemento existente. compara a posicao
		assertEquals(new Integer(305), table1.search(305));
		assertEquals(2, table1.indexOf(305));

	}

	@Test
	public void testIsEmpty() {
		assertFalse(table1.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(table1.isFull());
	}

	@Test
	public void testSize() {
		assertEquals(80, table1.size());
	}

	// Meus testes

	@Test
	public void testGeral01 () {
		assertTrue(table2.isEmpty());
		assertFalse(table2.isFull());
		assertEquals(-1, table2.indexOf(3));
		assertEquals(-1, table2.indexOf(0));
		assertEquals(-1, table2.indexOf(null));

		table2.insert(5);
		table2.insert(5);
		table2.insert(5);
		table2.insert(null);
		table2.remove(null);
		assertEquals(1, table2.size());
		assertFalse(table2.isEmpty());

		table2.remove(null);
		table2.remove(3);
		table2.remove(0);
		assertEquals(1, table2.size());
		assertFalse(table2.isEmpty());

		table2.remove(5);
		assertEquals(0, table2.size());
		assertTrue(table2.isEmpty());
	}

	@Test
	public void testGeral02 () {
		assertNull(table1.search(1)); // assertNull(table1.search(-1)); número negativo não passa retorna um hash negativo
		assertNull(table1.search(15));
		assertNull(table1.search(100));
		assertNull(table1.search(null));

		assertNull(table1.search(199));
		assertEquals(Integer.valueOf(200), table1.search(200));
		assertEquals(Integer.valueOf(205), table1.search(205));
		assertEquals(Integer.valueOf(325), table1.search(325));
		assertEquals(Integer.valueOf(415), table1.search(415));
		assertEquals(Integer.valueOf(555), table1.search(555));
		assertEquals(Integer.valueOf(595), table1.search(595));
		assertNull(table1.search(596));
	}

	@Test
	public void testGeral03 () {
		table2.insert(10);
		table2.insert(1);
		table2.insert(12);
		assertEquals(0, table2.getCOLLISIONS());
		assertEquals(10, table2.indexOf(10));
		assertEquals(1, table2.indexOf(1));
		assertEquals(12, table2.indexOf(12));

		table2.insert(1020);
		table2.insert(1011);
		table2.insert(1022);
		assertEquals(3, table2.getCOLLISIONS());
		assertEquals(10, table2.indexOf(1020));
		assertEquals(1, table2.indexOf(1011));
		assertEquals(12, table2.indexOf(1022));

		table2.remove(10);
		assertEquals(-1, table2.indexOf(10));
		assertEquals(2, table2.getCOLLISIONS());

		table2.remove(1);
		assertEquals(-1, table2.indexOf(1));
		assertEquals(1, table2.getCOLLISIONS());

		table2.remove(12);
		assertEquals(-1, table2.indexOf(12));
		assertEquals(0, table2.getCOLLISIONS());
	}

}
