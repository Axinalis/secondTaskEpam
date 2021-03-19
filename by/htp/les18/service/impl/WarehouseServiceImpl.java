package by.htp.les18.service.impl;

import java.util.List;

import by.htp.les18.bean.Appliance;
import by.htp.les18.dao.DAOException;
import by.htp.les18.dao.DAOProvider;
import by.htp.les18.dao.FindApplianceDAO;
import by.htp.les18.service.ServiceException;
import by.htp.les18.service.WarehouseService;

public class WarehouseServiceImpl implements WarehouseService {

	@Override
	public List<Appliance> findByCategory(String name) throws ServiceException {

		DAOProvider daoProvider = DAOProvider.getInstance();
		FindApplianceDAO findApplianceDao = daoProvider.getFindApplianceDAO();

		try {
			return findApplianceDao.findByCategory(name);
		} catch (DAOException ex) {
			throw new ServiceException(ex.getMessage());
		}
	}

}
