package models;

import java.io.Serializable;

public class Users implements Serializable{
	private static final long serialVersionUID = 3570292232868532331L;
	private int ID ;
	private String name;       
    private String email;   
    private String password;    
    private String phoneNumber;
    
    
    
    
	@Override
	public String toString() {
		return "Users [ID=" + ID + ", name=" + name + ", email=" + email + ", password=" + password + ", phoneNumber="
				+ phoneNumber + "]";
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
    
	
}
