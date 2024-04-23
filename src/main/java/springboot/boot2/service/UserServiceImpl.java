package springboot.boot2.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import springboot.boot2.daoRepo.UserDao;
import springboot.boot2.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao daoRepo;

    public UserServiceImpl(UserDao daoRepo) {
        this.daoRepo = daoRepo;
    }

    @Override

    @Transactional
    public List<User> getAllUsers() {
        return daoRepo.getAllUsers();
    }

    @Transactional
    public void createUser(User user) {
        daoRepo.createUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        daoRepo.updateUser(user);
    }

    @Override
    @Transactional
    public void createOreUpdateUser(User user) {
        if (0 == user.getId()) {
            createUser(user);
        } else {
            updateUser(user);
        }
    }

    @Override
    @Transactional
    public User getUser(long id) {
        return daoRepo.getUser(id);
    }

    @Override
    @Transactional
    public User deleteUser(long id) {
        daoRepo.deleteUser(id);
        return new User();
    }

}
