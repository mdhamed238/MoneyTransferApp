package com.iscae.projetdevoir.models;

import com.iscae.projetdevoir.utils.Rand;

public class Account {

    private String accountNumber;
    private double balance;
    private TransferService transferService;

    public Account(TransferService transferService) {
        this.accountNumber = Rand.generateRandomNumber("account#");
        this.balance = 0;
        this.transferService = transferService;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public TransferService getTransferService() {
        return transferService;
    }

    public void setTransferService(TransferService transferService) {
        this.transferService = transferService;
    }

    public void credit(double amount) {
        this.balance += amount;
    }

    public void transfer(Account recipientAccount, double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            recipientAccount.credit(amount);
        } else {
            return;
        }
    }
}
