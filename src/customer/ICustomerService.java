package customer;

import java.util.List;

import commonEntities.Customer;
import dish.Dish;

public interface ICustomerService {
	public boolean registerCustomer(Customer cus);
	public boolean bookTable(Customer cus);
	public List<Dish> checkMenu(Customer cus);
}
