package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    List<User> getUsers();

    void updateUser(Long id, User user);

    void deleteUser(Long id);

    User showUser(Long id);
}
