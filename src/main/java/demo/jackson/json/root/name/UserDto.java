package demo.jackson.json.root.name;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
@JsonDeserialize(builder = UserDto.UserDtoBuilder.class)
@JsonRootName("User")
public class UserDto {
  private final String userId;
  private final String name;
  private final String email;
}
