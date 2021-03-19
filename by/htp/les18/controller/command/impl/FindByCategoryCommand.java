package by.htp.les18.controller.command.impl;

import java.util.List;

import by.htp.les18.bean.Appliance;
import by.htp.les18.controller.command.Command;
import by.htp.les18.dao.DataSep;
import by.htp.les18.service.ServiceException;
import by.htp.les18.service.ServiceProvider;
import by.htp.les18.service.WarehouseService;

public class FindByCategoryCommand implements Command {

	@Override
	public String execute(String request) {

		ServiceProvider provider = ServiceProvider.getInstance();
		WarehouseService warehouse = provider.getWarehouseService();
		List<Appliance> buffer;
		String result;

		try {
			buffer = warehouse.findByCategory(request.split(DataSep.getSep())[1]);
			for (int i = 0; i < buffer.size(); i++) {
				System.out.println("/-----------------\\");
				System.out.println(buffer.get(i).toString());
				System.out.println("\\-----------------/");
			}
			result = "Found " + buffer.size() + " aplpliances";
		} catch (ServiceException ex) {
			result = ex.getMessage();
		} catch (NullPointerException ex) {
			result = "No appliances found";
		}

		return result;
	}

}
