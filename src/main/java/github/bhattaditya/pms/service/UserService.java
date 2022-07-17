package github.bhattaditya.pms.service;

import github.bhattaditya.pms.entity.User;

public interface UserService {
    User saveUser(User user);
    User getUserByUsername(String username);
}
