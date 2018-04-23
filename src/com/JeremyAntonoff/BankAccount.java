package com.JeremyAntonoff;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private String accountNumber;
    public ReentrantLock lock;

    public BankAccount(String accountNumber, double initialBalance, ReentrantLock lock) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = lock;
    }

    public void deposit(double amount) {
        balance+= amount;
        System.out.println("Deposited " + amount + ". New balance is " + balance);
    }

    public void withdraw(double amount) {
        balance-= amount;
        System.out.println("Withdrew " + amount + ". New balance is " + balance);

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number is: " + accountNumber);
    }
}
