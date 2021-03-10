package demo.jackson.enums;

import java.util.stream.Stream;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum Side {

  FRONT("top"), BACK("bottom"), LEFT("left"), RIGHT("right"), NULL("");


  @JsonValue
  private String displayName;


  @JsonCreator
  public static Side of(final String displayName) {
    return Stream.of(values()).filter(s -> s.displayName.equals(displayName)).findAny()
        .orElse(NULL);
  }

}
