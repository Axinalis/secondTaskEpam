package by.htp.les18.service;

import by.htp.les18.service.impl.ClientServiceImpl;
import by.htp.les18.service.impl.WarehouseServiceImpl;

public class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();

	private final ClientService clientService = new ClientServiceImpl();
	private final WarehouseService warehouseService = new WarehouseServiceImpl();
	
	private ServiceProvider() {
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public WarehouseService getWarehouseService() {
		return warehouseService;
	}
	
	
}
