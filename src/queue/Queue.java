package queue;

public class Queue<T> {

    private Node<T> entryNodeRef;

    public Queue() {
        this.entryNodeRef = null;
    }

    public void enqueue(T object) {
        Node newNode = new Node(object);
        newNode.setNodeRef(entryNodeRef);
        entryNodeRef = newNode;
    }

    public T firstElement() {
        if (!this.isEmpty()) {
            Node firstNode = entryNodeRef;
            while (true) {
                if (firstNode.getNodeRef() != null) {
                    firstNode = firstNode.getNodeRef();
                }
                else {
                    break;
                }
            }
            return (T) firstNode.getObject();
        }
        return null;
    }

    public T dequeue() {
        if (!this.isEmpty()) {
            Node firstNode = entryNodeRef;
            Node auxNode = entryNodeRef;
            while (true) {
                if (firstNode.getNodeRef() != null) {
                    auxNode = firstNode;
                    firstNode = firstNode.getNodeRef();
                }
                else {
                    auxNode.setNodeRef(null);
                    break;
                }
            }
            return (T) firstNode.getObject();
        }
        return null;
    }

    public boolean isEmpty() {
        return entryNodeRef == null ? true : false;
    }

    @Override
    public String toString() {
        String returnString = "";
        Node auxNode = entryNodeRef;

        if (entryNodeRef != null) {
            while (true) {
                returnString += "[Node{object=" + auxNode.getObject() + "}]--->";
                if(auxNode.getNodeRef() != null) {
                    auxNode = auxNode.getNodeRef();
                }
                else {
                    returnString += "null";
                    break;
                }
            }
        }
        else {
            returnString = "null";
        }
        return returnString;
    }
}
