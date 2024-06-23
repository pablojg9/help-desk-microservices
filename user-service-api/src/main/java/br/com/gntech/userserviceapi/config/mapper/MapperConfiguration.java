package br.com.gntech.userserviceapi.config.mapper;

import org.mapstruct.Builder;
import org.mapstruct.MapperConfig;

import static org.mapstruct.ReportingPolicy.IGNORE;

@MapperConfig(componentModel = "spring", unmappedSourcePolicy = IGNORE, builder = @Builder(disableBuilder = true))
public interface MapperConfiguration {
}
