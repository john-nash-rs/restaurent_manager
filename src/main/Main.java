package main;

import storage.*;
import commonEntities.*;
import admin.*;
import customer.*;
import waiter.*;
import table.*;
import dish.*;
import booking.*;

public class Main {

	public static void main(String[] args) {
		IStorageService storage = new StorageServiceImplem();
		IAdminService admin = new AdminServiceImplem(storage);
		ICustomerService customer = new CustomerServiceImplem(storage);
		IWaiterService waiter = new WaiterServiceImplem(storage);
		ITableService table = new TableServiceImplem(storage);
		IDishService dish = new DishServiceImplem(storage);
		IBookingService booking = new BookingServiceImplem(storage);
		
		Employee admin1 = new Employee("Neha", "+91", "XXXCCCCXXX", Designation.ADMIN);
		admin.registerAdmin(admin1);
		admin.registerAdmin(admin1);
		
		Employee fakeAdmin = new Employee("Neha", "+91", "XXXCCCCXXX", Designation.WAITER);
		admin.registerAdmin(fakeAdmin);
		
		Customer customer1 = new Customer("Neha", "+91", "XXXCCCCXXX");
		customer.registerCustomer(customer1);
		customer.registerCustomer(customer1);
		
		Employee waiter1 = new Employee("Neha", "+91", "XXXCCCCXXX", Designation.WAITER);
		waiter.registerWaiter(waiter1);
		waiter.registerWaiter(waiter1);
		
		Employee fakeWaiter = new Employee("Neha", "+91", "XXXCCCCXXX", Designation.ADMIN);
		waiter.registerWaiter(fakeWaiter);
		
		Table table1 = new Table("Table1");
		table.registerTable(table1, admin1);
		table.registerTable(table1, admin1);
		table.registerTable(table1, waiter1);
		
		Dish maggie = new Dish("Maggie", 20D);
		dish.registerDish(maggie);
		dish.registerDish(maggie);
		
		Dish pizza = new Dish("Pizza", 200D);
		dish.registerDish(pizza);
		
		//Customer
		customer.bookTable(customer1);
		customer.checkMenu(customer1);
		
		//Admin
		admin.assignWaiterToTable(waiter1, table1);
		admin.assignWaiterToTable(fakeWaiter, table1);
		admin.assignWaiterToTable(waiter1, new Table("Table1"));
		
		//Waiter
		waiter.seeBillOfCustomer(customer1);
		
		
	}

}
