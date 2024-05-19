package com.bank;

public class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction(double amount, String accountId, String reason) {
        super(amount, accountId, null, reason);
    }

    @Override
    public double calculateFee(double flatFee, double percentFee) {
        return flatFee; 
    }
}

