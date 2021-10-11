package BST;

public class Node<T> {
    Node<T> left;
    Node<T> right;
    Node<T> parent;
    T value;

    public Node(T value) {
        this.value = value;
    }
}
