package com.spartaglobal.samurah.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Swap {

    private static final Logger logger = LogManager.getLogger(Swap.class);

    static {
        logger.trace("Swap.class initialized.");
    }

    public static void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static <T extends Number> void swap(T[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
