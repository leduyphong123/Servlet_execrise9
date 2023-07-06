package com.example.usermanager.dao;

import com.example.usermanager.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void insertUser(User user) throws SQLException;

    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;
}
