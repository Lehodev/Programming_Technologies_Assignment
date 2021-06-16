package org.example;

public class Order{
    MainWarehouse mainWarehouse;
    ICustomerStrategy customerStrategy;

    public Order(MainWarehouse mainWarehouse, ICustomerStrategy customerStrategy) {
        this.mainWarehouse = mainWarehouse;
        this.customerStrategy = customerStrategy;
    }

    public void order(Device device, double wallet, int amount) throws NoPaymentException, MinCostException {
        customerStrategy.pay(device,wallet,amount);
    }

    public void delete() {
        customerStrategy.deleteOrder();
    }
}

