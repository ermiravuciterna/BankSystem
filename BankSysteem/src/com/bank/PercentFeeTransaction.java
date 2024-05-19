package com.bank;

public class PercentFeeTransaction extends Transaction {
    public PercentFeeTransaction(double amount, String originatingAccountId, String resultingAccountId, String reason) {
        super(amount, originatingAccountId, resultingAccountId, reason);
    }

    @Override
    public double calculateFee(double flatFeeAmount, double percentFeeValue) {
        return (amount * percentFeeValue) / 100.0; 
    }
}

