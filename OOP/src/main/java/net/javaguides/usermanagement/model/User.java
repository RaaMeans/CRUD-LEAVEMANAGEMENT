package net.javaguides.usermanagement.model;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */
public class User {
	protected int Id;
	protected String Name;
	protected String Email;
	protected String Country;
	
	public User() {
	}
	
	public User(String Name, String Email, String Country) {
		super();
		this.Name = Name;
		this.Email = Email;
		this.Country = Country;
	}

	public User(int Id, String Name, String Email, String Country) {
		super();
		this.Id = Id;
		this.Name = Name;
		this.Email = Email;
		this.Country = Country;
	}

	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String Country) {
		this.Country = Country;
	}
}
