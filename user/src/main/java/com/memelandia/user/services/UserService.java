package com.memelandia.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memelandia.user.models.User;
import com.memelandia.user.repositories.UserRepositorie;

@Service
public class UserService {

  @Autowired
  private UserRepositorie repositorie;

  public List<User> getUsers() {
    return repositorie.findAll();
  }

}
