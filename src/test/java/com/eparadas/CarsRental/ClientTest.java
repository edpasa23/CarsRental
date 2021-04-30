package com.eparadas.CarsRental;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ClientTest {
    
    @Test
    public void insertTest() throws Exception{
        ClientDAO clientDAO = new ClientDAO();
        Client client = new Client(123,"Eduardo","Parada","Estado de Mexico","5565182996");

        System.out.println(clientDAO.insert(client));
    }

    @Test
    public void selectTest() throws Exception{
        ClientDAO clientDAO = new ClientDAO();
        List<Client> clients = clientDAO.selectAll();

        clients.forEach(client ->
                System.out.println(client.toString()));
    }

    @Test
    public void removeTest() throws Exception{
        ClientDAO clientDAO = new ClientDAO();
        Client client = new Client(13,"Eduardo","Parada","Estado de Mexico","5565182996");

        System.out.println("Se removio correctamente = " +clientDAO.remove(client));

    }

}
