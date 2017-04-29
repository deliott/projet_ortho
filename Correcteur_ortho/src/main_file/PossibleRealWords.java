package main_file;

import java.util.LinkedList;

public class PossibleRealWords {
	

	public static String[] possibleRealWords(String word, int numberOfLettersToChopAddSwich, String alphabet) {
		
		LinkedList<String> added = new LinkedList<String>();
		LinkedList<String> choped = new LinkedList<String>();
		LinkedList<String> swich = new LinkedList<String>();
		//LinkedList<String> Words = new LinkedList<String>();
		
		added = addLetters(word,numberOfLettersToChopAddSwich,alphabet);
		String[] convertedAdded = new String[added.size()];
		convertedAdded = convert(added);
		
		choped = chopLetters(word,numberOfLettersToChopAddSwich);
		String[] convertedChoped = new String[choped.size()];
		convertedChoped = convert(choped);
		
		swich = swichLetters(word,numberOfLettersToChopAddSwich,alphabet);
		String[] convertedSwich = new String[swich.size()];
		convertedSwich = convert(swich);
		
		String[] convertedWords = new String[added.size()+choped.size()+swich.size()];
		
		for (int j=0;j<added.size();j+=1)
		{
			convertedWords[j] = convertedAdded[j];
		}
		
		for (int j=added.size();j<added.size() + choped.size();j+=1)
		{
			convertedWords[j] = convertedChoped[j-added.size()];
		}
		for (int j=added.size() + choped.size();j<added.size() + choped.size() + swich.size();j+=1)
		{
			convertedWords[j] = convertedSwich[j-(added.size() + choped.size())];
		}
		
		//added.addAll(choped);
		//added.addAll(swich);
		//Words = added;
		
		return convertedWords;
	}
	
	private static String[] convert(LinkedList<String> toConvert)
	{
		String[] converted = new String[toConvert.size()];
		for (int j=0;j<toConvert.size();j+=1)
		{
			converted[j] = toConvert.get(j);
		}
		return converted;
	}
	
	private static LinkedList<String> swichLetters(String word,int numberToSwich,String alphabet){
		
		LinkedList<String> Swiched = new LinkedList<String>();
		LinkedList<String> NextToSwich = new LinkedList<String>();
		NextToSwich.add(word);
		for ( int numberSwiched=0;numberSwiched<numberToSwich;numberSwiched+=1)
		{
			LinkedList<String> ToSwich = new LinkedList<String>();
			for (int j=0;j<NextToSwich.size();j+=1)
			{
				ToSwich.addAll(swichSomeLetters(NextToSwich.get(j),alphabet,word));
				
			}
			NextToSwich = ToSwich;
			Swiched.addAll(NextToSwich);
			
		}
		
		return Swiched;//Something to suppress the same words should be added
		
	}
	
private static LinkedList<String> swichSomeLetters(String word,String alphabet, String realWord) {
		
		LinkedList<String> Swiched = new LinkedList<String>();
		
		String changedWord;
		
		for (int j=0;j<word.length();j+=1)//Choose where to swich a letter
		{
			for (int k=0;k<alphabet.length();k+=1)//Choose the letter to swich
			{
					if (alphabet.charAt(k)!=word.charAt(j)) //check that the switch actually changes a letter.
					{
						if (j == word.length()) {changedWord = word.substring(0, j) + alphabet.charAt(k);}
						
						else if (j==0) {changedWord = alphabet.charAt(k) + word.substring(1);}
						
						else {changedWord = word.substring(0, j) + alphabet.charAt(k) + word.substring(j+1);}
							
						if (realWord!=changedWord) {Swiched.add(changedWord);}
					}
			}
		}
		return Swiched;
	}
	
	
	private static LinkedList<String> addSomeLetters(String word,String alphabet) {
		
		LinkedList<String> Added = new LinkedList<String>();
		
		String changedWord;
		
		for (int j=0;j<word.length()+1;j+=1)//Choose where to add a letter
		{
			for (int k=0;k<alphabet.length();k+=1)//Choose the letter to add
			{
				if (j == word.length())
				{
					changedWord = word + alphabet.charAt(k);
				}
				else 
				{
					changedWord = word.substring(0,j) + alphabet.charAt(k) + word.substring(j);
				}
				Added.add(changedWord);
			}
		}
		return Added;
	}
	private static LinkedList<String> addLetters(String word, int numberToAdd,String alphabet) {
		
		LinkedList<String> Added = new LinkedList<String>();
		LinkedList<String> NextToAdd = new LinkedList<String>();
		NextToAdd.add(word);
		
		
		for ( int numberAdded=0;numberAdded<numberToAdd;numberAdded+=1)
		{
			LinkedList<String> ToAdd = new LinkedList<String>();
			for (int j=0;j<NextToAdd.size();j+=1)
			{
				ToAdd.addAll(addSomeLetters(NextToAdd.get(j),alphabet));
				
			}
			NextToAdd = ToAdd;
			Added.addAll(NextToAdd);
			
		}
		
		return Added;//Something to suppress the same words should be added
	}
	
private static LinkedList<String> chopLetters(String word,int numberToChop) {
		
		LinkedList<String> Chopped = new LinkedList<String>();
		LinkedList<String> NextToChop = new LinkedList<String>();
		NextToChop.add(word);
		for ( int numberChoped=0;numberChoped<numberToChop;numberChoped+=1)
		{	
			
			LinkedList<String> ToChop = new LinkedList<String>();
			for (int j=0;j<NextToChop.size();j+=1)
			{
				ToChop.addAll(chopSomeLetters(NextToChop.get(j)));
				
			}
			NextToChop = ToChop;
			Chopped.addAll(NextToChop);
			
		}
		
		return Chopped;//Something to suppress the same words should be added
	}
private static LinkedList<String> chopSomeLetters(String word) {
	LinkedList<String> Chopped = new LinkedList<String>();
	for (int j=0;j<word.length();j+=1)
	{
		Chopped.add(word.substring(0,j)+word.substring(j+1));
	}
	return Chopped;
}

}
