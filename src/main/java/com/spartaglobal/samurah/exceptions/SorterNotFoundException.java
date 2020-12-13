package com.spartaglobal.samurah.exceptions;

public class SorterNotFoundException extends Exception {
    public SorterNotFoundException(String message) {
        super(message);
    }

    public SorterNotFoundException() {
        super();
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
