package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() { }

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if (this.isEmpty())
			return 0;

		return 1 + this.next.size();
	}

	@Override
	public T search(T element) {
		if (element != null) {
			if (this.isEmpty() || this.data.equals(element)){
				return this.data;
			} else
				return this.next.search(element);
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.data = element;
				this.next = new RecursiveSingleLinkedListImpl<>();
			} else
				this.next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			if (this.data.equals(element)) {
				this.data = this.next.getData();
				this.next = this.next.getNext();
			} else
				this.next.remove(element);
		}
	}

	@Override
	public T[] toArray() {
		List<T> array = new ArrayList<>();
		return this.toArray(array);
	}

	private T[] toArray(List<T> array) {
		if (!this.isEmpty()){
			array.add(this.data);
			this.next.toArray(array);
		}
		return (T[]) array.toArray();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
