package table;

import java.util.*;

import commonEntities.Employee;

public class Table {
	private String id;
	private String name;
	private boolean isAvailable;
	private String registeredByAdminId;
	
	public Table(String name) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.isAvailable = true;
	}
	
	public String getId() {
		return this.id;
	}
	
	public boolean getIsAvailable() {
		return this.isAvailable;
	}
	
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public void setRegisteredByAdminId(String registeredByAdminId) {
		this.registeredByAdminId = registeredByAdminId;
	}
}
