package com.bank;

import java.io.Serializable;

public class AccountNotFoundException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    public AccountNotFoundException(String message) {
        super(message);
    }
}