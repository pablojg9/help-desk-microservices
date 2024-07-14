package br.com.gntech.userserviceapi.service.user;

import models.records.request.user.UserRequestRecord;
import models.records.response.user.UserResponseRecord;

public interface UserService {

  UserResponseRecord findById(String id);

  void save(UserRequestRecord user);
}
