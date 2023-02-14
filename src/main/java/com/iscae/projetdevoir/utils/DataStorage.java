package com.iscae.projetdevoir.utils;

import com.iscae.projetdevoir.models.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStorage {

  private static DataStorage instance;
  private Map<String, User> users;
  private Map<String, TransferService> transferServices;
  private Map<String, Account> accounts;

  private DataStorage() {
    users = new HashMap<>();
    accounts = new HashMap<>();
    transferServices = new HashMap<>();

    // Create a default user
    User admin = new Admin("admin", "admin");
    users.put(admin.getUsername(), admin);
  }

  public static DataStorage getInstance() {
    if (instance == null) {
      instance = new DataStorage();
    }
    return instance;
  }

  public Map<String, User> getUsers() {
    return users;
  }

  public void addUser(User user) {
    users.put(user.getUsername(), user);
  }

  public User getUser(String username) {
    return users.get(username);
  }

  public void updateUser(User user) {
    users.put(user.getUsername(), user);
  }
  public User loginUser(String username, String password) {
    User user = getUser(username);

    if(user == null)
      return null;

    if (user.getPassword().equals(password)) {
      return user;
    } else {
      return null;
    }
  }

  public Map<String, TransferService> getTransferServices() {
    return transferServices;
  }

  public Map<String, Account> getAccounts() {
    return accounts;
  }


  public void addTransferService(TransferService transferService) {
    transferServices.put(transferService.getName(), transferService);
  }

  public void addAccount(Account account) {
    accounts.put(account.getAccountNumber(), account);
  }

  public TransferService getTransferService(String transferServiceName) {
    return transferServices.get(transferServiceName);
  }

  public Account getAccount(String accountNumber) {
    return accounts.get(accountNumber);
  }

  public void changePassword(String username, String newPassword) {
    getUser(username).setPassword(newPassword);
  }

  public Map<String, Transfer> getTransfers() {
    Map<String, TransferService> transferServices = getTransferServices();
    Map<String, Transfer> transfers = new HashMap<>();

    for (TransferService transferService : transferServices.values()) {
      transfers.putAll(transferService.getTransfers());
    }

    return transfers;
  }
}
