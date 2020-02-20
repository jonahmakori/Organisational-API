package dao;

import models.Department;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oDepartmentDaoTest {
    private static Connection conn;
    private static Sql2oDepartmentDao departmentDao;
    private static Sql2oUserDao userDao;
    private static Sql2oNewsDao newsDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "jonah", "jonah1ma");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        departmentDao.clearAll();
        userDao.clearAll();
        newsDao.clearAll();
    }
    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
    }
    @Test
    public void addingDepartmentSetsId() throws Exception {
        Department testDepartment = setupNewDepartment();
        int originalDepartmentId = testDepartment.getDepartmentId();
        departmentDao.add(testDepartment);
        assertNotEquals(originalDepartmentId, testDepartment.getDepartmentId());
    }

    @Test
    public void getAll() throws Exception{
        Department testDepartment = new Department("accounting", "handles firm budget", 6);
        departmentDao.add(testDepartment);
        assertEquals(1, departmentDao.getAll().size());
    }

    @Test
    public void addedDepartmentsAreReturnedFromGetAll() throws Exception {
        Department testDepartment = setupNewDepartment();
        assertEquals(1, departmentDao.getAll().size());
    }
    @Test
    public void noDepartmentsReturnsEmptyList() throws Exception {
        assertEquals(0, departmentDao.getAll().size());
    }

//    @Test
//    public void findByIdReturnsCorrectDepartment() throws Exception {
//        Department testDepartment = setupNewDepartment();
//        Department otherDepartment = setupNewDepartment();
//        assertEquals(testDepartment, departmentDao.findById(otherDepartment.getDepartmentId()));
//    }


    @Test
    public void deleteByIdDeletesCorrectDepartment() throws Exception {
        Department testDepartment = setupNewDepartment();
        departmentDao.deleteById(testDepartment.getDepartmentId());
        assertEquals(0, departmentDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Department testDepartment = setupNewDepartment();
        Department otherDepartment = setupNewDepartment();
        departmentDao.clearAll();
        assertEquals(0, departmentDao.getAll().size());
    }

//    @Test
//    public void getAllUsersForADepartmentReturnsUsersCorrectly() {
//        Department testDepartment = new Department ("accounting", "handles company's finance", 5,1);
//        departmentDao.add(testDepartment);
//        int departmentId = testDepartment.getId();
//        News firstUser = new News("Corruption",  "Corruption is common in african countries",1);
//        userDao.add(firstUser);
//        News secondUser = new News("Sports",  "Football is the most watched sport",2);
//        userDao.add(secondUser);
//        News[] users = {firstUser, secondUser};
//        assertEquals(Arrays.asList(users), departmentDao.getUsers(testDepartment.getId()));
//    }

//    @Test
//    public void getAllNewsForADepartmentReturnsNewsCorrectly() throws Exception {
//        News firstNews = new News("Entertainment","Koroga festival wentdown in Nakuru","General News");
//        newsDao.add(firstNews);
//
//        News secondNews = new News("Weather", "Rains will be expected in northern parts of Kenya","Department News");
//        newsDao.add(secondNews);
//
//        Department testDepartment = setupNewDepartment();
//        departmentDao.add(testDepartment);
//        departmentDao.addDepartmentToNews(testDepartment,firstNews);
//        departmentDao.addDepartmentToNews(testDepartment,secondNews);
////        int departmentId = testDepartment.getDepartmentId();
//        News[] News = {firstNews, secondNews};
//        assertEquals(Arrays.asList(News), departmentDao.getNews(testDepartment.getDepartmentId()));
//    }

    public Department setupNewDepartment(){
        Department department = new Department("accounting", "handles company's finance", 5);
        departmentDao.add(department);
        return department;
    }
}