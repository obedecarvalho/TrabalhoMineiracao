package exemplo;

import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.attribute.StringToWordVector; //tf idf
import weka.core.Instances;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.classifiers.lazy.IBk;


public class Exemplo {
    public static void main(String[] args) throws Exception {
        //------------------------------------------------------
        // (1) importação da base de dados de treinamento
        //------------------------------------------------------
         DataSource source = new DataSource("/home/otavio/eclipse-workspace/TrabalhoMineiracao/src/exemplo/weather.arff");
         Instances D = source.getDataSet();
         
         // 1.1 - espeficicação do atributo classe
         if (D.classIndex() == -1) {
             D.setClassIndex(D.numAttributes() - 1);
         }
        //------------------------------------------------------
        // (2) Construção do modelo classificador (treinamento)
        //------------------------------------------------------
         IBk k3 = new IBk(3);
         k3.buildClassifier(D);
         
        //------------------------------------------------------
        // (3) Classificando um novo exemplo
        //------------------------------------------------------
         
         // 3.1 criação de uma nova instância
         Instance newInst = new DenseInstance(5);
         newInst.setDataset(D);
         newInst.setValue(0, "sunny");
         newInst.setValue(1, 80);
         newInst.setValue(2, 75);
         newInst.setValue(3, "TRUE");
         // 3.2 classificação de uma nova instância
         double pred = k3.classifyInstance(newInst);
 
         // 3.3 imprime o valor de pred
         System.out.println("Predição: " + pred);
         
    }
}
