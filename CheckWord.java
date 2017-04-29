package main_file;


public class CheckWord {

	public static boolean checkWord(String word, String[] Dico)
	{
		int t=0;
		while (t<Dico.length)
		{
			if (Dico[t].equals(word))
			{
				return true;
			}
			t+=1;
		}
		return false;
	}
	
}
