package com.iscae.projetdevoir.models;

import java.util.List;

public class NormalUser implements User {

  private String type;
  private String username;
  private String password;
  private Account account;

  public NormalUser(String username, String password) {
    this.type = "NormalUser";
    this.username = username;
    this.password = password;
  }

  public String getType() {
    return type;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public boolean hasAccount() {
    return account != null;
  }
}
