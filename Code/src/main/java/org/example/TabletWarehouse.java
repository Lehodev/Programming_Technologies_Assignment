package org.example;

import java.util.ArrayList;

public class TabletWarehouse implements IObserver, IDeviceOperations {

    private final ArrayList<Device> boardGameList = new ArrayList<>();
    private MainWarehouse mainWarehouse;

    public TabletWarehouse(MainWarehouse mainWarehouse) {
        this.mainWarehouse = mainWarehouse;
        mainWarehouse.ObserverAdd(this);}

    @Override
    public void update(Device device, int quantity) {
        if (device.getType() == DeviceTypeEnum.Tablet)
            for (int i=0;i<quantity;i++){boardGameList.add(device);}
    }

    @Override
    public void addProduct(Device device) {
        this.boardGameList.add(device);
    }

    @Override
    public void removeProduct(String name) {
        ArrayList<Device> list = mainWarehouse.getTabletStorage().boardGameList;
        for (int i=0;i<list.size();i++){
            if (list.get(i).getName().equals(name)){
                list.remove(i);
                return;
            }
        }
    }

    @Override
    public int getListSize() {
        return boardGameList.size();
    }
}
