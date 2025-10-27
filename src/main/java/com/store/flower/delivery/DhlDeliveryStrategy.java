package com.store.flower.delivery;

import java.util.List;
import com.store.flower.Item;

public class DhlDeliveryStrategy implements DeliveryStrategy{
    @Override
    public double deliver(List<Item> orders, double price){
        System.out.println("Delivering " + String.valueOf(orders.size()) + "items with DHL");
        return price + 15;
    }
}
