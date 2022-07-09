import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/** Cette classe modélise la fenêtre
 * @author Kevin
 * @see <a href="Frame.html">Frame</a> */
public class Frame extends JFrame implements KeyListener{
	
	/** Longueur de la fenêtre. */
	public static int WIDTH = 800;
	/** Hauteur de la fenêtre. */
	public static int HEIGHT = 600;
	/** Jeu ayant créé cette fenêtre. */
	protected Jeu game;
	/** Couleur de fond. */
	protected Color couleur;
	/** Panneau de la fenêtre. */
	protected JPanel fond;
	/** Texte avec les informations du sous-marin. */
	protected JLabel informations;
	
	/** Instanciation d'une fenêtre. 
	 * @param g Le Jeu qui à créé cette fenêtre.
	 */
	public Frame(Jeu g){
		super("Submarine GAME");
		this.game=g;
		fond = new JPanel();
		couleur = new Color(30,107,190);
		fond.setBackground(couleur);
		fond.setLayout(new FlowLayout(FlowLayout.LEFT));
		String info=" ";
		informations=new JLabel(info);
		informations.setVerticalTextPosition(JLabel.BOTTOM);
		fond.add(informations);
		this.add(fond);
		this.addKeyListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH,HEIGHT);
		this.setResizable(false);
		this.setVisible(true);
	}

	/** Permet d'afficher tout les objets à l'écran. 
	 * @param gr L'objet Graphics qui affichera toute l'interface
	 */
	public void paint(Graphics gr){
		int i=0;
		gr.setColor(couleur);
		
		String info="<html><body>Vitesse : "+(game.sousmarin.getVitesse()/5);
		info += "<br>Angle : "+(int)((game.sousmarin.getAngle()*180)/Math.PI)+"°";
		info += "<br> Score : 0</body></html>";
		this.informations.setText(info);
		this.fond.paint(gr); // colorie le fond en bleu

		Bateau[] objet=this.game.getMovable(); // recupere tout les objets du jeu
		while(objet[i]!=null){
			objet[i].paint(gr);		// affiche les objets
			i++;
		}
	}

	public void keyTyped(KeyEvent e){
	}

	/** Permet la détection des touches appuyées sur le clavier. */
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_UP){
			this.game.sousmarin.accelerer();
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			this.game.sousmarin.freiner();
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			this.game.sousmarin.tournerG();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			this.game.sousmarin.tournerD();
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			this.game.sousmarin.tirer();
		}
		if(e.getKeyCode()==KeyEvent.VK_R){
			this.game.sousmarin.recharger();
		}
		if(e.getKeyCode()==KeyEvent.VK_E){
			this.game.sousmarin.plonger();
		}
	}
	
	public void keyReleased(KeyEvent e){
	}

}
