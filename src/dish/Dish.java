package dish;

import java.util.UUID;

public class Dish {
	private String id;
	private String name;
	private boolean isAvailable;
	private double price;
	
	public Dish(String name, double price) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.isAvailable = true;
		this.price = price;
	}
	
	public String getId() {
		return this.id;
	}
}
