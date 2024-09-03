package application;

public class Martyr implements Comparable<Martyr>{
	private String name;
	private String event;
	private int age;
	private String location;
	private String district;
	private String gender;
	
	
	public Martyr(String name, String event, int age, String location, String district, String gender) {
		super();
		this.name = name;
		this.event = event;
		this.age = age;
		this.location = location;
		this.district = district;
		this.gender = gender;
	}
	
	
	public Martyr(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@Override
	public int compareTo(Martyr o) {
		if(this.district.toLowerCase().equals(o.getDistrict().toLowerCase())) return this.name.toLowerCase().compareTo(o.getName().toLowerCase());
		return this.district.toLowerCase().compareTo(o.getDistrict().toLowerCase());
	}
	@Override
	public String toString() {
		return "Martyr: name= " + name + ", event= " + event + ", age= " + age + ", location= " + location + ", district= "
				+ district + "Gender= " + gender ;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	
	
}
