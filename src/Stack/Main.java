package Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(19);
        stack.push(12);
        stack.print();
        System.out.println("----Pops----");
        System.out.println(stack.pop());
        System.out.println("----After Pops----");
        stack.print();
    }
}
