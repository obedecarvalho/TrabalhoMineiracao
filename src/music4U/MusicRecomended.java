package music4U;

import weka.core.Instance;

public class MusicRecomended implements Comparable<MusicRecomended> {
	public Instance instance;
	public double [] acuracy;
	
	public MusicRecomended(Instance i, double [] p) {
		this.instance = i;
		this.acuracy = p;
	}

	@Override
	public int compareTo(MusicRecomended o) {
		return acuracy[0] < o.acuracy[0] ? -1 : acuracy[0] > o.acuracy[0] ? 1 : 0;
	}
	
	public void alterClass(String clazz){
		instance.setValue(instance.numAttributes()-1, clazz);
	}
}
