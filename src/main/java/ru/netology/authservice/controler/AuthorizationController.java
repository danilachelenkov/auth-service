package ru.netology.authservice.controler;

import org.springframework.web.bind.annotation.*;
import ru.netology.authservice.domain.Authorities;
import ru.netology.authservice.exception.InvalidCredentials;
import ru.netology.authservice.exception.UnauthorizedUser;
import ru.netology.authservice.service.AuthorizationService;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {

    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/auth")
    public List<Authorities> getAuthorities(@RequestParam("user") String user,
                                            @RequestParam("password") String password) {
        try {
            return service.getAuthorities(user, password);
        } catch (InvalidCredentials | UnauthorizedUser ex) {
            throw ex;
        }
    }
}
