package com.costaff.service;
import com.costaff.db.MyConnection;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Service
public class LoginImplement implements LoginService{
    @Override
    public boolean authenticate(String username, String password) {
       boolean status=false;
       Connection con=MyConnection.getConnection();
       //check in db :
        // if username & pwd matches set status = true
        try {

            PreparedStatement ps=con.prepareStatement("select id from susers where username=? and password = ?");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();

            if (rs.next()){
                status= true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       // return status
       return status;
    }
}
