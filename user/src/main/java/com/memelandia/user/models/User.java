package com.memelandia.user.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Setter(value = lombok.AccessLevel.NONE)
  private Long id;

  @Column(nullable = false)
  @NotBlank(message = "name of user is Required")
  private String name;

  @Column(nullable = false)
  @NotBlank(message = "email of user is Required")
  private String email;

  @Column(nullable = false)
  @CreationTimestamp
  @Setter(value = lombok.AccessLevel.NONE)
  private Date registerDate;
}
