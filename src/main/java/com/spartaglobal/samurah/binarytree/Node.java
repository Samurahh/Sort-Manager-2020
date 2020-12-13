package com.spartaglobal.samurah.binarytree;

import com.spartaglobal.samurah.factory.SortFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Node {
    private final int value;
    private Node leftChild;
    private Node rightChild;

    private static final Logger logger = LogManager.getLogger(Node.class);

    static {
        logger.trace("Node.class initialized.");
    }

    public Node(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getValue(){
        return value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isLeftChildEmpty(){
        return leftChild == null;
    }

    public boolean isRightChildEmpty(){
        return rightChild == null;
    }
}
