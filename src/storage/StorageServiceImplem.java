package storage;

import java.util.*;

import booking.Booking;
import commonEntities.Customer;
import commonEntities.Designation;
import commonEntities.Employee;
import dish.Dish;
import table.Table;
import booking.Booking;

public class StorageServiceImplem implements IStorageService{
	
	private Map<String, Employee> employees;
	private Map<String, Customer> customers;
	private Map<String, Employee> waiters;
	private Map<String, Table> tables;
	private Map<String, Dish> dishes;
	private Map<String, Booking> bookings;
	
	List<Dish> dishesList;
	
	public StorageServiceImplem() {
		this.employees = new HashMap<>();
		this.customers = new HashMap<>();
		this.waiters = new HashMap<>();
		this.tables = new HashMap<>();
		this.dishes = new HashMap<>();
		this.bookings = new HashMap<>();
		this.dishesList = new ArrayList<>();
	}
	
	public boolean registerAdmin(Employee emp) {
		if(employees.containsKey(emp.getId())) {
			System.out.println("The admin with id " + emp.getId() + " is already registered");
			return false;
		}
		employees.put(emp.getId(), emp);
		System.out.println("The admin with id " +  emp.getId() + " successfully registered");
		return true;
	}
	
	public boolean registerCustomer(Customer cus) {
		if(customers.containsKey(cus.getId())) {
			System.out.println("The customer with id " + cus.getId() + " is already registered");
			return false;
		}
		customers.put(cus.getId(), cus);
		System.out.println("The customer with id " +  cus.getId() + " successfully registered");
		return true;
	}
	
	public boolean registerWaiter(Employee emp) {
		if(waiters.containsKey(emp.getId())) {
			System.out.println("The waiter with id " + emp.getId() + " is already registered");
			return false;
		}
		waiters.put(emp.getId(), emp);
		System.out.println("The waiter with id " +  emp.getId() + " successfully registered");
		return true;
	}
	
	public boolean registerTable(Table table, Employee registeredByAdminId) {
		
		if(!registeredByAdminId.getDesignation().equals(Designation.ADMIN)) {
			System.out.println("The employee is not an admin. So don't have the access to add the table.");
			return false;
		}
		
		if(tables.containsKey(table.getId())) {
			System.out.println("The table with id " + table.getId() + " is already registered");
			return false;
		}
		table.setRegisteredByAdminId(registeredByAdminId.getId());
		tables.put(table.getId(), table);
		System.out.println("The table with id " +  table.getId() + " successfully registered");
		return true;
	}
	
	public boolean registerDish(Dish dish) {
		if(dishes.containsKey(dish.getId())) {
			System.out.println("The dish with id " + dish.getId() + " is already registered");
			return false;
		}
		dishes.put(dish.getId(), dish);
		this.dishesList.add(dish);
		System.out.println("The dish with id " +  dish.getId() + " successfully registered");
		return true;
	}
	
	public boolean generateBill(Booking booking) {
		if(bookings.containsKey(booking.getId())) {
			System.out.println("The booking with id " + booking.getId() + " is already registered");
			return false;
		}
		/*TODO : calculate total price of the ordered food
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		bookings.put(booking.getId(), booking);
		System.out.println("The booking with id " +  booking.getId() + " successfully registered");
		return true;
	}
	
	public boolean assignWaiterToTable(Employee waiter, Table table) {
		if(!tables.containsKey(table.getId())) {
			System.out.println("The table with id " + table.getId() + " is not registered. So the table can't be assigned.");
			return false;
		}
		
		if(!waiters.containsKey(waiter.getId())) {
			System.out.println("The waiter with id " + waiter.getId() + " is not registered. So the waiter can't be assigned.");
			return false;
		}
		for(Map.Entry<String, Customer> entry : customers.entrySet()) {
			Customer customer = entry.getValue();
			if(customer.getTableId().equals(table.getId())) {
				table.setIsAvailable(true);
				customer.setWaiterId(waiter.getId());
			}
			System.out.println("The waiter with id " + waiter.getId() + " is booked a table with id " + table.getId());
			return true;
		}
		System.out.println("Table with id " + table.getId() + " is not assigned to a customer. So the waiter can't be assigned.");
		return false;
	}
	
	public boolean bookTable(Customer cus) {
		if(!customers.containsKey(cus.getId())) {
			System.out.println("The customer with id " + cus.getId() + " is not registered. So can't book a table.");
			return false;
		}
		
		for(Map.Entry<String, Table> entry : tables.entrySet()) {
			Table table = entry.getValue();
			if(table.getIsAvailable()) {
				table.setIsAvailable(true);
				cus.setTableIdId(entry.getKey());
			}
			System.out.println("The customer with id " + cus.getId() + " is booked a table with id " + table.getId());
			return true;
		}
		System.out.println("Table is not available. So the customer with id " + cus.getId() + " can't booked a table.");
		return false;
	}
	
	public List<Dish> checkMenu(Customer cus) {
		System.out.println("Customer with id " + cus.getId() + " is checking the menu.");
		return this.dishesList;
	}
	
	public Booking seeBillOfCustomer(Customer cus) {
		if(cus.getBookingId() == null || cus.getBookingId().equals("") || !bookings.containsKey(cus.getBookingId())) {
			System.out.println("Customer with id " + cus.getId() + " has no order/booking placed against him/her.");
		}
		Booking booking =  bookings.get(cus.getBookingId());
		System.out.println("Customer with id " + cus.getId() + " order/booking is seen by the waiter.");
		return booking;
	}
}
