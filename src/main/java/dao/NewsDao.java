package dao;

import models.News;
import models.User;

import java.util.List;

public interface NewsDao {
    void add(News news);

    List<News> getAll();
    News findById(int id);
    List<News> getAllNewsByDepartment(int departmentId);
    void update(int id, String departmentName, String description, int numberOfEmployees);

    void deleteById(int id);
    void clearAll();

    void add(User testUser);
}
