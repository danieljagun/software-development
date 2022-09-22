package assignment;

import java.util.ArrayList;

public class Waiter extends Thread {
	Chef c1 = new Chef();
	
	public void run() {
		synchronized(c1) {
			while(!Restaurant.ListOfOrders.isEmpty()) {
				if(!c1.isAlive()) {
					c1.start();
					System.out.println("Chef has been started");
				}else
					notify();
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}

	public Waiter(ArrayList<String> listOfOrders) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Chef c1 = new Chef();
		c1.start();
		System.out.println("Chef has been started");

	}
	
}
