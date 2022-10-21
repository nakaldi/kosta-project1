package com.thunderdragon.projectshop.exception;

public class OutOfStockException extends RuntimeException {

    public OutOfStockException(String message) {
        super(message);
    }
}
