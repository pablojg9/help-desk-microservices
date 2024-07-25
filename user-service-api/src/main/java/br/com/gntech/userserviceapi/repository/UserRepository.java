package br.com.gntech.userserviceapi.repository;

import br.com.gntech.userserviceapi.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

  Optional<User> findByEmail(String email);
}
