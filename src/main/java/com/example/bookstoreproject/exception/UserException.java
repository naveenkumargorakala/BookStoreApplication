package com.example.bookstoreproject.exception;

public class UserException extends RuntimeException{
    private String message;

    public UserException(String message) {
        super(message);
        this.message =message;
    }
}
