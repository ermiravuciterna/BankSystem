package com.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private String bankName;
    private List<Account> accounts;
    private double totalTransactionFeeAmount;
    private double totalTransferAmount;
    private double transactionFlatFeeAmount;
    private double transactionPercentFeeValue;

    public Bank(String bankName, double transactionFlatFeeAmount, double transactionPercentFeeValue) {
    	this.bankName = bankName;
        this.accounts = new ArrayList<>();
        this.totalTransactionFeeAmount = 0;
        this.totalTransferAmount = 0;
        this.transactionFlatFeeAmount = transactionFlatFeeAmount;
        this.transactionPercentFeeValue = transactionPercentFeeValue;
    }
    
    public String getBankName() {
        return bankName;
    }
    
    

    public void createAccount(String accountId, String userName, double initialBalance) {
        Account account = new Account(accountId, userName, initialBalance);
        accounts.add(account);
    }

    public Account findAccountById(String accountId) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account with ID " + accountId + " not found.");
    }

    public void deposit(String accountId, double amount) throws AccountNotFoundException {
        Account account = findAccountById(accountId);
        account.deposit(amount);
    }

    public void withdraw(String accountId, double amount) throws AccountNotFoundException, InsufficientFundsException {
        Account account = findAccountById(accountId);
        account.withdraw(amount);
    }

    public void performTransaction(Transaction transaction) throws AccountNotFoundException, InsufficientFundsException {
        String originatingAccountId = transaction.getOriginatingAccountId();
        if (originatingAccountId == null) {
            throw new IllegalArgumentException("Originating account ID cannot be null.");
        }

        Account originatingAccount = findAccountById(originatingAccountId);
        Account resultingAccount = null;
        String resultingAccountId = transaction.getResultingAccountId();
        if (resultingAccountId != null) {
            resultingAccount = findAccountById(resultingAccountId);
        }

        
        double fee = transaction.calculateFee(transactionFlatFeeAmount, transactionPercentFeeValue);
        totalTransactionFeeAmount += fee;

        
        if (resultingAccount != null) {
            totalTransferAmount += transaction.getAmount();
            originatingAccount.withdraw(transaction.getAmount() + fee);
            resultingAccount.deposit(transaction.getAmount());
        } else {
            if (transaction instanceof DepositTransaction) {
                originatingAccount.deposit(transaction.getAmount());
            } else if (transaction instanceof WithdrawalTransaction) {
                originatingAccount.withdraw(transaction.getAmount() + fee);
            }
        }
    }




    public List<Transaction> getTransactionsForAccount(String accountId) throws AccountNotFoundException {
        Account account = findAccountById(accountId);
        return account.getTransactions();
    }

    public void listAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public double getTotalTransactionFeeAmount() {
        return totalTransactionFeeAmount;
    }

    public double getTotalTransferAmount() {
        return totalTransferAmount;
    }
}
