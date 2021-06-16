package org.example;

import org.junit.Assert;
import org.junit.Test;

public class OrderTests {

    MainWarehouse mainWarehouse = MainWarehouse.getInstance();

    @Test
    public void OrderPhoneTest() throws NoPaymentException, MinCostException {
        mainWarehouse.ProductImported(new Device(DeviceTypeEnum.Phone,"iPhone SE", 150000),
                new DeviceSupplier("iPhone","Apple","06306666969"), 2);
        int expected = mainWarehouse.getPhoneStorage().getListSize() - 2;
        Customer customer = new Customer("Vajk", "Mohács", 300000, new PersonCustomerStrategy(mainWarehouse));
        customer.Order(new Device(DeviceTypeEnum.Phone,"iPhone SE", 150000), customer.getWallet(),2);
        int actual = mainWarehouse.getPhoneStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void OrderTabletTest() throws NoPaymentException, MinCostException {
        mainWarehouse.ProductImported(new Device(DeviceTypeEnum.Tablet,"LENOVO TAB M8", 80000),
                new DeviceSupplier("TAB","LENOVO","06704528758"), 1);
        int expected = mainWarehouse.getTabletStorage().getListSize() - 1;
        Customer customer = new Customer("Alexandra", "Eger", 100000, new PersonCustomerStrategy(mainWarehouse));
        customer.Order(new Device(DeviceTypeEnum.Tablet,"LENOVO TAB M8", 10990), customer.getWallet(),1);
        int actual = mainWarehouse.getTabletStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void DeletePhoneOrder() throws NoPaymentException, MinCostException {
        mainWarehouse.ProductImported(new Device(DeviceTypeEnum.Phone,"iPhone SE", 150000),
                new DeviceSupplier("iPhone","Apple","06306666969"), 2);
        int expected = mainWarehouse.getPhoneStorage().getListSize();
        Customer customer = new Customer("Vajk", "Mohács", 4000000, new PersonCustomerStrategy(mainWarehouse));
        customer.Order(new Device(DeviceTypeEnum.Phone,"iPhone SE", 150000), customer.getWallet(),2);
        customer.deleteOrder();
        int actual = mainWarehouse.getPhoneStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void DeleteTabletOrder() throws NoPaymentException, MinCostException {
        mainWarehouse.ProductImported(new Device(DeviceTypeEnum.Tablet,"LENOVO TAB M8", 80000),
                new DeviceSupplier("TAB","LENOVO","06704528758"), 1);
        int expected = mainWarehouse.getTabletStorage().getListSize();
        Customer customer = new Customer("Alexandra", "Eger", 200000, new PersonCustomerStrategy(mainWarehouse));
        customer.Order(new Device(DeviceTypeEnum.Tablet,"LENOVO TAB M8", 80000), customer.getWallet(),1);
        customer.deleteOrder();
        int actual = mainWarehouse.getTabletStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }
}

