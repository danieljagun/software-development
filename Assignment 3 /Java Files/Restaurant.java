package assignment;

import java.util.ArrayList;

public class Restaurant {
	ArrayList<Restaurant> list;
	static ArrayList<String> ListOfOrders = new ArrayList<String>();


public static void main(String[] args) {
	Waiter w1 = new Waiter(ListOfOrders);
	w1.start();
	System.out.println("Waiter has been started");
}
}

