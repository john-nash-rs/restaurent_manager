package booking;

import dish.Dish;
import storage.IStorageService;

public class BookingServiceImplem implements IBookingService{
	IStorageService storage;

	public BookingServiceImplem(IStorageService storage) {
		this.storage = storage;
	}

	public boolean generateBill(Booking booking) {

		if(booking == null) {
			System.out.println("Invalid Booking");
			return false;
		}

		return storage.generateBill(booking);
	}
}
