package com.company;

public class OrderAlreadyAddedException extends Exception {
    OrderAlreadyAddedException(String message) {
        super(message);
    }
}

