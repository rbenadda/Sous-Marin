import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;

/** Cette classe modélise le sous-marin du joueur
 * @author Kevin
 * @see <a href="SubMarine.html">SubMarine</a> */
public class SubMarine extends BateauMilitaire{

	/** Vrai si le bateau se trouve sous l'eau. */
	protected boolean sousleau;

	/** Instanciation d'un bateau militaire avec une position x,y de départ et une couleur. 
	 * @param x Position sur l'axe horizontal.
	 * @param y Position sur l'axe vertical.
	 */
	public SubMarine(int x,int y){
		super(x,y,0.0);
		this.color=Color.RED;
		sousleau=false;
	}

	/** Augmente la vitesse du sous-marin. */
	public void accelerer(){
		vitesse+=5;
		if(vitesse>=15)
			vitesse=15;
	}

	/** Reduit la vitesse du sous-marin. */
	public void freiner(){
		vitesse-=5;
		if(vitesse<0)
			vitesse=0;
	}
	
	/** Fait plonger le sous-marin dans l'eau ou le fait remonter à la surface. */
	public void plonger(){
		if(vitesse==0){
			if(sousleau){
				color=Color.RED;
				sousleau=false;
			}else{
				color=new Color(153,0,0);
				sousleau=true;
			}
		}
	}
	
	/** Modifie l'angle du sous-marin. */
	public void tournerG(){
		angle-=0.1;
		if(angle<0.0)
			angle=6.2;
	}

	/** Modifie l'angle du sous-marin. */
	public void tournerD(){
		angle+=0.1;
		if(angle>6.2)
			angle=0.0;
	}
	
	/** Recharge le nombre de torpille du sous-marin. */
	public void recharger(){
		this.nombreMun=3;
	}
}
