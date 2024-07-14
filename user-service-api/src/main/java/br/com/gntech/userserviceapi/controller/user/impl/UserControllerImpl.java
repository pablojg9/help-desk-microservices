package br.com.gntech.userserviceapi.controller.user.impl;

import br.com.gntech.userserviceapi.controller.user.UserController;
import br.com.gntech.userserviceapi.service.user.UserService;
import lombok.RequiredArgsConstructor;
import models.records.request.user.UserRequestRecord;
import models.records.response.user.UserResponseRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

  private final UserService userService;

  @Override
  public ResponseEntity<UserResponseRecord> findById(String id) {
    return ResponseEntity.ok().body(userService.findById(id));
  }

  @Override
  public ResponseEntity<Void> saveUser(UserRequestRecord userRequestRecord) {
    userService.save(userRequestRecord);
    return ResponseEntity.status(HttpStatus.CREATED.value()).build();
  }
}
