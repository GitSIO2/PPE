import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Ecouteur implements ActionListener{	//on implement ActionListener pour avoir acces a ses methodes et pouvoir "ecouter" les boutons de la fenetre
	private Calculatrice calc;
	private Fenetre fenCalc;

	public Ecouteur(Calculatrice c,Fenetre fc){
		calc=c;	//l'ecouteur doit avoir le meme objet Calculatrice que celui contenu en attribut dans la classe Fenetre 
		fenCalc=fc;	
	}
	class Except extends Exception{
	}
	@Override
	public void actionPerformed(ActionEvent e)  {	//methode a editer imperativement si on implemente la classe ActionListener
		// TODO Auto-generated method stub
		JButton btn=(JButton)e.getSource();
		try
		{
			/**
			 * Pour la saisie au clavier
			 */
			if(fenCalc.isBtnEntrer(btn)){	//si le bouton entrer est clique 
				double valeur=Double.parseDouble(fenCalc.getTexte());	//on recupere le texte contenu par le JTextfield de la fenetre, on le transforme en double
				calc.entrerValeur(valeur);	//et on ajoute la valeur obtenue a la pile de la calculatrice
			}
			
			/**
			 * Pour la saisie sur bouton
			 */
			if(fenCalc.isBtn0(btn)){
			    calc.entrerValeur(0);
			}
			
			if(fenCalc.isBtn1(btn)){
			    calc.entrerValeur(1);
			}
			
			if(fenCalc.isBtn2(btn)){
			    calc.entrerValeur(2);
			}
			
			if(fenCalc.isBtn3(btn)){
			    calc.entrerValeur(3);
			}
			
			if(fenCalc.isBtn4(btn)){
			    calc.entrerValeur(4);
			}
			
			if(fenCalc.isBtn5(btn)){
			    calc.entrerValeur(5);
			}
			
			if(fenCalc.isBtn6(btn)){
			    calc.entrerValeur(6);
			}
			
			if(fenCalc.isBtn7(btn)){
			    calc.entrerValeur(7);
			}
			
			if(fenCalc.isBtn8(btn)){
			    calc.entrerValeur(8);
			}
			
			if(fenCalc.isBtn9(btn)){
			    calc.entrerValeur(9);
			}
			
			//methodes autres agissant en fonction des boutons cliques
			if(calc.estVide()) throw new Except();
			else
			{
				if(fenCalc.isBtnPlus(btn)){
					calc.additionner();
				}
				if(fenCalc.isBtnMoins(btn)){
					calc.soustraire();
				}
				if(fenCalc.isBtnFois(btn)){
					calc.multiplier();
				}
				if(fenCalc.isBtnDivise(btn)){
					calc.diviser();
				}
				if(fenCalc.isBtnEffacer(btn)){
					calc.effacer();
				}
				if(fenCalc.isBtnVider(btn)){
					calc.vider();
				}
				fenCalc.afficherHauteur(calc.getHauteur());
				fenCalc.afficherSommet(calc.getSommet());
			}
		}catch(Except ex)
		{
			System.out.println("Il faut entrer un nombre!!!!!!!");
		}
		//on affiche la hauteur et le sommet de la pile au niveau du pied de la fenetre 

	}
}
