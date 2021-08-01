package pilhas;

public class Stack {

    private Node refNodeEntryStack;

    public Stack() {
        this.refNodeEntryStack = null;
    }

    public void push(Node newNode) {
        Node refAux = refNodeEntryStack;
        refNodeEntryStack = newNode;
        refNodeEntryStack.setRefNode(refAux);
    }

    public Node pop() {
        if (!isEmpty()) {
            Node poppedNode = refNodeEntryStack;
            refNodeEntryStack = refNodeEntryStack.getRefNode();
            return poppedNode;
        }
        return null;
    }

    public Node top() {
        return refNodeEntryStack;
    }

    public boolean isEmpty() {
        return refNodeEntryStack == null ? true : false;
    }

    @Override
    public String toString() {
        String returnString = " -------------\n";
        returnString += "      Stack\n";
        returnString += " -------------\n";

        Node auxNode = refNodeEntryStack;

        while (true) {
            if (auxNode != null) {
                returnString += "[Node{data=" + auxNode.getData() + "}]\n";
                auxNode = auxNode.getRefNode(); //Recebe a referência do Próximo Nó, passando a ser o próximo Nó
            }
            else {
                break;
            }
        }
        returnString += " =============\n";
        return returnString;
    }

}
