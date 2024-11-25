package com.maximmus.cis254_final;

public class EmptyPasswordException extends Exception {
    EmptyPasswordException() {}
    EmptyPasswordException(String message) {
        super(message);
    }
}
