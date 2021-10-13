package adt.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return this.heightRecursive(this.root);
	}

	public int heightRecursive (BSTNode<T> currentNode) {
		int resp = -1;

		if (!currentNode.isEmpty())
			resp = 1 + Math.max(
					this.heightRecursive((BSTNode<T>) currentNode.getLeft()),
					this.heightRecursive((BSTNode<T>) currentNode.getRight())
			);

		return resp;
	}

	@Override
	public BSTNode<T> search(T element) {
		return element == null
				? new BSTNode<>()
				: this.searchRecursive(this.root, element);
	}

	private BSTNode<T> searchRecursive (BSTNode<T> currentNode, T element) {
		BSTNode<T> resp;

		if (currentNode.isEmpty() || currentNode.getData().equals(element))
			resp = currentNode;
		else if (element.compareTo(currentNode.getData()) > 0)
			resp = this.searchRecursive((BSTNode<T>) currentNode.getRight(), element);
		else
			resp = this.searchRecursive((BSTNode<T>) currentNode.getLeft(), element);

		return resp;
	}

	@Override
	public void insert(T element) {
		if (element != null)
			this.insertRecursive(this.root, element);
	}

	private void insertRecursive (BSTNode<T> currentNode, T element) {
		if (currentNode.isEmpty()) {
			currentNode.setData(element);
			currentNode.setRight(new BSTNode.Builder<T>().parent(currentNode).build());
			currentNode.setLeft(new BSTNode.Builder<T>().parent(currentNode).build());
		} else
			if (element.compareTo(currentNode.getData()) > 0)
				this.insertRecursive((BSTNode<T>) currentNode.getRight(), element);
			else
				this.insertRecursive((BSTNode<T>) currentNode.getLeft(), element);
	}

	@Override
	public BSTNode<T> maximum() {
		return this.isEmpty()
				? null
				: this.maximumRecursive(this.root);
	}

	private BSTNode<T> maximumRecursive (BSTNode<T> currentNode) {
		return currentNode.getRight().isEmpty()
				? currentNode
				: this.maximumRecursive((BSTNode<T>) currentNode.getRight());
	}

	@Override
	public BSTNode<T> minimum() {
		return this.isEmpty()
				? null
				: this.minimumRecursive(this.root);
	}

	private BSTNode<T> minimumRecursive (BSTNode<T> currentNode) {
		return currentNode.getLeft().isEmpty()
				? currentNode
				: this.minimumRecursive((BSTNode<T>) currentNode.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = this.search(element);

		if (!node.isEmpty())
			if (!node.getRight().isEmpty())
				node = this.minimumRecursive((BSTNode<T>) node.getRight());
			else
				node = this.sucessorRecursive(node, element);

		return (node == null || node.isEmpty()) ? null : node;
	}

	private BSTNode<T> sucessorRecursive (BSTNode<T> currentNode, T element) {
		return currentNode != null && currentNode.getData().compareTo(element) <= 0
				? this.sucessorRecursive((BSTNode<T>) currentNode.getParent(), element)
				: currentNode;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = this.search(element);

		if (!node.isEmpty())
			if (!node.getLeft().isEmpty())
				node = this.maximumRecursive((BSTNode<T>) node.getLeft());
			else
				node = this.predecessorRecursive(node, element);

		return (node == null || node.isEmpty()) ? null : node;
	}

	private BSTNode<T> predecessorRecursive (BSTNode<T> currentNode, T element) {
		return currentNode != null && currentNode.getData().compareTo(element) >= 0
				? this.predecessorRecursive((BSTNode<T>) currentNode.getParent(), element)
				: currentNode;
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> node = this.search(element);

			if (!node.isEmpty()) {
				if (node.isLeaf()) { // Caso 1: nó a ser removido é folha
					node.setData(null);
					node.setLeft(null);
					node.setRight(null);
				} else if (node.getRight().isEmpty() || node.getLeft().isEmpty()) { // Caso 2: nó a ser removido tem um filho
					BSTNode<T> childNode = node.getRight().isEmpty() ? (BSTNode<T>) node.getLeft() : (BSTNode<T>) node.getRight();
					if (this.root.equals(node)) {
						this.root = childNode;
						this.root.setParent(null);
					}
					else {
						childNode.setParent(node.getParent());
						if (node.getParent().getLeft().equals(node))
							node.getParent().setLeft(childNode);
						else
							node.getParent().setRight(childNode);
					}
				} else { // Caso 3: nó a ser removido tem dois filhos
					T sucessor = this.sucessor(node.getData()).getData();
					this.remove(sucessor);
					node.setData(sucessor);
				}
			}
		}
	}

	@Override
	public T[] preOrder() {
		return this.preOrderRecursive(this.root, new ArrayList<>());
	}

	private T[] preOrderRecursive (BSTNode<T> currentNode, List<T> list) {
		if (!currentNode.isEmpty()) {
			list.add(currentNode.getData());
			this.preOrderRecursive((BSTNode<T>) currentNode.getLeft(), list);
			this.preOrderRecursive((BSTNode<T>) currentNode.getRight(), list);
		}

		return (T[]) list.toArray(new Comparable[0]);
	}

	@Override
	public T[] order() {
		return this.orderRecursive(this.root, new ArrayList<>());
	}

	private T[] orderRecursive (BSTNode<T> currentNode, List<T> list) {
		if (!currentNode.isEmpty()) {
			this.orderRecursive((BSTNode<T>) currentNode.getLeft(), list);
			list.add(currentNode.getData());
			this.orderRecursive((BSTNode<T>) currentNode.getRight(), list);
		}

		return (T[]) list.toArray(new Comparable[0]);
	}

	@Override
	public T[] postOrder() {
		return this.postOrderRecursive(this.root, new ArrayList<>());
	}

	private T[] postOrderRecursive (BSTNode<T> currentNode, List<T> list) {
		if (!currentNode.isEmpty()) {
			this.postOrderRecursive((BSTNode<T>) currentNode.getLeft(), list);
			this.postOrderRecursive((BSTNode<T>) currentNode.getRight(), list);
			list.add(currentNode.getData());
		}

		return (T[]) list.toArray(new Comparable[0]);
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
