package com.spartaglobal.samurah.sorters;

import com.spartaglobal.samurah.factory.SortFactory;
import com.spartaglobal.samurah.interfaces.Sorter;
import com.spartaglobal.samurah.utilities.Swap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BubbleSort implements Sorter {

    private static final Logger logger = LogManager.getLogger(BubbleSort.class);

    static {
        logger.trace("BubbleSort.class initialized.");
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++)
            for (int j = 1; j < arrayToSort.length; j++)
                if (arrayToSort[j] < arrayToSort[j - 1])
                    Swap.swap(arrayToSort, j, j - 1);
        return arrayToSort;
    }

    public <T extends Number> T[] sortArray(T[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++)
            for (int j = 1; j < arrayToSort.length; j++)
                if (arrayToSort[j].doubleValue() < arrayToSort[j - 1].doubleValue())
                    Swap.swap(arrayToSort, j, j - 1);
        return arrayToSort;
    }

}
