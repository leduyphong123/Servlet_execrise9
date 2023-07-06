package service.builder;

import entity.User;

public class UserBuilder {
    private int id;
    private String userName;
    private String phone;
    private String email;
    private String password;

    public UserBuilder withId(int id) {
        this.id = id;
        return this;
    }
    public UserBuilder withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }
    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public User builder() {
        return new User(id,userName,phone,email,password);
    }
}
