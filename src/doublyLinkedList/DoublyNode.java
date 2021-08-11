package doublyLinkedList;

public class DoublyNode<T> {

    private T content;
    private DoublyNode<T> nextNode;
    private DoublyNode<T> previousNode;

    public DoublyNode(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public DoublyNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoublyNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public DoublyNode<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoublyNode<T> previousNode) {
        this.previousNode = previousNode;
    }

    @Override
    public String toString() {
        return "DoublyNode{" +
                "content=" + content +
                '}';
    }
}
