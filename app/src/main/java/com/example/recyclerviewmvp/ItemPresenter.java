package com.example.recyclerviewmvp;

public class ItemPresenter {

    private ItemsInterface itemsInterface;

    public ItemPresenter(ItemsInterface itemsInterface){
        this.itemsInterface = itemsInterface;
    }

    public void addNewItem(Item item){
        itemsInterface.addNewItem(item);
    }

    public void update(int index, Item item){
        itemsInterface.updateItem(index, item);
    }

}
