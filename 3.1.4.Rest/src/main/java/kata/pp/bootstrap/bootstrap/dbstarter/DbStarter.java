package kata.pp.bootstrap.bootstrap.dbstarter;

import jakarta.annotation.PostConstruct;
import kata.pp.bootstrap.bootstrap.model.Role;
import kata.pp.bootstrap.bootstrap.model.User;
import kata.pp.bootstrap.bootstrap.service.RoleService;
import kata.pp.bootstrap.bootstrap.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class DbStarter {
    private final UserService userService;
    private final RoleService roleService;

    @PostConstruct
    public void init() {
        Role admin = new Role();
        Role user = new Role();
        admin.setName("ROLE_ADMIN");
        user.setName("ROLE_USER");
        roleService.addRole(admin);
        roleService.addRole(user);
        userService.save(new User("admin",
                "admin@admin.com",
                "111111",
                Set.of(admin)));
        userService.save(new User("user",
                "user@user.com",
                "qwerty",
                Set.of(user)));
        log.info("DB initialized");
    }
}