package Core;

import edu.stanford.nlp.simple.*;

public class SimpleCoreNLPDemo {
    public static void main(String[] args) { 
        // Créer un document 
        Document doc = new Document("I got my red dress on tonight. Dancing in the dark, in the pale moonlight.");

        for (Sentence sent : doc.sentences()) {  // Will iterate over all sentences
        	for (int count=0; count<sent.length(); count++) {
        		
        		System.out.println("Le "+(count+1)+ "ème mot de la phrase " + sent + " est " + sent.word(count));
        		System.out.println("Le POS du "+(count+1)+ "ème mot de la phrase " + sent + " est " + sent.posTag(count));
        		System.out.println("Le lemma du "+(count+1)+ "ème mot de la phrase " + sent + " est " + sent.lemma(count));
        		System.out.println("Le NER du "+(count+1)+ "ème mot de la phrase " + sent + " est " + sent.nerTag(count));
        		System.out.println("Dependency Parsing du phrase: " + sent + " est " + sent.governor(count));
            	System.out.println("---------------------------------------------------------------————————————————————————————————————————————————");
        	
        	}
        	
        	System.out.println("---------------------------------------------------------------——————————————————————————————————————————————————————");
    		System.out.println("Constituency Parsing du phrase: " + sent + " est " + sent.parse());
    		System.out.println("Natural Logic Polarity: " + sent + " est " + sent.natlogPolarities());

        }
    }
}
