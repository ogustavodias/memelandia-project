package com.memelandia.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memelandia.user.models.User;
import com.memelandia.user.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/users")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping
  public ResponseEntity<User> insertUser(@RequestBody @Valid User user) {
    service.insertUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }

  @GetMapping
  public ResponseEntity<List<User>> getUsers() {
    List<User> users = service.getUsers();
    return ResponseEntity.status(HttpStatus.OK).body(users);
  }

  @GetMapping(params = "id")
  public ResponseEntity<Boolean> existsById(@RequestParam @Valid Long id) {
    Boolean exists = service.existsById(id);

    if (exists)
      return ResponseEntity.status(HttpStatus.OK).body(exists);

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exists);
  }

}
