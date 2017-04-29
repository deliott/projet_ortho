package main_file;

import java.io.IOException;
import java.util.LinkedList;

public class auxiliaire {

	public static String auxiliaire (String word) throws IOException{
		
		String pathDico = "C:/Documents and Settings/Dupont/workspace/Correcteur_ortho/BDD_WORDS";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String[] Dico = TakeDico.takeDico(pathDico);

		LinkedList<String> realWords = new LinkedList<String>();
		String correctedWord;

		
		if ((CheckWord.checkWord(word,Dico))==true)
			{
			System.out.println("Le mot corrigé est : ");
			System.out.println(word);
			//p.giveDecision("- " + word + " - est correctement orthographié !");
			correctedWord = word;
			}
		else
			{
			//if ((Triple.CheckTriple(word,Dico))==true)
			//{p.giveDecision();}
			//else{
				String[] Words = PossibleRealWords.possibleRealWords(word,1,alphabet);
			
			//System.out.println("résultat normal" + Words + "tentative =");
			realWords = SearchingWords.searchingWords(Dico,Words);
			//p.giveWordsList(realWords);
			//p.;
			//System.out.println(realWords);
			int[] Cost = new int[realWords.size()];
			Cost = GetCost.getCost(realWords,word);
			correctedWord = Decision.decision(realWords,Cost);
			//System.out.println("Le mot corrigé est : ");
			//System.out.println(correctedWord);
			//p.giveDecision(correctedWord);
			//}
	
	}
		return(correctedWord)	;			
	}
	

	
}
