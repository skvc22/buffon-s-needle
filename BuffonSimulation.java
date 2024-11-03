/** 
* <h2>Buffon Simulation</h2>
* <p>A Monte Carlo simulation determining the average k value in the equation
* P = kr, where P is the probability of needles of randomly generated length r
* in the range [0, 1) crossing lines 1 unit apart. Additionally, it determines 
* a 95% confidence interval for the k values from a series of simulations.</p>
* 
* @author Sophie von Coelln
*/
public class BuffonSimulation {
	
	double ratio;
	double rValue;
	
	/**
	* The constructor for a BuffonSimulation object. Instantiate a Tarp object
	* with a t value of 1.0 and a needle length of r, throw n needles onto
	* the tarp, and set the value of ratio to the ratio of needles that crossed
	* a line vs the total needles. 
	* 
	* @param r passed as a parameter to an instance of the Tarp class as the
	* length of the needles.
	* @param n the number of needles to be "thrown" onto the tarp.
	*/
	public BuffonSimulation(double r, int n) {
		this.rValue = r;
		Tarp tarp = new Tarp(1.0, r);		
		
		for (int i = 0; i < n; i++) {
			tarp.throwNeedle();
		}
		
		ratio = tarp.ratioOfCrossings();
	}
	
	/**
	* Calculate the k value of a simulation by dividing ratio (needles
	* that crossed a line vs total needles) by the length of the needles.
	* 
	* @return the k value.
	*/
	public double kValue() {
		return ratio / rValue;
	}
	
	/**
	* Calculate the standard deviation of all k values from the mean. 
	* 
	* @param values an array of k values from all simulations.
	* @param avg average k value across all simulations. 
	* @return the standard deviation. 
	*/
	public static double standardDeviation(double[] values, double avg) {
		double avgDifference = 0.0;
		for (int i = 0; i < values.length; i++) {
			avgDifference += Math.pow(values[i] - avg, 2);
		}
        return Math.sqrt(avgDifference/values.length);
	}

	/**
	* Calculate the upper bound of the 95% confidence interval. 
	* 
	* @param stdDev the standard deviation.
	* @param population the total number of simulations.
	* @param avg average k value across all simulations. 
	* @return the upper bound of the confidence interval. 
	*/
	public static double ciUpper(double stdDev, int population, double avg) {
		double zSigmaN = 1.96 * (stdDev/(Math.sqrt(population)));
		return (avg + zSigmaN);
	}
	
	/**
	* Calculate the lower bound of the 95% confidence interval. 
	* 
	* @param stdDev the standard deviation.
	* @param population the total number of simulations.
	* @param avg average k value across all simulations. 
	* @return the lower bound of the confidence interval. 
	*/
	public static double ciLower(double stdDev, int population, double avg) {
		double zSigmaN = 1.96 * (stdDev/(Math.sqrt(population)));
		return (avg - zSigmaN);
	}

	/**
	* Instantiate a BuffonSimulation object. Create variables for the number
	* of simulations (passed as a command line argument), total k value, average
	* k value, and standard deviation. Instantiate and fill an array of all k
	* values. Print the average k values and upper and lower bounds of the
	* confidence interval.
	* 
	* @param args[0] command line argument.
	*/
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		double totalK = 0.0;
		double[] k = new double[x];
		
		for (int i = 0; i < x; i++) {
			BuffonSimulation simulate = new BuffonSimulation(Math.random(), 1000000);
			k[i] = simulate.kValue();
			totalK += simulate.kValue();
		}
		
		double kAvg = totalK/x;
		double d = standardDeviation(k, kAvg);

		System.out.println("Upper limit of the confidence interval: " + ciUpper(d, x, kAvg) + 
		"\nLower limit of the confidence interval: " + ciLower(d, x, kAvg) + "\nAverage k value: " + kAvg);
	}
}
