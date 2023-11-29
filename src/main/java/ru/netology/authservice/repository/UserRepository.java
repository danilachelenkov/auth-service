package ru.netology.authservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authservice.domain.Authorities;
import ru.netology.authservice.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private Map<User, List<Authorities>> authInMemory;

    public UserRepository() {
        authInMemory = new HashMap<>();
        authInMemory = Map.of(
                new User("Ivan", "1234"), List.of(Authorities.READ),
                new User("Svetlana", "777"), List.of(Authorities.READ, Authorities.WRITE),
                new User("Goga", "777"), List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)
        );

    }

    public List<Authorities> getUserAuthorities(String login, String password) {
        User user = new User(login, password);
        if (authInMemory.containsKey(user)) {
            return authInMemory.get(user);
        } else {
            return null;
        }
    }
}
