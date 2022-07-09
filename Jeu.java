import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.lang.Math;

/** Cette classe modélise le Jeu
 * @author Kevin
 * @see Jeu */

public class Jeu {

	/** Fenetre du jeu. */
	protected Frame frame;
	/** Le sous-marin du joueur. */
	public SubMarine sousmarin;
	/** Bateau ennemi. */
	protected BateauMilitaire ennemi;
	/** Groupe de bateau. */
	protected BateauCommerce[] convoi;
	/** vrai si le jeu est en cour. */
	protected boolean encour=true;
	
	/** Instanciation du jeu. */
	public Jeu(){
		sousmarin = new SubMarine(50,50);
		//ennemi = new BateauMilitaire();
		convoi = new BateauCommerce[6];
		this.frame = new Frame(this);
	}

	/** Boucle du jeu. */
	public void run(){
		int i,k=0;
		this.ennemi = new BateauMilitaire(150,100,0.0);
		this.createConvoi(150,100,0.0);
		while(this.encour){
			try{Thread.sleep(100);}catch(InterruptedException e){}
			if(k>500){
				k=0;
				this.ennemi = new BateauMilitaire(150,100,0.0);
				this.createConvoi(150,100,0.0);
			}
			this.deplacement();
			this.frontiere();
			this.collisions();
			
			this.frame.repaint();
			k++;
		}
	}

	/** Cette méthode permet de recuperer tout les objets du jeu. 
	 * @return Le tableau de tout les bateaux du jeu
	 */
	public Bateau[] getMovable(){
		int i=0,j=0;
		Bateau[] objet = new Bateau[20];
		// Rajoute le sous marin dans le tableau
		objet[j]=this.sousmarin;
		j++;
		// Rajoute les torpilles du sous marin dans le tableau
		for(i=2;i>=0;i--){
			if(this.sousmarin.torpilles[i]!=null){
				objet[j]=this.sousmarin.torpilles[i];
				j++;
			}
		}
		// Rajoute le bateau ennemi dans le tableau
		if(this.ennemi!=null){
			objet[j]=this.ennemi;
			j++;
		}
		// Rajoute le convoi dans le tableau
		for(i=0;i<6;i++){
			if(this.convoi[i]!=null){
				objet[j]=this.convoi[i];
				j++;
			}
		}
		return objet;
	}

	/** Cette méthode permet de lancer le deplacement de tout les objets du jeu. */
	public void deplacement(){
		int i=0;
		Bateau[] objet=this.getMovable(); // recupere tout les objets du jeu
		while(objet[i]!=null){
			objet[i].move();		// deplace les objets
			i++;
		}
	}

	/** Cette méthode permet la detection de n'importe quel collisions entre deux objets du jeu. */
	public void collisions(){
		int i=0,j=1;

		Bateau[] objet=this.getMovable();
		
		while(objet[i]!=null){
			while(objet[j]!=null){
				if(objet[i].collision(objet[j])){
					if(objet[i] instanceof SubMarine){
						System.out.println("STOP !");// collision entre SM et autre chose
						this.encour=false;
					}
				}
				j++;
			}
			i++;
			j=i+1;
		}
		
	}

	/** Cette méthode permet de passer d'un rebord de la fenêtre à son opposé. */
	public void frontiere(){
			if(this.sousmarin.pol.xpoints[0]<0)
				this.sousmarin.pol.xpoints[0]=800;
			if(this.sousmarin.pol.xpoints[0]>800)
				this.sousmarin.pol.xpoints[0]=0;
			if(this.sousmarin.pol.ypoints[0]<0)
				this.sousmarin.pol.ypoints[0]=600;
			if(this.sousmarin.pol.ypoints[0]>600)
				this.sousmarin.pol.ypoints[0]=0;
	}

	/** Cette méthode crée un convoi de bateau de commerce. */
	public void createConvoi(int x,int y,double a){
		int i,m=30,n=20;
		for(i=0;i<3;i++){
			this.convoi[i]=new BateauCommerce(x+m,y+n,a);
			m+=30;
		}
		m=30;
		n=40;
		for(i=3;i<6;i++){
			this.convoi[i]=new BateauCommerce(x+m,y+n,a);
			m+=30;
		}
	}

	public static void main(String[] args){
		Jeu g = new Jeu();
		g.run();
	}
}
