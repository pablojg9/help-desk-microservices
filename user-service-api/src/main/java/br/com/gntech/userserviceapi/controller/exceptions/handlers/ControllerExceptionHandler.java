package br.com.gntech.userserviceapi.controller.exceptions.handlers;

import jakarta.servlet.http.HttpServletRequest;
import models.exceptions.ResourceNotFoundException;
import models.exceptions.ValidationException;
import models.exceptions.record.StandardErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardErrorDTO> handleNotFoundException(final ResourceNotFoundException e, final HttpServletRequest request) {
    return buildResponse(Collections.singleton(e.getMessage()), request);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationException> handleMethodArgumentNotValidException(final MethodArgumentNotValidException e, final HttpServletRequest request) {

    ValidationException validationException = ValidationException.builder()
      .timestamp(Instant.now())
      .status(HttpStatus.BAD_REQUEST.value())
      .error(Collections.singleton("Validation Exception"))
      .path(request.getRequestURI())
      .errors(new ArrayList<>())
      .build();

    e.getBindingResult().getFieldErrors().forEach(x -> validationException.addError(x.getField(), x.getDefaultMessage()));


    return ResponseEntity.badRequest().body(validationException);
  }

  private ResponseEntity<StandardErrorDTO> buildResponse(final Collection<String> messages, final HttpServletRequest request) {
    StandardErrorDTO error = StandardErrorDTO.builder()
      .timestamp(Instant.now())
      .status(HttpStatus.NOT_FOUND.value())
      .error(messages)
      .path(request.getRequestURI())
      .build();
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }
}
