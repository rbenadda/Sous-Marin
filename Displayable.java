import java.awt.Graphics;
import java.awt.Color;

/** Cette classe modélise tout objet voulant être afficher dans la fenêtre
 * @author Kevin
 * @see Displayable
 */
public abstract class Displayable{
	/** Couleur de l'objet. */
	protected Color color;

	
	public Displayable(Color c){
		this.color=c;
	}

	public abstract void paint(Graphics g);
}
