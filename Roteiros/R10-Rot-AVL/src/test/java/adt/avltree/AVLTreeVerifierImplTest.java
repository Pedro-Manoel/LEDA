package adt.avltree;

import adt.bst.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Não realiza balanceamento nem rotação
 */
class AVLTest <T extends Comparable<T>> extends AVLTreeImpl<T> {
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
}

public class AVLTreeVerifierImplTest {

    private AVLTree<Integer> avl, avlTest;
    private AVLTreeVerifier<Integer> avlVerifier, avlTestVerifier;

    private void defineAVLS (Integer[] array) {
        avl = new AVLTreeImpl<>();
        avlTest = new AVLTest<>();

        for (Integer value : array) {
            avl.insert(value);
            avlTest.insert(value);
        }

        this.avlVerifier = new AVLTreeVerifierImpl<>(avl);
        this.avlTestVerifier = new AVLTreeVerifierImpl<>(avlTest);
    }

    @Test
    public void testIsAVL01() {
        defineAVLS(new Integer[]{10,15,18,12});
        assertTrue(avlVerifier.isAVLTree());
        assertFalse(avlTestVerifier.isAVLTree());
    }

    @Test
    public void testIsAVL02() {
        defineAVLS(new Integer[]{18,15,10});
        assertTrue(avlVerifier.isAVLTree());
        assertFalse(avlTestVerifier.isAVLTree());
    }

    @Test
    public void testIsAVL03() {
        defineAVLS(new Integer[]{18,15,10,17});
        assertTrue(avlVerifier.isAVLTree());
        assertFalse(avlTestVerifier.isAVLTree());
    }

    @Test
    public void testIsAVL04() {
        defineAVLS(new Integer[]{10,15,12});
        assertTrue(avlVerifier.isAVLTree());
        assertFalse(avlTestVerifier.isAVLTree());
    }

    @Test
    public void testIsAVL05() {
        defineAVLS(new Integer[]{15,10,12});
        assertTrue(avlVerifier.isAVLTree());
        assertFalse(avlTestVerifier.isAVLTree());
    }

    @Test
    public void testIsBstIsAvl() {
        defineAVLS(new Integer[]{10,15,9});
        assertTrue(avlVerifier.isAVLTree());
        assertTrue(avlTestVerifier.isAVLTree());
    }

    @Test
    public void testNotIsBstIsAvl() {
        defineAVLS(new Integer[]{10,15,12});
        avl.search(10).setData(18);
        avlTest.search(10).setData(18);
        assertFalse(avlVerifier.isAVLTree());
        assertFalse(avlTestVerifier.isAVLTree());
    }

    @Test
    public void testIsBstNotIsAvl() {
        defineAVLS(new Integer[]{10,15,18});
        assertTrue(avlVerifier.isAVLTree());
        assertFalse(avlTestVerifier.isAVLTree());
    }

}