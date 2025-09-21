package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class UserRepository {
    private final Map<Long, User> users = new HashMap<>();

    public UserRepository() {
        users.put(1L, new User(1L, "siva", "siva@example.com"));
        users.put(2L, new User(2L, "Bob", "bob@example.com"));
    }

    public List<User> findAll() { return new ArrayList<>(users.values()); }

    public Optional<User> findById(Long id) { return Optional.ofNullable(users.get(id)); }

    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public void delete(Long id) { users.remove(id); }
}
