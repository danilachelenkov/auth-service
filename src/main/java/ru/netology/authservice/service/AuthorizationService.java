package ru.netology.authservice.service;

import org.springframework.stereotype.Service;
import ru.netology.authservice.domain.Authorities;
import ru.netology.authservice.domain.User;
import ru.netology.authservice.exception.InvalidCredentials;
import ru.netology.authservice.exception.UnauthorizedUser;
import ru.netology.authservice.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getUser()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getUser(), user.getPassword());

        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
