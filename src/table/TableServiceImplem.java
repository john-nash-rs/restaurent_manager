package table;

import commonEntities.*;
import storage.IStorageService;

public class TableServiceImplem implements ITableService{
	
	IStorageService storage;
	
	public TableServiceImplem(IStorageService storage) {
		this.storage = storage;
	}
	
	public boolean registerTable(Table table, Employee registeredByAdminId){

		if(table == null) {
			System.out.println("Invalid Table. Table can't be registered.");
			return false;
		}
		
		if(registeredByAdminId == null) {
			System.out.println("Invalid Admin.Admin can't register table.");
			return false;
		}
		
		return storage.registerTable(table, registeredByAdminId);
	}
}
