package demo.jackson.json.alias;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class AliasDto {

  @JsonAlias({"name", "user", "userId"})
  private String userName;

  private String title;
}
