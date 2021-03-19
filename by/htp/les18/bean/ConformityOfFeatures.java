package by.htp.les18.bean;

import java.util.*;

public class ConformityOfFeatures {

	private static final ConformityOfFeatures instance = new ConformityOfFeatures();

	private List<List<String>> nameOfFeature;
	private List<TYPE_OF_FEATURE> typeOfFeature;

	private ConformityOfFeatures() {
		nameOfFeature = new ArrayList<>();
		typeOfFeature = new ArrayList<>();
		setNewType(TYPE_OF_FEATURE.BAG_TYPE, "BAG_TYPE", "Bag type");
		setNewType(TYPE_OF_FEATURE.BATTERY_CAPACITY, "BATTERY_CAPACITY", "Battery capacity");
		setNewType(TYPE_OF_FEATURE.CAPACITY, "CAPACITY", "Capacity");
		setNewType(TYPE_OF_FEATURE.CLEANING_WIDTH, "CLEANING_WIDTH", "Cleaning width");
		setNewType(TYPE_OF_FEATURE.COLOR, "COLOR", "Color");
		setNewType(TYPE_OF_FEATURE.CORD_LENGTH, "CORD_LENGTH", "Cord length");
		setNewType(TYPE_OF_FEATURE.CPU, "CPU", "CPU");
		setNewType(TYPE_OF_FEATURE.DEPTH, "DEPTH", "Depth");
		setNewType(TYPE_OF_FEATURE.DISPLAY_INCHES, "DISPLAY_INCHES", "Display inches");
		setNewType(TYPE_OF_FEATURE.FILTER_TYPE, "FILTER_TYPE", "Filter type");
		setNewType(TYPE_OF_FEATURE.FLASH_MEMORY_CAPACITY, "FLASH_MEMORY_CAPACITY", "Flash memory capacity");
		setNewType(TYPE_OF_FEATURE.FREEZER_CAPACITY, "FREEZER_CAPACITY", "Freezer capacity");
		setNewType(TYPE_OF_FEATURE.FREQENCY_RANGE, "FREQENCY_RANGE", "Frequency range");
		setNewType(TYPE_OF_FEATURE.HEAT_TIME, "HEAT_TIME", "Heat time");
		setNewType(TYPE_OF_FEATURE.HEIGHT, "HEIGHT", "Height");
		setNewType(TYPE_OF_FEATURE.MATERIAL, "MATERIAL", "Material");
		setNewType(TYPE_OF_FEATURE.MAX_TEMPERATURE, "MAX_TEMPERATURE", "Max temperature");
		setNewType(TYPE_OF_FEATURE.MEMORY_ROM, "MEMORY_ROM", "Memory ROM");
		setNewType(TYPE_OF_FEATURE.MOTOR_SPEED_REGULATION, "MOTOR_SPEED_REGULATION", "Motor speed regulation");
		setNewType(TYPE_OF_FEATURE.NUMBER_OF_SPEAKERS, "NUMBER_OF_SPEAKERS", "Number of speakers");
		setNewType(TYPE_OF_FEATURE.OP_SYSTEM, "OP_SYSTEM", "Operating system");
		setNewType(TYPE_OF_FEATURE.OVERALL_CAPACITY, "OVERALL_CAPACITY", "Overall capacity");
		setNewType(TYPE_OF_FEATURE.POWER_CONSUMPTION, "POWER_CONSUMPTION", "Power consumption");
		setNewType(TYPE_OF_FEATURE.SYSTEM_MEMORY, "SYSTEM_MEMORY", "System memory");
		setNewType(TYPE_OF_FEATURE.WAND_TYPE, "WAND_TYPE", "Wand type");
		setNewType(TYPE_OF_FEATURE.WEIGHT, "WEIGHT", "Weight");
		setNewType(TYPE_OF_FEATURE.WIDTH, "WIDTH", "Width");
		setNewType(TYPE_OF_FEATURE.WIRE_LENGTH, "WIRE_LENGTH", "Wire length");

	}

	public static ConformityOfFeatures getInstance() {
		return instance;
	}

	public TYPE_OF_FEATURE getType(String str) {
		for (int i = 0; i < typeOfFeature.size(); i++) {
			if (nameOfFeature.get(i).contains(str)) {
				return typeOfFeature.get(i);
			}
		}
		return TYPE_OF_FEATURE.NO_SUCH_TYPE;
	}

	public String getRawName(TYPE_OF_FEATURE type) {
		for (int i = 0; i < typeOfFeature.size(); i++) {
			if (typeOfFeature.get(i) == type) {
				return nameOfFeature.get(i).get(0);
			}
		}
		return null;
	}

	public String getName(TYPE_OF_FEATURE type) {
		for (int i = 0; i < typeOfFeature.size(); i++) {
			if (typeOfFeature.get(i) == type) {
				return nameOfFeature.get(i).get(1);
			}
		}
		return null;
	}

	public String getName(String str) {
		for (int i = 0; i < typeOfFeature.size(); i++) {
			if (nameOfFeature.get(i).contains(str)) {
				if (nameOfFeature.get(i).get(0) == str) {
					return nameOfFeature.get(i).get(1);
				} else {
					return nameOfFeature.get(i).get(0);
				}
			}
		}
		return null;
	}

	public boolean exists(String str) {
		for (int i = 0; i < typeOfFeature.size(); i++) {
			if(nameOfFeature.get(i).contains(str)) {
				return true;
			}
		}
		return false;
	}

	private void setNewType(TYPE_OF_FEATURE newType, String newRawName, String newName) {
		List<String> buffer = new ArrayList<>();
		buffer.add(newRawName);
		buffer.add(newName);
		nameOfFeature.add(buffer);
		typeOfFeature.add(newType);
	}

}