package models;

import java.util.Objects;

public class User {
    private int id;
    private String userName;
    private String positionLevel;
    private String role;
    private int departmentId;

    public User(String userName, String position, String role, int departmentId) {
        this.userName = userName;
        this.role = role;
        this.positionLevel = position;
        this.departmentId = departmentId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public void setPositionLevel(String positionLevel) {
        this.positionLevel = positionLevel;
    }

    public String getPositionLevel() {
        return positionLevel;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(departmentId, user.departmentId)&&
                Objects.equals(userName, user.userName) &&
                Objects.equals(positionLevel, user.positionLevel)&&
                Objects.equals(role, user.role);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, positionLevel, role, departmentId);
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//        User user = (User) o;
//        return departmentId == user.departmentId &&
//                Objects.equals(userName, user.userName) &&
//                Objects.equals(role, user.role);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(userName, departmentId, role);
//    }
}
