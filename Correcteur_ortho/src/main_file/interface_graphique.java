

package main_file;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.*;


public class interface_graphique extends JFrame implements ActionListener {
	
	JSplitPane sp;
	JLabel nb_error,langue, titr,word_inputl, word_outputl,word_decisionl ;
	JComboBox nb_error_box,langue_box;
	JTextField cod;
	static JTextField word_input;
	JTextField word_output,word_decision;
	JButton b4, corriger,annuler;	 
	
	public interface_graphique()
	{
		sp= new JSplitPane();
		sp.setSize(new Dimension(800,600));
		sp.setDividerLocation(230);
		
	//Definissons la partie gauche de la fenetre
		JPanel p=new JPanel();
		nb_error=new JLabel("Nombre d'erreures supposées");
	 	langue=new JLabel("Langue");
	 	nb_error_box = new JComboBox();
	    langue_box = new JComboBox();
		
	    b4= new JButton("valider");
	    
	    for (int i = 1; i <= 3; i++) {nb_error_box.addItem("" + i); }
	    langue_box.addItem("Anglais");
	    nb_error_box.setSelectedIndex(0); 
	    
	    
		p.setPreferredSize(new Dimension(280,300));
		p.setMaximumSize(new Dimension(280,300));
		p.setLayout(new GridLayout(10,1,20,10));
		p.add(new JPanel());
		p.add(new JPanel());
    	p.add(nb_error);
    	p.add(nb_error_box);
		p.add(langue);
		p.add(langue_box);
		p.add(new JPanel());
		p.add(b4);
		for(int i=0;i<10;i++){p.add(new JPanel());}

		//	String f=langue_box.getSelectedItem();
		
		
		JPanel pleft=new JPanel();
		pleft.setLayout(new GridLayout(1,2,20,10));
		pleft.add(p);	
 
	//Définissons la partie de droite de la fenetre
		
		word_inputl= new JLabel("Mot à corriger");
		word_outputl= new JLabel("Suggestions de correction :");
		word_decisionl = new JLabel("Suggestion principale :");
		titr= new JLabel("Correcteur Orthographique");
		word_input= new JTextField();
		word_output= new JTextField();
		word_decision = new JTextField();
		 

	 	JPanel p1=new JPanel();
	 	JPanel p2=new JPanel();
	 	JPanel p3=new JPanel();
	 	corriger= new JButton("corriger");
	 	annuler= new JButton("annuler ");
	 	Font titreFont=new Font("Arial",2, 20);
	 	Font titre=new Font("Arial",1, 30);
	 	
	 	word_inputl.setFont(titreFont);
	 	word_outputl.setFont(titreFont);
	 	word_decisionl.setFont(titreFont);
	 	titr.setFont(titre);
	 	corriger.setFont(titreFont);
	 	annuler.setFont(titreFont);
	 	
	 	titr.setForeground(Color.red);
	 	p1.add(titr);
	 	p2.setLayout(new GridLayout(4,2,10,10));
	 	p2.add(word_inputl);
	 	p2.add(word_input); 
	 
	
	 	JPanel p5= new JPanel();
	 	p5.setLayout(new GridLayout(2,1,5,5));
	 	p5.add(word_outputl);
	 	p5.add(word_output);
	 	p3.add(corriger);
	 	p3.add(annuler);
	 	
	 	JPanel p6=new JPanel();
	 	p6.setLayout(new GridLayout(4,2,10,10));
	 	p6.add(word_decisionl);
	 	p6.add(word_decision); 
	 
	 	JPanel p4= new JPanel();
	 	p4.setLayout(new GridLayout(6,1,10,10));
	 	p4.add(p1);
	 	p4.add(p2);
	 	p4.add(p5);
	 	p4.add(p6);
	 	p4.add(p3);
	 	
	 	JPanel pright= new JPanel();
	 	pright.add(p4);

		
		
	//Intégrons les parties gauches et droites dans la fenetre
	 	
	 	
		sp.setLeftComponent(pleft);
		//sp.setRightComponent(new deposer_conge() );
		sp.setRightComponent(pright );
		Container c= this.getContentPane();
		this.setPreferredSize(new Dimension(900,650));
		this.setSize(new Dimension(900,650));
		c.add(sp);
		pack();
		this.setLocation(100,50);
		
	
		b4.addActionListener(this);
		corriger.addActionListener(this);
	 	annuler.addActionListener(this);

		
	}
	public void actionPerformed(ActionEvent e)
	{boolean trouve=false;
		if(e.getSource()==b4){
			System.out.println("on a cliqué sur valider dans le panneau de gauche ");
			}
		if(e.getSource()==corriger){
	    		System.out.println("on a cliqué sur corriger ");
	    		//on met un getter ? 
	    		String temp = word_input.getText(); 
	    		System.out.println("après avoir voulu corrigé :"+temp);
	    		String to_correct = getMottest(word_input.getText());
	    	//	main_code.corriger(to_correct);
	    		/*
	    		if(trouve==true)
	    		{}
	    		else{System.out.println("trouve=false");
	    		//JOptionPane.showMessageDialog(null,"prout")	;
	    		
    			}*/
		}
		
    if(e.getSource()==annuler)
    {
    
word_input.setText("");
word_output.setText("pas encore de recomandations :");
    	
    }	
	}
	
	public String getMottest(String test){
		return(test) ;
	}
	
	public void giveWordsList(LinkedList<String> possibles){
		
		String suggestedWords = "";
		for (int j=0;j<possibles.size();j+=1)
		{suggestedWords += possibles.get(j)+"  ";}
		word_output.setText(suggestedWords);
	}
	
	public void giveDecision(String solution){
		word_decision.setText(solution);
	}
	
	
/*	public static String getWord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please, enter the word you want to correct : ");
		
		
		String test_word = word_input.getText();
		String word = sc.nextLine();
		//sc.close();
		return test_word;
		}	
		
*/
	
	
/*
public static void main(String []arg)
	{
		interface_graphique p= new interface_graphique();
		p.setVisible(true);
	while(true) {
	to_correct = 
	correction = correcteur(to_correct);
	
	p.giveDecision(correction);
			
	}
		
	}
*/	
	
	

}


