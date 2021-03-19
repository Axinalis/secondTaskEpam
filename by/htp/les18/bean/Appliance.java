package by.htp.les18.bean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Appliance {

	private String name;
	int cost;
	Map<TYPE_OF_FEATURE, String> features;

	public Appliance() {
		features = new HashMap<>();
	}

	public Appliance(String name, int cost) {
		this.name = name;
		this.cost = cost;
		features = new HashMap<>();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public int getCost() {
		return this.cost;
	}

	public void setCost(int newCost) {
		if (newCost >= 0) {
			this.cost = newCost;
		}
	}

	public Map<TYPE_OF_FEATURE, String> getFeatures(TYPE_OF_FEATURE type) {
		Map<TYPE_OF_FEATURE, String> buffer = new HashMap<>();
		if (features.containsKey(type)) {
			buffer.put(type, features.get(type));
			return buffer;
		}
		return null;
	}

	public String getFeatureValue(TYPE_OF_FEATURE type) {
		return features.get(type);
	}

	public void addFeature(TYPE_OF_FEATURE type, String value) {
		features.put(type, value);
	}

	public void removeFeature(TYPE_OF_FEATURE type) {
		features.remove(type);
	}

	public boolean hasFeature(TYPE_OF_FEATURE type) {
		return features.containsKey(type);
	}

	Map<TYPE_OF_FEATURE, String> getFeatures() {
		return new HashMap<TYPE_OF_FEATURE, String>(features);
	}

	public void setFeatures(Map<TYPE_OF_FEATURE, String> setOfFeatures) {
		this.features = setOfFeatures;
	}

	@Override
	public String toString() {
		String buffer = "";
		Set<TYPE_OF_FEATURE> set = features.keySet();
		Iterator<TYPE_OF_FEATURE> iter = set.iterator();
		ConformityOfFeatures cof = ConformityOfFeatures.getInstance();
		TYPE_OF_FEATURE type;
		for (int i = 0; i < set.size(); i++) {
			type = iter.next();
			buffer = buffer.concat('\n' + cof.getName(type) + " - " + features.get(type));
		}

		return ("Name - " + this.name + "\nCost - " + this.cost + buffer);
	}
}
