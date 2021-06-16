package org.example;

import org.junit.Test;

public class MinCostExceptionTests {

    MainWarehouse mainWarehouse = MainWarehouse.getInstance();

    @Test(expected = MinCostException.class)
    public void PhoneMinCostException() throws NoPaymentException, MinCostException {
        Device device = new Device(DeviceTypeEnum.Phone, "iPhone 12 Mini", 215000);
        mainWarehouse.ProductImported(device, new DeviceSupplier("iPhone","Apple","06703457856"), 30);
        Customer customer = new Customer("AlmaBolt", "Szentendre", 10000000, new StoreCustomerStrategy(mainWarehouse));
        customer.Order(device, customer.getWallet(),1);
    }

    @Test(expected = MinCostException.class)
    public void TabletMinCostException() throws NoPaymentException, MinCostException {
        Device device = new Device(DeviceTypeEnum.Tablet, "Samsung Galaxy S7", 250000);
        mainWarehouse.ProductImported(device, new DeviceSupplier("Galaxy","Samsung","06201436742"), 20);
        Customer customer = new Customer("Telekom", "Eger", 5000000, new StoreCustomerStrategy(mainWarehouse));
        customer.Order(device, customer.getWallet(),1);
    }
}
