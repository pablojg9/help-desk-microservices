package br.com.gntech.userserviceapi.repository;

import br.com.gntech.userserviceapi.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
