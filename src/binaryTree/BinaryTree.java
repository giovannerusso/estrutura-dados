package binaryTree;

public class BinaryTree<T extends Comparable<T>> {

    private BiNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(T content) {
        BiNode<T> newNode = new BiNode<>(content);
        this.root = insert(root, newNode);
    }

    private BiNode<T> insert(BiNode<T> current, BiNode<T> newNode) {
        if (current == null) {
            return newNode;
        }
        else if (newNode.getContent().compareTo(current.getContent()) < 0) {
            current.setLeftNode(insert(current.getLeftNode(), newNode));
        }
        else {
            current.setRightNode(insert(current.getRightNode(), newNode));
        }
        return current;
    }

    public void remove(T content) { //Sem recursividade
        try {
            BiNode<T> current = this.root;
            BiNode<T> parent = null;
            BiNode<T> son = null;
            BiNode<T> temp = null;

            while (current != null && !current.getContent().equals(content)) {
                parent = current;
                if (content.compareTo(current.getContent()) < 0) {
                    current = current.getLeftNode();
                }
                else {
                    current = current.getRightNode();
                }
            }
            if (current == null) {
                System.out.println("Content not found. Try block.");
            }
            if (parent == null) {
                if (current.getRightNode() == null) {
                    this.root = current.getLeftNode();
                }
                else if (current.getLeftNode() == null) {
                    this.root = current.getRightNode();
                }
                else {
                    for (temp = current, son = current.getLeftNode();
                        son.getRightNode() != null;
                        temp = son, son = son.getLeftNode()) {
                        if (son != current.getLeftNode()) {
                            temp.setRightNode(son.getLeftNode());
                            son.setLeftNode(root.getLeftNode());
                        }
                    }
                    son.setRightNode(root.getRightNode());
                    root = son;
                }
            }
            else if(current.getRightNode() == null){
                if (parent.getLeftNode() == current) {
                    parent.setLeftNode(current.getLeftNode());
                }
                else {
                    parent.setRightNode(current.getLeftNode());
                }
            }
            else if (current.getLeftNode() == null) {
                if (parent.getLeftNode() == current) {
                    parent.setLeftNode(current.getRightNode());
                }
                else {
                    parent.setRightNode(current.getRightNode());
                }
            }
            else {
                for (temp = current, son = current.getLeftNode();
                     son.getRightNode() != null;
                     temp = son, son = son.getRightNode()) {
                    if (son != current.getLeftNode()) {
                        temp.setRightNode(son.getLeftNode());
                        son.setLeftNode(current.getLeftNode());
                    }
                    son.setRightNode(current.getRightNode());
                    if (parent.getLeftNode() == current) {
                        parent.setLeftNode(son);
                    }
                    else {
                        parent.setRightNode(son);
                    }
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("Content not found. Catch block.");
        }
    }

    public void visualizeInOrder() {
        System.out.println("\n Visualizing InOrder");
        visualizeInOrder(this.root);
    }

    private void visualizeInOrder(BiNode<T> current) {
        if (current != null) {
            visualizeInOrder(current.getLeftNode());
            System.out.print(current.getContent() + ", ");
            visualizeInOrder(current.getRightNode());
        }
    }

    public void visualizePostOrder() {
        System.out.println("\n Visualizing PostOrder");
        visualizePostOrder(this.root);
    }

    private void visualizePostOrder(BiNode<T> current) {
        if (current != null) {
            visualizePostOrder(current.getLeftNode());
            visualizePostOrder(current.getRightNode());
            System.out.print(current.getContent() + ", ");
        }
    }

    public void visualizePreOrder() {
        System.out.println("\n Visualizing PreOrder");
        visualizePreOrder(this.root);
    }

    private void visualizePreOrder(BiNode<T> current) {
        if (current != null) {
            System.out.print(current.getContent() + ", ");
            visualizePreOrder(current.getLeftNode());
            visualizePreOrder(current.getRightNode());
        }
    }

}
