package customer;

import java.util.List;

import commonEntities.Customer;
import commonEntities.Designation;
import commonEntities.Employee;
import dish.Dish;
import storage.IStorageService;

public class CustomerServiceImplem implements ICustomerService{
	IStorageService storage;
	
	public CustomerServiceImplem(IStorageService storage) {
		this.storage = storage;
	}
	
	public boolean registerCustomer(Customer cus){
		if(cus == null) {
			System.out.println("Invalid Customer");
			return false;
		}
		
		return storage.registerCustomer(cus);
	}
	
	public boolean bookTable(Customer cus) {
		if(cus == null) {
			System.out.println("Invalid Customer. So can't book a table.");
			return false;
		}
		
		return storage.bookTable(cus);
	}
	
	public List<Dish> checkMenu(Customer cus) {
		if(cus == null) {
			System.out.println("Invalid Customer. So can't check a menu.");
			return null;
		}
		
		return storage.checkMenu(cus);
	}
}
