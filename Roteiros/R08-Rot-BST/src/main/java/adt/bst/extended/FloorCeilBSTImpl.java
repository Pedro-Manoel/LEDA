package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bt.BTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor (Integer[] array, double numero) {
		for (Integer value : array)
			this.insert(value);

		return this.floorRecursive(this.root, numero, null);
	}

	private Integer floorRecursive (BTNode<Integer> currentNode, double number, Integer floor) {
		if (!currentNode.isEmpty()) {
			if (number > currentNode.getData())
				floor = this.floorRecursive(currentNode.getRight(), number, currentNode.getData());
			else if (number < currentNode.getData())
				floor = this.floorRecursive(currentNode.getLeft(), number, floor);
			else
				floor = currentNode.getData();
		}

		return floor;
	}

	@Override
	public Integer ceil (Integer[] array, double numero) {
		for (Integer value : array)
			this.insert(value);

		return this.ceilRecursive(this.root, numero, null);
	}

	private Integer ceilRecursive (BTNode<Integer> currentNode, double number, Integer ceil) {
		if (!currentNode.isEmpty()) {
			if (number > currentNode.getData())
				ceil = this.ceilRecursive(currentNode.getRight(), number, ceil);
			else if (number < currentNode.getData())
				ceil = this.ceilRecursive(currentNode.getLeft(), number, currentNode.getData());
			else
				ceil = currentNode.getData();
		}

		return ceil;
	}

}
