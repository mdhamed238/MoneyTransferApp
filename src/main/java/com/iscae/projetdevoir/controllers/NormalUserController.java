package com.iscae.projetdevoir.controllers;

import com.iscae.projetdevoir.models.Account;
import com.iscae.projetdevoir.models.NormalUser;
import com.iscae.projetdevoir.models.TransferService;
import com.iscae.projetdevoir.models.User;
import com.iscae.projetdevoir.utils.DataStorage;

public class NormalUserController {

  DataStorage dataStorage = DataStorage.getInstance();

  public User login(String username, String password) {
    User user = dataStorage.loginUser(username, password);
    return user;
  }

  public void createAccount(NormalUser user, TransferService transferService) {
    Account account = new Account(transferService);

    user.setAccount(account);
    dataStorage.addAccount(account);
  }



  public void creditAccount(Account account, double creditAmount) {
    account.credit(creditAmount);
    dataStorage.updateAccount(account);
  }

  public void transferMoney(
          Account senderAccount,
          Account recipientAccount,
          double amount
  ) {
    senderAccount.transfer(recipientAccount, amount);
  }
}
