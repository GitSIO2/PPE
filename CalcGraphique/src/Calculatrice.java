
import java.util.Stack;

public class Calculatrice {
	private Stack<Double> pile;
	
	public Calculatrice(){
		pile=new Stack<Double>();
	}
	class Except extends Exception{
	}
	class ExceptDiv extends Exception{
	}
	
	/**
	 * ajoute une valeur a la pile
	 */
	public void entrerValeur(double valeur){
		pile.push(valeur);
	}
	/**
	 * retourne la valeur au sommet de la pile sous forme d'une String
	 */
	public String getSommet(){
		return pile.peek()+"";
	}
	/**
	 * retourne la hauteur de la pile sous forme d'une String
	 */
	public String getHauteur(){
		return pile.size()+"";
	}
	/**
	 * vide la pile
	 */
	public void vider(){
		pile.clear();
	}
	/**
	 * additionne les deux valeurs les plus recemment ajoutees a la pile (elles sont retirees de la pile) et ajoute le resultat obtenu a la pile
	 */
	public void additionner(){
		double add = pile.pop();
		int taille = pile.size();
		try{
			if(taille <1) throw new Except();
		}
		catch(Except e)
		{
			System.out.println("Il manque un nombre\nEntrez un deuxième nombre");
		}
		for(int i=0;i<taille;i++){
			add=add+pile.pop();
		}
		pile.push(add);
	}
	/**
	 * soustrait la derniere valeur de la pile a l'avant-derniere, les valeurs sont enlevees de la pile et le resultat ajoute
	 */
	public void soustraire(){
		double op1, op2; 
		op1 = pile.pop();
		try{
			if (pile.size()<1) throw new Except();
			
			    op2 = pile.pop();
			    pile.push(op2-op1);
		}catch(Except e)
		{
			System.out.println("Il manque un nombre!\nRecommencez et entrez deux nombres");
		}
	}
	/**
	 * meme principe que pour l'addition
	 */
	public void multiplier(){
		double mul = pile.pop();
		int taille = pile.size();
		try{
			if(taille <1) throw new Except();
		}
		catch(Except e)
		{
			System.out.println("Il manque un nombre\nEntrez un deuxième nombre");
		}
		for(int i=0;i<taille;i++){
			mul=mul*pile.pop();
		}
		pile.push(mul);
	}
	/**
	 * meme principe que pour la soustraction
	 */
	public void diviser(){
		double op1, op2;
		op1 = pile.pop();
		try{
			if (pile.size()<1) throw new Except();
			if (op1==0) throw new ExceptDiv();
			 op2 = pile.pop();
			 pile.push(op2/op1);
			
			   
		}catch(Except e)
		{
			System.out.println("Il manque un nombre!\nRecommencez et entrez deux nombres");
		}
		catch(ExceptDiv e)
		{
			System.out.println("Division par 0 impossible");
		}
	}
	/**
	 * enleve une valeur de la pile
	 */
	public void effacer(){
		pile.pop();
	}
	public boolean estVide(){
		return pile.empty();
	}
	
	
	
}
