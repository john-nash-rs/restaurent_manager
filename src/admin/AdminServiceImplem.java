package admin;

import commonEntities.Employee;
import storage.IStorageService;
import table.Table;
import commonEntities.Designation;

public class AdminServiceImplem implements IAdminService{
	IStorageService storage;
	
	public AdminServiceImplem(IStorageService storage) {
		this.storage = storage;
	}
	
	public boolean registerAdmin(Employee emp) {
		if(emp == null) {
			System.out.println("Invalid Admin");
			return false;
		}
		
		if(!emp.getDesignation().equals(Designation.ADMIN)) {
			System.out.println("The employee is not an admin. So registration of admin failed.");
			return false;
		}
		
		return storage.registerAdmin(emp);
	}
	
	public boolean assignWaiterToTable(Employee waiter, Table table) {
		if(waiter == null) {
			System.out.println("Invalid waiter. Can't assign this waiter");
			return false;
		}
		
		if(table == null) {
			System.out.println("Invalid table. Can't assign this table.");
			return false;
		}
		
		if(!waiter.getDesignation().equals(Designation.WAITER)) {
			System.out.println("The employee is not waiter. So can't be assigned to a table..");
			return false;
		}
		
		return storage.assignWaiterToTable(waiter, table);
	}
}
