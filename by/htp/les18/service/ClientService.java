package by.htp.les18.service;

public interface ClientService {
	
	boolean logination(String login, String password) throws ServiceException;
	void changeProfile(String request);
}
