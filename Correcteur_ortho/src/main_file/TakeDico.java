package main_file;

import java.util.LinkedList;
import java.io.BufferedReader;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TakeDico {
	//public static LinkedList<String> takeDico(String pathDico) throws IOException{
	public static String[] takeDico(String pathDico) throws IOException{
        //LinkedList<String> Dico = new LinkedList<String>();
        
        InputStream flux = new FileInputStream(pathDico); 
		InputStreamReader lecture = new InputStreamReader(flux);
		  
		BufferedReader buff = new BufferedReader(lecture);
		String ligne;
		int nbLignes =0;
        while((ligne=buff.readLine()) != null)
         
        {
        		nbLignes+=1;
            	//Dico.add(ligne);	
           	}
        buff.close();
        String[] Dico = new String[nbLignes];
        
        InputStream Flux = new FileInputStream(pathDico); 
		InputStreamReader Lecture = new InputStreamReader(Flux);
		  
		BufferedReader Buff=new BufferedReader(Lecture);
		nbLignes=0;
        while((ligne=Buff.readLine()) != null)
         
        {
        		Dico[nbLignes] = ligne;	
        		nbLignes+=1;
           	}
        Buff.close();
        
        return Dico;
	}
	
			
}
