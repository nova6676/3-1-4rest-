package kata.pp.bootstrap.bootstrap.controller;


import kata.pp.bootstrap.bootstrap.dto.UserDTO;
import kata.pp.bootstrap.bootstrap.model.User;
import kata.pp.bootstrap.bootstrap.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/user/api")
public class UserRestController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<UserDTO> userInfo(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        UserDTO userDTO = toUserDTO(user);
        log.info("REST: {}", userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    private UserDTO toUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

}
