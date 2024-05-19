package com.bank;

public class FlatFeeTransaction extends Transaction {
    public FlatFeeTransaction(double amount, String originatingAccountId, String resultingAccountId, String reason) {
        super(amount, originatingAccountId, resultingAccountId, reason);
    }

    @Override
    public double calculateFee(double flatFeeAmount, double percentFeeValue) {
        return flatFeeAmount; 
    }
}
