package demo.jackson.json.property;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
public class PropertyController {

  @GetMapping
  public ScreamingSnakeCaseDto getScreamingSnakeCaseDto() {
    return ScreamingSnakeCaseDto.builder()
        .withSnakeSays("ÁÁÁÁÁÁÁÁÁÁÁÁÁÁ")
        .build();
  }

  @PostMapping
  public String snakeSays(@RequestBody final ScreamingSnakeCaseDto dto) {
    return String.format("The snake said %s.", dto.getSnakeSays());
  }
}
