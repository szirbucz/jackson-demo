package demo.jackson.enums;

import javax.validation.constraints.AssertTrue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoWithEnum {

  private Side side;

  @AssertTrue(message = "Invalid value for Side.")
  private boolean hasSide() {
    return !Side.NULL.equals(side);
  }

}
