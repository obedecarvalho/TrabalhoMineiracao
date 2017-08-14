package music4U.antigo;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		//DataSet d = new Entrada().getConteudoArquivoTratado("/home/obede/Documentos/eclipse-workspace/TrabalhoMineiracao/data/letras_musicas_tfidf.arff");
		ArrayList<Music> d = Entrada.getConteudoArquivoLetras("/home/obede/Documentos/eclipse-workspace/TrabalhoMineiracao/data/letras_musicas.arff");
		for (Music m : d){
			System.out.println(m);
		}
//		for (String s : d.attributes){
//			System.out.println(s);
//		}
//		System.out.println("-----------------------------------------------------");
//		for (Instancia i : d.instancias){
//			System.out.println(i.entities);
//			System.out.println(i.clazz);
//		}
//		Instancia ant = null;
//		for (Instancia a : d.instancias){
//			if (a.clazz.equals("true") && ant != null){
//				System.out.println(Similaridade.calcularSimilaridade(a, ant));
//				ant = a;
//			} else if (a.clazz.equals("true")){
//				ant = a;
//			}
//		}
//		double maior = 0;
//		Instance c = null;
//		Instance w = null;
//		for (Instance a : d.instances){
//			for (Instance b : d.instances){
//				if (!a.equals(b)){
//					double atual = Similaridade.calcularSimilaridade(a, b);
//					if (atual > maior){
//						System.out.println(maior);
//						maior = atual;
//						c = a;
//						w = b;
//					}
//				}
//			}
//		}
//		System.out.println(maior);
//		System.out.println(c);
//		System.out.println(w);
//		//teste();
	}
	
	public static void teste(){
		Attribute a = new Attribute(1, 0.0);
		Attribute b = new Attribute(2, 0.0);
		Attribute c = new Attribute(3, 0.0);
		Attribute d = new Attribute(4, 0.0);
		Attribute e = new Attribute(5, 0.0);
		Attribute f = new Attribute(6, 0.0);
		Attribute g = new Attribute(7, 0.0);
		Attribute h = new Attribute(8, 0.0);
		Instance aa = new Instance();
		aa.attributes.put(1, a);
		aa.attributes.put(4, d);
		aa.attributes.put(6, f);
		aa.attributes.put(7, g);
		Instance bb = new Instance();
		bb.attributes.put(8, h);
		bb.attributes.put(2, b);
		bb.attributes.put(3, c);
		bb.attributes.put(5, e);
		System.out.println(Similaridade.calcularSimilaridade(aa, bb));
	}

}
