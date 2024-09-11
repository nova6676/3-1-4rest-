package kata.pp.bootstrap.bootstrap.service;


import kata.pp.bootstrap.bootstrap.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();

    Role findById(Long id);

    Role findByName(String name);

    void addRole(Role role);
}
