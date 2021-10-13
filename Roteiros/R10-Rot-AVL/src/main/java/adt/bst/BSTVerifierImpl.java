package adt.bst;

import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
        return this.bst.isEmpty() || this.isBSTRecursive(this.bst.getRoot());
	}

	private boolean isBSTRecursive (BTNode<T> currentNode) {
        boolean resp = true;

	    if (!currentNode.isEmpty())
            if (this.isValidLeft(currentNode) && this.isValidRight(currentNode))
                resp =
                        this.isBSTRecursive(currentNode.getLeft())
                                &&
                                this.isBSTRecursive(currentNode.getRight());
            else
                resp = false;

        return resp;
    }

    private boolean isValidLeft (BTNode<T> node) {
        return this.isValidLeft(node.getLeft(), node);
    }

    private boolean isValidLeft (BTNode<T> currentNode, BTNode<T> root) {
        boolean resp = true;

        if (!currentNode.isEmpty())
            if (currentNode.getData().compareTo(root.getData()) < 0)
                resp =
                        this.isValidLeft(currentNode.getLeft(), root)
                                &&
                                this.isValidLeft(currentNode.getRight(), root);
            else
                resp = false;

        return resp;
	}

    private boolean isValidRight (BTNode<T> node) {
        return this.isValidRight(node.getRight(), node);
    }

    private boolean isValidRight (BTNode<T> currentNode, BTNode<T> root) {
        boolean resp = true;

        if (!currentNode.isEmpty())
            if (currentNode.getData().compareTo(root.getData()) > 0)
                resp =
                        this.isValidRight(currentNode.getLeft(), root)
                                &&
                                this.isValidRight(currentNode.getRight(), root);
            else
                resp = false;

        return resp;
    }

}
