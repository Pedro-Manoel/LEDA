package adt.hashtable.open;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.open.AbstractHashtableOpenAddress;
import adt.hashtable.open.HashtableElement;
import adt.hashtable.open.HashtableOpenAddressLinearProbingImpl;

public class StudentTestHashtableOpenAddressLinearProbing {

	protected AbstractHashtableOpenAddress<HashtableElement> table1;
	protected AbstractHashtableOpenAddress<HashtableElement> table2;

	protected final int PROPOSED_SIZE = 10;

	@Before
	public void setUp() throws Exception {
		table1 = new HashtableOpenAddressLinearProbingImpl<HashtableElement>(PROPOSED_SIZE, HashFunctionClosedAddressMethod.DIVISION);// o tamanho real utilizado vai ser PROPOSED_SIZE
		table1.insert(new HashtableElement(2)); // coloca no slot indexado com 2
		table1.insert(new HashtableElement(3)); // coloca no slot indexado com 3
		table1.insert(new HashtableElement(4)); // coloca no slot indexado com 4
		table1.insert(new HashtableElement(5)); // coloca no slot indexado com 5

		table2 = new HashtableOpenAddressLinearProbingImpl<HashtableElement>(PROPOSED_SIZE, HashFunctionClosedAddressMethod.DIVISION);
	}

	@Test
	public void testInsert() {
		assertEquals(0, table1.getCOLLISIONS());
		table1.insert(new HashtableElement(7)); // nao produz colisao. coloca no
												// slot indexado com 7
		assertEquals(7, table1.indexOf(new HashtableElement(7)));
		assertEquals(0, table1.getCOLLISIONS());

		table1.insert(new HashtableElement(9)); // nao produz colisao. coloca no
												// slot indexado com 9
		assertEquals(9, table1.indexOf(new HashtableElement(9)));
		assertEquals(0, table1.getCOLLISIONS());

		table1.insert(new HashtableElement(12)); // produz colisao com o 2.
													// coloca no slot indexado
													// com 6 (prox disponivel)
		assertEquals(6, table1.indexOf(new HashtableElement(12)));
		assertEquals(4, table1.getCOLLISIONS());

		table2.insert(new HashtableElement(14)); // nao produz colisao. coloca
													// no slot indexado com 4
		assertEquals(4, table2.indexOf(new HashtableElement(14)));
		assertEquals(0, table2.getCOLLISIONS());

	}

	@Test
	public void testRemove() {
		table1.remove(new HashtableElement(12)); // elemento inexistente
		assertEquals(4, table1.size());

		table1.remove(new HashtableElement(5)); // elemento existente
		assertEquals(3, table1.size());
		assertNull(table1.search(new HashtableElement(5)));

	}

	@Test
	public void testSearch() {
		assertEquals(new HashtableElement(5),
				table1.search(new HashtableElement(5))); // elemento que existe
		assertNull(table1.search(new HashtableElement(15))); // elemento que nao
																// existe
	}

