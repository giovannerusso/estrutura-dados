package binaryTree;

public class BiNode<T extends Comparable<T>> { //Upperbounded Wildcard

    private T content;
    private BiNode<T> leftNode;
    private BiNode<T> rightNode;

    public BiNode(T content) {
        this.content = content;
        this.leftNode = this.rightNode = null;
    }

    public BiNode() {
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public BiNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BiNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public BiNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BiNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "BiNode{" +
                "content=" + content +
                '}';
    }
}
