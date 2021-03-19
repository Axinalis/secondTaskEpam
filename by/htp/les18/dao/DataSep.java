package by.htp.les18.dao;

public class DataSep {
	private static String dataSeparator = "\\s+_\\|_\\s+";
	private static String dataBridge = " _|_ ";
	
	public static String getSep() {
		return dataSeparator;
	}
	
	public static String getBridge() {
		return dataBridge;
	}
}
