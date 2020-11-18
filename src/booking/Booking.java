package booking;

import java.util.*;


public class Booking {
	private String id;
	private String customerId;
	private String tableId;
	private String waiterId;
	private List<String> dishes;
	private double totalPrice;
	
	public Booking(String customerId, String tableId, String waiterId, List<String> dishes, double totalPrice) {
		this.id = UUID.randomUUID().toString();
		this.customerId = customerId;
		this.tableId = tableId;
		this.waiterId = waiterId;
		this.dishes = dishes;
		this.totalPrice = totalPrice;
	}
	
	public String getId() {
		return this.id;
	}
}


