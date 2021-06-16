package org.example;

public class StoreCustomerStrategy implements ICustomerStrategy {

    MainWarehouse mainWarehouse;

    private boolean deleteOrder=false;
    private Device device;
    private int amount;

    public StoreCustomerStrategy(MainWarehouse mainWarehouse) {
        this.mainWarehouse = mainWarehouse;
    }

    @Override
    public void pay(Device device, double wallet, int amount) throws NoPaymentException, MinCostException {
        int minCostPhone=500000;
        int minCostTablet=600000;
        this.device = device;
        this.amount=amount;

        if (device.getType() == DeviceTypeEnum.Phone){
            if (device.getPrice()*amount>wallet){
                throw new NoPaymentException("Nincs elég pénzed ehhez a tranzakcióhoz.");
            }
            if (device.getPrice()*amount < minCostPhone){
                throw new MinCostException("Egy tranzakció minimum értéke: " +minCostPhone+"Ft.");
            }
            for (int i = 0; i < amount; i++) {
                mainWarehouse.getPhoneStorage().removeProduct(device.getName());
            }
        }
        else if (device.getType()== DeviceTypeEnum.Tablet){
            if (device.getPrice()*amount>wallet){
                throw new NoPaymentException("Nincs elég pénzed ehhez a tranzakcióhoz.");
            }
            if (device.getPrice()*amount < minCostTablet){
                throw new MinCostException("Egy tranzakció minimum értéke: " +minCostTablet+"Ft.");
            }
            for (int i = 0; i < amount; i++) {
                mainWarehouse.getTabletStorage().removeProduct(device.getName());
            }
        }
        deleteOrder = true;
    }

    @Override
    public void deleteOrder() {
        if (deleteOrder){
            if (device.getType()== DeviceTypeEnum.Phone){
                for (int i = 0; i < amount; i++) {
                    mainWarehouse.getPhoneStorage().addProduct(device);
                }
            }
            else if (device.getType()== DeviceTypeEnum.Tablet){
                for (int i = 0; i < amount; i++) {
                    mainWarehouse.getTabletStorage().addProduct(device);
                }
            }
            deleteOrder = true;
        }
    }
}
