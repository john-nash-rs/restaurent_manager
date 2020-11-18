package dish;

import storage.IStorageService;
import table.Table;

public class DishServiceImplem implements IDishService{
	IStorageService storage;

	public DishServiceImplem(IStorageService storage) {
		this.storage = storage;
	}

	public boolean registerDish(Dish dish) {

		if(dish == null) {
			System.out.println("Invalid Dish");
			return false;
		}

		return storage.registerDish(dish);
	}
}
