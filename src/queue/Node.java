package queue;

public class Node<T> {

    private T object;
    private Node<T> nodeRef;

    public Node() {
    }

    public Node(T object) {
        this.nodeRef = null;
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public Node getNodeRef() {
        return nodeRef;
    }

    public void setNodeRef(Node nodeRef) {
        this.nodeRef = nodeRef;
    }

    @Override
    public String toString() {
        return "Node{" +
                "object=" + object +
                '}';
    }
}
