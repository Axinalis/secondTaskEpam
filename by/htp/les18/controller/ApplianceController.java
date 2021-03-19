package by.htp.les18.controller;

import by.htp.les18.controller.command.Command;
import by.htp.les18.dao.DataSep;
import by.htp.les18.controller.command.CommandProvider;

public class ApplianceController implements Controller{
	
	private final CommandProvider provider = new CommandProvider();
	
	public String doAction(String request) {
		String commandName;
		commandName = request.split(DataSep.getSep(),2)[0];

		Command command;
		command = provider.getCommand(commandName);
		
		String response;
		response = command.execute(request);
		
		return response;
	}

}
