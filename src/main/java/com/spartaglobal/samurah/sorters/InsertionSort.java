package com.spartaglobal.samurah.sorters;

import com.spartaglobal.samurah.interfaces.Sorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertionSort implements Sorter {

    private static final Logger logger = LogManager.getLogger(InsertionSort.class);

    static {
        logger.trace("InsertionSort.class initialized.");
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        for (int i = 1; i < arrayToSort.length; i++) {
            int key = arrayToSort[i];
            int j = i - 1;
            while (j >= 0 && arrayToSort[j] > key) {
                arrayToSort[j + 1] = arrayToSort[j];
                j = j - 1;
            }
            arrayToSort[j + 1] = key;
        }
        return arrayToSort;
    }
}
