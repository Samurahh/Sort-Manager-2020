package com.spartaglobal.samurah.factory;

import com.spartaglobal.samurah.App;
import com.spartaglobal.samurah.exceptions.SorterNotFoundException;
import com.spartaglobal.samurah.interfaces.Sorter;
import com.spartaglobal.samurah.sorters.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;

public class SortFactory {

    private static final Logger logger = LogManager.getLogger(SortFactory.class);

    static {
        logger.trace("SortFactory.class initialized.");
    }

    public static Sorter getSorter(SorterType type){
        return type.getConstructor().get();
    }

    public static Sorter getSorter(int optionNumber) throws SorterNotFoundException {
        SorterType sorter = SorterType.getSorter(optionNumber);
        if(sorter != null){
            return sorter.getConstructor().get();
        }else{
            throw new SorterNotFoundException();
        }
    }

}
