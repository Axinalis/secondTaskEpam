package by.htp.les18.dao;

import by.htp.les18.dao.impl.FileFindApplianceDAO;
import by.htp.les18.dao.impl.FileUserDAO;

public final class DAOProvider {
	
	private static final DAOProvider instance = new DAOProvider();

	private final UserDAO userDAO = new FileUserDAO();
	private final FindApplianceDAO findApplianceDAO = new FileFindApplianceDAO();
	
	private DAOProvider() {}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public FindApplianceDAO getFindApplianceDAO() {
		return findApplianceDAO;
	}

	public static DAOProvider getInstance() {
		return instance;
	}	
}
