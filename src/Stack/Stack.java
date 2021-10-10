package Stack;

import LinkedList.Node;

public class Stack<T> {

    Node<T> head;

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = this.head;
        this.head = newNode;
    }

    public T pop() {
        Node<T> popped = this.head;
        this.head = this.head.next;
        return popped.value;
    }

    public void print() {
        Node<T> start = this.head;

        while(start != null) {
            System.out.println(start.value);
            start = start.next;
        }
    }
}
