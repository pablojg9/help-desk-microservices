package br.com.gntech.userserviceapi.service.user;

import models.record.user.UserResponseRecord;

public interface UserService {

  UserResponseRecord findById(String id);
}
