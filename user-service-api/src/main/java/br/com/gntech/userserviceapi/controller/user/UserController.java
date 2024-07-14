package br.com.gntech.userserviceapi.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import models.exceptions.record.StandardErrorDTO;
import models.records.request.user.UserRequestRecord;
import models.records.response.user.UserResponseRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/users")
@Tag(name = "UserController", description = "Controller responsible for user operation")
public interface UserController {

  @Operation(summary = "Find user by Id")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "User found", content = @Content(schema = @Schema(implementation = UserResponseRecord.class))),
    @ApiResponse(responseCode = "404", description = "User not found", content = @Content(schema = @Schema(implementation = StandardErrorDTO.class))),
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
  })
  @GetMapping("/{id}")
  ResponseEntity<UserResponseRecord> findById(@Parameter(description = "parameter id to user", required = true, example = "667785dddb3e19505b1c4c94") @PathVariable final String id
  );

  @Operation(summary = "created user, required data in body")
  @PostMapping
  ResponseEntity<Void> saveUser(@Valid @RequestBody UserRequestRecord userRequestRecord);
}
