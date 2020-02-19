package dao;

import models.News;
import models.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> getAll();
    User findById(int id);
    List<User> getAllUsersByDepartment(int departmentId);
    void update(int id, String departmentName, String description, int numberOfEmployees);

    void deleteById(int id);
    void clearAll();

    void add(News firstUser);
}
