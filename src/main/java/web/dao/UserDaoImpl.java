package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void updateUser(Long id, User user) {
        User userForUpdate = entityManager.find(User.class, id);
        userForUpdate.setName(user.getName());
        userForUpdate.setLastName(user.getLastName());
    }

    @Override
    public void deleteUser(Long id) {
        User userForRemove = showUser(id);
        entityManager.remove(userForRemove);
    }

    @Override
    public User showUser(Long id) {
        return entityManager.find(User.class, id);
    }
}
