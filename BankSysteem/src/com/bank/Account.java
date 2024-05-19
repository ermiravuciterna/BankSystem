package com.bank;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountId;
    private String userName;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountId, String userName, double balance) {
        this.accountId = accountId;
        this.userName = userName;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public String getUserName() {
        return userName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new DepositTransaction(amount, accountId, "Deposit"));
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds in account " + accountId);
        }
        balance -= amount;
        transactions.add(new WithdrawalTransaction(amount, accountId, "Withdrawal"));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", userName='" + userName + '\'' +
                ", balance=" + balance +
                '}';
    }
}

