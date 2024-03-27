package Core;

import java.util.List;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.pipeline.CoreDocument;

import edu.stanford.nlp.semgraph.SemanticGraph;


public class FrenchDemo{

	public static String text = "À l'occasion d'un déplacement à Valençay, dans l'Indre ce vendredi, la première ministre Élisabeth Borne a annoncé s'engager à diviser par deux d'ici l'été le délai pour obtenir un titre d'identité. Son déplacement intervient au lendemain des deux visites chahutées d'Emmanuel Macron, qui s'est rendu mercredi en Alsace, puis jeudi dans l'Hérault.";

	public static void main(String[] args) {
	FrenchDemo exemple = new FrenchDemo();
	exemple.DIY();
	exemple.Simple();
	}
	
	public void Simple() {
		String props="StanfordCoreNLP-french.properties";
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		Annotation document = new Annotation(text);
		pipeline.annotate(document);
        pipeline.prettyPrint(document, System.out);

	}
	public void DIY(){
		String props="StanfordCoreNLP-french.properties";

		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	    CoreDocument document = new CoreDocument(text);

		pipeline.annotate(document);
		
		 CoreLabel token = document.tokens().get(0);
		 System.out.println(token);
		 //exemple sur ls 2ème phrase
		 CoreSentence sentence = document.sentences().get(1);
		 SemanticGraph dependencyParse = sentence.dependencyParse();
		 System.out.println("Example: dependency parse");
		 System.out.println(dependencyParse);
		 System.out.println();
		 
		List<String> posTags = sentence.posTags();
	    System.out.println("Example: pos tags");
	    System.out.println(posTags);
	    System.out.println();
	}
}
