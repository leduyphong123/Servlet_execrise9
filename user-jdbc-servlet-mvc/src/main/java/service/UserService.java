package service;

import entity.User;

import java.sql.SQLException;

public interface UserService {

    boolean createUser(String userName, String phone, String email, String passwrod) throws SQLException, ClassNotFoundException;

    User getUser(String email, String passwrod) throws SQLException, ClassNotFoundException;

    Boolean editUSer(int id, String userName, String phone) throws SQLException, ClassNotFoundException;

    User getUserId(int id) throws SQLException, ClassNotFoundException;
}
