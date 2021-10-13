package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack (int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue (T element) throws QueueOverflowException {
		try {
			if (!this.stack2.isEmpty())
				this.transferInverted(this.stack2, this.stack1);

			this.stack1.push(element);
		} catch (StackOverflowException e) {
			throw new QueueOverflowException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public T dequeue () throws QueueUnderflowException {
		try {
			if (!this.stack1.isEmpty())
				this.transferInverted(this.stack1, this.stack2);

			return this.stack2.pop();
		} catch (StackUnderflowException e) {
			throw new QueueUnderflowException();
		} catch (Exception e) {
			e.printStackTrace();
            return null;
		}
	}

	@Override
	public T head () {
		try {
			if (!this.stack1.isEmpty())
				this.transferInverted(this.stack1, this.stack2);

			return this.stack2.top();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean isEmpty () {
		return this.stack1.isEmpty() && this.stack2.isEmpty();
	}

	@Override
	public boolean isFull () {
		return this.stack1.isFull() || this.stack2.isFull();
	}

	private void transferInverted (Stack<T> inputStack, Stack<T> outputStack) throws StackUnderflowException, StackOverflowException {
		while (!inputStack.isEmpty())
			outputStack.push(inputStack.pop());
	}

}
