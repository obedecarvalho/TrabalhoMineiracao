package music4U;

import java.io.File;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;

public class MusicFile {
	
	public Instances instances;
	private String path;
	public static String path3 = "/home/obede/Documentos/eclipse-workspace/TrabalhoMineiracao/data_current/letras_musicas_historico.arff";
	public static String path2 = "/home/obede/Documentos/eclipse-workspace/TrabalhoMineiracao/data_current/letras_musicas.arff";
	
	public MusicFile(String path) {
		this.path = path;
		loadDataSet();
	}
	
	private Instances loadDataSet(){
		try {
			DataSource source;
			source = new DataSource(path);
			instances = source.getDataSet();
			if (instances.classIndex() == -1) {
	             instances.setClassIndex(instances.numAttributes() - 1);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addInstance(Instance i){
		instances.add(i);
	}
	
	public Instances getDataSet(){
		return instances; 
	}
	
	public void saveDataSet(){
		try {
			ArffSaver saver = new ArffSaver();
			saver.setInstances(instances);
			saver.setFile(new File(path + "0"));
			//saver.setDestination(new File(path));
			saver.writeBatch();
		} catch (Exception e) {			
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
