package com.minghong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

    public static void main(String[] args) {
        try {
            //establishing connection and make database with the name market in the specified folder
            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\Java Course\\SQLiteCRUD\\market.db");

            //run a sql statement
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE MsUser(user_id TEXT PRIMARY KEY,username TEXT,password TEXT,role TEXT)");

            //this code is used to delete the MsUser table
            //statement.execute("DROP TABLE MsUser");

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
