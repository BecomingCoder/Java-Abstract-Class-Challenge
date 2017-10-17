package com.robinsondetroit;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree extends Collection{
    private List<AbstractListItem> tree;
    private AbstractListItem headOfTree;

    public BinarySearchTree(String name, List<AbstractListItem> tree) {
        super(name);
        this.tree = new ArrayList<AbstractListItem>();
        this.headOfTree = null;
    }

    @Override
    public boolean addItem(ListItem newListItem) {
        super.addItem(newListItem);
        if (this.headOfTree == null) {
            this.headOfTree = newListItem;
            newListItem.setStartOfList(true);
            newListItem.setEndOfList(true);
            return true;
        }

        boolean quit = false;

        for (AbstractListItem currentItem : this.tree) {
            while (!quit) {
                switch (currentItem.compareTo(newListItem)) {
                    case 0:
                        System.out.println("Sorry, currentItem is a duplicate and cannot be added.");
                        return false;

                    case 1: //newItem is less than currentItem
                        tree.add(newListItem);
                        currentItem.moveAheadOf(newListItem);
                        newListItem.nextListItem = currentItem;
                        findItem( (ListItem) currentItem.previousListItem).nextListItem = newListItem;
                        // for above: we must find this item because currentItem's previousItem
                        // is just a copy of the actual item in the tree
                        // and we want the actual item in the tree, right?
                        return true;

                    case -1: //newItem is greater than currentItem
                        tree.add(newListItem);
                        currentItem.moveBehind(newListItem);
                        newListItem.previousListItem = currentItem;
                        findItem((ListItem) currentItem.nextListItem).previousListItem = newListItem;
                        return true;
                }
            }

        }
        return false;

    }
}
