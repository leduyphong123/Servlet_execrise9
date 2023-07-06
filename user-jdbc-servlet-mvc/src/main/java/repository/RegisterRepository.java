package repository;

import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterRepository {


    public boolean insertUser(User user) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstmt = null;
        try{
            String query = "INSERT INTO USER (USERNAME,PHONE,EMAIL,PASSWORD) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2,user.getPhone());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4,user.getPassword());
            pstmt.execute();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            conn.close();
        }

    }
}
