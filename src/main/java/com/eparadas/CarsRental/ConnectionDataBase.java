package com.eparadas.CarsRental;

import javax.sql.DataSource;
import java.sql.*;

public class ConnectionDataBase {

    //static?

    private static final String URL = "jdbc:mysql://localhost:3306/car_rental?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASS = "NetProject";
   // private static BasicDataSource dataSourse;

    public static Connection getConnection() throws SQLException { //change with a connection pool
        return DriverManager.getConnection(URL,USER,PASS);
    }

    public static void close(Connection connection) throws SQLException{
        connection.close();
    }

    public static void close(PreparedStatement statement) throws SQLException{
        statement.close();
    }

    public static void close(ResultSet resultSet) throws SQLException{
        resultSet.close();
    }

    public static void close(ResultSet resultSet, PreparedStatement statement,Connection connection) throws SQLException {
        close(resultSet);
        close(statement);
        close(connection);
    }

    public static void close(PreparedStatement statement,Connection connection) throws SQLException {
        close(statement);
        close(connection);
    }

}
