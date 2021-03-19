package by.htp.les18.dao;

import java.util.List;

import by.htp.les18.bean.Appliance;

public interface FindApplianceDAO {

	List<Appliance> findByCategory(String name) throws DAOException;
}
