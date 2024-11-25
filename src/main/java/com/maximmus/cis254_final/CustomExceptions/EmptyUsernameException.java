package com.maximmus.cis254_final.CustomExceptions;

public class EmptyUsernameException extends Exception {
    public EmptyUsernameException() {}
    public EmptyUsernameException(String message) {
        super(message);
    }
}
