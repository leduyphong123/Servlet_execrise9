package repository;

import entity.User;
import service.builder.UserBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditRepository {
    public Boolean editUser(User user) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstmt = null;
        try{
            String query = "UPDATE USER SET USERNAME = ?,PHONE = ? WHERE ID = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPhone());
            pstmt.setInt(3,user.getId());
            pstmt.executeUpdate();
           return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            conn.close();
        }

    }

    public User insertUser(int id) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstmt = null;
        User userResult = null;
        try{
            String query = "SELECT * FROM USER WHERE ID = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
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
