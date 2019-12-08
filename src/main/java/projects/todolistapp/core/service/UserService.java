package projects.todolistapp.core.service;

import projects.todolistapp.core.model.User;

public interface UserService {
    void saveUser(User user);

    User findByEmail(String email);
}