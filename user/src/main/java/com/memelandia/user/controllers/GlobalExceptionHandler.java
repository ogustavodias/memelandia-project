package com.memelandia.user.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> handleValidationMethodArgumentExceptions(MethodArgumentNotValidException ex) {
    StringBuilder errorMessage = new StringBuilder("Validation failed: ");

    for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
      errorMessage.append(fieldError.getDefaultMessage()).append("; ");
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.toString());
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<String> handleValidationDataIntegrityExpections(DataIntegrityViolationException ex) {
    StringBuilder errorMessage = new StringBuilder("Validation failed: ").append(ex.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage.toString());
  }

}
