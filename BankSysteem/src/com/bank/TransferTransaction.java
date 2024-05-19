package com.bank;

public abstract class TransferTransaction extends Transaction {
    public TransferTransaction(double amount, String originatingAccountId, String resultingAccountId, String reason) {
        super(amount, originatingAccountId, resultingAccountId, reason);
    }
}
