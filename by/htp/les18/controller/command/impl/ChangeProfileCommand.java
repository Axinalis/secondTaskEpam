package by.htp.les18.controller.command.impl;

import by.htp.les18.controller.command.Command;
import by.htp.les18.service.ClientService;
import by.htp.les18.service.ServiceProvider;

public class ChangeProfileCommand implements Command {

	@Override
	public String execute(String request) {
		
		ServiceProvider service = ServiceProvider.getInstance();
		ClientService clientService = service.getClientService();
		clientService.changeProfile(request);

		return "Profile changed successfully";
	}

}
