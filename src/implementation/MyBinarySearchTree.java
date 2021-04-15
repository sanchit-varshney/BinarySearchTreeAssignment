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
        boolean response = false;
        if(root!= null){
            Node<E> temp = root;
            while (temp != null && !response) {
                if (searchElement == temp.getData()) {
                    response = true;
                } else if (searchElement.compareTo(temp.getData()) < 0) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
        }
        return response;
    }

    @Override
    public int height(Node<E> node) {
        return 0;
    }

    @Override
    public void reverseInOrder(Node<E> node) {
        if(node!= null){
            reverseInOrder(node.getRight());
            System.out.println(node.getData()+" ");
            reverseInOrder(node.getLeft());
        }

    }

    @Override
    public void postOrder(Node<E> node) {
        if (node!= null){
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println(node.getData()+" ");
        }

    }

    @Override
    public void preOrder(Node<E> node) {
        if(node!= null){
            System.out.println(node.getData()+" ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }

    }

    @Override
    public void inOrder(Node<E> node) {
        if(node!= null){
            inOrder(node.getLeft());
            System.out.println(node.getData()+" ");
            inOrder(node.getRight());
        }

    }
    @Override
    public void delete(E data) {
        Node<E> temp = root;
        Node<E> parent = null;
        while (temp != null) {
            if (data.compareTo(temp.getData()) == 0) {
                break;
            } else {
                parent = temp;
                if (data.compareTo(temp.getData()) < 0) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
        }
        if(temp != null){
            //case 1

            if(isLeaf(temp)){
                //root node
                if(parent == null){
                    root = null;
                }
                else{
                    if(data.compareTo(parent.getData()) < 0){
                        parent.setLeft(null);
                    }
                    else{
                        parent.setRight(null);
                    }
                }
            }
            //case 2
            //left child
            else if(hasLeftChild(temp)){
                //root node
                if(parent == null){
                    root = root.getLeft();
                }
                else{
                    if(data.compareTo(parent.getData()) < 0){
                        parent.setLeft(temp.getLeft());
                    }
                    else{
                        parent.setRight(temp.getLeft());
                    }
                }
            }
            //right child
            else if(hasRightChild(temp)){
                //root case
                if(parent == null){
                    root = root.getRight();
                }
                else {
                    if(data.compareTo(parent.getData()) < 0){
                        parent.setLeft(temp.getRight());
                    }
                    else{
                        parent.setRight(temp.getRight());
                    }
                }
            }
            //case 3 two children
            else{
                Node<E> successor = getSuccessor(temp);
                //delete successor
                delete(successor.getData());
                successor.setLeft(temp.getLeft());
                successor.setRight(temp.getRight());
                //root case
                if(parent == null){
                    root = successor;
                }
                else{
                    if(data.compareTo(parent.getData()) < 0){
                        parent.setLeft(successor);
                    }
                    else{
                        parent.setRight(successor);
                    }
                }
            }


            //root node
        }
        else{
            System.out.println("cannot delete");
        }


    }

    private boolean isLeaf(Node<E> temp) {
        if(temp.getLeft()==null && temp.getRight()==null){
            return true;
        }
        return false;
    }

    private Node<E> getSuccessor(Node<E> node) {
        Node<E> temp = node.getRight();
        while (temp.getLeft() != null ){
            temp = temp.getLeft();

        }
        return temp;

    }

    private boolean hasRightChild(Node<E> temp) {
        if(temp.getRight() != null && temp.getRight() == null){
            return true;
        }
        return false;

    }

    private boolean hasLeftChild(Node<E> temp) {
        if(temp.getLeft()!= null && temp.getRight() == null){
            return true;
        }
        return false;
        
    }
}
