package org.example;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceTest {

    MainWarehouse mainWarehouse = MainWarehouse.getInstance();

    @Test
    public void GiveInvoice() throws NoPaymentException, MinCostException {
        Device device = new Device(DeviceTypeEnum.Tablet, "Sasmung Galaxy S7", 250000);
        mainWarehouse.ProductImported(device, new DeviceSupplier("Galaxy","Samsung","06201436742"), 20);
        Customer customer = new Customer("Endre", "Budapest", 500000, new PersonCustomerStrategy(mainWarehouse));
        Invoice actual = customer.Order(device, customer.getWallet(),1);
        Invoice expected = new Invoice("Endre", "Budapest", 1, device);
        Assert.assertEquals(expected, actual);
    }
}
