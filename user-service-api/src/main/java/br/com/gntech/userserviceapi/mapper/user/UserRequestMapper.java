package br.com.gntech.userserviceapi.mapper.user;

import br.com.gntech.userserviceapi.config.mapper.MapperConfiguration;
import br.com.gntech.userserviceapi.entity.User;
import models.records.request.user.UserRequestRecord;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface UserRequestMapper {

  UserRequestRecord entityToDto(User user);

  User dtoToEntity(UserRequestRecord userRequestRecord);
}
