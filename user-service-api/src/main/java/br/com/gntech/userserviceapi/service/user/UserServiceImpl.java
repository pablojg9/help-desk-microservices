package br.com.gntech.userserviceapi.service.user;

import br.com.gntech.userserviceapi.entity.User;
import br.com.gntech.userserviceapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public User findById(String id) {
    return userRepository.findById(id).orElseThrow(() -> new RuntimeException("not found was user"));
  }
}
