package com.robinsondetroit;

public abstract class Item {
    String name;
    String value;

    Item nextItem;
    Item previousItem;

    Boolean endOfList;
    Boolean startOfList;

    public Item(String name, String value, Item nextItem, Item previousItem) {
        this.name = name;
        this.value = value;
        this.nextItem = nextItem;
        this.previousItem = previousItem;

        updateEndAndStartOfListState();
    }

    public void moveForward(Item newItem){
        this.previousItem = newItem;
        updateEndAndStartOfListState();
    }

    public void moveBackward(Item newItem){
        this.nextItem = newItem;
        updateEndAndStartOfListState();
    }

    public int compareTo(Item listItem){
        if(listItem.getValue() == this.value){
            return 0;

        } else if ( Integer.parseInt(listItem.getValue()) <  Integer.parseInt(this.value)) {
            return 1;

        } else {
            return -1;
        }
    }


    private void updateEndAndStartOfListState() {
        if (nextItem == null) {
            this.endOfList = true;
        } else {
            this.endOfList = false;
        }

        if (previousItem == null) {
            this.startOfList = true;
        } else {
            this.startOfList = false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Item getNextItem() {
        return nextItem;
    }

    public void setNextItem(Item nextItem) {
        this.nextItem = nextItem;
    }

    public Item getPreviousItem() {
        return previousItem;
    }

    public void setPreviousItem(Item previousItem) {
        this.previousItem = previousItem;
    }

    public Boolean getEndOfList() {
        return endOfList;
    }

    public void setEndOfList(Boolean endOfList) {
        this.endOfList = endOfList;
    }

    public Boolean getStartOfList() {
        return startOfList;
    }

    public void setStartOfList(Boolean startOfList) {
        this.startOfList = startOfList;
    }
}
