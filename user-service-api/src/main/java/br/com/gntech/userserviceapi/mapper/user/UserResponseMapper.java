package br.com.gntech.userserviceapi.mapper.user;

import br.com.gntech.userserviceapi.config.mapper.MapperConfiguration;
import br.com.gntech.userserviceapi.entity.User;
import models.records.response.user.UserResponseRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(config = MapperConfiguration.class,
  nullValuePropertyMappingStrategy = IGNORE,
  nullValueCheckStrategy = ALWAYS
)
public interface UserResponseMapper {

  UserResponseRecord entityToDto(final User user);

  @Mapping(target = "password", ignore = true)
  User dtoToEntity(final UserResponseRecord userResponseRecord);
}
