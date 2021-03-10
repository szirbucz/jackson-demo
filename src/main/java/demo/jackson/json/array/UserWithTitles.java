package demo.jackson.json.array;

import java.util.Set;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
@JsonDeserialize(builder = UserWithTitles.UserWithTitlesBuilder.class)
public class UserWithTitles {

  private final String name;

  private final Set<String> titles;

}
