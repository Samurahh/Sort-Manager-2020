package com.spartaglobal.samurah.exceptions;

public class ChildNotFoundException extends Exception {
    public ChildNotFoundException(String message) {
        super(message);
    }

    public ChildNotFoundException() {
        super("Child not found in the node!");
    }
}
