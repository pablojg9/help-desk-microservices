package models.record.user;

import models.enums.ProfileEnum;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

public record UserResponseRecord(
  String id,
  String name,
  String email,
  Set<ProfileEnum> profiles) implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
}
