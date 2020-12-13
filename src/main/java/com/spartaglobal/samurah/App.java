package com.spartaglobal.samurah;

import com.spartaglobal.samurah.userinterface.CommandLineUI;
import com.spartaglobal.samurah.utilities.RandomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger = LogManager.getLogger(App.class);

    static {
        logger.trace("App.class initialized.");
    }

    public static void main(String[] args) {
        CommandLineUI commandLine = new CommandLineUI();
        commandLine.run();
    }
}
