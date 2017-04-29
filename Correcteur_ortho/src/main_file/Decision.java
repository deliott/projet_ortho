package main_file;

import java.util.LinkedList;

public class Decision {

	public static String decision(LinkedList<String> realWords, int[] Cost)
	{
		String correctedWord = "";
		int min=40;
		for (int j=0;j<realWords.size();j+=1)
		{
			if (min>Cost[j])
			{
				min = Cost[j];
				correctedWord = realWords.get(j);
			}
		}
		
		return correctedWord;
	}
}
