package by.htp.les18.service.impl;

import by.htp.les18.bean.User;
import by.htp.les18.currentSession.CurrentUser;
import by.htp.les18.dao.DAOException;
import by.htp.les18.dao.DAOProvider;
import by.htp.les18.dao.DataSep;
import by.htp.les18.dao.UserDAO;
import by.htp.les18.service.ClientService;
import by.htp.les18.service.ServiceException;

public class ClientServiceImpl implements ClientService {

	@Override
	public boolean logination(String login, String password) throws ServiceException {
		// validation
		if (login == null || "".equals(login)) {
			throw new ServiceException("error message");
		}

		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserDAO();

		boolean result;
		try {
			result = userDAO.logination(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return result;
	}

	public void changeProfile(String request) {
		DAOProvider provider = DAOProvider.getInstance();
		UserDAO dao = provider.getUserDAO();

		setChanges(CurrentUser.getCurrentUser(), request);
		try {
			dao.changeProfile(CurrentUser.getCurrentUser());
		} catch(DAOException ex) {
			System.out.println(ex.getMessage());
		}

		
	}

	private void setChanges(User user, String rawString) {
		String[] split = rawString.split(DataSep.getSep());
		String[] buffer;

		for (int i = 1; i < split.length; i++) {
			buffer = split[i].split("\\s+=\\s+");

			switch (buffer[0]) {
			case "login": {
				user.setLoginName(buffer[1]);
				break;
			}
			case "password": {
				user.setPassword(buffer[1]);
				break;
			}
			case "firstname": {
				user.setFirstName(buffer[1]);
				break;
			}
			case "secondname": {
				user.setSecondName(buffer[1]);
				break;
			}
			}
		}
	}

}
