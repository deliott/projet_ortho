package main_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
 
public class Stocker_dict_dans_liste {
 
    /**
     * @param args
     */
	private static LinkedList<String> tableau_dico = new LinkedList();
	
	//public static String affiche_prout() {
	//	return "prout";
	//}
    public static LinkedList<String> readFromFileAndStockToList(String file, int length_word) {
 
        BufferedReader br;
        String motLu;
        try{
            br = new BufferedReader(new FileReader(new File(file)));
            while((motLu = br.readLine()) != null)
         
            {

            	if (Math.abs(motLu.length()-length_word) < 1 || length_word < 0){
            		tableau_dico.add(motLu);
            		
            	}
            
            }
            br.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return tableau_dico;
    }

public static void main(String[] args) {
    // Nous déclarons nos objets en dehors du bloc try/catch
		tableau_dico=readFromFileAndStockToList("dico.txt",7);
	   for(int i = 0; i < tableau_dico.size(); i++)
		   System.out.println(String.valueOf(tableau_dico.get(i)));
 }	 
}

