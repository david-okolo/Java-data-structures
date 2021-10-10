package LinkedList;

import java.util.function.BiFunction;

public class LinkedList {
    public static void main(String[] args) {
        Integer[] data = { 1, 3, 5, 6 };

        BiFunction<Integer, Integer, Integer> compareFn = (a, b) -> a - b;

        List<Integer> list = new List<>(data, compareFn);
        list.printList();
        list.remove(6);
        System.out.println("---After Removal----");
        list.printList();
        list.add(4);
        list.add(7);
        list.add(2);
        list.add(0);
        list.add(-30);
        System.out.println("---After Add----");
        list.printList();


        Person[] employees = { new Person(23, "Sarah") };
        BiFunction<Person, Person, Integer> comparePeople = (a, b) -> a.age - b.age;
        List<Person> people = new List<>(employees, comparePeople);
        people.printList();
        people.add(new Person(45, "Robert"));
        people.add(new Person(17, "Mateo"));
        people.printList();

    }
}
