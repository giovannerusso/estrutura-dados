package pilhas;

public class Main {

    public static void main(String[] args) {

        Stack myStack = new Stack();

        myStack.push(new Node(1));
        myStack.push(new Node(2));
        myStack.push(new Node(3));
        myStack.push(new Node(4));
        myStack.push(new Node(5));

        System.out.println(myStack);

        System.out.println(myStack.pop());
        System.out.println(myStack);

        myStack.push(new Node(6));
        System.out.println(myStack);

        System.out.println();
        System.out.println(myStack.top());

    }
}
