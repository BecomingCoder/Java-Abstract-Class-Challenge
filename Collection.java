package com.robinsondetroit;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    private String name;
    private List<ListItem> collection;
    private ListItem headOfCollection;

    public Collection(String name) {
        this.name = name;
        this.headOfCollection = null;
        this.collection = new ArrayList<ListItem>();
    }

    public boolean addItem(ListItem newListItem) {
        System.out.println("\nAdding item...");
        if (this.headOfCollection == null) {
            System.out.println("Head of Count is null");
            this.headOfCollection = newListItem;
            newListItem.setStartOfList(true);
            newListItem.setEndOfList(true);
            this.collection.add(newListItem);
            System.out.println(this.collection.get(0).getName() + " with value: " + this.collection.get(0).getValue());
            return true;
        }

        boolean quit = false;

        while (!quit) {
            System.out.println("while loop");

            for (ListItem currentItem : this.collection) {
                switch (currentItem.compareTo(newListItem)) {
                    case 0:
                        System.out.println("Sorry, currentItem is a duplicate and cannot be added.");
                        return false;
                    //break;

                    case 1: //newItem is less than currentItem
                        System.out.println("Case 1");
                        this.collection.add(newListItem);
                        currentItem.moveAheadOf(newListItem);
                        newListItem.nextListItem = currentItem;
                        findItem((ListItem) currentItem.previousListItem).nextListItem = newListItem;
                        // for above: we must find this item because currentItem's previousItem
                        // is just a copy of the actual item in the collection
                        // and we want the actual item in the collection, right?
                        return true;
                    // break;

                    case -1: //newItem is greater than currentItem
                        System.out.println("Case -1");
                        if (currentItem.nextListItem == null) {
                            this.collection.add(newListItem);
                            quit = true;
                        }
                        break;
                }
            System.out.println("For loop for " + currentItem.getName());
        }


        }
        return false;
    }

    public ListItem findItem(ListItem searchItem){
        for(ListItem listItem: this.collection){
            if (searchItem == listItem) {
                return listItem;
            }
        }

        return null;
    }

    public void removeListItem(ListItem itemToRemove){
        for(ListItem listItem: this.collection){
            if(listItem == itemToRemove){
                if(collection.remove(listItem)){
                    System.out.println(itemToRemove + "has been removed successfully.");
                } else {
                    System.out.println(itemToRemove + "was not removed.");
                }
            }
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ListItem> getCollection() {
        return collection;
    }

    public void setCollection(List<ListItem> collection) {
        this.collection = collection;
    }

    public ListItem getHeadOfCollection() {
        return headOfCollection;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "name='" + name + '\'' +
                ", collection=" + collection +
                ", headOfCollection=" + headOfCollection +
                '}';
    }

    public void setHeadOfCollection(ListItem headOfCollection) {
        this.headOfCollection = headOfCollection;
    }

    public void printCollection(){
        for(ListItem item : collection){

        }

    }
}
