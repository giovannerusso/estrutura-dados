package circularLinkedLists;

public class CircularLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int listSize;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.listSize = 0;
    }

    public T get(int index) {
        return this.getNode(index).getContent();
    }

    private Node<T> getNode(int index) {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("The list is empty.");
        }
        if (index == 0) {
            return this.tail;
        }
        Node<T> auxNode = this.tail;
        for (int i = 0; i < index; i++) {
            auxNode = auxNode.getNextNode();
        }
        return auxNode;
    }

    public void add(T content) {
        Node<T> newNode = new Node<>(content);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
            this.head.setNextNode(tail);
        }
        else {
            newNode.setNextNode(this.tail); //Adicionando o Nó atrás da cauda
            this.head.setNextNode(newNode);
            this.tail = newNode;
        }
        this.listSize++;
    }

    public void remove(int index) {
        if (index >= this.listSize) {
            throw new IndexOutOfBoundsException("Index is bigger than list's size.");
        }
        Node<T> auxNode = this.tail;
        if (index == 0) {
            this.tail = this.tail.getNextNode();
            this.head.setNextNode(this.tail);
        }
        else if (index == 1) {
            this.tail.setNextNode(this.tail.getNextNode().getNextNode());
        }
        else {
            for (int i = 0; i < index - 1; i++) {
                auxNode = auxNode.getNextNode();
            }
            auxNode.setNextNode(auxNode.getNextNode().getNextNode());
        }
        this.listSize--;
    }

    public boolean isEmpty() {
        return this.listSize == 0 ? true : false;
    }

    public int size() {
        return this.listSize;
    }

    @Override
    public String toString() {
        String returnStr = "";

        Node<T> auxNode = this.tail;
        for (int i = 0; i < this.size(); i++) {
            returnStr += "[Node{content=" + auxNode.getContent() + "}]--->";
            auxNode = auxNode.getNextNode();
        }
        returnStr += this.size() != 0 ? "(Return to start)" : "[]";

        return returnStr;
    }

}
