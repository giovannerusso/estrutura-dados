package linkedList;

public class LinkedList<T> {

    Node<T> entryReference;

    public LinkedList() {
        this.entryReference = null;
    }

    public void add(T content) {
        Node<T> newNode = new Node<>(content);
        if (this.isEmpty()) {
            entryReference = newNode;
            return;
        }
        Node<T> auxNode = entryReference;
        for (int i = 0; i < this.size() - 1; i++) {
            auxNode = auxNode.getNextNode();
        }
        auxNode.setNextNode(newNode);
    }

    public T get(int index) {
        return getNode(index).getContent();
    }

    private Node<T> getNode(int index) {
        validateIndex(index);
        Node<T> auxNode = entryReference;
        Node<T> returnNode = null;
        for (int i = 0; i <= index; i++) {
            returnNode = auxNode;
            auxNode = auxNode.getNextNode();
        }
        return returnNode;
    }

    public T remove(int index) {
        Node<T> pivotNode =  this.getNode(index);
        if (index == 0) {
            entryReference = pivotNode.getNextNode();
            return pivotNode.getContent();
        }
        Node<T> previousNode = getNode(index - 1);
        previousNode.setNextNode(pivotNode.getNextNode());
        return pivotNode.getContent();
    }

    private void validateIndex (int index) {
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException("There is no content at the index " + index);
        }
    }

    public int size() {
        int listSize = 0;
        Node<T> auxRef = entryReference;
        while (true) {
            if (entryReference != null) {
                listSize++;
                if (auxRef.getNextNode() != null) {
                    auxRef = auxRef.getNextNode();
                }
                else {
                    break;
                }
            }
            else {
                break;
            }
        }
        return listSize;
    }

    public boolean isEmpty() {
        return entryReference == null ? true : false;
    }

    @Override
    public String toString() {
        String returnStr = "";
        Node<T> auxNode = entryReference;
        for (int i = 0; i < this.size(); i++) {
            returnStr += "Node{content=" + auxNode.getContent() + "}----->";
            auxNode = auxNode.getNextNode();
        }
        returnStr += "null";
        return returnStr;
    }
}
