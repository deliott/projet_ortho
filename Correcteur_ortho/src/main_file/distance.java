package main_file;

public class distance {

	static float calculate_distance(String entree, String referenced_word){
		float total_distance = 0;
		//At the begining we're gonna assume that the two words have the same length
		for(int i=0;i<entree.length();i++){
			if (entree.charAt(i)!=referenced_word.charAt(i)){
				total_distance=total_distance+1;
				
			}
		}
		return total_distance;
	}
	
	static String insertCharIntoString(String StringConcerned, char char_concerned,int indice){
		String final_string="";

		for(int i=0;i<StringConcerned.length();i++){
			if (i==indice){
				final_string+=char_concerned;
			}
			final_string+=StringConcerned.charAt(i);
		}
		return final_string;
	}
	
	static float calculate_distance_entree_smallest(String entree, String referenced_word){
		float total_distance = 999;
		String mot_test;
		//assuming that the entree has a lack of a letter compared to the referenced word
		//for example lapin et lpin
		for(int i=0;i<entree.length();i++){
			if (calculate_distance(insertCharIntoString(entree,referenced_word.charAt(i),i),referenced_word) < total_distance){
				total_distance=total_distance+1;
				
			}
		}
		return total_distance;
	}
	
	public static void main(String[] args) {
		String s = "1479KP";
		char t = 'e';
		//String commonChars = s.replaceAll("[^"+t+"]","");
		System.out.print(distance.insertCharIntoString(s, t, 0));
		 }	 
}
