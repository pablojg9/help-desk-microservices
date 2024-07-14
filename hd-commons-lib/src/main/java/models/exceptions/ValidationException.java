package models.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import models.exceptions.record.StandardErrorDTO;

import java.util.List;

@Getter
@SuperBuilder
public class ValidationException extends StandardErrorDTO {

  private List<FieldError> errors;

  @Getter
  @AllArgsConstructor
  private static class FieldError {
    private String fieldName;
    private String message;
  }

  public void addError(final String fieldName, final String message) {
    errors.add(new FieldError(fieldName, message));
  }
}
