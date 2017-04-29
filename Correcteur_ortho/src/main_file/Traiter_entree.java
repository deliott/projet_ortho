package main_file;

import java.util.LinkedList;
import main_file.Stocker_dict_dans_liste;
import main_file.distance;

public class Traiter_entree {
	private static LinkedList<String> tableau_dico; 
	static float mini;
	static String mot_corrige;
	static int i;
	static boolean enter_is_in_list(String entree){
		tableau_dico = Stocker_dict_dans_liste.readFromFileAndStockToList("dico.txt",entree.length());
		for(String s : tableau_dico){
		  if(s.contains(entree)){
		   return true;
		  }
		}
		return false;	
	}
	
	static String word_the_closest(String entree){
		tableau_dico = Stocker_dict_dans_liste.readFromFileAndStockToList("dico.txt",entree.length());
		mini=+999;
		mot_corrige=tableau_dico.getFirst();
		for(i=0;i<tableau_dico.size();i++){
			System.out.print(distance.calculate_distance(entree, tableau_dico.get(i)));
		  if(distance.calculate_distance(entree, tableau_dico.get(i))<mini){
		   mini=distance.calculate_distance(entree, tableau_dico.get(i));
		   mot_corrige=tableau_dico.get(i);
		  }
		}
		mini=+999;
		return mot_corrige;	
	}
}
