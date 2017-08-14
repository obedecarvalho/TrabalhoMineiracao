package music4U;

import java.util.HashMap;

public class Instance {
	public static Integer n = 0; 
	public HashMap<Integer,Attribute> attributes;
	public String clazz = "false";
	public Integer index;
	public Instance() {
		attributes = new HashMap<>();
		index = n;
		n++;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Instance)){
			return false;
		}
		Instance n = (Instance) obj;
		if (n.attributes.size() == attributes.size()){
			for (Integer i : attributes.keySet()){
				if (!n.attributes.containsKey(i)){
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}
}
