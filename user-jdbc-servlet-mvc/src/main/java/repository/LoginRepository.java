package repository;

import entity.User;
import service.builder.UserBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepository {
    public User getUser(User user) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstmt = null;
        User userResult = null;
        try{
            String query = "SELECT * FROM USER WHERE EMAIL = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getEmail());
            pstmt.executeQuery();
            ResultSet resultSet  = pstmt.executeQuery();
            while (resultSet.next()){
                userResult = new UserBuilder()
                        .withId(resultSet.getInt("id"))
                        .withUserName(resultSet.getString("username"))
                        .withPhone(resultSet.getString("phone"))
                        .withEmail(resultSet.getString("email"))
                        .withPassword(resultSet.getString("password"))
                        .builder();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return userResult;
    }


}
