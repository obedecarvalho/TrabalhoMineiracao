package music4U;

import java.util.ArrayList;

public class Similaridade {
	
	public static double calcularSimilaridade(Instance a, Instance b){
		
		ArrayList<Integer> keys = getAllKeys(a, b);
		int count = 0;
		for (Integer key : keys){
			if (a.attributes.containsKey(key) && b.attributes.containsKey(key)){
				count++;
			}
		}
		
		return ((double)count)/((double)keys.size());
	}
	
	public static ArrayList<Integer> getAllKeys(Instance a, Instance b){
		ArrayList<Integer> keys = new ArrayList<>();
		keys.addAll(a.attributes.keySet());
		for (Integer ind : b.attributes.keySet()){
			if (!keys.contains(ind)){
				keys.add(ind);
			}
		}
		return keys;
	}

}
