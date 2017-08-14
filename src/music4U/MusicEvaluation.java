package music4U;

import java.util.ArrayList;

public class MusicEvaluation {
	
	private ArrayList<MusicRecomended> musics;
	private MusicFile origem;
	private MusicFile classificar;
	private RecomendationSystem rec;
	private static MusicEvaluation INSTANCE;
	
	private MusicEvaluation(){
		init();
	}
	
	public static MusicEvaluation getInstance(){
		if (INSTANCE == null){
			INSTANCE = new MusicEvaluation();
		}
		return INSTANCE;
	}
	
	public void init(){
		origem = new MusicFile(MusicFile.path3);
		classificar = new MusicFile(MusicFile.path2);
		rec = new RecomendationSystem(RecomendationSystem.pathStopWords2, origem);
		this.musics = rec.getListRecomendation(classificar);
	}
	
	public ArrayList<MusicRecomended> getMusicsRecomended(){
		return musics;
	}
	
	public void alterClass(MusicRecomended mr, String clazz){
		mr.alterClass(clazz);
		rec.updateClassify(mr.instance);
		
		origem.addInstance(mr.instance);
		classificar.instances.remove(mr.instance);
		
		origem.saveDataSet();
		classificar.saveDataSet();
	}
}