	@Test
	public void testIsEmpty() {
		assertFalse(table1.isEmpty());
		table1.remove(new HashtableElement(2)); // esvazia
		table1.remove(new HashtableElement(3));
		table1.remove(new HashtableElement(4));
		table1.remove(new HashtableElement(5));
		assertTrue(table1.isEmpty());

		assertTrue(table2.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(table1.isFull());
		table1.insert(new HashtableElement(1));
		table1.insert(new HashtableElement(6));
		table1.insert(new HashtableElement(7));
		table1.insert(new HashtableElement(8));
		table1.insert(new HashtableElement(9));
		table1.insert(new HashtableElement(10)); // enche a tabela
		assertTrue(table1.isFull());

		assertFalse(table2.isFull());
	}

	@Test
	public void testSize() {
		assertEquals(4, table1.size());
	}

	// Meus testes

	@Test
	public void testGeral01() {
		assertTrue(table2.isEmpty());
		assertFalse(table2.isFull());
		assertEquals(-1, table2.indexOf(new HashtableElement(3)));
		assertEquals(-1, table2.indexOf(new HashtableElement(0)));
		assertEquals(-1, table2.indexOf(null));

		table2.insert(new HashtableElement(5));
		table2.insert(new HashtableElement(5));
		table2.insert(new HashtableElement(5));
		table2.insert(null);
		table2.remove(null);
		assertEquals(1, table2.size());
		assertFalse(table2.isEmpty());

		table2.remove(null);
		table2.remove(new HashtableElement(3));
		table2.remove(new HashtableElement(0));
		assertEquals(1, table2.size());
		assertFalse(table2.isEmpty());

		table2.remove(new HashtableElement(5));
		assertEquals(0, table2.size());
		assertTrue(table2.isEmpty());
	}

	@Test
	public void testGeral02() {
		assertFalse(table2.isFull());
		assertTrue(table2.isEmpty());

		table2.insert(new HashtableElement(3));
		assertEquals(3, table2.indexOf(new HashtableElement(3)));

		table2.insert(new HashtableElement(13));
		assertEquals(4, table2.indexOf(new HashtableElement(13)));

		table2.insert(new HashtableElement(4));
		assertEquals(5, table2.indexOf(new HashtableElement(4)));

		table2.insert(new HashtableElement(30));
		table2.insert(new HashtableElement(10));
		assertEquals(1, table2.indexOf(new HashtableElement(10)));
		assertEquals(0, table2.indexOf(new HashtableElement(30)));

		table2.insert(new HashtableElement(2));
		table2.insert(new HashtableElement(9));
		table2.insert(new HashtableElement(19));
		table2.insert(new HashtableElement(52));
		table2.insert(null);
		table2.insert(null);

		assertFalse(table2.isFull());
		table2.insert(new HashtableElement(28));
		assertTrue(table2.isFull());

		assertEquals(6, table2.indexOf(new HashtableElement(19)));
		assertEquals(7, table2.indexOf(new HashtableElement(52)));
		assertEquals(8, table2.indexOf(new HashtableElement(28)));

		table2.remove(new HashtableElement(3));
		assertFalse(table2.isFull());
		table2.remove(new HashtableElement(4));
		table2.remove(new HashtableElement(28));
		table2.remove(new HashtableElement(10));
		table2.remove(new HashtableElement(9));
		table2.remove(new HashtableElement(30));
		table2.remove(new HashtableElement(13));
		table2.remove(new HashtableElement(2));
		table2.remove(new HashtableElement(19));

		assertEquals(7, table2.indexOf(new HashtableElement(52)));
		table2.insert(new HashtableElement(6));
		assertEquals(6, table2.indexOf(new HashtableElement(6)));
		assertEquals(new HashtableElement(52), table2.search(new HashtableElement(52)));
		table2.remove(new HashtableElement(6));
		table2.remove(new HashtableElement(52));
		assertNull(table1.search(new HashtableElement(52)));
		assertTrue(table2.isEmpty());

	}

	@Test
	public void testGeral03 () {
		assertNull(table1.search(new HashtableElement(1)));
		//assertNull(table1.search(new HashtableElement(-1))); // erro com números negativos
		assertNull(table1.search(new HashtableElement(6)));
		assertNull(table1.search(new HashtableElement(12)));
		assertNull(table1.search(null));

		assertEquals(new HashtableElement(2), table1.search(new HashtableElement(2)));
		assertEquals(new HashtableElement(3), table1.search(new HashtableElement(3)));
		assertEquals(new HashtableElement(4), table1.search(new HashtableElement(4)));
		assertEquals(new HashtableElement(5), table1.search(new HashtableElement(5)));
	}

	@Test
	public void testGetColisao() {
		table2.insert(new HashtableElement(1)); // sem colisão
		assertEquals(0, table2.getCOLLISIONS());
		assertEquals(1, table2.size());

		table2.insert(new HashtableElement(11)); // 1 colisão
		assertEquals(1, table2.getCOLLISIONS()); // 0 + 1 = 1
		assertEquals(2, table2.size());

		table2.insert(new HashtableElement(21)); // 2 colisões
		assertEquals(3, table2.getCOLLISIONS()); // 2 + 1 = 3
		assertEquals(3, table2.size());

		table2.insert(new HashtableElement(31)); // 3 colisões
		assertEquals(6, table2.getCOLLISIONS()); // 3 + 3 = 6
		assertEquals(4, table2.size());

		table2.insert(new HashtableElement(41)); // 4 colisões
		assertEquals(10, table2.getCOLLISIONS()); // 6 + 4 = 10
		assertEquals(5, table2.size());
	}

	@Test
	public void testRemoveColisao() {
		assertEquals(0, table2.getCOLLISIONS());
		table2.insert(new HashtableElement(1)); // sem colisão
		table2.insert(new HashtableElement(11)); // 1 colisão
		table2.insert(new HashtableElement(21)); // 2 colisões
		table2.insert(new HashtableElement(31)); // 3 colisões
		table2.insert(new HashtableElement(41)); // 4 colisões
		assertEquals(10, table2.getCOLLISIONS()); // 1 + 2 + 3 + 4 = 10
		assertEquals(5, table2.size());

		table2.remove(new HashtableElement(1)); // sem remoção de colisão
		assertEquals(10, table2.getCOLLISIONS()); // 10 - 0 = 10
		assertEquals(4, table2.size());

		table2.remove(new HashtableElement(11)); // 1 remoção de colisão
		assertEquals(9, table2.getCOLLISIONS()); // 10 - 1 = 9
		assertEquals(3, table2.size());

		table2.remove(new HashtableElement(21)); // 2 remoções de colisões
		assertEquals(7, table2.getCOLLISIONS()); // 9 - 2 = 7
		assertEquals(2, table2.size());

		table2.remove(new HashtableElement(31)); // 3 remoções de colisões
		assertEquals(4, table2.getCOLLISIONS()); // 7 - 3 = 4
		assertEquals(1, table2.size());

		table2.remove(new HashtableElement(41)); // 4 remoções de colisões
		assertEquals(0, table2.getCOLLISIONS()); // 4 - 4 = 0
		assertEquals(0, table2.size());
	}

}
