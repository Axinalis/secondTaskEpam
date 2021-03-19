package by.htp.les18.controller.command.impl;

import by.htp.les18.controller.command.Command;
import by.htp.les18.service.ClientService;
import by.htp.les18.service.ServiceException;
import by.htp.les18.service.ServiceProvider;

public class LoginationCommand implements Command {

	@Override
	public String execute(String request) {// "logination"
		String[] params;

		params = request.split("\\s+_\\|_\\s+");
		// check params
		String login;
		String password;

		login = params[1].split("\\s+=\\s+")[1];
		password = params[2].split("\\s+=\\s+")[1];

		ServiceProvider provider = ServiceProvider.getInstance();
		ClientService clientService = provider.getClientService();

		boolean result;
		String response;

		try {
			result = clientService.logination(login, password);
			if (result) {
				response = "Logination went successfully";
			} else {
				response = "Wrong password or login. Try again";
			}
		} catch (ServiceException e) {
			response = e.getMessage();
		}

		return response;
	}

}
