package org.example;

public class Customer {
    private String name;
    private String address;
    private double wallet;
    Order orders;

    public Customer(String name, String address, double wallet, ICustomerStrategy customerStrategy) {
        this.name = name;
        this.address = address;
        this.wallet = wallet;
        this.orders = new Order(MainWarehouse.getInstance(),customerStrategy);
    }

    public double getWallet() { return wallet;}

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Invoice Order(Device device, double wallet, int amount) throws NoPaymentException, MinCostException {
        Invoice invoice = new Invoice(getName(),getAddress(),amount, device);
        orders.order(device,wallet,amount);
        return invoice;
    }

    public void deleteOrder(){orders.delete();
    }
}
