package com.minghong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
    public static void main(String[] args) {
        try {
            //establishing connection and use database with the name market in the specified folder
            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\Java Course\\SQLiteCRUD\\market.db");

            //run a sql statement
            Statement statement = conn.createStatement();
            statement.execute("UPDATE MsUser SET role = 'Admin' WHERE user_id='US003'");

            //close statement and connection
            statement.close();
            conn.close();

            System.out.println("Command successful");
        } catch (SQLException e) {
            //error handling & print error message
            System.out.println("Error : " + e.getMessage());
        }
    }
}
