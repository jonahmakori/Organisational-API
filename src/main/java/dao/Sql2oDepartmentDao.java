package dao;

import models.Department;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;


public class Sql2oDepartmentDao implements DepartmentDao{
    private final Sql2o sql2o;
    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Department department){
        String sql = "INSERT INTO departments (departmentName, description, numberOfEmployees) VALUES (:departmentName, :description, :numberOfEmployees);";
        try(Connection con = sql2o.open()){
            int departmentId = (int) con.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setDepartmentId(departmentId);
        } catch(Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Department> getAll(){
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM departments")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public Department findById(int departmentId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments WHERE departmentId = :departmentId")
                    .addParameter("departmentId", departmentId)
                    .executeAndFetchFirst(Department.class);
        }
    }


    @Override
    public void deleteById(int departmentId) {
        String sql = "DELETE from departments WHERE departmentId = :departmentId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("departmentId", departmentId)
                    .executeUpdate();

        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from departments";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void addDepartmentToNews(Department testDepartment, News firstNews) {

    }

    @Override
    public List<User> getUsers(int departmentId) {
        String sql = "SELECT * FROM users where departmentId=:departmentId";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public List<News> getNews(int departmentId) {
        String sql = "SELECT * FROM news where departmentId=:departmentId";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public void update(int departmentId, String departmentName, String description, int numberOfEmployees) {

    }
}
