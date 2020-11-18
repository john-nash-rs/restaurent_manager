package commonEntities;

import java.util.*;

import dish.Dish;

public class Customer extends PersonalInfo{
	private String waiterId;
	private String tableId;
	private List<Dish> dishesToOrder;
	private String bookingId;
	
	public Customer(String name, String countryCode, String phone) {
		super(name, countryCode, phone);
	}
	
	public String getBookingId() {
		return this.bookingId;
	}
	
	public String getTableId() {
		return this.tableId;
	}
	
	public String getWaiterId() {
		return this.waiterId;
	}
	
	public void setTableIdId(String tableId) {
		this.tableId = tableId;
	}
	
	public void setWaiterId(String waiterId) {
		this.waiterId = waiterId;
	}
	
	public void setDishesToOrder(List<Dish> dishesToOrder) {
		this.dishesToOrder = dishesToOrder;
	}
}
