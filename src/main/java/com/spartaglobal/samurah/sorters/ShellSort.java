package com.spartaglobal.samurah.sorters;

import com.spartaglobal.samurah.interfaces.Sorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShellSort implements Sorter {

    private static final Logger logger = LogManager.getLogger(ShellSort.class);

    static {
        logger.trace("ShellSort.class initialized.");
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        for (int interval = arrayToSort.length / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < arrayToSort.length; i += 1) {
                int temp = arrayToSort[i];
                int j;
                for (j = i; j >= interval && arrayToSort[j - interval] > temp; j -= interval) {
                    arrayToSort[j] = arrayToSort[j - interval];
                }
                arrayToSort[j] = temp;
            }
        }
        return arrayToSort;
    }

    public <T extends Number> T[] sortArray(T[] arrayToSort){
        for (int interval = arrayToSort.length / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < arrayToSort.length; i += 1) {
                T temp = arrayToSort[i];
                int j;
                for (j = i; j >= interval && arrayToSort[j - interval].doubleValue() > temp.doubleValue(); j -= interval) {
                    arrayToSort[j] = arrayToSort[j - interval];
                }
                arrayToSort[j] = temp;
            }
        }
        return arrayToSort;
    }
}
