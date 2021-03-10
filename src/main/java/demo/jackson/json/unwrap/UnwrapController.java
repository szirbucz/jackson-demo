package demo.jackson.json.unwrap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.jackson.json.root.name.UserDto;


@RestController
@RequestMapping("/unwrap")
public class UnwrapController {

  @PostMapping
  public UserWrapper wrapUser(@RequestBody final UserDto user) {
    return UserWrapper.builder()
        .withUser(user)
        .withPassword("ChangeMe123")
        .build();
  }
}
