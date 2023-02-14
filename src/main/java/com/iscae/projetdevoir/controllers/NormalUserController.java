package com.iscae.projetdevoir.controllers;

import com.iscae.projetdevoir.models.User;
import com.iscae.projetdevoir.utils.DataStorage;

public class NormalUserController {

  DataStorage dataStorage = DataStorage.getInstance();

  public User login(String username, String password) {
    User user = dataStorage.loginUser(username, password);
    return user;
  }
}
