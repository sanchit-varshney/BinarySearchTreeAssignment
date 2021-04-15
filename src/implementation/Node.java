package implementation;

public class Node<E extends Comparable<E>> implements myinterface.Node<E> {
    private E data;
    private Node<E> left;
    private Node<E> right;

    public Node(E data) {
        this.data = data;
        left = null;
        right = null;
    }

    //complete node class
}
