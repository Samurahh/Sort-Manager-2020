package com.spartaglobal.samurah.sorters;

import com.spartaglobal.samurah.interfaces.Sorter;
import com.spartaglobal.samurah.utilities.Swap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SelectionSort implements Sorter {

    private static final Logger logger = LogManager.getLogger(SelectionSort.class);

    static {
        logger.trace("SelectionSort.class initialized.");
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        return sort(arrayToSort);
    }

    private int[] sort(int[] arrayToSort)
    {
        for (int i = 0; i < arrayToSort.length-1; i++)
        {
            int indexOfMinimum = i;
            for (int j = i+1; j < arrayToSort.length; j++) {
                if (arrayToSort[j] < arrayToSort[indexOfMinimum]) {
                    indexOfMinimum = j;
                }
            }
            Swap.swap(arrayToSort,indexOfMinimum,i);
        }
        return arrayToSort;
    }
}
