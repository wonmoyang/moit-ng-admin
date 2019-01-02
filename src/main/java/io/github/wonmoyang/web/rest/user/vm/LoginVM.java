package io.github.wonmoyang.web.rest.user.vm;

public class LoginVM {

	private String userName;
	private String password;
	
	public LoginVM() {}
	
	public LoginVM(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginVM - (" + super.toString() + ")";
	}
	
}
