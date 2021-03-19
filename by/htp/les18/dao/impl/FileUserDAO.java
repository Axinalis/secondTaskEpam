package by.htp.les18.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import by.htp.les18.bean.User;
import by.htp.les18.currentSession.CurrentUser;
import by.htp.les18.dao.DAOException;
import by.htp.les18.dao.DataSep;
import by.htp.les18.dao.UserDAO;

public class FileUserDAO implements UserDAO {

	@Override
	public boolean logination(String login, String password) throws DAOException {
		boolean result = false;
		User user = new User();
		try {
			user = getUserFromDatabase(login);
			if (user == null) {
				throw new DAOException("No such user in database");
			}

			if (user.getPassword().equals(password)) {
				result = true;
				CurrentUser.changeUser(user);
			} else {
				result = false;
			}

		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		}

		return result;
	}

	@Override
	public void changeProfile(User user) throws DAOException {
		try {
			File tmp = File.createTempFile("tmp", "");
			//File oldDataFile = new File("resources//users.db");
			BufferedReader fileReader = new BufferedReader(new FileReader("resources//users.db"));
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(tmp));
			String buffer = fileReader.readLine();

			while (buffer != null) {
				if (!hasRightLogin(buffer, user.getLoginName())) {
					fileWriter.write(buffer + '\n');
				} else {
					fileWriter.write(user.getLoginName() + DataSep.getBridge());
;					fileWriter.write(user.getPassword() + DataSep.getBridge());
					fileWriter.write(user.getFirstName() + DataSep.getBridge());
					fileWriter.write(user.getSecondName() + '\n');
				}
				buffer = fileReader.readLine();

			}
		
			fileReader.close();
			fileWriter.close();
			
			File oldFile = new File("resources//users.db");
			if(oldFile.delete()) {
				tmp.renameTo(oldFile);
			}

		} catch (FileNotFoundException ex) {
			throw new DAOException("Database file not found");
		} catch (IOException ex) {
			throw new DAOException("Cannot read database file");
		}
	}

	public boolean isLoginAvailable(String loginName) {
		try {
			FileReader reader = new FileReader("resources//users.db");
			String bufferLine = getLine(reader);
			while (bufferLine != null) {
				if (hasRightLogin(bufferLine, loginName)) {
					return false;
				}
				bufferLine = getLine(reader);
			}
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public User getUserFromDatabase(String login) throws IOException, FileNotFoundException {
		try {
			FileReader reader = new FileReader("resources//users.db");
			String bufferLine = getLine(reader);
			while (bufferLine != null) {
				if (hasRightLogin(bufferLine, login)) {

					return fromStringToUser(bufferLine);
				}
				bufferLine = getLine(reader);
			}
			return null;
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			throw ex;
		} catch (IOException ex) {
			ex.printStackTrace();
			throw ex;
		}

	}

	private String getLine(FileReader databaseFile) throws IOException {
		BufferedReader reader = new BufferedReader(databaseFile);
		try {
			return reader.readLine();
		} catch (IOException ex) {
			throw ex;
		}
	}

	private boolean hasRightLogin(String rawLine, String loginName) throws IOException {
		String[] bufferSplit;
		bufferSplit = rawLine.split(DataSep.getSep());

		if (bufferSplit[0].equals(loginName)) {
			return true;
		} else {
			return false;
		}
	}

	private User fromStringToUser(String str) {
		String[] split;
		User newUser = new User();

		split = str.split(DataSep.getSep());
		newUser.setLoginName(split[0]);
		newUser.setPassword(split[1]);
		newUser.setFirstName(split[2]);
		newUser.setSecondName(split[3]);

		return newUser;
	}
}
