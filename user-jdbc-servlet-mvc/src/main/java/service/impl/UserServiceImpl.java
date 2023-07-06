package service.impl;

import entity.User;
import repository.EditRepository;
import repository.LoginRepository;
import repository.RegisterRepository;
import service.UserService;
import service.builder.UserBuilder;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private RegisterRepository registerRepository;
    private LoginRepository loginRepository;
    private EditRepository  editRepository;
    public UserServiceImpl() {
        registerRepository = new RegisterRepository();
        loginRepository = new LoginRepository();
        editRepository = new EditRepository();
    }

    @Override
    public boolean createUser(String userName, String phone, String email, String passwrod) throws SQLException, ClassNotFoundException {
        User user = new UserBuilder()
                .withUserName(userName)
                .withPhone(phone)
                .withEmail(email)
                .withPassword(passwrod)
                .builder();
        return registerRepository.insertUser(user);
    }

    @Override
    public User getUser(String email, String passwrod) throws SQLException, ClassNotFoundException {
        User user = new UserBuilder()
                .withEmail(email)
                .withPassword(passwrod)
                .builder();
        return loginRepository.getUser(user);
    }

    @Override
    public Boolean editUSer(int id, String userName, String phone) throws SQLException, ClassNotFoundException {
        User user = new UserBuilder()
                .withId(id)
                .withUserName(userName)
                .withPhone(phone)
                .builder();
        return editRepository.editUser(user);
    }

    @Override
    public User getUserId(int id) throws SQLException, ClassNotFoundException {

        return editRepository.insertUser(id);
    }
}
