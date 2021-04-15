package implementation;

import myinterface.BinarySearchTreeADT;

public class MyBinarySearchTree<E extends Comparable<E>> implements BinarySearchTreeADT<E> {
    Node<E> root = null;

    public Node<E> getRoot() {
        return root;
    }

    @Override
    public void insert(E data) {
        Node<E> node = new Node<>(data);
        if(root == null){
            root = node;
        }
        else {
            Node<E> temp = root;
            Node<E> parent = null;
            while (temp != null){
                parent = temp;
                if(data.compareTo(temp.getData())> 0){
                    temp = temp.getRight();
                }
                else {
                    temp = temp.getLeft();
                }
            }
            if(data.compareTo(parent.getData())<=0){
                parent.setLeft(node);
            }
            else {
                parent.setRight(node);
            }
        }

    }

    @Override
    public boolean search(E searchElement) {
        return false;
    }

    @Override
    public void delete(E data) {

    }

    @Override
    public int height(Node<E> node) {
        return 0;
    }

    @Override
    public void reverseInOrder(Node<E> node) {

    }

    @Override
    public void postOrder(Node<E> node) {

    }

    @Override
    public void preOrder(Node<E> node) {

    }

    @Override
    public void inOrder(Node<E> node) {

    }
}
