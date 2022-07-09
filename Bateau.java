import java.awt.Color;
import java.lang.Math;
import java.awt.Polygon;
import java.awt.Graphics;

/** Cette classe modélise les bateaux
 * @author Kevin
 * @see Bateau
 */
public abstract class Bateau extends Displayable{

	/** Forme d'un bateau. */
	protected Polygon pol;
	/** L'angle du bateau. */
	protected double angle;
	/** Vitesse du bateau. */
	protected int vitesse;
	/** Longueur du bateau. */
	protected int lo;
	/** Largeur du bateau. */
	protected int la;

	/** Instanciation d'un bateau avec une position x,y de départ et une couleur. 
	 * @param x Position sur l'axe horizontal.
	 * @param y Position sur l'axe vertical.
	 * @param c Couleur du bateau.
	 **/
	public Bateau(int x, int y, Color c){
		super(c);
		int[] tx ={x,0,0,0,0};
		int[] ty ={y,0,0,0,0};
		this.pol = new Polygon(tx,ty,5);
		calculPol();
		this.angle=0.0;
		this.vitesse=5;
		this.lo=16;
		this.la=7;
	}

	/** Renvoi la vitesse du bateau. 
	 * @return la vitesse du bateau.
	 */
	public int getVitesse(){
		return this.vitesse;
	}

	/** Renvoi l'angle du bateau. 
	 * @return l'angle du bateau.
	 */
	public double getAngle(){
		return this.angle;
	}

	/** Affiche le bateau. 
	 * @param g L'objet Graphics qui affichera les objets
	 */
	public void paint(Graphics g){
		g.setColor(this.color);
		calculPol();
		g.fillPolygon(this.pol);
	}

	/** Deplace le bateau selon sa vitesse et son angle. */
	public void move(){
		this.pol.xpoints[0]+=this.vitesse*Math.cos(this.angle);
		this.pol.ypoints[0]+=this.vitesse*Math.sin(this.angle);
	}
	
	/** Calcul de la forme du bateau depuis selon sa position x,y. */
	public void calculPol(){
		this.pol.xpoints[1]=(int)(pol.xpoints[0]+this.lo*Math.cos(this.angle));
		this.pol.ypoints[1]=(int)(pol.ypoints[0]+this.lo*Math.sin(this.angle));
		this.pol.xpoints[3]=(int)(pol.xpoints[1]-this.la*Math.cos(Math.PI/2-this.angle));
		this.pol.ypoints[3]=(int)(pol.ypoints[1]+this.la*Math.sin(Math.PI/2-this.angle));
		this.pol.xpoints[4]=(int)(pol.xpoints[0]-this.la*Math.cos(Math.PI/2-this.angle));
		this.pol.ypoints[4]=(int)(pol.ypoints[0]+this.la*Math.sin(Math.PI/2-this.angle));
		this.pol.xpoints[2]=(int)((pol.xpoints[1]+pol.xpoints[3])/2+Math.cos(this.angle)*lo/2);
		this.pol.ypoints[2]=(int)((pol.ypoints[1]+pol.ypoints[3])/2+Math.sin(this.angle)*lo/2);
	}

	/** Verifie si le bateau rentre en collision avec un autre bateau. 
	 * @param bat Le bateau avec lequel il risque une collision.
	 * @return Vrai si il y a une collision entre les 2 bateaux.
	 */
	public boolean collision(Bateau bat){
		int i=0;
		for(i=0;i<5;i++){
			if(this.pol.contains(bat.pol.xpoints[i],bat.pol.ypoints[i])){
				System.out.println("Collision ! ");
				return true;
			}
			/*if(this.pol.intersects(bat.pol.xpoints[0],bat.pol.ypoints[0],bat.lo,bat.la)){
				System.out.println("Collision ! inter");
				return true;
			}*/
		}
		return false;
	}

}
