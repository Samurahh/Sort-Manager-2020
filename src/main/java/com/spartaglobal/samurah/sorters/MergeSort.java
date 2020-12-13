package com.spartaglobal.samurah.sorters;

import com.spartaglobal.samurah.interfaces.Sorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MergeSort implements Sorter {

    private static final Logger logger = LogManager.getLogger(MergeSort.class);

    static {
        logger.trace("MergeSort.class initialized.");
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        mergeSort(arrayToSort, arrayToSort.length);
        return arrayToSort;
    }

    public static void mergeSort(int[] arrayToSort, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[n - mid];

        System.arraycopy(arrayToSort, 0, leftArray, 0, mid);
        System.arraycopy(arrayToSort,mid,rightArray, 0, n-mid);

        mergeSort(leftArray, mid);
        mergeSort(rightArray, n - mid);

        merge(arrayToSort, leftArray, rightArray, mid, n - mid);
    }

    public static void merge(int[] sourceArray, int[] leftArray, int[] rightArray, int leftSize, int rightSize) {
        int leftIndex = 0, rightIndex = 0, mergedArrayIndex = 0;

        while (leftIndex < leftSize && rightIndex < rightSize) {

            if (leftArray[leftIndex] <= rightArray[rightIndex])
                sourceArray[mergedArrayIndex++] = leftArray[leftIndex++];
            else
                sourceArray[mergedArrayIndex++] = rightArray[rightIndex++];

        }

        while (leftIndex < leftSize)
            sourceArray[mergedArrayIndex++] = leftArray[leftIndex++];

        while (rightIndex < rightSize)
            sourceArray[mergedArrayIndex++] = rightArray[rightIndex++];
    }

}
