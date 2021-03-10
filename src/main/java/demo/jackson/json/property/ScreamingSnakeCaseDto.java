package demo.jackson.json.property;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
@JsonDeserialize(builder = ScreamingSnakeCaseDto.ScreamingSnakeCaseDtoBuilder.class)
public class ScreamingSnakeCaseDto {

  @JsonProperty("SNAKE_SAYS")
  private final String snakeSays;
}
