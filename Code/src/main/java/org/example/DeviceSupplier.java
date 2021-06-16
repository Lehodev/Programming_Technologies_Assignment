package org.example;

public class DeviceSupplier {

    private String name;
    private String company;
    private String phone;

    public String getSupplierName() {
        return name;
    }

    public String getAddress() {
        return company;
    }

    public String getPhoneNumber() {
        return phone;
    }

    public DeviceSupplier(String name, String company, String phone) {
        this.name = name;
        this.company = company;
        this.phone = phone;
    }

}
