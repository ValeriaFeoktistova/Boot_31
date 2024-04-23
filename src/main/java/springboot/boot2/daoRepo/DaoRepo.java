package springboot.boot2.daoRepo;

import springboot.boot2.model.User;

import java.util.List;

public interface DaoRepo {
    List<User> getAllUsers();

    void createUser(User user);

    public void updateUser(User user);

    void deleteUser(long id);

    User getUser(long id);
}

