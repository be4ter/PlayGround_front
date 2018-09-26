package com.playground.exception;

public class UnableLoginException extends RuntimeException {
    public UnableLoginException(String message) {
        super(message);
    }
}
