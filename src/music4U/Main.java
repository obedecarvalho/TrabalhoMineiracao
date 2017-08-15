package music4U;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		recomendar();
	}
	
	public static void recomendar(){
		MusicEvaluation musicE = MusicEvaluation.getInstance();
		ArrayList<MusicRecomended> mrs = musicE.getMusicsRecomended();
		ArrayList<MusicRecomended> ins = new ArrayList<>();
		for (int i=0; i<20; i++){
			ins.add(mrs.get(i));
		}
		MusicView mv = MusicView.getInstance();
		mv.draw(ins);
	}

}
