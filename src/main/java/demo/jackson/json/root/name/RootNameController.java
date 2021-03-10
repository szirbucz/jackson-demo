package demo.jackson.json.root.name;

import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
@RequestMapping("/root-name")
public class RootNameController {

  @GetMapping(produces = "application/json")
  public String getUser() throws JsonProcessingException {
    return getObjectMapper().writeValueAsString(
        UserDto.builder()
            .withUserId(UUID.randomUUID().toString())
            .withEmail("george.soros@osf.org")
            .withName("George Soros")
            .build());
  }

  @PostMapping
  public String greetUser(@RequestBody final String user)
      throws JsonMappingException, JsonProcessingException {
    final String name = getObjectMapper().readValue(user, UserDto.class).getName();
    return String.format("Hi %s!", name);
  }

  private ObjectMapper getObjectMapper() {
    return new ObjectMapper()
        .configure(SerializationFeature.WRAP_ROOT_VALUE, true)
        .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }
}
