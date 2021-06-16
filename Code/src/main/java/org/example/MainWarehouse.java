package org.example;

import java.util.ArrayList;

public final class MainWarehouse implements IObserverInfo {

    static MainWarehouse mainWarehouse =null;

    public static MainWarehouse getInstance(){
        if(mainWarehouse ==null) mainWarehouse = new MainWarehouse();
        return mainWarehouse;
    }
    private ArrayList<IObserver> observerList = new ArrayList<>();
    PhoneWarehouse phoneWarehouse;
    TabletWarehouse tabletWarehouse;

    private MainWarehouse(){
        this.phoneWarehouse =new PhoneWarehouse(this);
        this.tabletWarehouse =new TabletWarehouse(this);
    }

    public PhoneWarehouse getPhoneStorage() {
        return phoneWarehouse;
    }

    public TabletWarehouse getTabletStorage() {
        return tabletWarehouse;
    }

    public void ProductImported(Device device, DeviceSupplier deviceSupplier, int amount) {
        device.setProductSupplier(deviceSupplier);
        ObserverInform(device, amount);}

    @Override
    public void ObserverAdd(IObserver observer) {
    observerList.add(observer);
    }

    @Override
    public void ObserverInform(Device device, int amount) {
    for (IObserver observer:observerList){
        observer.update(device, amount);
    }
    }
}
