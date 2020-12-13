package com.spartaglobal.samurah.utilities;

import com.spartaglobal.samurah.sorters.HeapSort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class RandomArray {

    private static final Logger logger = LogManager.getLogger(RandomArray.class);

    static {
        logger.trace("RandomArray.class initialized.");
    }

    public static int[] getRandomArray(int size) {
        Random random = new Random();

        logger.debug("Generating random array of size: "+ size);

        int[] returnedArray = new int[size];
        for (int i = 0; i < size; i++) {
            returnedArray[i] = random.nextInt(size * 10);
        }
        logger.debug("Random array generated successfully!");
        return returnedArray;
    }
}
