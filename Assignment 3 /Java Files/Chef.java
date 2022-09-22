package assignment;

public class Chef extends Thread {
	public void run() {
		synchronized (this) {
			while(!Restaurant.ListOfOrders.isEmpty()) {
				String order1 = Restaurant.ListOfOrders.get(0);
				Restaurant.ListOfOrders.remove(0);
				try {
					Thread.sleep(300);
					System.out.println("Thread is sleeping");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				notify();
				System.out.println("Thread is notified");
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public static void main(String[] args) {
		System.out.println("Thread is sleeping");

	}
//chef.notify
	//chef.wait
}
