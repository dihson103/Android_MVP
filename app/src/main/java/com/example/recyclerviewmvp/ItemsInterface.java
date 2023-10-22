package com.example.recyclerviewmvp;

public interface ItemsInterface {

    void addNewItem(Item item);
    void deleteItem(int index);
    void goToUpdate(int index);
    void updateItem(int index, Item item);

}
