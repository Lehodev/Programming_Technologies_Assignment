package org.example;

import org.junit.Assert;
import org.junit.Test;

public class WarehouseTests
{
    MainWarehouse mainWarehouse = MainWarehouse.getInstance();

    @Test
    public void MainStorageSingleton() {
        MainWarehouse mainWarehouse1 = MainWarehouse.getInstance();
        Object expected = mainWarehouse;
        Object actual = mainWarehouse1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void PhoneStorageTest() {
        int expected = mainWarehouse.getPhoneStorage().getListSize() + 30;
        mainWarehouse.ProductImported(new Device(DeviceTypeEnum.Phone,"iPhone 12 Mini", 215000),
                new DeviceSupplier("iPhone","Apple","06703457856"), 30);
        int actual = mainWarehouse.getPhoneStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TabletStorageTest() {
        int expected = mainWarehouse.getTabletStorage().getListSize() + 20;
        mainWarehouse.ProductImported(new Device(DeviceTypeEnum.Tablet,"Samsung Galaxy S7", 250000),
                new DeviceSupplier("Galaxy","Samsung","06201436742"), 20);
        int actual = mainWarehouse.getTabletStorage().getListSize();
        Assert.assertEquals(expected, actual);
    }

}
