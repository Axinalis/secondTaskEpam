package by.htp.les18.bean;

import by.htp.les18.dao.impl.FileUserDAO;

public class User {

	private String firstName;
	private String secondName;
	private String password;
	private String loginName;
	private static FileUserDAO userDAO = new FileUserDAO();

	public User() {
		this.firstName = "Empty";
		this.secondName = "Account";
		this.password = "111111";
		this.loginName = null;
	}

	public User(String password, String loginName) {
		this.firstName = "New";
		this.secondName = "Guest";
		this.password = password;
		if (userDAO.isLoginAvailable(loginName)) {
			this.loginName = loginName;
		} else {
			this.loginName = null;
		}
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}

	public String getSecondName() {
		return this.secondName;
	}

	public void setSecondName(String newSecondName) {
		this.secondName = newSecondName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String newPassword) {
		this.password = newPassword;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String newLoginName) {
		if (userDAO.isLoginAvailable(newLoginName)) {
			this.loginName = newLoginName;
		}
	}
}
