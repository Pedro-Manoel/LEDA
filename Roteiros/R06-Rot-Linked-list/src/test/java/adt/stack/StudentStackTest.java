package adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;
	public Stack<Integer> stack4;
	public Stack<Integer> stack5;

	@Before
	public void setUp() throws StackOverflowException {

		getImplementations();

		// Pilha com 3 elementos não cheia.
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);

		// Pilha com 2 elementos de tamanho 2, pilha cheia.
		stack2.push(1);
		stack2.push(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		stack1 = new StackDoubleLinkedListImpl<>(4);
		stack2 = new StackDoubleLinkedListImpl<>(2);
		stack3 = new StackDoubleLinkedListImpl<>(3); // pilha vazia
		stack4 = new StackDoubleLinkedListImpl<>(2); // pilha vazia
		stack5 = new StackDoubleLinkedListImpl<>(1); // pilha vazia
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTop() {
		assertEquals(new Integer(3), stack1.top());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(stack1.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(stack1.isFull()); // vai depender do tamanho que a pilha foi
										// iniciada!!!!
	}

	@Test
	public void testPush() {
		try {
			stack1.push(new Integer(5));
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stack2.push(new Integer(5)); // levanta excecao apenas se o tamanhonao
										// permitir outra insercao
	}

	@Test
	public void testPop() {
		try {
			assertEquals(new Integer(3), stack1.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		assertEquals(new Integer(3), stack3.pop()); // levanta excecao apenas se
													// stack1 for vazia
	}

	// MEUS TESTES

	@Test
	public void testPilhaVazia () throws StackOverflowException {
		assertTrue(stack4.isEmpty());
		stack4.push(1);
		assertFalse(stack4.isEmpty());
	}

	@Test
	public void testPilhaCheia () throws StackOverflowException{
		assertFalse(stack5.isFull());
		stack5.push(1);
		assertTrue(stack5.isFull());
	}

	@Test
	public void testPilhaTop () throws StackOverflowException, StackUnderflowException {
		assertNull(stack3.top());
		stack3.push(1);
		assertEquals(Integer.valueOf(1), stack3.top());
		stack3.push(4);
		assertEquals(Integer.valueOf(4), stack3.top());
		stack3.push(9);
		assertEquals(Integer.valueOf(9), stack3.top());

		stack3.pop();
		assertEquals(Integer.valueOf(4), stack3.top());
		stack3.pop();
		assertEquals(Integer.valueOf(1), stack3.top());
		stack3.pop();
		assertNull(stack3.top());;
	}

	@Test(expected = StackUnderflowException.class)
	public void testPilhaPopErro () throws StackUnderflowException {
		stack4.pop();
	}

	@Test(expected = StackOverflowException.class)
	public void testPilhaPushErro () throws StackOverflowException {
		stack5.push(2);
		stack5.push(4);
	}

	@Test
	public void testPilhaPush () throws StackOverflowException {
		assertTrue(stack3.isEmpty());
		assertFalse(stack3.isFull());

		stack3.push(1);

		assertFalse(stack3.isEmpty());
		assertFalse(stack3.isFull());
		assertEquals(Integer.valueOf(1), stack3.top());

		stack3.push(2);
		stack3.push(3);

		assertFalse(stack3.isEmpty());
		assertTrue(stack3.isFull());
		assertEquals(Integer.valueOf(3), stack3.top());
	}

	@Test(expected = StackOverflowException.class)
	public void testPilhaCheiaPushError () throws StackOverflowException {
		stack5.push(1);
		stack5.push(2);
	}

	@Test
	public void testPilhaPop () throws StackOverflowException, StackUnderflowException {
		assertTrue(stack3.isEmpty());
		assertFalse(stack3.isFull());

		stack3.push(1);
		stack3.push(2);
		stack3.push(3);

		assertFalse(stack3.isEmpty());
		assertTrue(stack3.isFull());

		assertEquals(Integer.valueOf(3), stack3.pop());

		assertFalse(stack3.isEmpty());
		assertFalse(stack3.isFull());
		assertEquals(Integer.valueOf(2), stack3.top());

		assertEquals(Integer.valueOf(2), stack3.pop());
		assertEquals(Integer.valueOf(1), stack3.pop());
		assertNull(stack3.top());

		assertTrue(stack3.isEmpty());
		assertFalse(stack3.isFull());
	}

	@Test(expected = StackUnderflowException.class)
	public void testPilhaVaziaPopError () throws StackUnderflowException {
		stack3.pop();
	}


}