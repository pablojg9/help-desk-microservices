package br.com.gntech.userserviceapi.mapper.user;

import br.com.gntech.userserviceapi.config.mapper.MapperConfiguration;
import br.com.gntech.userserviceapi.entity.User;
import models.record.user.UserResponseRecord;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(config = MapperConfiguration.class,
  nullValuePropertyMappingStrategy = IGNORE,
  nullValueCheckStrategy = ALWAYS
)
public interface UserResponseMapper {

  UserResponseRecord entityToDto(final User user);

  User dtoToEntity(final UserResponseRecord userResponseRecord);
}
