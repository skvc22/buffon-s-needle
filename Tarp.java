import java.util.ArrayList;

/** 
* <h2>Tarp</h2>
* <p>Create a tarp which stores width, needle length, and an arraylist of needles.
* It has methods for accessing these, creating needles, checking if they crossed
* a line on the tarp, counting the total number of crossings, accessing the total
* number of needles, calculating the ratio of crossings to total needles.</p>
* 
* @author Sophie von Coelln
*/
public class Tarp {
    private final double t;
    private final double l;
    private ArrayList<Needle> needles = new ArrayList<Needle>();

	/**
	* The constructor for a Tarp object. Create a tarp of length t whose needles
	* are of length l. 
	* 
	* @param t the length of the tarp.
	* @param l the length of the needles.
	*/
    public Tarp(double t, double l) {
		this.t = t;
		this.l = l;
    }

	/**
	* Create a needle which takes the tarp object it is called with as a parameter.
	* Add it to an ArrayList of all needles. 
	*/
	public void throwNeedle() {
		Needle myNeedle = new Needle(this);
		needles.add(myNeedle);
	}

	/**
	* Return true if the needle has crossed a line on the tarp. 
	* 
	* @param n a needle.
	* @return if the needle crossed a line. 
	*/
	private boolean hasCrossed(Needle n) {
		return (n.leftTip() < 0 || n.rightTip() > t);
	}

	/**
	* Loop through the needles and count the number of times hasCrossed returns
	* true. Return this number. 
	* 
	* @return the number of needles that crossed a line on the tarp.
	*/
    public int numberOfCrossings() {
		int counter = 0;
		for (int i = 0; i < needles.size(); i++) {
			if (hasCrossed(needles.get(i))) {
				counter++;
			}
		}
		return counter;
    }

	/**
	* Return the size of the needle ArrayList. 
	* 
	* @return the total number of needles.
	*/
    public int numberOfNeedles() {
		return needles.size();
    }
	
	/**
	* Calculate the fraction of needles that crossed a line. 
	* 
	* @return the ratio of crossings to total needles.
	*/
	public double ratioOfCrossings() {
		return ((double)numberOfCrossings() / numberOfNeedles());
	}
	
	/**
	* Return the length of the tarp. 
	* 
	* @return the tarp's length.
	*/
	public double getT() {
		return t;
	}
	
	/**
	* Return the length of the needles. 
	* 
	* @return the needles' length.
	*/
	public double getL() {
		return l;
	}
}