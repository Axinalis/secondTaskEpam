package by.htp.les18.dao;

import by.htp.les18.bean.User;

public interface UserDAO {

	boolean logination(String login, String password) throws DAOException;
	void changeProfile(User user) throws DAOException;
	
}
