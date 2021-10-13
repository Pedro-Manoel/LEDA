package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> currentNode = this.head;

		while (!currentNode.isNIL()) {
			currentNode = currentNode.getNext();
			size++;
		}

		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> currentNode = this.head;

		while (!currentNode.isNIL() && !currentNode.getData().equals(element))
			currentNode = currentNode.getNext();

		return currentNode.getData();
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> currentNode = this.head;

			while (!currentNode.isNIL())
				currentNode = currentNode.getNext();

			currentNode.setData(element);
			currentNode.setNext(new SingleLinkedListNode<>());
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			SingleLinkedListNode<T> currentNode = this.head;

			while (!currentNode.isNIL() && !currentNode.getData().equals(element))
				currentNode = currentNode.getNext();

			if (!currentNode.isNIL()){
				currentNode.setData(currentNode.getNext().getData());
				currentNode.setNext(currentNode.getNext().getNext());
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> currentNode = this.head;

		for (int i = 0; i < array.length; i++) {
			array[i] = currentNode.getData();
			currentNode = currentNode.getNext();
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
