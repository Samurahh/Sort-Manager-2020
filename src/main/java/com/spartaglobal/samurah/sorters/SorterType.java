package com.spartaglobal.samurah.sorters;

import com.spartaglobal.samurah.binarytree.BinaryTree;
import com.spartaglobal.samurah.factory.SortFactory;
import com.spartaglobal.samurah.interfaces.Sorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public enum SorterType {
    BUBBLE_SORT(BubbleSort::new, 1),
    MERGE_SORT(MergeSort::new, 2),
    HEAP_SORT(HeapSort::new, 3),
    BINARY_TREE_SORT(BinaryTree::new, 4),
    SHELL_SORT(ShellSort::new, 5),
    QUICK_SORT(QuickSort::new, 6),
    INSERTION_SORT(InsertionSort::new, 7),
    BINARY_SORT(BinarySort::new, 8);

    private static final Logger logger = LogManager.getLogger(SorterType.class);

    static {
        logger.trace("SorterType.class initialized.");
    }

    private final Supplier<Sorter> constructor;

    private final int optionNumber;

    SorterType(Supplier<Sorter> constructor, int optionNumber) {
        this.constructor = constructor;
        this.optionNumber = optionNumber;
    }

    public static SorterType getSorter(int optionNumber) {
        for (SorterType type : SorterType.values()) {
            if (optionNumber == type.optionNumber) {
                return type;
            }
        }
        return null;
    }

    public Supplier<Sorter> getConstructor() {
        return this.constructor;
    }
}
