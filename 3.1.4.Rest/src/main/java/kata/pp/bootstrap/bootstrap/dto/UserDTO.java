package kata.pp.bootstrap.bootstrap.dto;

import kata.pp.bootstrap.bootstrap.model.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {

    Long id;
    String username;
    String email;
    String password;
    Set<Role> roles;

}
