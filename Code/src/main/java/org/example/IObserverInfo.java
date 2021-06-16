package org.example;

public interface IObserverInfo {
    void ObserverAdd(IObserver observer);
    void ObserverInform(Device device, int amount);
}
