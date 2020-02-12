/**
 * Class that takes in values from the Soil Controller and manipulates them
 * using various methods Also contains the setter and getter methods for its
 * instance variables
 * 
 *
 */
public class SoilSensorModel {
	private double currentSoil;
	private double desiredSoil;
	private String SprinklerLabel;
	private long sampleRateSoil;
	private double sprinklerRate;
	private double moistureLossRate;

	private double upperRange;
	private double lowerRange;

	private double extSoil;
	private double extRate;
	private double sumRate;

	/**
	 * Constructor to set the intial values for all varibles to zero
	 */
	public SoilSensorModel() {
		currentSoil = 0;
		desiredSoil = 0;
		upperRange = 0;
		lowerRange = 0;
		SprinklerLabel = "OFF";
		sampleRateSoil = 0;
		sprinklerRate = 0;

		extSoil = 0;
		extRate = 0;
		sumRate = 0;
	}

	public String getSprinklerLabel() {
		return SprinklerLabel;
	}

	public void extSoilEffect() {

		// if the current is greater than the external, than the external rate
		// is set to a negative
		if (currentSoil > extSoil)
			this.extRate *= -1;

	}

	/**
	 * Sets the external moisture effect rate
	 * 
	 * @param extRate
	 *            The value to set the external moisture effect rate to
	 */
	public void setExtRate(double extRate) {

		this.extRate = extRate;
	}

	/**
	 * 
	 * @return The external soil moisture effect rate as a double
	 */
	public double getExtRate() {
		return extRate;
	}

	/**
	 * Sets the sum of the rates affecting the current soil moisture level
	 * 
	 * @param rate
	 *            The value to set the sum of the rates to
	 */
	public void setSumRate(double rate) {
		this.sumRate = rate;
	}

	/**
	 * A method to apply the sum of the rates affecting the moisture level to
	 * the current soil moisture level
	 */
	public void applySumRate() {
		// Takes the combined rate and adds it and assigns it to the current
		// value
		this.currentSoil += sumRate;
	}

	/**
	 * Sets the external moisture level
	 * 
	 * @param extSoil
	 *            The value to set the external moisture level to
	 */
	public void setExtSoil(double extSoil) {
		this.extSoil = extSoil;
	}

	/**
	 * 
	 * @return The external soil moisture level as a double
	 */
	public double getExtSoil() {
		return extSoil;
	}

	/**
	 * 
	 * @return The current soil mositure level as a double
	 */
	public double getCurrentSoil() {
		return currentSoil;
	}

	/**
	 * Sets the current soil moisture level
	 * 
	 * @param currentSoil
	 *            The value to set the current moisture level to
	 */
	public void setCurrentSoil(double currentSoil) {
		this.currentSoil = currentSoil;
	}

	/**
	 * 
	 * @return The desired soil moisture level as a double
	 */
	public double getDesiredSoil() {
		return desiredSoil;
	}

	/**
	 * Sets the desired soil moisture level
	 * 
	 * @param desiredSoil
	 *            The value of the desired soil mositure
	 */
	public void setDesiredSoil(double desiredSoil) {
		this.desiredSoil = desiredSoil;
	}

	/**
	 * 
	 * @return The upper range of the desired moisture level as a double
	 */
	public double getUpperRange() {
		return upperRange;
	}

	/**
	 * Sets the upper range of the desired moisture level
	 * 
	 * @param upperRange
	 *            The to set the upper range to
	 */
	public void setUpperRange(double upperRange) {
		this.upperRange = desiredSoil + upperRange;
	}

	/**
	 * 
	 * @return The lower range of the desired moisture level as a double
	 */
	public double getLowerRange() {
		return lowerRange;
	}

	/**
	 * Sets the lower range of the desired moisture level
	 * 
	 * @param lowerRange
	 *            The value to set the lower range to
	 */
	public void setLowerRange(double lowerRange) {
		this.lowerRange = desiredSoil - lowerRange;
	}

	/**
	 * 
	 * @return The current refresh rate as a long
	 */
	public long getSampleRateSoil() {
		return sampleRateSoil;
	}

	/**
	 * Sets the refresh rate
	 * 
	 * @param sampleRateSoil
	 *            The value to set the refresh rate to
	 */
	public void setSampleRateSoil(long sampleRateSoil) {
		this.sampleRateSoil = sampleRateSoil;
	}

	/**
	 * 
	 * @return The rate at which the sprinkler acts as a double
	 */
	public double getSprinklereRate() {
		return sprinklerRate;
	}

	/**
	 * Sets the rate at which the sprinkler acts
	 * 
	 * @param sprinklerRate
	 *            The value to set the sprinkler rate to
	 */
	public void setSprinklerRate(double sprinklerRate) {
		this.sprinklerRate = sprinklerRate;
	}

	/**
	 * 
	 * @return The rate at which moisture is lost as a double.
	 */
	public double getMoistureLossRate() {
		return moistureLossRate;
	}

	/**
	 * Sets the rate at which soil moisture is lost.
	 */
	public void setMoistureLossRate() {
		this.moistureLossRate = this.sprinklerRate * -1;
	}

}
