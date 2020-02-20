package dao;

import models.Department;
import models.News;
import models.User;

import java.util.List;

public interface DepartmentDao {

    void add (Department department);

    List<Department> getAll();
    Department findById(int departmentId);
    List<User> getUsers(int departmentId);
    List<News> getNews(int departmentId);

    //update
    void update(int departmentId, String departmentName, String description, int numberOfEmployees);

    //delete
    void deleteById(int departmentId);
    void clearAll();

    void addDepartmentToNews(Department testDepartment, News firstNews);
}
