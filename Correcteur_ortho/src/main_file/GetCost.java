package main_file;
import java.util.LinkedList;

public class GetCost {
	public static int[] getCost(LinkedList<String> realWords, String word)
	{
		int[] Cost = new int[realWords.size()];
		String wordTreated;
		String voyelles = "aeiouy";
		String consonnes = "zrtpqsdfghjklmwxcvbn";
		char realLetter = 'a';
		char letter = 'a';
		char rightLetter = 'a';
		char leftLetter = 'a';
		int size;
		int l = 0;
		boolean found;
		for (int j=0;j<realWords.size();j+=1)
		{
			wordTreated = realWords.get(j);
			size = wordTreated.length();
			if (wordTreated.length()==word.length())//swich
			{
				for (int k=0;k<size;k+=1)//search for the swiched letter
				{
					if (wordTreated.charAt(k) != word.charAt(k))
					{
						letter = word.charAt(k);
						realLetter = wordTreated.charAt(k);
					}
				}
				if (voyelles.indexOf(letter)!=-1 && voyelles.indexOf(realLetter)!=-1)//a vowel swich with a vowel
				{
					Cost[j] = 1;
				}
				
				else if (consonnes.indexOf(letter)!=-1 && consonnes.indexOf(realLetter)!=-1)//a consonant swich with a consonant
				{
					Cost[j] = 2;
				}
				else {Cost[j] = 3;}
			}
			else if (wordTreated.length()>word.length())//add
			{
				l=0;
				found = false;
				while (l<size-1 && found==false)//search for the added letter
				{
					if (wordTreated.charAt(l) != word.charAt(l) && l!=0)
					{
						realLetter = wordTreated.charAt(l);
						leftLetter = wordTreated.charAt(l-1);
						rightLetter = word.charAt(l);
						found = true;
						
					}
					else if (wordTreated.charAt(l) != word.charAt(l) && l==0)
					{
						realLetter = wordTreated.charAt(l);
						rightLetter = word.charAt(l);
						found = true;
						l-=1;
					}
					l+=1;
				}
				
				if (l==0)//first letter added
				{
					Cost[j] = 1;
				}
				else if (l==size-2)//last letter added
				{
					Cost[j] = 1;
				}
				else
				{
					if ((realLetter==rightLetter || realLetter==leftLetter) && (consonnes.indexOf(realLetter)!=-1))//double a consonant
					{
						Cost[j] = 2;
					}
					else if ((voyelles.indexOf(realLetter)!=-1) && (consonnes.indexOf(leftLetter)!=-1) && (consonnes.indexOf(rightLetter)!=-1))//add a vowel between two consonants
					{
						Cost[j] = 2;
					}
					else {Cost[j] = 3;}
				}
			}
			else//chopped words
			{
				l=0;
				found = false;
				while (l<size && found==false)//search for the chopped letter
				{
					if (wordTreated.charAt(l) != word.charAt(l) && l!=0)
					{
						realLetter = word.charAt(l);
						leftLetter = wordTreated.charAt(l-1);
						rightLetter = wordTreated.charAt(l);
						found = true;
						
					}
					else if (wordTreated.charAt(l) != word.charAt(l) && l==0)
					{
						realLetter = word.charAt(0);
						rightLetter = wordTreated.charAt(0);
						found = true;
						l-=1;
					}
					l+=1;
				}
				
				if (l==0)//first letter chopped
				{
					Cost[j] = 1;
				}
				else if (l==size-1)//last letter chopped
				{
					Cost[j] = 1;
				}
				else
				{
					if ((voyelles.indexOf(leftLetter)!=-1 && leftLetter==realLetter)||(voyelles.indexOf(rightLetter)!=-1 && rightLetter==realLetter))//take out a double same vowel
					{
						Cost[j] = 1;
					}
					else if ((consonnes.indexOf(leftLetter)!=-1 && leftLetter==realLetter)||(consonnes.indexOf(rightLetter)!=-1 && rightLetter==realLetter))//take out a double same consonant
					{
						Cost[j] = 2;
					}
					else if ((voyelles.indexOf(leftLetter)!=-1 && voyelles.indexOf(realLetter)!=-1) || (voyelles.indexOf(rightLetter)!=-1 && voyelles.indexOf(realLetter)!=-1))//take out a vowel between vowels or next to a vowel
					{
						Cost[j] = 2;
					}
					else if ((consonnes.indexOf(leftLetter)!=-1 && consonnes.indexOf(realLetter)!=-1 && consonnes.indexOf(rightLetter)!=-1))//take out a consonant between consonants
					{
						Cost[j] = 2;
					}
					else {Cost[j] = 3;}
				}
			}
		}
		
		return Cost;
	}

}
