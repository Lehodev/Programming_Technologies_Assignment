package org.example;

import org.junit.Assert;
import org.junit.Test;

public class NoPaymentExceptionTests {

    MainWarehouse mainWarehouse = MainWarehouse.getInstance();

    @Test
    public void PersonCanPurchaseTest() throws NoPaymentException, MinCostException {
        Device device = new Device(DeviceTypeEnum.Phone, "iPhone 12 Mini", 215000);
        mainWarehouse.ProductImported(device, new DeviceSupplier("iPhone","Apple","06703457856"), 30);
        int expected = mainWarehouse.getPhoneStorage().getListSize() - 2;
        Customer customer = new Customer("Ede", "Szeged", 600000, new PersonCustomerStrategy(mainWarehouse));
        customer.Order(device, customer.getWallet(),2);
        int actual = mainWarehouse.getPhoneStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NoPaymentException.class)
    public void PersonCanNotPurchaseTest() throws NoPaymentException, MinCostException {
        Device device = new Device(DeviceTypeEnum.Tablet, "Samsung Galaxy S7", 250000);
        mainWarehouse.ProductImported(device, new DeviceSupplier("Galaxy","Samsung","06201436742"), 20);
        Customer customer = new Customer("Virág", "Tata", 30000, new PersonCustomerStrategy(mainWarehouse));
        customer.Order(device, customer.getWallet(),4);
    }

    @Test
    public void StoreCanPurchaseTest() throws NoPaymentException, MinCostException {
        Device device = new Device(DeviceTypeEnum.Phone, "iPhone 12 Mini", 215000);
        mainWarehouse.ProductImported(device, new DeviceSupplier("iPhone","Apple","06703457856"), 30);
        int expected = mainWarehouse.getPhoneStorage().getListSize() - 5;
        Customer customer = new Customer("AlmaBolt", "Szentendre", 10000000, new StoreCustomerStrategy(mainWarehouse));
        customer.Order(device, customer.getWallet(),5);
        int actual = mainWarehouse.getPhoneStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NoPaymentException.class)
    public void StoreCanNotPurchaseTest() throws NoPaymentException, MinCostException {
        Device device = new Device(DeviceTypeEnum.Tablet, "Samsung Galaxy S7", 250000);
        mainWarehouse.ProductImported(device, new DeviceSupplier("Galaxy","Samsung","06201436742"), 20);
        Customer customer = new Customer("Telekom", "Eger", 1000000, new StoreCustomerStrategy(mainWarehouse));
        customer.Order(device, customer.getWallet(),100);
    }


}
