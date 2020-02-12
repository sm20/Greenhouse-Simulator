/**
 * 
 * Class that takes in values sent by the Humidity controller and manipulates
 * them using various methods. Also contains getters and setters for all of its
 * instance variables.
 *
 */
public class HumiditySensorModel {

	private double currentHumidity;
	private double desiredHumidity;
	private String humidifierLabel;
	private long sampleRateHumidity;
	private double humidifierRate;
	private double humidityLossRate;

	private double upperRange;
	private double lowerRange;

	private double extHumidity;
	private double extRate;
	private double sumRate;

	/**
	 * Constructor to set the intial values for all varibles to zero
	 */
	public HumiditySensorModel() {
		currentHumidity = 0;
		desiredHumidity = 0;
		upperRange = 0;
		lowerRange = 0;
		humidifierLabel = "OFF";
		sampleRateHumidity = 0;
		humidifierRate = 0;

		extHumidity = 0;
		extRate = 0;
		sumRate = 0;
	}

	/**
	 * 
	 * @return The state of the humidifier as a String
	 */
	public String gethumidifierLabel() {
		return humidifierLabel;
	}

	/**
	 * Sets the external humidity rate to a negative if the current humidty is
	 * greater that the external humidity
	 */
	public void extHumidityEffect() {

		// if the current is greater than the external, than the external rate
		// is set to a negative
		if (currentHumidity > extHumidity)
			this.extRate *= -1;

	}

	/**
	 * Sets the rate effect the external temperature has
	 * 
	 * @param extRate
	 *            The value to set the external rate to
	 */
	public void setExtRate(double extRate) {

		this.extRate = extRate;
	}

	public double getExtRate() {
		return extRate;
	}

	/**
	 * Sets the summation of all the rates
	 * 
	 * @param rate
	 *            The value for the sum of all the rates
	 */
	public void setSumRate(double rate) {
		this.sumRate = rate;
	}

	/**
	 * A method to increase the current humidty by the sum of all the rates
	 * affecting the humidity
	 */
	public void applySumRate() {
		// Takes the combined rate and adds it and assigns it to the current
		// value
		this.currentHumidity += sumRate;
	}

	/**
	 * Sets the external humidity level
	 * 
	 * @param extHumidity
	 *            the value for the external humidity level
	 */
	public void setExtHumidity(double extHumidity) {
		this.extHumidity = extHumidity;
	}

	/**
	 * 
	 * @return The external humidity level as a double
	 */
	public double getExtHumidity() {
		return extHumidity;
	}

	/**
	 * 
	 * @return The current humidity as a double
	 */
	public double getCurrentHumidity() {
		return currentHumidity;
	}

	/**
	 * Sets the current humidity level
	 * 
	 * @param currentHumidity
	 *            The value to set the current humidity level to
	 */
	public void setCurrentHumidity(double currentHumidity) {
		this.currentHumidity = currentHumidity;
	}

	/**
	 * 
	 * @return The desired humidity level as a double
	 */
	public double getDesiredHumidity() {
		return desiredHumidity;
	}

	/**
	 * Sets teh desired humidity level
	 * 
	 * @param desiredHumidity
	 *            The value to set the desired humidity level to
	 */
	public void setDesiredHumidity(double desiredHumidity) {
		this.desiredHumidity = desiredHumidity;
	}

	/**
	 * 
	 * @return The upper range of the desired humidity as a double
	 */
	public double getUpperRange() {
		return upperRange;
	}

	/**
	 * Sets the upper range for the desired humidity
	 * 
	 * @param upperRange
	 *            The value to set the upper range of teh desired humidity to
	 */
	public void setUpperRange(double upperRange) {
		this.upperRange = desiredHumidity + upperRange;
	}

	/**
	 * 
	 * @return The lower range of the desired humidity as a double
	 */
	public double getLowerRange() {
		return lowerRange;
	}

	/**
	 * Sets the lower range of the desired humidity
	 * 
	 * @param lowerRange
	 *            The value to set teh lower range of the desired humidity to
	 */
	public void setLowerRange(double lowerRange) {
		this.lowerRange = desiredHumidity - lowerRange;
	}

	/**
	 * 
	 * @return The refresh rate for the humidity panel as a long
	 */
	public long getSampleRateHumidity() {
		return sampleRateHumidity;
	}

	/**
	 * sets the refresh rate for the humidity panel
	 * 
	 * @param sampleRateHumidity
	 *            The value to set the refresh rate to
	 */
	public void setSampleRateHumidity(long sampleRateHumidity) {
		this.sampleRateHumidity = sampleRateHumidity;
	}

	/**
	 * 
	 * @return The rate at which the humidifier acts as a double
	 */
	public double getHumidifiereRate() {
		return humidifierRate;
	}

	/**
	 * Sets the humidifier rate
	 * 
	 * @param humidifierRate
	 *            The value to set the humidifier rate to
	 */
	public void setHumidifierRate(double humidifierRate) {
		this.humidifierRate = humidifierRate;
	}

	/**
	 * 
	 * @return The rate at which humidity is lost as a double
	 */
	public double getHumidityLossRate() {
		return humidityLossRate;
	}

	/**
	 * Sets the rate at which the humidity is lost
	 */
	public void setHumidityLossRate() {
		this.humidityLossRate = this.humidifierRate * -1;
	}
}
