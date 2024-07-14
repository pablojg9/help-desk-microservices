package models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ProfileEnum {

  ROLE_ADMIN("ROLE_ADMIN"),
  ROLE__CUSTOMER("ROLE_CUSTOMER"),
  ROLE_TECHNICIAN("ROLE_TECHNICIAN");

  private final String description;

  public static ProfileEnum getEnum(final String description) {
    return Arrays.stream(ProfileEnum.values())
      .filter(profileEnum -> profileEnum.getDescription().equals(description))
      .findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid description" + description));
  }
}
