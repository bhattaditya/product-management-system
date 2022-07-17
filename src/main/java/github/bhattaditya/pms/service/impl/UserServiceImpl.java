package github.bhattaditya.pms.service.impl;

import github.bhattaditya.pms.entity.User;
import github.bhattaditya.pms.repository.UserRepo;
import github.bhattaditya.pms.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {

        return this.userRepo.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        User user = this.userRepo.findByUsername(username);

        return user;
    }
}
