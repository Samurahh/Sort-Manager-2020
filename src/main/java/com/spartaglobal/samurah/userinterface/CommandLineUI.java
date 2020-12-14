package com.spartaglobal.samurah.userinterface;

import com.spartaglobal.samurah.exceptions.SorterNotFoundException;
import com.spartaglobal.samurah.factory.SortFactory;
import com.spartaglobal.samurah.interfaces.Sorter;
import com.spartaglobal.samurah.sorters.SorterType;
import com.spartaglobal.samurah.utilities.RandomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class CommandLineUI {

    private static final Logger logger = LogManager.getLogger(CommandLineUI.class);

    static{
        logger.trace("CommandLineUI.class initialized.");
    }

    public void run() {
        logger.trace("CommandLine UI running");
        showHeader();
        showOptions();
        askForOption();
    }

    private void showHeader() {
        logger.trace("Display header");
        System.out.println("**********************************************************************");
        System.out.println("*************** - WELCOME TO YOUR SORT MANAGER 2020! - ***************");
        System.out.println("**********************************************************************");
    }

    private void showOptions() {
        logger.trace("Show options");
        System.out.println("******************** - SORT ALGORITHMS AVAILABLE - *******************");
        System.out.println("********************** - 0. Try them all *****************************");
        System.out.println("** - 1. Bubble Sort - **************** - 2. Merge Sort - *************");
        System.out.println("** - 3. Heap Sort - ****************** - 4. Binary Tree Sort - *******");
        System.out.println("** - 5. Shell Sort - ***************** - 6. QuickSort Sort - *********");
        System.out.println("** - 7. Insertion Sort - ************* - 8. Binary Sort - ************");
        System.out.println("********************* - 9. Selection Sorter **************************");
        System.out.println("********** - Please select your desired sorting algorithm - **********\n");
    }

    private void askForOption() {
        logger.trace("Asking for option (RANGE 0-9).");
        System.out.print("** Select option (0-9): ");
        int option;
        try {
            option = Integer.parseInt(expectInput());
            if(printSelected(option)){
                askForInput(option);
            }else{
                logger.warn("Invalid numerical input! Range exceeded (0-9) - input = " + option);
                askForOption();
            }
        } catch (Exception e) {
            logger.error("Non numerical input attempted!\nTrying again..");
            askForOption();
        }
    }

    private boolean printSelected(int option){
        switch (option) {
            case 0: {
                System.out.println("**********************************************************************");
                System.out.println("** You have selected (0) TRY ALL *************************************\n");
                break;
            }
            case 1: {
                System.out.println("**********************************************************************");
                System.out.println("******************** (1) Bubble Sort *********************************\n");
                break;
            }
            case 2: {
                System.out.println("**********************************************************************");
                System.out.println("******************** (2) Merge Sort **********************************\n");
                break;
            }
            case 3: {
                System.out.println("**********************************************************************");
                System.out.println("******************** (3) Heap Sort ***********************************\n");
                break;
            }
            case 4: {
                System.out.println("**********************************************************************");
                System.out.println("******************** (4) Binary Tree Sort ****************************\n");
                break;
            }
            case 5: {
                System.out.println("**********************************************************************");
                System.out.println("******************** (5) Shell Sort **********************************\n");
                break;
            }
            case 6: {
                System.out.println("**********************************************************************");
                System.out.println("******************** (6) QuickSort Sort ******************************\n");
                break;
            }
            case 7: {
                System.out.println("**********************************************************************");
                System.out.println("******************** (7) Insertion Sort ******************************\n");
                break;
            }
            case 8: {
                System.out.println("**********************************************************************");
                System.out.println("******************** (8) Binary Sort *********************************\n");
                break;
            }
            case 9: {
                System.out.println("**********************************************************************");
                System.out.println("******************** (9) Selection Sort ******************************\n");
                break;
            }
            default: {
                logger.debug("IllegalArgument for option: " + option);
                return false;
            }
        }
        logger.debug("User selected option " + option);
        return true;
    }

    private void printArray(int[] array) {
        logger.trace("Printing array with size " + array.length);
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            if (i % 15 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "]");
        logger.trace("Printing: success");
    }

    private String expectInput() {
        logger.trace("Waiting for input...");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        logger.trace("User input: "+ input);
        return input;
    }

    private void askForInput(int option) {
        logger.trace("Asking for input on option selected: "+ option);
        System.out.println("**********************************************************************");
        System.out.println("Type in your integer array to sort or type 'random [size]' to generate \na random array with specified size. delimiters: any non-digit character.");
        String input;
        input = expectInput();
        if(!input.equals("")) {
            if (option == 0) {
                for (int i = 1; i <= SorterType.values().length; i++) {
                    printSelected(i);
                    sortingOperation(i, input, true);
                    System.out.println("Press ENTER to continue...");
                    expectInput();
                }
            } else {
                sortingOperation(option, input, false);
            }
            tryAgain();
        }else{
            logger.trace("User input is empty. Trying again...");
            askForInput(option);
        }
    }

    private void sortingOperation(int option, String input, boolean onlyTiming) {
        try {
            Sorter sorter = SortFactory.getSorter(option);
            try {
                logger.debug("Sorting operation: " + sorter.getClass());
                int[] array = processingInput(input);
                printSortPrint(sorter, array, onlyTiming);
            } catch (Exception e) {
                logger.error("Invalid input. Trying again..");
                askForInput(option);
            }
        } catch (SorterNotFoundException e) {
            logger.fatal("SORTER NOT FOUND. Abort()");
        }
    }


    private void printSortPrint(Sorter sorter, int[] array, boolean onlyTiming) {
        logger.trace("Sorting operation in process.");
        int[] initialArray = array.clone();
        long initialTime = System.nanoTime();
        array = sorter.sortArray(array);
        long afterTime = System.nanoTime();
        logger.trace("Sorting operation: success");
        if(!onlyTiming) {
            logger.trace("Printing initial array and sorted array for comparison.");
            System.out.println("** ARRAY BEFORE SORTING **");
            printArray(initialArray);
            System.out.println("** ARRAY AFTER SORTING ***");
            printArray(array);
        }else{
            logger.trace("Printing time elapsed only.");
        }
        System.out.printf("** Time elapsed: %sms.%n***",(afterTime-initialTime)/1_000_000.);
    }

    private void tryAgain() {
        logger.trace("User reached the end of the program. Trying again?");
        System.out.println("*************************** Try again? ***********************************");
        System.out.println("***************************** (y/n) **************************************");
        String input = expectInput().toLowerCase(Locale.ROOT);
        if (input.equals("y")) {
            logger.trace("Reloading. User selected to try again.");
            System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n");
            run();
        } else if (input.equals("n")) {
            logger.trace("User selected to end.");
            finish();
        } else {
            logger.trace("Invalid input... trying again.");
            tryAgain();
        }
    }

    private void finish(){
        logger.debug("The program successfully finished running.");
    }

    private int[] processingInput(String input) {
        logger.trace("Processing user input: "+ input);
        int[] arrayToSort;
        if (input.contains("random")) {
            int size = Integer.parseInt(input.substring(input.indexOf("random") + 7).split(" ")[0]);
            arrayToSort = RandomArray.getRandomArray(size);
            logger.debug("The user selected a random array of size: "+ size);
        } else {
            logger.debug("Trying to format the array from the user input.");
            arrayToSort = formatArray(input);
        }
        return arrayToSort;
    }

    private int[] formatArray(String input) {
        logger.trace("Formatting input...");
        String[] numberStrings = input.split("[\\D]");
        List<Integer> integers = new ArrayList<>();
        for (String string : numberStrings) {
            if (string.matches("\\d+")) {
                integers.add(Integer.valueOf(string));
            }
        }
        logger.debug("Successfully formatted the input. The result is an array of integer with the size: " + integers.size());
        return integers.stream().mapToInt(i -> i).toArray();
    }


}
