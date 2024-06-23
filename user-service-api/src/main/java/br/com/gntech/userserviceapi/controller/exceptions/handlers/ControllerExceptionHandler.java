package br.com.gntech.userserviceapi.controller.exceptions.handlers;

import jakarta.servlet.http.HttpServletRequest;
import models.exceptions.ResourceNotFoundException;
import models.exceptions.record.StandardErrorRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.Collection;
import java.util.Collections;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardErrorRecord> handleNotFoundException(final ResourceNotFoundException e, final HttpServletRequest request) {
    return buildResponse(Collections.singleton(e.getMessage()), request);
  }

  private ResponseEntity<StandardErrorRecord> buildResponse(final Collection<String> messages, final HttpServletRequest request) {
    StandardErrorRecord error = new StandardErrorRecord(
      Instant.now(),
      HttpStatus.NOT_FOUND.value(),
      messages,
      request.getRequestURI()
    );

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }
}
