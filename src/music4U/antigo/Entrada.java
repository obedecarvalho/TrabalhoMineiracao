package music4U.antigo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Entrada {

	public static DataSet getConteudoArquivoTratado(String file) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fr);
			DataSet conjunto = new DataSet();
			while (buffer.ready()) {
				String line = buffer.readLine();
				if (line.equals("") || line.contains("@relation")) {

				} else if (line.contains("@attribute")) {
					conjunto.attributesDescription.add(line.split(" ")[1]);
				} else if (line.startsWith("{")) {
					getInstance(line.replace("{", "").replace("}", ""), conjunto);
				}
			}
			buffer.close();
			return conjunto;
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado");
			return null;
		} catch (IOException e) {
			System.out.println("Arquivo com formato errado");
			return null;
		}
	}

	public static void getInstance(String line, DataSet conj) {
		Instance inst = new Instance();
		String[] attributes = line.split(",");
		for (String attribute : attributes) {
			String[] attr = attribute.split(" ");
			if (attr[0].equals("1160")) {
				inst.clazz = "true";
			} else {
				Integer index = new Integer(attr[0]);
				Double value = new Double(attr[1]);
				inst.attributes.put(index, new Attribute(index, value));
			}
		}
		conj.instances.add(inst);
	}
	
	public static ArrayList<Music> getConteudoArquivoLetras(String file) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fr);
			ArrayList<Music> conjunto = new ArrayList();
			while (buffer.ready()) {
				String line = buffer.readLine();
				if (line.equals("") || line.contains("@relation")) {

				} else if (line.contains("@attribute")) {
					
				} else if (!line.startsWith("@")) {
					getInstanceLetra(line, conjunto);
				}
			}
			buffer.close();
			return conjunto;
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado");
			return null;
		} catch (IOException e) {
			System.out.println("Arquivo com formato errado");
			return null;
		}
	}

	public static void getInstanceLetra(String line, ArrayList<Music> conj) {
		String[] attributes = line.split(",");
		Music m = new Music(attributes[0].replaceAll("'", ""), attributes[1].replaceAll("'", ""), attributes[2].replaceAll("'", ""));
		conj.add(m);
	}

}
