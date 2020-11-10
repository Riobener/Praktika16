package com.company;

//интерфейс Order – позиции заказа

public interface Order {
    boolean add(Item item);
    boolean remove(String itemName);
    int itemQuantityDelete(String itemName);
    int itemQuantity();
    double costTotal();
    Item[] getItems();
    Item[] sortedItemsByCostDescending();
}
