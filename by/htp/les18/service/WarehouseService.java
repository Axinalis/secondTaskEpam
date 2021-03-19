package by.htp.les18.service;

import java.util.List;

import by.htp.les18.bean.Appliance;

public interface WarehouseService {
	
	List<Appliance> findByCategory(String name)  throws ServiceException;

}
