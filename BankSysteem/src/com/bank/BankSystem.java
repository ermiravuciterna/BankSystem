package com.bank;

import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bank System!");

        System.out.print("Enter bank name: ");
        String bankName = scanner.nextLine();
        System.out.print("Enter transaction flat fee amount: ");
        double flatFee = scanner.nextDouble();
        System.out.print("Enter transaction percent fee value: ");
        double percentFee = scanner.nextDouble();

        
        Bank bank = new Bank(bankName, flatFee, percentFee);

        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Create account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Perform flat fee transfer");
            System.out.println("5. Perform percent fee transfer");
            System.out.println("6. List accounts");
            System.out.println("7. Check account balance");
            System.out.println("8. List transactions for account");
            System.out.println("9. Check bank total transaction fee amount");
            System.out.println("10. Check bank total transfer amount");
            System.out.println("0. Exit");
            
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            
            try {
                switch (option) {
                    case 1:
                        System.out.print("Enter account ID: ");
                        String accountId = scanner.next();
                        System.out.print("Enter user name: ");
                        String userName = scanner.next();
                        System.out.print("Enter initial balance: ");
                        double initialBalance = scanner.nextDouble();
                        bank.createAccount(accountId, userName, initialBalance);
                        break;
                    case 2:
                        System.out.print("Enter account ID: ");
                        accountId = scanner.next();
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        bank.deposit(accountId, depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter account ID: ");
                        accountId = scanner.next();
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        bank.withdraw(accountId, withdrawalAmount);
                        break;
                    case 4:
                        System.out.print("Enter originating account ID: ");
                        String originatingAccountId = scanner.next();
                        System.out.print("Enter resulting account ID: ");
                        String resultingAccountId = scanner.next();
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = scanner.nextDouble();
                        Transaction flatFeeTransaction = new FlatFeeTransaction(transferAmount, originatingAccountId, resultingAccountId, "Transfer with flat fee");
                        bank.performTransaction(flatFeeTransaction);
                        break;
                    case 5:
                        System.out.print("Enter originating account ID: ");
                        originatingAccountId = scanner.next();
                        System.out.print("Enter resulting account ID: ");
                        resultingAccountId = scanner.next();
                        System.out.print("Enter transfer amount: ");
                        transferAmount = scanner.nextDouble();
                        Transaction percentFeeTransaction = new PercentFeeTransaction(transferAmount, originatingAccountId, resultingAccountId, "Transfer with percent fee");
                        bank.performTransaction(percentFeeTransaction);
                        break;
                    case 6:
                        bank.listAccounts();
                        break;
                    case 7:
                        System.out.print("Enter account ID: ");
                        accountId = scanner.next();
                        Account account = bank.findAccountById(accountId);
                        System.out.println("Account balance: " + account.getBalance());
                        break;
                    case 8:
                        System.out.print("Enter account ID: ");
                        accountId = scanner.next();
                        for (Transaction transaction : bank.getTransactionsForAccount(accountId)) {
                            System.out.println(transaction);
                        }
                        break;
                    case 9:
                        System.out.println("Total transaction fee amount: " + bank.getTotalTransactionFeeAmount());
                        break;
                    case 10:
                        System.out.println("Total transfer amount: " + bank.getTotalTransferAmount());
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (AccountNotFoundException | InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Bank System!");
    }
}
