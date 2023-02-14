package com.iscae.projetdevoir.models;

import java.util.HashMap;
import java.util.Map;

public class TransferService {

    private String name;
    private Map<String, Transfer> transfers;
    private Responsible responsible;

    public TransferService(String name) {
        this.name = name;
        this.transfers = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Transfer> getTransfers() {
        return transfers;
    }

    public Transfer getTransfer(String transferID) {
        return transfers.get(transferID);
    }

    public void addTransfer(Transfer transfer) {
        this.transfers.put(transfer.getTransferNumber(), transfer);
    }

    public void removeTransfer(String transferID) {
        this.transfers.remove(transferID);
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }
}
