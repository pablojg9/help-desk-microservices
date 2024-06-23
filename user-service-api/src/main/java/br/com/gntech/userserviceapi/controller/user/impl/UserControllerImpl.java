package br.com.gntech.userserviceapi.controller.user.impl;

import br.com.gntech.userserviceapi.controller.user.UserController;
import br.com.gntech.userserviceapi.entity.User;
import br.com.gntech.userserviceapi.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

  private final UserService userService;

  @Override
  public ResponseEntity<User> findById(String id) {
    return ResponseEntity.ok().body(userService.findById(id));
  }
}
