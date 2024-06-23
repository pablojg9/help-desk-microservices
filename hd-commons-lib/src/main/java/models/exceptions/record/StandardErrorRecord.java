package models.exceptions.record;

import java.time.Instant;
import java.util.Collection;

public record StandardErrorRecord(
  Instant timestamp,
  Integer status,
  Collection<String> error,
  String path
) {
}
