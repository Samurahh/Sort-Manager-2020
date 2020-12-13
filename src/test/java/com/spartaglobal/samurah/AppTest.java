package com.spartaglobal.samurah;


import com.spartaglobal.samurah.binarytree.BinaryTree;
import com.spartaglobal.samurah.exceptions.SorterNotFoundException;
import com.spartaglobal.samurah.factory.SortFactory;
import com.spartaglobal.samurah.sorters.*;
import com.spartaglobal.samurah.utilities.RandomArray;
import com.spartaglobal.samurah.utilities.Swap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */

    @Test
    public void checkSwapper(){
        int[] array = {1,26,3};
        int[] swapped = {3,26,1};

        Swap.swap(array,0,2);
        Assertions.assertArrayEquals(swapped, array);
    }

    @Test
    public void checkIfSorted() {
        for (SorterType sorterType : SorterType.values()) {
            int[] arrayToSort = RandomArray.getRandomArray(100);
            arrayToSort = sorterType.getConstructor().get().sortArray(arrayToSort);
            boolean sorted = true;
            for (int i = 0; i < arrayToSort.length - 1; i++) {
                if (arrayToSort[i + 1] < arrayToSort[i]) {
                    sorted = false;
                    break;
                }
            }
            Assertions.assertTrue(sorted);
        }
    }

    @Test
    public void testSorterFactory() throws SorterNotFoundException {
        boolean workingProperly = true;
        sorter:for (int i = 0;i<SorterType.values().length;i++){
            switch (i){
                case 1:{
                    if(!(SortFactory.getSorter(i) instanceof BubbleSort)){
                        workingProperly = false;
                        break sorter;
                    }
                    break;
                }
                case 2:{
                    if(!(SortFactory.getSorter(i) instanceof MergeSort)){
                        workingProperly = false;
                        break sorter;
                    }
                    break;
                }
                case 3:{
                    if(!(SortFactory.getSorter(i) instanceof HeapSort)){
                        workingProperly = false;
                        break sorter;
                    }
                    break;
                }
                case 4:{
                    if(!(SortFactory.getSorter(i) instanceof BinaryTree)){
                        workingProperly = false;
                        break sorter;
                    }
                    break;
                }
                case 5:{
                    if(!(SortFactory.getSorter(i) instanceof ShellSort)){
                        workingProperly = false;
                        break sorter;
                    }
                    break;
                }
                case 6:{
                    if(!(SortFactory.getSorter(i) instanceof QuickSort)){
                        workingProperly = false;
                        break sorter;
                    }
                    break;
                }
                case 7:{
                    if(!(SortFactory.getSorter(i) instanceof InsertionSort)){
                        workingProperly = false;
                        break sorter;
                    }
                    break;
                }
                case 8:{
                    if(!(SortFactory.getSorter(i) instanceof BinarySort)){
                        workingProperly = false;
                        break sorter;
                    }
                    break;
                }
            }
        }
        Assertions.assertTrue(workingProperly);
    }

    @Test
    public void testIfSorterFactoryDoesNotThrowsException(){
        boolean throwed = false;
        try{
            testSorterFactory();
        }catch (SorterNotFoundException e){
            throwed = true;
        }
        Assertions.assertFalse(throwed);
    }

    @Test
    public void testIfSorterFactoryDoesThrowsException(){
        boolean throwed = false;
        try{
            SortFactory.getSorter(0);
        }catch (SorterNotFoundException e){
            throwed = true;
        }
        Assertions.assertTrue(throwed);
    }

}
