package by.htp.les18.currentSession;

import by.htp.les18.bean.*;

public class CurrentUser {
	private static User user = new User();

	static public User getCurrentUser() {
		return user;
	}

	static public void changeUser(User newUser) {
		user = newUser;
	}
	
	static public void printUserInfo() {
		System.out.print(user.getLoginName()+" _|_ "+user.getPassword()+" _|_ "+user.getFirstName()+" _|_ "+user.getSecondName());
	}

}
