package org.example;

import java.util.Objects;

public class Invoice {
    private String name;
    private String address;
    private int amount;
    private Device device;

    public Invoice(String name, String address, int amount, Device device) {
        this.name = name;
        this.address = address;
        this.amount = amount;
        this.device = device;
    }

    double GetFullPrice() {
        return device.getPrice() * amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Device getProduct() {
        return device;
    }

    public void setProduct(Device device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                ", product=" + device +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return amount == invoice.amount &&
                Objects.equals(name, invoice.name) &&
                Objects.equals(address, invoice.address) &&
                Objects.equals(device, invoice.device);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, amount, device);
    }
}
