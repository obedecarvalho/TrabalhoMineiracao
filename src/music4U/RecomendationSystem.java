package music4U;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import weka.classifiers.bayes.NaiveBayesMultinomialText;
import weka.core.Instance;
import weka.core.stopwords.WordsFromFile;

public class RecomendationSystem {
	
	private NaiveBayesMultinomialText classifier;
	private String pathStopWords;
	
	public static final String pathStopWords2 = "/home/obede/Documentos/eclipse-workspace/TrabalhoMineiracao/data/stopwords.txt";
	
	public RecomendationSystem(String pathStopWords, MusicFile dataset) {
		this.pathStopWords = pathStopWords;
		init(dataset);
	}
	
	private void init(MusicFile dataset){
		try {
			WordsFromFile handler = new WordsFromFile();
			handler.setStopwords(new File(this.pathStopWords));		
			NaiveBayesMultinomialText n = new NaiveBayesMultinomialText();
			n.setMinWordFrequency(5.0);
			n.setUseWordFrequencies(true);
			n.setStopwordsHandler(handler);
			n.buildClassifier(dataset.getDataSet());
			classifier = n;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateClassify(Instance i){
		try {
			classifier.updateClassifier(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public double[] classify(Instance i){
		try {
			return classifier.distributionForInstance(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<MusicRecomended> getListRecomendation(MusicFile classify){
		ArrayList<MusicRecomended> musics = new ArrayList<>();
		for (Object i : classify.getDataSet().toArray()){
			musics.add(new MusicRecomended((Instance) i, classify((Instance)i)));
		}
		Collections.sort(musics);
		Collections.reverse(musics);
		return musics;
	}

}
