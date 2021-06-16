package org.example;

public interface ICustomerStrategy {
    void pay (Device device, double wallet, int amount) throws NoPaymentException, MinCostException;
    void deleteOrder();
}
