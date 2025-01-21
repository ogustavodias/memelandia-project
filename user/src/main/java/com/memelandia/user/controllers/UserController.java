package com.memelandia.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    StringBuilder errorMessage = new StringBuilder("Validation failed: ");

    for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
      errorMessage.append(fieldError.getDefaultMessage()).append("; ");
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.toString());
  }

}
