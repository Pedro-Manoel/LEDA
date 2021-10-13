package adt.bst;

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTVerifierImplTest {

    private BST<Integer> bst;
    private BSTVerifier<Integer> bstVerifier;

    private void defineBST (Integer[] array) {
        bst = new BSTImpl<>();

        for (Integer value : array)
            bst.insert(value);

        this.bstVerifier = new BSTVerifierImpl<>(bst);
    }

    @Test
    public void testBstVazia () {
        defineBST(new Integer[]{});
        //assertFalse(bstVerifier.isBST());
        assertTrue(bstVerifier.isBST());
    }

    @Test
    public void testBstComUmNo () { // bst com apenas o nó root - válido
        defineBST(new Integer[]{1});
        assertTrue(bstVerifier.isBST());
    }

    @Test
    public void testBstComUmNoNaEsquerdaMenorQueRoot () { // bst com apenas um nó na esquerda menor que o root - válido
        defineBST(new Integer[]{5,4});
        assertTrue(bstVerifier.isBST());
    }

    @Test
    public void testBstComUmNoNaDireitaMaiorQueRoot () { // bst com apenas um nó na direita maior que o root - válido
        defineBST(new Integer[]{5,6});
        assertTrue(bstVerifier.isBST());
    }

    @Test
    public void testBstComUmNoNaDireitaMaiorQueRootUmNoNaEsquerdaMenorQueRoot () { // bst com um nó na esquerda e na direita, com o nó na esquerda menor e na direita maior que o root - válido
        defineBST(new Integer[]{4,5,6});
        assertTrue(bstVerifier.isBST());
    }

    @Test
    public void testBstComUmNoNaEsquerdaMaiorQueRoot () { // bst com apenas um nó na esquerda maior que o root - inválido
        defineBST(new Integer[]{5,4});
        bst.search(4).setData(6);
        assertFalse(bstVerifier.isBST());
    }

    @Test
    public void testBstComUmNoNaDireitaMenorQueRoot () { // bst com apenas um nó na direita menor que o root - inválido
        defineBST(new Integer[]{5,6});
        bst.search(6).setData(4);
        assertFalse(bstVerifier.isBST());
    }

    @Test
    public void testBstComUmNoNaDireitaMenorQueRootUmNoNaEsquerdaMenorQueRoot () { // bst com um nó na esquerda e na direita com o nó na esquerda menor e na direita menor que o root - inválido
        defineBST(new Integer[]{4,5,6});
        bst.search(6).setData(3);
        assertFalse(bstVerifier.isBST());
    }

    @Test
    public void testBstComUmNoNaDireitaMaiorQueRootUmNoNaEsquerdaMaiorQueRoot () { // bst com um nó na esquerda e na direita com o nó na esquerda maior e na direita maior que root - inválido
        defineBST(new Integer[]{4,5,6});
        bst.search(4).setData(7);
        assertFalse(bstVerifier.isBST());
    }

    @Test
    public void testBstComUmNoNaDireitaMenorQueRootUmNoNaEsquerdaMaiorQueRoot () { // bst com um nó na esquerda e na direita com o nó na esquerda maior e na direita menor que root - inválido
        defineBST(new Integer[]{4,5,6});
        bst.search(6).setData(3);
        bst.search(4).setData(7);
        assertFalse(bstVerifier.isBST());
    }

    @Test
    public void testGeral01 () {
        defineBST(new Integer[]{63,7,69,2,59,65,90,52,60,83});
        BSTNode<Integer> node;
        assertTrue(bstVerifier.isBST());

        node = (BSTNode<Integer>)  bst.search(69);
        node.setData(62);
        assertFalse(bstVerifier.isBST());
        node.setData(69);
        assertTrue(bstVerifier.isBST());

        node = (BSTNode<Integer>)  bst.search(2);
        node.setData(8);
        assertFalse(bstVerifier.isBST());
        node.setData(2);
        assertTrue(bstVerifier.isBST());

        node = (BSTNode<Integer>)  bst.search(90);
        node.setData(82);
        assertFalse(bstVerifier.isBST());
        node.setData(90);
        assertTrue(bstVerifier.isBST());

        node = (BSTNode<Integer>)  bst.search(60);
        node.setData(58);
        assertFalse(bstVerifier.isBST());
        node.setData(60);
        assertTrue(bstVerifier.isBST());
    }

    @Test
    public void testGeral02 () {
        defineBST(new Integer[]{1,2,3,4,5,6,7,8,9});
        assertTrue(bstVerifier.isBST());
    }

    @Test
    public void testGeral03 () {
        defineBST(new Integer[]{4,2,5,0,3,6});
        bst.search(3).setData(30);
        assertFalse(bstVerifier.isBST());
    }
}

