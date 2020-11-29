package CS180Project5;

import java.util.ArrayList;

/**
 * Project 5
 *
 * Received guidance from Stack Overflow and high school friend
 *
 * @author Simon Twiss, Saul Means, Timothy Porterfield
 * @version 11/28/2020
 *
 */

public class User {
	private String userName;
	private String password;
	private String email;
	private long phoneNumber;
	
	public User(String userName, String password, String email, long phoneNumber) {
		try {
			this.userName = userName;
			this.password = password;
			this.email = email;
			this.phoneNumber = phoneNumber;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setUserName(String userName) {
		try {
			this.userName = userName;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getUserName() {
		try {
			return this.userName;
		} catch (Exception e) {
			e.printStackTrace();
			return null; // default return statement for when Exceptions are found
		}
	}
	
	public void setPassword(String password) {
		try {
			this.password = password;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getPassword() {
		try {
			return this.password;
		} catch (Exception e) {
			e.printStackTrace();
			return null; // default return statement for when Exceptions are found
		}
	}
	
	public void setEmail(String email) {
		try {
			this.email = email;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getEmail() {
		try {
			return this.email;
		} catch (Exception e) {
			e.printStackTrace();
			return null; // default return statement for when Exceptions are found
		}
	}
	
	public void setPhoneNumber(long phoneNumber) {
		try {
			this.phoneNumber = phoneNumber;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public long getPhoneNumber() {
		try {
			return this.phoneNumber;
		} catch (Exception e) {
			e.printStackTrace();
			return -1; // default return statement for when Exceptions are found
		}
	}
	
	public String toString() {
		try {
			return this.userName + "," + this.password + "," + this.email + "," + this.phoneNumber;
		} catch (Exception e) {
			e.printStackTrace();
			return null; // default return statement for when Exceptions are found
		}
	}
}