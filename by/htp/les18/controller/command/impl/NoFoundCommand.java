package by.htp.les18.controller.command.impl;

import by.htp.les18.controller.command.Command;

public class NoFoundCommand implements Command {

	@Override
	public String execute(String request) {
		
		return "Invalid command. Please try again";
	}

}
