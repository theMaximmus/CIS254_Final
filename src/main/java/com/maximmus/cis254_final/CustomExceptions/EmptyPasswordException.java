package com.maximmus.cis254_final.CustomExceptions;

public class EmptyPasswordException extends Exception {
    public EmptyPasswordException() {}
    public EmptyPasswordException(String message) {
        super(message);
    }
}
