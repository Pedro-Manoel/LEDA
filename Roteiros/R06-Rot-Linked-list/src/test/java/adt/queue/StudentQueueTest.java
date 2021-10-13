package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;
	public Queue<Integer> queue4;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new QueueDoubleLinkedListImpl<>(4);
		queue2 = new QueueDoubleLinkedListImpl<>(2);
		queue3 = new QueueDoubleLinkedListImpl<>(3); // vazia
		queue4 = new QueueDoubleLinkedListImpl<>(1); // vazia
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue3.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}

	// Meus testes

	@Test
	public void testFilaEnqueue () throws QueueOverflowException {
		assertTrue(queue3.isEmpty());
		assertFalse(queue3.isFull());

		queue3.enqueue(1);

		assertFalse(queue3.isEmpty());
		assertFalse(queue3.isFull());
		assertEquals(Integer.valueOf(1), queue3.head());

		queue3.enqueue(2);
		queue3.enqueue(3);

		assertFalse(queue3.isEmpty());
		assertTrue(queue3.isFull());
		assertEquals(Integer.valueOf(1), queue3.head());
	}

	@Test(expected = QueueOverflowException.class)
	public void testFilaCheiaEnqueueError () throws QueueOverflowException {
		queue4.enqueue(1);
		queue4.enqueue(2);
	}

	@Test
	public void testFilaDequeue () throws QueueOverflowException, QueueUnderflowException {
		assertTrue(queue3.isEmpty());
		assertFalse(queue3.isFull());

		queue3.enqueue(1);
		queue3.enqueue(2);
		queue3.enqueue(3);

		assertFalse(queue3.isEmpty());
		assertTrue(queue3.isFull());

		assertEquals(Integer.valueOf(1), queue3.dequeue());

		assertFalse(queue3.isEmpty());
		assertFalse(queue3.isFull());
		assertEquals(Integer.valueOf(2), queue3.head());

		assertEquals(Integer.valueOf(2), queue3.dequeue());
		assertEquals(Integer.valueOf(3), queue3.dequeue());
		assertNull(queue3.head());

		assertTrue(queue3.isEmpty());
		assertFalse(queue3.isFull());
	}

	@Test(expected = QueueUnderflowException.class)
	public void testFilaVaziaDequeueError () throws QueueUnderflowException {
		queue3.dequeue();
	}
}