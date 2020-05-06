package com.minghong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

    public static void main(String[] args) {
        try {
            //establishing connection and use database with the name market in the specified folder
            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\Java Course\\SQLiteCRUD\\market.db");

            //run a sql statement
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO MsUser(user_id,username,password,role)" + "VALUES('US001','Bob','test123','Admin')");
            statement.execute("INSERT INTO MsUser(user_id,username,password,role)" + "VALUES('US002','Alice','alice123','User')");
            statement.execute("INSERT INTO MsUser(user_id,username,password,role)" + "VALUES('US003','Matthew','matthew123','User')");

            //close statement and connection
            statement.close();
            conn.close();

            System.out.println("Command successful");
        }catch(SQLException e){
            //error handling & print error message
            System.out.println("Error : " + e.getMessage());
        }
    }
}
