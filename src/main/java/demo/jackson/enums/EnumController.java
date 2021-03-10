package demo.jackson.enums;

import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enum")
public class EnumController {

  @GetMapping
  public DtoWithEnum getEnum() {
    return new DtoWithEnum(Side.FRONT);
  }

  @PostMapping
  public String getDimension(@RequestBody final DtoWithEnum dto) {
    final Set<ConstraintViolation<@Valid DtoWithEnum>> validate = validate(dto);
    if (validate.isEmpty()) {
      return Set.of(Side.FRONT, Side.BACK).contains(dto.getSide()) ? "horizontal" : "vertical";
    }
    return validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", "));
  }

  private Set<ConstraintViolation<@Valid DtoWithEnum>> validate(final DtoWithEnum dto) {
    return Validation.buildDefaultValidatorFactory().getValidator().validate(dto);
  }
}
