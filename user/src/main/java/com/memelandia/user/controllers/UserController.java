package com.memelandia.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memelandia.user.models.User;
import com.memelandia.user.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping
  public List<User> getUsers() {
    return service.getUsers();
  }

}
