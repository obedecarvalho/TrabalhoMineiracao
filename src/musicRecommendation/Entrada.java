package musicRecommendation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Entrada {

	public DataSet getConteudoArquivo(String file) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fr);
			DataSet d = new DataSet();
			while (buffer.ready()) {
				String line = buffer.readLine();
				if (line.equals("") || line.contains("@relation")) {

				} else if (line.contains("@attribute")) {
					d.attributes.add(line.split(" ")[1]);
				} else if (line.startsWith("{")) {
					tratarInstancia(line.replace("{", "").replace("}", ""), d);
				}
			}
			buffer.close();
			return d;
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado");
			return null;
		} catch (IOException e) {
			System.out.println("Arquivo com formato errado");
			return null;
		}
	}

	public void tratarInstancia(String line, DataSet d) {
		Instancia i = new Instancia();
		String[] a = line.split(",");
		for (String b : a) {
			String[] c = b.split(" ");
			if (c[0].equals("1160")) {
				i.clazz = "true";
			} else {
				Integer ind = new Integer(c[0]);
				Double v = new Double(c[1]);
				i.entities.put(ind, v);
			}
		}
		d.instancias.add(i);
	}

}
