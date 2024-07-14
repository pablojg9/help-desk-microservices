package models.records.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.With;
import models.enums.ProfileEnum;

import java.util.Set;

@With
public record UserRequestRecord(

  @Schema(description = "user name", example = "Pablo Junior")
  @NotEmpty(message = "Name cannot be empty")
  @Size(min = 3, max = 50, message = "name must contain between 3 and 50 characters")
  String name,

  @Schema(description = "user email", example = "pablo@gmail.com")
  @Email(message = "the email is not valid")
  @Size(min = 6, max = 50)
  String email,

  @NotBlank(message = "password is not blank")
  String password,

  @Schema(description = "Users profiles", example = "[\"ROLE_ADMIN\", \"ROLE_CUSTOMER\"]")
  Set<ProfileEnum> profiles) {
}
