package com.maximmus.cis254_final;

public class EmptyUsernameException extends Exception {
    EmptyUsernameException() {}
    EmptyUsernameException(String message) {
        super(message);
    }
}
