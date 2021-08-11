package doublyLinkedList;

import java.util.function.DoublePredicate;

public class DoublyLinkedList<T> {

    private DoublyNode<T> firstNode;
    private DoublyNode<T> lastNode;

    private int listSize;

    public DoublyLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
        this.listSize = 0;
    }

    public T get(int index) {
        return this.getNode(index).getContent();
    }

    public void add(T content) {
        DoublyNode<T> newNode = new DoublyNode<>(content);
        newNode.setNextNode(null);
        newNode.setPreviousNode(lastNode);
        if (firstNode == null) {
            firstNode = newNode;
        }
        if (lastNode != null) {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
        listSize++;
    }

    public void add(int index, T content) {
        DoublyNode<T> auxNode = getNode(index);
        DoublyNode<T> newNode = new DoublyNode<>(content);
        newNode.setNextNode(auxNode);
        if (newNode.getNextNode() != null) {
            newNode.setPreviousNode(auxNode.getPreviousNode());
            newNode.getNextNode().setPreviousNode(newNode);
        }
        else {
            newNode.setPreviousNode(lastNode);
            lastNode = newNode;
        }
        if (index == 0) {
            firstNode =  newNode;
        }
        else {
            newNode.getPreviousNode().setNextNode(newNode);
        }
        listSize++;
    }

    public void remove(int index) {
        if (index == 0) {
            firstNode = firstNode.getNextNode();
            if (firstNode != null) {
                firstNode.setPreviousNode(null);
            }
        }
        else {
            DoublyNode<T> auxNode = getNode(index);
            auxNode.getPreviousNode().setNextNode(auxNode.getNextNode());
            if (auxNode != lastNode) {
                auxNode.getNextNode().setPreviousNode(auxNode.getPreviousNode());
            }
            else {
                lastNode = auxNode;
            }
        }
        listSize--;
    }

    private DoublyNode<T> getNode(int index) {
        DoublyNode<T> auxNode = firstNode;
        for (int i = 0; (i < index) && (auxNode != null); i++) {
            auxNode = auxNode.getNextNode();
        }
        return auxNode;
    }

    public int size() {
        return listSize;
    }

    @Override
    public String toString() {
        String returnStr = "";
        DoublyNode<T> auxNode = firstNode;
        returnStr += "null<---";
        for (int i = 0; i < size(); i++) {
            returnStr += "[Node{content=" + auxNode.getContent() + "}]<--->";
            auxNode = auxNode.getNextNode();
        }
        returnStr += "null";
        return returnStr;
    }

}
