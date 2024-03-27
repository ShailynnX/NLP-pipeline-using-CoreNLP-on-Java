package Core;

import java.util.List;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.pipeline.CoreDocument;

import edu.stanford.nlp.semgraph.SemanticGraph;


public class ChineseDemo{

	public static String text = "香港文化博物馆推出“虚拟凡尔赛宫之旅”展览。";

	public static void main(String[] args) {
	ChineseDemo exemple = new ChineseDemo();
	exemple.DIY();
	exemple.Simple();
	}
	
	public void Simple() {
		String props="StanfordCoreNLP-chinese.properties";
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		Annotation document = new Annotation(text);
		pipeline.annotate(document);
        pipeline.prettyPrint(document, System.out);

	}
	public void DIY(){
		String props="StanfordCoreNLP-chinese.properties";

		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	    CoreDocument document = new CoreDocument(text);

		pipeline.annotate(document);
		
		 CoreLabel token = document.tokens().get(0);
		 System.out.println(token);
		 //exemple sur ls 2ème phrase
		 CoreSentence sentence = document.sentences().get(0);
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
