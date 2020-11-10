package com.company;

import java.util.Arrays;

public class InternetOrder implements Order {
    private int size = 0;
    private Item[] items = new Item[]{};

    InternetOrder() {
    }

    public boolean add(Item item) {
        size++;
        Item[] tempDishes = new Item[size];
        for (int i = 0; i < items.length; i++)
            tempDishes[i] = items[i];
        tempDishes[size - 1] = item;
        items = tempDishes;
        return true;
    }


    public int removeAll(String itemName) {
        int lastSize = items.length;
        int count = 0;
        for (int i = 0; i < size; i++)
            if (items[i].getName().equals(itemName) == false)
                count++;

        Item[] tempItems = new Item[count];
        int currentIndex = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(itemName) == false) {
                tempItems[currentIndex] = items[i];
                currentIndex++;
            }
        }
        items = tempItems;
        size = items.length;
        return lastSize - size;
    }

    public boolean remove(String itemName) {
        Item[] tempItems = new Item[items.length];
        int remove_pos = -1;
        for (int i = size - 1; i >= 0; i--)
            if (items[i].getName().equals(itemName)) {
                remove_pos = i;
                break;
            }
        if (remove_pos == -1)
            return false;
        int currentIndex = 0;
        for (int i = 0; i < size; i++) {
            if (i == remove_pos)
                continue;
            tempItems[currentIndex] = items[i];
            currentIndex++;
        }
        items = tempItems;
        size = items.length;
        return true;
    }

    public int itemQuantityDelete(String itemName) {
        return removeAll(itemName);
    }

    public int itemQuantity() {
        return items.length;
    }

    public int itemQuantity(String itemName) {
        int count = 0;
        for (int i = 0; i < size; i++)
            if (itemName.equals(items[i].getName()))
                count++;
        return count;
    }

    public Item[] getItems() {
        return items.clone();
    }

    public double costTotal() {
        double coastAll = 0;
        for (int i = 0; i < items.length; i++) {
            coastAll += items[i].getCost();
        }
        return coastAll;
    }

    public String[] itemsNames() {
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            names[i] = items[i].getName();
        }

        return names;
    }

    public Item[] sortedItemsByCostDescending() {
        Item temp;
        Item[] itemsCopy = items.clone();
        for (int i = 0; i < itemsCopy.length; i++) {
            for (int j = i; j < itemsCopy.length - 1; j++) {
                if (itemsCopy[j].getCost() < itemsCopy[j + 1].getCost()) {
                    temp = itemsCopy[j];
                    itemsCopy[j] = itemsCopy[j + 1];
                    itemsCopy[j + 1] = temp;
                }
            }
        }
        return itemsCopy;
    }

    public String toString() {

        return "Заказ:" +
                " размер: " + size +
                ", позиции: " + Arrays.toString(items);
    }
}
