import java.awt.Color;
import java.lang.Math;

/** Cette classe modélise les bateaux militaires
 * @author Kevin
 * @see BateauMilitaire 
 */
public class BateauMilitaire extends Bateau{
	
	/** Nombre de torpille pouvant être tirer par un bateau militaire. */
	protected static int nombreMun=3;
	/** Les torpilles tiré par un bateau militaire. 
	 * @see Torpille
	 */
	protected Torpille[] torpilles;

	/** Instanciation d'un bateau militaire avec une position x,y de départ et une couleur. 
	 * @param x Position sur l'axe horizontal.
	 * @param y Position sur l'axe vertical.
	 * @param a Angle d'inclinaison.
	 */
	public BateauMilitaire(int x,int y,double a){
		super(x,y,Color.GREEN);
		this.angle=a;
		this.vitesse=10;
		this.torpilles=new Torpille[BateauMilitaire.nombreMun];
	}
	
	/** Permet de tirer des torpilles. */
	public void tirer(){
		if(this.nombreMun>0){
			this.nombreMun--;
			this.torpilles[nombreMun]= new Torpille(this.pol.xpoints[2]+3,this.pol.ypoints[2]-3,this.angle);
		}else{
			System.out.println("Plus de munitions");
		}
	}


}
