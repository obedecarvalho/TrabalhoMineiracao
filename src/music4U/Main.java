package music4U;

import java.util.ArrayList;

import weka.core.Instance;

public class Main {
	
	public static void main(String[] args) {
		MusicEvaluation musicE = MusicEvaluation.getInstance();
		ArrayList<MusicRecomended> mrs = musicE.getMusicsRecomended();
		ArrayList<MusicRecomended> ins = new ArrayList<>();
		for (int i=0; i<10; i++){
			ins.add(mrs.get(i));
		}
		MusicView mv = MusicView.getInstance();
		
		mv.draw(ins);
	}

}
