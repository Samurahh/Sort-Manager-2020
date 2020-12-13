package com.spartaglobal.samurah.sorters;

import com.spartaglobal.samurah.factory.SortFactory;
import com.spartaglobal.samurah.interfaces.Sorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HeapSort implements Sorter {

    private static final Logger logger = LogManager.getLogger(HeapSort.class);

    static {
        logger.trace("HeapSort.class initialized.");
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        sort(arrayToSort);
        return arrayToSort;
    }

    public <T extends Number> T[] sortArray(T[] arrayToSort){
        sort(arrayToSort);
        return arrayToSort;
    }

    private <T extends Number> void sort(T[] arrayToSort){
        int arrayLength = arrayToSort.length;

        for (int i = arrayLength / 2 - 1; i >= 0; i--) {
            heap(arrayToSort, arrayLength, i);
        }

        for (int i = arrayLength - 1; i >= 0; i--) {
            T temp = arrayToSort[0];
            arrayToSort[0] = arrayToSort[i];
            arrayToSort[i] = temp;

            heap(arrayToSort, i, 0);
        }
    }

    private <T extends Number> void heap(T[] arrayToSort, int n, int index) {
        int largest = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < n && arrayToSort[leftIndex].doubleValue() > arrayToSort[largest].doubleValue()) {
            largest = leftIndex;
        }

        if (rightIndex < n && arrayToSort[rightIndex].doubleValue() > arrayToSort[largest].doubleValue()) {
            largest = rightIndex;
        }

        if (largest != index) {
            T swap = arrayToSort[index];
            arrayToSort[index] = arrayToSort[largest];
            arrayToSort[largest] = swap;

            heap(arrayToSort, n, largest);
        }
    }

    private void sort(int[] arrayToSort){
        int arrayLength = arrayToSort.length;

        for (int i = arrayLength / 2 - 1; i >= 0; i--) {
            heap(arrayToSort, arrayLength, i);
        }

        for (int i = arrayLength - 1; i >= 0; i--) {
            int temp = arrayToSort[0];
            arrayToSort[0] = arrayToSort[i];
            arrayToSort[i] = temp;

            heap(arrayToSort, i, 0);
        }
    }

    private void heap(int[] arrayToSort, int n, int index) {
        int largest = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < n && arrayToSort[leftIndex] > arrayToSort[largest]) {
            largest = leftIndex;
        }

        if (rightIndex < n && arrayToSort[rightIndex] > arrayToSort[largest]) {
            largest = rightIndex;
        }

        if (largest != index) {
            int swap = arrayToSort[index];
            arrayToSort[index] = arrayToSort[largest];
            arrayToSort[largest] = swap;

            heap(arrayToSort, n, largest);
        }
    }

}
