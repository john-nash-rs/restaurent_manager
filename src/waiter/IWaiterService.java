package waiter;

import commonEntities.*;
import dish.*;
import java.util.*;
import booking.*;

public interface IWaiterService {
	public boolean registerWaiter(Employee emp);
	public boolean placeOrderForCustomer(Customer cus, List<Dish> dishes);
	public Booking seeBillOfCustomer(Customer cus);
}
