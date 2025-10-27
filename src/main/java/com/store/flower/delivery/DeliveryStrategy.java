package com.store.flower.delivery;
import java.util.List;
import com.store.flower.Item;


public interface DeliveryStrategy {
    public double deliver(List<Item> orders, double price);
}
