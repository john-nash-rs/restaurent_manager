package storage;

import java.util.List;

import booking.Booking;
import commonEntities.Customer;
import commonEntities.Employee;
import dish.Dish;
import table.Table;

public interface IStorageService {
	public boolean registerAdmin(Employee emp);
	public boolean registerCustomer(Customer cus);
	public boolean registerWaiter(Employee emp);
	public boolean registerTable(Table table, Employee emp);
	public boolean registerDish(Dish dish);
	public boolean generateBill(Booking booking);
	public boolean assignWaiterToTable(Employee waiter, Table table);
	public boolean bookTable(Customer cus);
	public List<Dish> checkMenu(Customer cus);
	public Booking seeBillOfCustomer(Customer cus);
}
