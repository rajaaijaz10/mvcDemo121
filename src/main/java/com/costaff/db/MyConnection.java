package com.costaff.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnection {
    private MyConnection() {
    }


    private static Connection con = null;

    static {
        try {
            InputStream fis = MyConnection.class.getClassLoader().getResourceAsStream(Constants.DB_PROPS_FILE);
            Properties properties = new Properties();
            properties.load(fis);
            String driver = properties.getProperty(Constants.DRIVER);
            String url = properties.getProperty(Constants.URL);
            String username = properties.getProperty(Constants.USERNAME);
            String password = properties.getProperty(Constants.PASSWORD);
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    static public Connection getConnection() {
        return con;
    }



}
