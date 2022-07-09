import java.awt.Color;
import java.lang.Math;
import java.awt.Polygon;

/** Cette classe modélise les bateaux de commerces
 * @author Kevin
 * @see Bateau de commerce */
public class BateauCommerce extends Bateau{

	/** Instanciation d'un bateau de commerce avec une position x,y de départ et un angle. 
	 * @param x Position sur l'axe horizontal.
	 * @param y Position sur l'axe vertical.
	 * @param a Angle d'inclinaison.
	 */
	public BateauCommerce(int x,int y,double a){
		super(x,y,Color.GRAY);
		this.angle=a;
	}
}
