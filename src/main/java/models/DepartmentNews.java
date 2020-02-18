package models;

import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class DepartmentNews extends News {
    public DepartmentNews(String content) {
        super(content);
    }

    public DepartmentNews(String content, int departmentId) {
        super(content, departmentId);
    }
}
