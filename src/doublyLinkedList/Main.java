package doublyLinkedList;

public class Main {
    public static void main(String[] args) {

        DoublyLinkedList<String> myDoubleLinkedList = new DoublyLinkedList<>();

        myDoubleLinkedList.add("c1");
        myDoubleLinkedList.add("c2");
        myDoubleLinkedList.add("c3");
        myDoubleLinkedList.add("c4");
        myDoubleLinkedList.add("c5");
        myDoubleLinkedList.add("c6");
        myDoubleLinkedList.add("c7");

        System.out.println(myDoubleLinkedList);

        myDoubleLinkedList.remove(3);
        myDoubleLinkedList.add(3, "99");

        System.out.println();
        System.out.println(myDoubleLinkedList);

    }
}
