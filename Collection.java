package com.robinsondetroit;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    List<Item> collection = new ArrayList<Item>();
    Item headOfCollection;

    public boolean addItem(Item newItem){
        if(collection.isEmpty()){
            newItem.setStartOfList(true);
            newItem.setEndOfList(true);
            return true;
        }

        boolean quit = false;

            for (Item item: this.collection){
            while (!quit)
            switch (newItem.compareTo(item)){
                case 0:
                    System.out.println("Sorry, item is a duplicate and cannot be added.");
                    return false;
                    break;
                case 1:
                    collection.add(newItem);
                    item.moveForward(newItem);
                    return true;
                    break;
                case -1:
                    collection.add(newItem);
                    item.moveBackward(newItem);
                    return true;
                    break;
            }

        }
    }
}
