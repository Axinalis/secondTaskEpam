package by.htp.les18.dao.impl;

import java.io.*;

import java.util.*;
import by.htp.les18.bean.*;
import by.htp.les18.dao.DAOException;
import by.htp.les18.dao.FindApplianceDAO;

public class FileFindApplianceDAO implements FindApplianceDAO {

	@Override
	public List<Appliance> findByCategory(String name) throws DAOException {

		List<Appliance> listOfFoundProducts = new ArrayList<Appliance>();

		try {

			FileReader databaseFile = new FileReader("resources//appliances.db");
			BufferedReader reader = new BufferedReader(databaseFile);
			String bufferLineForDatabase = reader.readLine();

			while (bufferLineForDatabase != null) {
				if (lineFitsCondition(bufferLineForDatabase, name)) {
					listOfFoundProducts.add(getProductFromString(bufferLineForDatabase));
				}
				bufferLineForDatabase = reader.readLine();
			}

			reader.close();
			
			if (listOfFoundProducts.isEmpty()) {
				return null;
			} else {
				return listOfFoundProducts;
			}

		} catch (FileNotFoundException ex) {
			throw new DAOException("Database file not found");
		} catch (IOException ex) {
			throw new DAOException("Cannot read database file");
		}
		
	}

	private boolean lineFitsCondition(String rawLine, String nameOfProduct) {
		String bufferString = rawLine.split("\\s+:\\s+")[0];
		if (bufferString.equals(nameOfProduct)) {
			return true;
		} else {
			return false;
		}
	}

	private Appliance getProductFromString(String rawLine) {

		Appliance appl = new Appliance();
		String[] firstSplit;
		String[] secondSplit;
		ConformityOfFeatures transform = ConformityOfFeatures.getInstance();

		firstSplit = rawLine.split("\\s+:\\s+");
		secondSplit = firstSplit[1].split(",\\s+");

		appl.setName(firstSplit[0]);

		for (int i = 0; i < secondSplit.length; i++) {
			firstSplit = secondSplit[i].split("=");
			if (firstSplit[0].equals("COST")) {
				appl.setCost(Integer.parseInt(firstSplit[1]));
			} else {
				if (transform.exists(firstSplit[0])) {
					appl.addFeature(transform.getType(firstSplit[0]), firstSplit[1]);
				}
			}
		}
		return appl;

	}
}
