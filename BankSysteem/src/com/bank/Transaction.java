package com.bank;

public abstract class Transaction {
    protected double amount;
    protected String originatingAccountId;
    protected String resultingAccountId;
    protected String reason;

    public Transaction(double amount, String originatingAccountId, String resultingAccountId, String reason) {
        this.amount = amount;
        this.originatingAccountId = originatingAccountId;
        this.resultingAccountId = resultingAccountId;
        this.reason = reason;
    }

    public double getAmount() {
        return amount;
    }

    public String getOriginatingAccountId() {
        return originatingAccountId;
    }

    public String getResultingAccountId() {
        return resultingAccountId;
    }

    public String getReason() {
        return reason;
    }

    
    public abstract double calculateFee(double flatFeeAmount, double percentFeeValue);
}

