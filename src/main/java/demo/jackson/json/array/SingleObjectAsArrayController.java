package demo.jackson.json.array;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("array")
public class SingleObjectAsArrayController {

  @PostMapping
  public UserWithTitles getUserWithTitles(@RequestBody final UserWithTitles user) {
    return user;
  }
}
