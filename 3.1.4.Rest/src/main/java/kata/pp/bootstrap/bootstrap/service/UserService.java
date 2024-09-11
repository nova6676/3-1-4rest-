package kata.pp.bootstrap.bootstrap.service;


import kata.pp.bootstrap.bootstrap.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User findById(Long id);

    void save(User user);

    void update(User user);

    void deleteById(Long id);

    User findByUsername(String username);
}
