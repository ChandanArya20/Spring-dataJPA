package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	Integer id;
	String city;
	String country;
	Integer pincode;
	Integer age;
	String name;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", city=" + city + ", country=" + country + ", pincode=" + pincode + ", age=" + age
				+ ", name=" + name + "]";
	}
	
	
	
}
