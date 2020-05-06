package com.minghong;

import java.sql.*;
import java.util.Scanner;

public class Select {
    public static void main(String[] args) {
        try {
            //establishing connection and use database with the name market in the specified folder
            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\Java Course\\SQLiteCRUD\\market.db");

            //scan user's input
            Scanner scan = new Scanner(System.in);
            System.out.println("Username : ");
            String username = scan.nextLine();

            System.out.println("Password : ");
            String password = scan.nextLine();

            //sql statement that vulnerable to sql injection
            Statement statement = conn.createStatement();
            statement.execute("SELECT * FROM MsUser WHERE username='" + username + "'" + " AND password = '" + password + "'");
            System.out.println("SELECT * FROM MsUser WHERE username='" + username + "'" + " AND password = '" + password + "'");
            
            //get result
            ResultSet result = statement.getResultSet();
            if (result.next()) {
                System.out.println("Successfully login as " + result.getString("username"));
            } else {
                System.out.println("Wrong username or password");
            }

            result.close();

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
