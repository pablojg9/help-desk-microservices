package br.com.gntech.userserviceapi.service.user;

import br.com.gntech.userserviceapi.entity.User;

public interface UserService {

  User findById(String id);
}
