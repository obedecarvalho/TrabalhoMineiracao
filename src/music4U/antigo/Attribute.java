package music4U.antigo;

public class Attribute {
	
	public Integer index;
	public Double value;
	
	public Attribute(Integer index, Double value) {
		this.index = index;
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Attribute){
			Attribute n = (Attribute) obj;
			if (n.index.equals(index) && n.value.equals(value)){
				return true;
			}
		}
		return false;
	}


}
