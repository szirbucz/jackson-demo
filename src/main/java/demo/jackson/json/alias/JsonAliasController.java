package demo.jackson.json.alias;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alias")
public class JsonAliasController {

  @GetMapping
  public AliasDto translateDto(@RequestBody final AliasDto input) {
    return input;
  }
}
