package br.com.gntech.userserviceapi.controller.user;

import br.com.gntech.userserviceapi.entity.User;
import models.record.user.UserResponseRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/users")
public interface UserController {

  @GetMapping("/{id}")
  ResponseEntity<UserResponseRecord> findById(@PathVariable final String id);
}
