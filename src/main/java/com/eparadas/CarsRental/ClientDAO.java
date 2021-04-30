package com.eparadas.CarsRental;

import static com.eparadas.CarsRental.ConnectionDataBase.*;
import java.util.*;
import java.sql.*;


//DATA ACCESS OBJECT
public class ClientDAO {

    private static final String SQL_SELECT = "SELECT * FROM client";
    private static final String SQL_INSERT = "INSERT INTO client(ID_Client,Name_Client,Last_Name,City,Phone_Number) VALUES(?,?,?,?,?)";
    //rivate static final String SQL_ORDER = "SELECT * FROM client ORDER BY ";
    //private static final String SQL_WHERE = "SELECT * FROM client WHERE ";
    private static final String SQL_DELETE = "DELETE FROM client WHERE ID_Client = ?";

    public List<Client> selectAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Client client = null;
        List<Client> clientList = new ArrayList<>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement(SQL_SELECT);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                //Data Capture
                int idClient = resultSet.getInt("ID_Client");
                String name = resultSet.getString("Name_Client");
                String lastName = resultSet.getString("Last_Name");
                String city = resultSet.getString("City");
                String phone = resultSet.getString("Phone_Number");

                //save in the list
                client = new Client(idClient, name, lastName, city, phone);
                clientList.add(client);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                close(resultSet, statement, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }
        }

        return clientList;

    }

    public boolean insert(Client client) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean insertedCorrectly=false;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setInt(1,client.getIdClient());
            statement.setString(2,client.getName());
            statement.setString(3,client.getLastName());
            statement.setString(4,client.getCity());
            statement.setString(5,client.getPhoneNumber());
            statement.executeUpdate();
            insertedCorrectly = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                close(statement, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return insertedCorrectly;
    }

    public boolean remove(Client client) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean removedCorrectly = false;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setInt(1,client.getIdClient());
            if(statement.executeUpdate()==1){
                removedCorrectly = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                close(statement, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return removedCorrectly;
        }
    }


}
