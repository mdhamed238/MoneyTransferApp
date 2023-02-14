package com.iscae.projetdevoir.models;

import com.iscae.projetdevoir.utils.Rand;
import java.util.Date;

public class Transfer {

    private String transferNumber;
    private Account sourceAccount;
    private Account destinationAccount;
    private double amount;
    private Date date;
    private Status status;

    public Transfer(
            Account sourceAccount,
            Account destinationAccount,
            double amount
    ) {
        this.transferNumber = Rand.generateRandomNumber("transfer#");
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.date = new Date();
        this.status = Status.PENDING;
    }

    public String getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(String transferNumber) {
        this.transferNumber = transferNumber;
    }

    // Getters and Setters
    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status.name();
    }

    public void setStatus(Status status) {
        if (!(this.status.name() == "PENDING")) return;

        this.status = status;
    }
}
