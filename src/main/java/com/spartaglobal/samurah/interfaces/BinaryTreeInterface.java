package com.spartaglobal.samurah.interfaces;

import com.spartaglobal.samurah.exceptions.ChildNotFoundException;

public interface BinaryTreeInterface {
    int getRootElement();

    int getNumberOfElements();

    void addElements(final int[] elements);

    void addElement(final int element);

    void deleteElement(final int element);

    void deleteElements(final int[] elements);

    boolean findElement(final int value);

    int getLeftChild(int element) throws ChildNotFoundException;

    int getRightChild(int element) throws ChildNotFoundException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();
}
