package com.robinsondetroit;

public abstract class AbstractListItem {
    String name;
    String value;

    AbstractListItem nextListItem;
    AbstractListItem previousListItem;

    Boolean endOfList;
    Boolean startOfList;

    public AbstractListItem(String name, String value) {
        this.name = name;
        this.value = value;
        this.nextListItem = null;
        this.previousListItem = null;

        updateEndAndStartOfListState();
    }

    public void moveAheadOf(AbstractListItem newListItem){
        this.previousListItem = newListItem;
        updateEndAndStartOfListState();
    }

    public void moveBehind(AbstractListItem newListItem){
        this.nextListItem = newListItem;
        updateEndAndStartOfListState();
    }

    public int compareTo(AbstractListItem newListItem){
        System.out.println("newListItem.getValue: " + Integer.parseInt(newListItem.getValue()) +
                "\nthis.value: "+ Integer.parseInt(this.value));

        if(Integer.parseInt(newListItem.getValue()) == Integer.parseInt(this.value)){
            return 0;

        } else if ( Integer.parseInt(newListItem.getValue()) <  Integer.parseInt(this.value)) {
            return 1;

        } else {
            return -1;
        }
    }


    private void updateEndAndStartOfListState() {
        if (nextListItem == null) {
            this.endOfList = true;
        } else {
            this.endOfList = false;
        }

        if (previousListItem == null) {
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

    public AbstractListItem getNextListItem() {
        return nextListItem;
    }

    public void setNextListItem(AbstractListItem nextListItem) {
        this.nextListItem = nextListItem;
    }

    public AbstractListItem getPreviousListItem() {
        return previousListItem;
    }

    public void setPreviousListItem(AbstractListItem previousListItem) {
        this.previousListItem = previousListItem;
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
