package assignment;

public class Order {
	
	String food;
	int price;
	int orderID;
	
	public Order()
	{
		this.food = "";
		this.price = 0;
		this.orderID = 0;
	}
	
	public Order(String food, int price, int orderID)
	{
		this.food = food;
		this.price = price;
		this.orderID = orderID;
	}
	
	public String getFood()
	{
		return this.food;
	}
	
	public int getPrice()
	{
		return this.price;
	}
	
	public int getOrderID()
	{
		return this.orderID;
	}
	
	public void setFood(String f)
	{
		this.food = f;
	}
	
	public void setSandwich(int p)
	{
		this.price = p;
	}
	
	public void setPancake(int o)
	{
		this.orderID = o;
	}
	
	public String toString() {
		return "The food selected is : " + this.food + "\n"
				+ "The price of the order is " + this.price + "\n"
				+ "The order ID is : " + this.orderID;
	}
}

