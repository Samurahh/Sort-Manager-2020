package com.spartaglobal.samurah.binarytree;

import com.spartaglobal.samurah.exceptions.ChildNotFoundException;
import com.spartaglobal.samurah.factory.SortFactory;
import com.spartaglobal.samurah.interfaces.BinaryTreeInterface;
import com.spartaglobal.samurah.interfaces.Sorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class BinaryTree implements BinaryTreeInterface, Sorter {
    private final Node rootNode;
    private int numberOfElements;

    private static final Logger logger = LogManager.getLogger(BinaryTree.class);

    static {
        logger.trace("BinaryTree.class initialized.");
    }

    public BinaryTree(Node rootNode) {
        this.rootNode = rootNode;
        numberOfElements = 0;
    }

    public BinaryTree(final int rootValue) {
        this.rootNode = new Node(rootValue);
        numberOfElements = 0;
    }

    public BinaryTree() {
        this.rootNode = new Node(0);
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        BinaryTree tempBinaryTree = new BinaryTree(new Node(arrayToSort[0]));
        for(int i = 1;i<arrayToSort.length;i++){
            tempBinaryTree.addElement(arrayToSort[i]);
        }
        return tempBinaryTree.getSortedTreeAsc();
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return numberOfElements;
    }

    @Override
    public void addElements(int[] elements) {
        for (int element : elements) {
            addElement(element);
        }
    }

    public void addElement(final int element) {
        addNodeToTree(rootNode, element);
    }

    @Override
    public boolean findElement(int value) {
        return findNode(value) != null;
    }

    @Override
    public int[] getSortedTreeAsc() {
        return getSortedTreeAsc(rootNode, null).stream().mapToInt(i -> i).toArray();
    }

    private ArrayList<Integer> getSortedTreeAsc(Node node, ArrayList<Integer> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (node != null) {
            getSortedTreeAsc(node.getLeftChild(), list);
            list.add(node.getValue());
            getSortedTreeAsc(node.getRightChild(), list);
        }
        return list;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node leftChild = findNode(element).getLeftChild();
        if (leftChild == null) {
            throw new ChildNotFoundException("Left child not existent for node with value: " + element);
        } else {
            return leftChild.getValue();
        }
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node rightChild = findNode(element).getRightChild();
        if (rightChild == null) {
            throw new ChildNotFoundException("Right child not existent for node with value: " + element);
        } else {
            return rightChild.getValue();
        }
    }

    @Override
    public int[] getSortedTreeDesc() {
        return getSortedTreeDesc(rootNode, null).stream().mapToInt(i -> i).toArray();
    }

    private ArrayList<Integer> getSortedTreeDesc(Node node, ArrayList<Integer> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (node != null) {
            getSortedTreeDesc(node.getRightChild(), list);
            list.add(node.getValue());
            getSortedTreeDesc(node.getLeftChild(), list);
        }
        return list;
    }

    @Override
    public void deleteElement(int element) {
        deleteNodeFromTree(findNode(element));
    }

    @Override
    public void deleteElements(int[] elements) {

    }

    private void deleteNodeFromTree(Node node){
        Node rootNode = this.rootNode;
        while(rootNode!=null){
            if(rootNode.getValue() > node.getValue()){
                if(rootNode.getLeftChild().getValue() == node.getValue()){
                    assignNewNode(node, rootNode);
                    break;
                }
                rootNode = rootNode.getLeftChild();
            }else if (rootNode.getValue() < node.getValue()){
                if(rootNode.getRightChild().getValue() == node.getValue()){
                    assignNewNode(node, rootNode);
                    break;
                }
                rootNode = rootNode.getRightChild();
            }else{
                break;
            }
        }
    }

    private void assignNewNode(Node node, Node rootNode) {
        if(node.isLeftChildEmpty() && node.isRightChildEmpty()){
            rootNode.setLeftChild(null);
        }else if(!node.isLeftChildEmpty() && node.isRightChildEmpty()){
            rootNode.setLeftChild(node.getLeftChild());
        }else if(node.isLeftChildEmpty() && !node.isRightChildEmpty()) {
            rootNode.setRightChild(node.getRightChild());
        }else{
            rootNode.setLeftChild(node.getLeftChild());
            rootNode.setRightChild(node.getRightChild());
        }
    }

    private void addNodeToTree(Node node, int element) {
        if (element <= node.getValue()) {
            if (node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else {
            if (node.isRightChildEmpty()) {
                node.setRightChild(new Node(element));
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
        numberOfElements++;
    }

    public Node findNode(int element) {
        Node node = rootNode;
        while (node != null) {
            if (element == node.getValue()) {
                return node;
            }
            if (element < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return null;
    }
}
