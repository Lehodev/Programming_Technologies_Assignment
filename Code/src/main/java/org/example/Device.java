package org.example;

import java.util.Objects;

public class Device {

    private DeviceTypeEnum type;
    private String name;
    private double price;
    DeviceSupplier deviceSupplier;

    public Device(DeviceTypeEnum type, String name, double price){
        this.type=type;
        this.name=name;
        this.price=price;
    }

    public void setProductSupplier(DeviceSupplier deviceSupplier){this.deviceSupplier = deviceSupplier;}

    public DeviceTypeEnum getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Double.compare(device.price, price) == 0 &&
                Objects.equals(name, device.name) &&
                type == device.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, type);
    }
}
