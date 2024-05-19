package com.bank;

public class DepositTransaction extends Transaction {
    public DepositTransaction(double amount, String accountId, String reason) {
        super(amount, accountId, null, reason);
    }

    @Override
    public double calculateFee(double flatFee, double percentFee) {
        return 0; 
    }
}

