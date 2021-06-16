package org.example;

import java.util.ArrayList;

public class PhoneWarehouse implements IObserver, IDeviceOperations {

    private final ArrayList<Device> phoneList = new ArrayList<>();
    private MainWarehouse mainWarehouse;

    public PhoneWarehouse(MainWarehouse mainWarehouse) {
        this.mainWarehouse = mainWarehouse;
        mainWarehouse.ObserverAdd(this);}

    @Override
    public void update(Device device, int quantity) {
        if (device.getType() == DeviceTypeEnum.Phone)
            for (int i=0;i<quantity;i++){phoneList.add(device);}
    }

    @Override
    public void addProduct(Device device) {
        this.phoneList.add(device);
    }

    @Override
    public void removeProduct(String name) {
        ArrayList<Device> list = mainWarehouse.getPhoneStorage().phoneList;
        for (int i=0;i<list.size();i++){
            if (list.get(i).getName().equals(name)){
                list.remove(i);
                return;
            }
        }
    }

    @Override
    public int getListSize() {
        return phoneList.size();
    }
}
