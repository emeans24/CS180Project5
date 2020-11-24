import java.util.ArrayList;

public class User {
	private String userName;
	private String password;
	private String email;
	private long phoneNumber;
	
	public User(String userName, String password, String email, long phoneNumber) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public long getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String toString() {
		return this.userName + "," + this.password + "," + this.email + "," + this.phoneNumber;
	}
}