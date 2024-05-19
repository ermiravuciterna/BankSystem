package com.bank;

import java.io.Serializable;

public class InsufficientFundsException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    public InsufficientFundsException(String message) {
        super(message);
    }
}