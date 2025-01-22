package com.memelandia.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.memelandia.user.models.User;
import com.memelandia.user.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public User insertUser(User user) {
    existsByEmail(user.getEmail());
    return repository.save(user);
  }

  public List<User> getUsers() {
    return repository.findAll();
  }

  public void existsByEmail(String email) {
    if (repository.existsByEmail(email))
      throw new DataIntegrityViolationException("A user with this email already exists: " + email);
  }

  public Boolean existsById(Long id) {
    return repository.existsById(id);
  }
}
