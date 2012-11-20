import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Fenetre extends JFrame {
	
	/**
	 * zone de texte ou l'utilisateur pourra saisir des valeurs et ou on affichera le resultat d'une operation
	 */
	 JTextField zoneSaisie=new JTextField();	
	/**
	 * JPanel qui contient les boutons de la calculatrice
	 */
	private JPanel grilleBoutons=new JPanel();
	private JPanel grilleBoutonsChiffre=new JPanel();
	/**
	 * On crée un objet de type Calculatrice
	 */
	private Calculatrice calc=new Calculatrice();
	/**
	 * Ecouteur de la fenetre, 
	 * parametre calc=la calculatrice qui est en attribut dans la classe Fenetre
	 * parametre this=notre Fenetre
	 */
	private Ecouteur ec=new Ecouteur(calc,this);
	
	/**
	 * boutons + - * / entrer effacer
	 */
	private JButton plus=new JButton("+");
	private JButton moins=new JButton("-");
	private JButton fois=new JButton("*");
	private JButton divise=new JButton("/");
	private JButton entrer=new JButton("entrer");
	private JButton CE=new JButton("CE");
	private JButton vider=new JButton("C");
	private JButton b0=new JButton("0");
	private JButton b1=new JButton("1");
	private JButton b2=new JButton("2");
	private JButton b3=new JButton("3");
	private JButton b4=new JButton("4");
	private JButton b5=new JButton("5");
	private JButton b6=new JButton("6");
	private JButton b7=new JButton("7");
	private JButton b8=new JButton("8");
	private JButton b9=new JButton("9");
	/**
	 * pied de la calculatrice ou on aura l'affichage de la hauteur et du sommet de la pile
	 */
	private JPanel pied=new JPanel();
	/**
	 * label qui recevra le texte "hauteur de la pile"
	 */
	private JLabel textePiedHauteur=new JLabel();
	/**
	 * recevra la hauteur de la pile
	 */
	private JLabel valeur=new JLabel();
	/**
	 * label qui recevra le texte "sommet de la pile"
	 */
	private JLabel textePiedSommet=new JLabel();
	/**
	 * recevra le sommet de la pile
	 */
	private JLabel valeur2=new JLabel();
	
	
	/**
	 * structuration de la fenetre
	 */
	

	public Fenetre(){
		
		setTitle("Calculatrice");	//titre
		setSize(300,500);	//taille de 300 pixels sur 500
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//le programme s'arretera lorsque l'on clique sur la croix de la fenetre
		
		//par defaut la Fenetre(classe fille de JFrame donc est une JFrame) a pour Layout un BorderLayout
		add(zoneSaisie,BorderLayout.NORTH);	//on place la zone de saisie dans la zone nord de la fenetre 
		
		
		/**
		 * disposition des chiffres
		 */
		grilleBoutonsChiffre.setLayout(new GridLayout(5,1));
		
		grilleBoutonsChiffre.add(b0);
		b0.addActionListener(ec);
		grilleBoutonsChiffre.add(b1);
		b1.addActionListener(ec);
		grilleBoutonsChiffre.add(b2);
		b2.addActionListener(ec);
		grilleBoutonsChiffre.add(b3);
		b3.addActionListener(ec);
		grilleBoutonsChiffre.add(b4);
		b4.addActionListener(ec);
		grilleBoutonsChiffre.add(b5);
		b5.addActionListener(ec);
		grilleBoutonsChiffre.add(b6);
		b6.addActionListener(ec);
		grilleBoutonsChiffre.add(b7);
		b7.addActionListener(ec);
		grilleBoutonsChiffre.add(b8);
		b8.addActionListener(ec);
		grilleBoutonsChiffre.add(b9);
		b9.addActionListener(ec);
		
		add(grilleBoutonsChiffre,BorderLayout.CENTER);
		/**
		 * dispositions des symboles
		 */
		grilleBoutons.setLayout(new GridLayout(4,2));	//notre grille de boutons doit avoir 6 boutons on cree donc une grille de 3 sur 2
		//on y ajoute les boutons sans oublier de les lier a l'Ecouteur
		grilleBoutons.add(CE);
		CE.addActionListener(ec);
		grilleBoutons.add(vider);
		vider.addActionListener(ec);
		grilleBoutons.add(plus);
		plus.addActionListener(ec);
		grilleBoutons.add(moins);
		moins.addActionListener(ec);
		grilleBoutons.add(fois);
		fois.addActionListener(ec);
		grilleBoutons.add(divise);
		divise.addActionListener(ec);
		grilleBoutons.add(entrer);
		entrer.addActionListener(ec);
		
		
		//on place la grille au centre de la calculatrice
		add(grilleBoutons,BorderLayout.EAST);
				
		pied.setLayout(new GridLayout(2,2));	//on organise le pied de la fenetre pour accueuillir les labels souhaites
		pied.add(textePiedHauteur);
		textePiedHauteur.setText("Hauteur de la pile : ");
		pied.add(valeur);
		pied.add(textePiedSommet);
		textePiedSommet.setText("Sommet de la pile : ");
		pied.add(valeur2);
		add(pied,BorderLayout.SOUTH);	//le pied est place dans la zone sud
		
		setVisible(true);	//on rend la fenetre visible
	}
	public String getTexte(){	//renvoie le texte present dans la zone de saisie (JTextField)
		return zoneSaisie.getText();
	}
	/**
	 * méthodes de saisie des chiffres
	 * @param btn
	 * @return
	 */
	public Boolean isBtn0 (JButton btn){
		return btn == b0;
	}
	
	public Boolean isBtn1 (JButton btn){
		return btn == b1;
	}
	
	public Boolean isBtn2 (JButton btn){
		return btn == b2;
	}
	
	public Boolean isBtn3 (JButton btn){
		return btn == b3;
	}
	
	public Boolean isBtn4 (JButton btn){
		return btn == b4;
	}
	
	public Boolean isBtn5 (JButton btn){
		return btn == b5;
	}
	
	public Boolean isBtn6 (JButton btn){
		return btn == b6;
	}
	
	public Boolean isBtn7 (JButton btn){
		return btn == b7;
	}
	
	public Boolean isBtn8 (JButton btn){
		return btn == b8;
	}
	
	public Boolean isBtn9 (JButton btn){
		return btn == b9;
	}
	
	
	//methodes permettant de savoir a quel bouton correspond le bouton passe en parametre
	public boolean isBtnPlus(JButton btn){
		return btn==plus;
	}
	public boolean isBtnMoins(JButton btn){
		return btn==moins;
	}
	public boolean isBtnFois(JButton btn){
		return btn==fois;
	}
	public boolean isBtnDivise(JButton btn){
		return btn==divise;
	}
	public boolean isBtnEntrer(JButton btn){
		return btn==entrer;
	}
	public boolean isBtnEffacer(JButton btn){
		return btn==CE ;
	}
	public boolean isBtnVider(JButton btn){
		return btn==vider;
	}
	public boolean isEntrer(){
		boolean Entrer = true;
		return  Entrer;  
	}
	//affiche le texte passe en parametre dans le deuxieme label du pied
	public void afficherHauteur(String hauteur){
		valeur.setText(hauteur);
	}
	//affiche le texte passe en parametre dans le quatrieme label du pied et dans la zone de saisie
	public void afficherSommet(String sommet){
		valeur2.setText(sommet);
		zoneSaisie.setText(sommet);
	}
	
	

	
}
