package admin;
import table.*;

import commonEntities.Employee;

public interface IAdminService {
	public boolean registerAdmin(Employee emp);
	public boolean assignWaiterToTable(Employee waiter, Table table);
	
}
