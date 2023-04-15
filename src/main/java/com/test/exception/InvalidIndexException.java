package com.test.exception;

public class InvalidIndexException extends Exception {
    public InvalidIndexException() {
        super("Index out given bound");
    }
}
