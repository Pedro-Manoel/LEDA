package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.last = new DoubleLinkedListNode<>();
		this.head = this.last;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T>
					newNode = new DoubleLinkedListNode<>(),
					nil = new DoubleLinkedListNode<>();

			newNode.setData(element);
			newNode.setNext(nil);
			nil.setPrevious(newNode);
			this.last.setNext(newNode);
			newNode.setPrevious(this.last);

			if (this.last.isNIL())
				this.head = newNode;

			this.last = newNode;
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T>
					newNode = new DoubleLinkedListNode<>(),
					nil = new DoubleLinkedListNode<>();

			newNode.setData(element);
			newNode.setNext(this.head);
			newNode.setPrevious(nil);
			nil.setNext(newNode);
			((DoubleLinkedListNode<T>) this.head).setPrevious(newNode);

			if (this.head.isNIL())
				this.last = newNode;

			this.head = newNode;
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			if (this.head.getData().equals(element))
				this.removeFirst();
			else if (this.last.getData().equals(element))
				this.removeLast();
			else {
				DoubleLinkedListNode<T> currentNode = (DoubleLinkedListNode<T>) this.head;

				while (!currentNode.isNIL() && !currentNode.getData().equals(element))
					currentNode = (DoubleLinkedListNode<T>) currentNode.getNext();

				if (!currentNode.isNIL()){
					currentNode.getPrevious().setNext(currentNode.getNext());
					((DoubleLinkedListNode<T>) currentNode.getNext()).setPrevious(currentNode.getPrevious());
				}
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()){
			this.head = this.head.getNext();

			if (this.head.isNIL())
				this.last = ((DoubleLinkedListNode<T>) this.head);
			else {
				DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<>();

				((DoubleLinkedListNode<T>) this.head).setPrevious(nil);
				nil.setNext(this.head);
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()){
			this.last = this.last.getPrevious();

			if (this.last.isNIL())
				this.head = this.last;
			else {
				DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<>();

				this.last.setNext(nil);
				nil.setPrevious(this.last);
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
