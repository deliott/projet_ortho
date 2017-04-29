package main_file;


import java.util.LinkedList;

public class SearchingWords {
	public static LinkedList<String> searchingWords(String[] Dico,String[] Words)
	{
		LinkedList<String> realWords = new LinkedList<String>();
		int t;
		boolean found;
		for (int k=0;k<Words.length;k+=1)
		{
			
			t=0;
			
			found = false;
			while(t<Dico.length && found==false)
			{
				
				if (Dico[t].equals(Words[k]) && realWords.contains(Dico[t])==false)
				{
					found = true;
					realWords.add(Dico[t]);
				}
				
				t+=1;
			}
		}
		return realWords;
	}

}
