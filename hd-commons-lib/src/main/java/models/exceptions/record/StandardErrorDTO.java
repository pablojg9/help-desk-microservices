package models.exceptions.record;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.Collection;

@Getter
@SuperBuilder
public class StandardErrorDTO {
  private Instant timestamp;
  private Integer status;
  private Collection<String> error;
  private String path;
}
