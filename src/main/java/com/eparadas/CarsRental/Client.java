package com.eparadas.CarsRental;

import org.springframework.expression.spel.CodeFlow;

import java.util.Objects;

public class Client {

    private int idClient;
    private String name;
    private String lastName;
    private String city;
    private String phoneNumber;
    //email?, password?, address

    public Client(){
        //empty constructor
    }

    public Client(int idClient){
        this.idClient = idClient;
    }

    public Client(String name, String lastName, String phoneNumber, String city){
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

    public Client(int idClient, String name, String lastName, String city, String phoneNumber){
        this.idClient = idClient;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

    //Getters and Setters

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "IdClient= " + idClient +
                ", Name: '" + name + '\'' +
                ", LastName: '" + lastName + '\'' +
                ", PhoneNumber: '" + phoneNumber + '\'' +
                ", City: '" + city + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getIdClient() == client.getIdClient() && Objects.equals(getName(), client.getName()) && Objects.equals(getLastName(), client.getLastName()) && Objects.equals(getPhoneNumber(), client.getPhoneNumber()) && Objects.equals(getCity(), client.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdClient(), getName(), getLastName(), getPhoneNumber(), getCity());
    }
}
