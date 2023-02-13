package com.iscae.projetdevoir.utils;

import com.iscae.projetdevoir.models.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStorage {

  private static DataStorage instance;
  private Map<String, User> users;

  private DataStorage() {
    users = new HashMap<>();
    User admin = new Admin("admin", "password");
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
    if (user.getPassword() == password) {
      return user;
    } else {
      return null;
    }
  }
}
