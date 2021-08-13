package circularLinkedLists;

public class Main {
    public static void main(String[] args) {

        CircularLinkedList<String> myCircularList = new CircularLinkedList<>();

        myCircularList.add("c0");
        myCircularList.add("c1");
        myCircularList.add("c2");
        myCircularList.add("c3");
        System.out.println(myCircularList);

        System.out.println();
        myCircularList.remove(0);
        System.out.println(myCircularList);

        System.out.println();
        myCircularList.add("c3");
        System.out.println(myCircularList);
        myCircularList.remove(3);

        System.out.println();
        for (int i = 0; i < 20; i++) {
            System.out.println(myCircularList.get(i));
        }

    }
}
