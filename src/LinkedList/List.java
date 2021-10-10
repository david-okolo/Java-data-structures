package LinkedList;

import java.util.function.BiFunction;

public class List<T> {

    Node<T> head;
    BiFunction<T, T, Integer> compareFn;

    public List(T[] values, BiFunction<T, T, Integer> compareFn) {
        this.compareFn = compareFn;
        this.head = initializeList(values, 0);
    }

    public Node<T> initializeList(T[] values, int currentIndex) {

        Node<T> currentNode = new Node<>(values[currentIndex]);

        if(currentIndex < values.length - 1) {
            currentNode.next = initializeList(values, currentIndex + 1);
        }

        return currentNode;
    }

    public void add(T value) {
        Node<T> predecessor = null;
        Node<T> current = this.head;

        while(current != null && this.compareFn.apply(current.value, value) < 0 ) {
            predecessor = current;
            current = current.next;
        }

        if(predecessor == null) {
            // Head value is greater than input
            Node<T> newItem = new Node<>(value);
            newItem.next = this.head;
            this.head = newItem;
            return;
        }

        Node<T> newItem = new Node<>(value);
        newItem.next = current;
        predecessor.next = newItem;

    }

    public void remove(T value) {
        Node<T> predecessor = null;
        Node<T> current = this.head;

        while(current != null && this.compareFn.apply(current.value, value) != 0) {
            predecessor = current;
            current = current.next;
        }

        if(current == null) {
            // Got to the end of the list without finding the value
            return;
        }

        if(predecessor == null) {
            // we found the value at the head
            this.head = current.next;
        } else {
            predecessor.next = current.next;
        }
    }

    public void printList() {

        Node<T> start = this.head;

        while(start != null) {
            System.out.println(start.value);
            start = start.next;
        }
    }
}
