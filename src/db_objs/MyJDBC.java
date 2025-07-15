package db_objs;

import java.math.BigDecimal;
import java.sql.*;

public class MyJDBC {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/banking_app";
    private static final String DB_USERNAME = "toddw";
    private static final String DB_PASSWORD = "moonlight123";

    // if valid return an object with the user's information
    public static User validateLogin(String username, String password ){
        try{
            //establish a connection to the database
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // create sql query
            PreparedStatement preparedStatement = connection.prepareStatement(
               "SELECT * FROM users WHERE username = ? AND password = ?"
            );

            // replace the ? with values
            // parameter index referring to the ?, so 1 is username and 2 is password
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // execute query and store in a result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // next() returns true or false
            // true - query returned data and result set now points to the first row
            // false - query returned no data and result set is therefore null
            if(resultSet.next()){
                // success
                // get id
                int userId = resultSet.getInt("id");

                // get current balance
                BigDecimal currentBalance = resultSet.getBigDecimal("current_balance");

                // return user object
                return new User(userId, username, password, currentBalance);
            }


        }catch(SQLException e){
            e.printStackTrace();
        }

        // not valid user
        return null;

    }

}
