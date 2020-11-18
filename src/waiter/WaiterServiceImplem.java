package waiter;

import java.util.List;

import commonEntities.Customer;
import commonEntities.Designation;
import commonEntities.Employee;
import dish.Dish;
import storage.IStorageService;
import booking.*;

public class WaiterServiceImplem implements IWaiterService{
	IStorageService storage;

	public WaiterServiceImplem(IStorageService storage) {
		this.storage = storage;
	}

	public boolean registerWaiter(Employee emp) {

		if(emp == null) {
			System.out.println("Invalid Waiter");
			return false;
		}

		if(!emp.getDesignation().equals(Designation.WAITER)) {
			System.out.println("The employee is not an waiter. So registration of waiter failed.");
			return false;
		}

		return storage.registerWaiter(emp);
	}
	
	public boolean placeOrderForCustomer(Customer cus, List<Dish> dishesToOrder) {
		if(cus == null) {
			System.out.println("Invalid Customer. Can't place order.");
			return false;
		}
		
		if(dishesToOrder == null) {
			System.out.println("Invalid Dish. Can't place order.");
			return false;
		}
		
		if(dishesToOrder.size() == 0) {
			System.out.println("No dish chosen by the customer. Can't place order.");
			return false;
		}
		
		cus.setDishesToOrder(dishesToOrder);
		System.out.println("Order placed successfully");
		return true;
	}
	
	public Booking seeBillOfCustomer(Customer cus) {
		if(cus == null) {
			System.out.println("Invalid Customer. Can't see bill.");
			return null;
		}
		return storage.seeBillOfCustomer(cus);
	}
}
