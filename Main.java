package com.robinsondetroit;

public class Main {

    public static void main(String[] args) {

		Collection collection = new Collection("New Collection");

		//String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";

		String stringData = "12 4 55 1 11 23 5 17 71 10002";

		String[] data = stringData.split(" ");

		ListItem temporary = new ListItem("", "");
		int i = 0;


		for (String s : data) {
			i++;

			temporary.setValue(s);
			temporary.setName("\nThing " + i );

			System.out.println(temporary.getName() + ": " + temporary.getValue());

			collection.addItem(temporary);
		}

		for (i = 0; i < collection.getCollection().size(); i++) {
			System.out.println(i);
			System.out.println(collection.getCollection().get(i).getValue());
		}
	}

}
