package br.com.gntech.userserviceapi.service.user;

import br.com.gntech.userserviceapi.entity.User;
import br.com.gntech.userserviceapi.mapper.user.UserResponseMapper;
import br.com.gntech.userserviceapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import models.record.user.UserResponseRecord;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserResponseMapper userResponseMapper;

  @Override
  public UserResponseRecord findById(String id) {
    User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("not found was user"));
    return userResponseMapper.entityToDto(user);
  }
}
