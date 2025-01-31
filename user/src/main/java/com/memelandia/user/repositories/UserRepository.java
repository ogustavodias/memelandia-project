package com.memelandia.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memelandia.user.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

  boolean existsByEmail(String email);

}
