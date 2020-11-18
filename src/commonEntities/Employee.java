package commonEntities;

public class Employee extends PersonalInfo{
	private String designation;
	
	public Employee(String name, String countryCode, String phone, String designation) {
		super(name, countryCode, phone);
		this.designation = designation;
	}
	
	public String getDesignation() {
		return this.designation;
	}
}
