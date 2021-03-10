package demo.jackson.json.unwrap;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import demo.jackson.json.root.name.UserDto;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
@JsonDeserialize(builder = UserWrapper.UserWrapperBuilder.class)
public class UserWrapper {

  private final String password;

  @JsonUnwrapped
  private final UserDto user;

}
