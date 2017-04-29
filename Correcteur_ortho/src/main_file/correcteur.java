package main_file;

import java.util.Scanner;
import main_file.Traiter_entree;

public class correcteur {
	private static String entree;
	private static Boolean sortie;
	/**
	 * @param args
	 */
	public static String ask_for_entry() {

		String chaine = new String("Hello word !");
		System.out.print(chaine);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un mot :");
		return sc.nextLine();
		
	}

	public static void main(String[] args) {
		entree = correcteur.ask_for_entry();
		sortie = Traiter_entree.enter_is_in_list(entree);
		if (sortie==true){
			System.out.print(sortie);
		}
		else{
			System.out.print(Traiter_entree.word_the_closest(entree));
		}
		 }	 
}