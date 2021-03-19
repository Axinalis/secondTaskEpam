package by.htp.les18.main;

import by.htp.les18.controller.ApplianceController;
import by.htp.les18.controller.Controller;

public class Main {
	
	public static void main(String[] args) {
		Controller controller = new ApplianceController();
				
		String request;
		String response;
		
		request = "logination _|_ login = ivan _|_ password = 8686868";
		request = "findbycategory _|_ Oven";
		
		response = controller.doAction(request);
		
		System.out.println(response);

	}

}
