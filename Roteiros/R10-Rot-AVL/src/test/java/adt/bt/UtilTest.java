package adt.bt;

import adt.bst.BST;
import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UtilTest {

    private BST<Integer> bst;

    public void defineBST (Integer[] array) {
        bst = new BSTImpl<>();
        for (Integer value : array)
            bst.insert(value);
    }

    public Integer[] preOrder (BSTNode<Integer> node) {
        return this.preOrderRecursive(node, new ArrayList<>());
    }

    public Integer[] preOrderRecursive (BSTNode<Integer> node, List<Integer> list) {
        if (!node.isEmpty()) {
            list.add(node.getData());
            this.preOrderRecursive((BSTNode<Integer>) node.getLeft(), list);
            this.preOrderRecursive((BSTNode<Integer>) node.getRight(), list);
        }

        return list.toArray(new Integer[0]);
    }

    @Test
    public void testLeftRotation01() {
        defineBST(new Integer[]{10,15,18});
        BSTNode<Integer> newRoot = Util.leftRotation((BSTNode<Integer>) bst.getRoot());
        assertArrayEquals(preOrder(newRoot), new Integer[]{15,10,18});
    }

    @Test
    public void testLeftRotation02() {
        defineBST(new Integer[]{10,15,18,12});
        BSTNode<Integer> newRoot = Util.leftRotation((BSTNode<Integer>) bst.getRoot());
        assertArrayEquals(preOrder(newRoot), new Integer[]{15,10,12,18});
    }

    @Test
    public void testRightRotation01() {
        defineBST(new Integer[]{18,15,10});
        BSTNode<Integer> newRoot = Util.rightRotation((BSTNode<Integer>) bst.getRoot());
        assertArrayEquals(preOrder(newRoot), new Integer[]{15,10,18});
    }

    @Test
    public void testRightRotation02() {
        defineBST(new Integer[]{18,15,10,17});
        BSTNode<Integer> newRoot = Util.rightRotation((BSTNode<Integer>) bst.getRoot());
        assertArrayEquals(preOrder(newRoot), new Integer[]{15,10,18,17});
    }

    @Test
    public void testDoubleLeftRotation01() {
        defineBST(new Integer[]{10,15,12});
        BSTNode<Integer> newRoot = Util.doubleLeftRotation((BSTNode<Integer>) bst.getRoot());
        assertArrayEquals(preOrder(newRoot), new Integer[]{12,10,15});
    }

    @Test
    public void testDoubleRightRotation01() {
        defineBST(new Integer[]{15,10,12});
        BSTNode<Integer> newRoot = Util.doubleRightRotation((BSTNode<Integer>) bst.getRoot());
        assertArrayEquals(preOrder(newRoot), new Integer[]{12,10,15});
    }

    @Test
    public void testGeral() {
        defineBST(new Integer[]{8,4,2,6,12});
        BSTNode<Integer> newRoot = Util.rightRotation((BSTNode<Integer>) bst.getRoot());
        assertArrayEquals(preOrder(newRoot), new Integer[]{4,2,8,6,12});
    }

}