package db_objs;

/*
  JDBC class is used to interact with our mySql database to perform activities such as retrieving and updating our DB
 */

import java.math.BigDecimal;
import java.sql.*;

public class MyJDBC {
    // database configuration
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/banking_app";
    private static final String DB_USERNAME = "toddw";
    private static final String DB_PASSWORD = "moonlight123";

    // if valid return an object witht the user's information
    public static User validateLogin(String username, String password){
        try{
        // establish a connection to the database using configuration
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            //create query
            PreparedStatement preparedStatement = connection.prepareStatement(
                  "SELECT * FROM user WHERE username = ? AND password = ?"
            );

            // replace the ? with values
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // execute query and store it in the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // next() returns true or false
            // true - query returned data and the result set now points to the first row
            // false - query returned no data and the result set equals null
            if(resultSet.next()){
                int userId = resultSet.getInt("id");

                // get current balance
                BigDecimal currentBalance = resultSet.getBigDecimal("current_balance");

                // return user object
                return new User(userId, username, password, currentBalance);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        // not valid user
        return null;
    }
}