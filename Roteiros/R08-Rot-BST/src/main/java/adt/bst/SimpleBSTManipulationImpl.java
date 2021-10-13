package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals (BST<T> tree1, BST<T> tree2) {
		return this.equalsRecursive(tree1.getRoot(), tree2.getRoot());
	}

	private boolean equalsRecursive (BTNode<T> currentNodeTree1, BTNode<T> currentNodeTree2) {
		if (currentNodeTree1.equals(currentNodeTree2)) {
			if (!currentNodeTree1.isEmpty() && !currentNodeTree2.isEmpty()) {
				return
						this.equalsRecursive(currentNodeTree1.getLeft(), currentNodeTree2.getLeft())
								&& this.equalsRecursive(currentNodeTree1.getRight(), currentNodeTree2.getRight());
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean isSimilar (BST<T> tree1, BST<T> tree2) {
		return this.isSimilarRecursive(tree1.getRoot(), tree2.getRoot());
	}

	private boolean isSimilarRecursive (BTNode<T> currentNodeTree1, BTNode<T> currentNodeTree2) {
		if (!currentNodeTree1.isEmpty() && !currentNodeTree2.isEmpty()) {
			return
					this.isSimilarRecursive(currentNodeTree1.getLeft(), currentNodeTree2.getLeft())
							&& this.isSimilarRecursive(currentNodeTree1.getRight(), currentNodeTree2.getRight());
		} else
			return
					(!currentNodeTree1.isEmpty() || currentNodeTree2.isEmpty())
							&& (currentNodeTree1.isEmpty() || !currentNodeTree2.isEmpty());
	}

	@Override
	public T orderStatistic (BST<T> tree, int k) {
		int treeSize = tree.size();

		if (k >= 1 && k <= treeSize) {
			BTNode<T> treeMinimum = tree.minimum();

			if (k == 1)
				return treeMinimum.getData();
			else if (k == treeSize)
				return tree.maximum().getData();
			else
				return this.orderStatisticRecursive(tree, treeMinimum, k);
		}

		return null;
	}

	private T orderStatisticRecursive (BST<T> tree, BTNode<T> currentNode, int k) {
		return k == 1
				? currentNode.getData()
				: this.orderStatisticRecursive(tree, tree.sucessor(currentNode.getData()), --k);
	}

}
