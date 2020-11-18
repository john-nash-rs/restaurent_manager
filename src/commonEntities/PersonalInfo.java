package commonEntities;

public class PersonalInfo {
	private String id;
	private String name;
	private String countryCode;
	private String phone;
	
	public PersonalInfo(String name, String countryCode, String phone) {
		this.id = countryCode + phone;
		this.name = name;
		this.countryCode = countryCode;
		this.phone = phone;
	}
	
	public String getId() {
		return this.id;
	}
}
