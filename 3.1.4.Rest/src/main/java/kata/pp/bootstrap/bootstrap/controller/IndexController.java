package kata.pp.bootstrap.bootstrap.controller;

import kata.pp.bootstrap.bootstrap.model.User;
import kata.pp.bootstrap.bootstrap.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Controller
@RequestMapping("/")
public class IndexController {
    private final UserService userService;


    @GetMapping("")
    public String showUsers(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        if (user.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList())
                .contains("ROLE_ADMIN")) {
            model.addAttribute("page", "PAGE_ADMIN");
            log.info("Redirecting to PAGE_ADMIN: {}", user);
            return "redirect:/admin";
        } else {
            model.addAttribute("page", "PAGE_USER");
            log.info("Redirecting to PAGE_USER: {}", user);
            return "redirect:/user";
        }
    }
}

