package BST;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> compare = (a, b) -> a - b;
        BST<Integer> bst = new BST<>(compare);
        bst.add(3);
        bst.add(4);
        bst.add(32);
        bst.add(2);
        bst.add(3);
        bst.add(1);
        System.out.println("----In----");
        bst.traverseInOrder();
        System.out.println("----In (desc)----");
        bst.traverseInOrderDesc();
        System.out.println("----Post----");
        bst.traversePostOrder();
        System.out.println("----Pre----");
        bst.traversePreOrder();
        System.out.println(bst.find(32));
        System.out.println(bst.find(5));
        System.out.println("----After del In----");
        bst.delete(3);
        bst.traversePostOrder();


    }
}
