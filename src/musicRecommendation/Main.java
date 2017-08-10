package musicRecommendation;

public class Main {
	
	public static void main(String[] args) {
		DataSet d = new Entrada().getConteudoArquivo("/home/obede/Documentos/eclipse-workspace/TrabalhoMineiracao/data/letras_musicas_tfidf.arff");
//		for (String s : d.attributes){
//			System.out.println(s);
//		}
//		System.out.println("-----------------------------------------------------");
//		for (Instancia i : d.instancias){
//			System.out.println(i.entities);
//			System.out.println(i.clazz);
//		}
	}

}
