package springboot.boot2.service;


import springboot.boot2.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void createOreUpdateUser(User user);

    User getUser(long id);

    User deleteUser(long id);

}
