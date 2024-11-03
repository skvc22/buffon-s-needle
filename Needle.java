import java.util.Random;

/** 
* <h2>Needle</h2>
* <p>Create a single needle which stores length, center position, angle, left 
* tip position, and right tip position, and has methods for accessing these.</p>
* 
* @author Sophie von Coelln
*/
public class Needle {
    private final double length;
    private final double position;
    private final double angle;
    private final Tarp tarp;

	/**
	* The constructor for a Needle object. Generate a needle of length l, contained
	* in the tarp passed as a parameter. Generate a random number between -pi/2
	* and pi/2 as the needle's angle and a random number between 0 and the length
	* of the tarp as the needle's position. 
	* 
	* @param t an instance of the Tarp class
	*/
    public Needle(Tarp t) {
		this.tarp = t;
		length = tarp.getL();
		
		double ang = Math.random() - .5;
		angle = ang * Math.PI;
		
		position = Math.random()*tarp.getT();
    }

	/**
	* Return the position of the needle's center. 
	* 
	* @return the needle's position.
	*/
    public double center() {
		return position;
    }

	/**
	* Calculate the position of the needle's left tip. 
	* 
	* @return the position of the left tip of the needle.
	*/
    public double leftTip() {
		double left = position - (length/2 * (Math.cos(angle)));
		return left;
    }

	/**
	* Calculate the position of the needle's right tip. 
	* 
	* @return the position of the right tip of the needle.
	*/
    public double rightTip() {
		double right = position + (length/2 * (Math.cos(angle)));
		return right;
    }

	/**
	* Return the needle's angle between -pi/2 and pi/2. 
	* 
	* @return the needle's angle.
	*/
    public double angle() {
		return angle;
    }
}
