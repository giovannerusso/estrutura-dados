package binaryTree;

import binaryTree.model.Obj;

public class Main {
    public static void main(String[] args) {

        BinaryTree<Obj> myBinaryTree = new BinaryTree<Obj>();

        myBinaryTree.insert(new Obj(13));
        myBinaryTree.insert(new Obj(10));
        myBinaryTree.insert(new Obj(25));
        myBinaryTree.insert(new Obj(2));
        myBinaryTree.insert(new Obj(12));
        myBinaryTree.insert(new Obj(20));
        myBinaryTree.insert(new Obj(31));
        myBinaryTree.insert(new Obj(29));
        myBinaryTree.insert(new Obj(32));

        myBinaryTree.visualizeInOrder();
        System.out.println();
        myBinaryTree.visualizePreOrder();
        System.out.println();
        myBinaryTree.visualizePostOrder();

        myBinaryTree.remove(new Obj(20));
        myBinaryTree.visualizeInOrder();

    }
}
