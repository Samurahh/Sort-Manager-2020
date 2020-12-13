package com.spartaglobal.samurah.sorters;

import com.spartaglobal.samurah.interfaces.Sorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuickSort implements Sorter {

    private static final Logger logger = LogManager.getLogger(QuickSort.class);

    static {
        logger.trace("QuickSort.class initialized.");
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        return quickSort(arrayToSort, 0, arrayToSort.length - 1);
    }

    public int[] quickSort(int[] arrayToSort, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arrayToSort, begin, end);

            quickSort(arrayToSort, begin, partitionIndex - 1);
            quickSort(arrayToSort, partitionIndex + 1, end);
        }
        return arrayToSort;
    }

    private int partition(int[] arrayToSort, int begin, int end) {
        int pivot = arrayToSort[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arrayToSort[j] <= pivot) {
                i++;

                int swapTemp = arrayToSort[i];
                arrayToSort[i] = arrayToSort[j];
                arrayToSort[j] = swapTemp;
            }
        }

        int swapTemp = arrayToSort[i + 1];
        arrayToSort[i + 1] = arrayToSort[end];
        arrayToSort[end] = swapTemp;

        return i + 1;
    }

}
