package com.spartaglobal.samurah.sorters;

import com.spartaglobal.samurah.factory.SortFactory;
import com.spartaglobal.samurah.interfaces.Sorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class BinarySort implements Sorter {
    private static final Logger logger = LogManager.getLogger(BinarySort.class);

    static {
        logger.trace("BinarySort.class initialized.");
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        for (int i = 1; i < arrayToSort.length; i++) {
            int x = arrayToSort[i];
            int j = Math.abs(Arrays.binarySearch(arrayToSort, 0, i, x) + 1);
            System.arraycopy(arrayToSort, j, arrayToSort, j + 1, i - j);
            arrayToSort[j] = x;
        }
        return arrayToSort;
    }
}
