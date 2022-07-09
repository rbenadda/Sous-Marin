import java.awt.Color;

/** Cette classe modélise les torpilles
 * @author Kevin
 * @see <a href="Torpille.html">Torpille</a> */
public class Torpille extends Bateau{

	/** Instanciation d'un missile avec une position x,y de départ et un angle. 
	 * @param x Position sur l'axe horizontal.
	 * @param y Position sur l'axe vertical.
	 * @param a Angle d'inclinaison.
	 */
	public Torpille(int x,int y,double a){
		super(x,y,Color.BLACK);
		this.angle=a;
		this.vitesse=10;
		this.lo = 6;
		this.la = 3;
	}

	/** Deplace le bateau selon sa vitesse et son angle, puis accelere sa vitesse.*/
	public void move(){
		this.pol.xpoints[0]+=this.vitesse*Math.cos(this.angle);
		this.pol.ypoints[0]+=this.vitesse*Math.sin(this.angle);
		vitesse++;
	}
}
