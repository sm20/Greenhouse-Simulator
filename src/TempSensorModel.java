/**
 * Class that takes in values from the Temeprature Controller and manipulates
 * them using various methods Also contains the setter and getter methods for
 * its instance variables
 * 
 *
 */
public class TempSensorModel {

	private double currentTemp;
	private double desiredTemp;
	private String furnaceState;
	private String acState;
	private long sampleRateTemp;
	private double furnaceRate;
	private double acRate;

	private double upperRange;
	private double lowerRange;

	private double extTemp;
	private double extRate;
	private double sumRate;

	private String furnaceLabel;
	private String acLabel;

	/**
	 * Constructor to set the initial values for all variables to zero
	 */
	public TempSensorModel() {
		currentTemp = 0;
		desiredTemp = 0;
		upperRange = 0;
		lowerRange = 0;
		furnaceState = "OFF";
		acState = "OFF";
		sampleRateTemp = 0;
		furnaceRate = 0;
		acRate = 0;

		extTemp = 0;
		extRate = 0;
		sumRate = 0;

		furnaceLabel = "OFF";
		acLabel = "OFF";
	}

	/**
	 * A method that sets the state of the AC and Furnace
	 */
	public void setDeviceState() {
		// Sets the device state to ON or OFF based on if the combined rate will
		// cool or heat the system
		if (sumRate > 0) {
			furnaceLabel = "ON";
			acLabel = "OFF";
		} else if (sumRate < 0) {
			acLabel = "ON";
			furnaceLabel = "OFF";
		}
	}

	/**
	 * 
	 * @return The state of the furnace as a String
	 */
	public String getFurnaceLabel() {
		return furnaceLabel;
	}

	/**
	 * 
	 * @return The state of the AC as a String
	 */
	public String getACLabel() {
		return acLabel;
	}

	/**
	 * Sets the external effect rate as a negative if it is less than the
	 * current temperature
	 */
	public void extTempEffect() {

		// if the current is greater than the external, than the external rate
		// is set to a negative
		if (currentTemp > extTemp) {
			if (extRate > 0) {
				this.extRate *= -1;
			}
		}

		else if (currentTemp < extTemp) {

			if (extRate < 0) {
				this.extRate *= -1;
			}
		}

	}

	/**
	 * Sets the external temperature effect rate
	 * 
	 * @param extRate
	 *            The value to set the external effect rate to
	 */
	public void setExtRate(double extRate) {

		this.extRate = extRate;
	}

	/**
	 * 
	 * @return The external temperature effect rate as a double
	 */
	public double getExtRate() {
		return extRate;
	}

	/**
	 * Sets the sum of the rates
	 * 
	 * @param rate
	 *            The value to set the sum of the rates to
	 */
	public void setSumRate(double rate) {
		this.sumRate = rate;
	}

	/**
	 * A method that applies the sum of all the rates to the current temperature
	 */
	public void applySumRate() {
		// Takes the combined rate and adds it ans assigns it to the current
		// value
		this.currentTemp += sumRate;
	}

	/**
	 * Sets the external temperature
	 * 
	 * @param extTemp
	 *            The value to set the external temeprature to
	 */
	public void setExtTemp(double extTemp) {
		this.extTemp = extTemp;
	}

	/**
	 * 
	 * @return The external temperature as a double
	 */
	public double getExtTemp() {
		return extTemp;
	}

	/**
	 * 
	 * @return The current temperature as a double
	 */
	public double getCurrentTemp() {
		return currentTemp;
	}

	/**
	 * Sets the current Temperature
	 * 
	 * @param currentTemp
	 *            The value to setr the current temperature to
	 */
	public void setCurrentTemp(double currentTemp) {
		this.currentTemp = currentTemp;
	}

	/**
	 * 
	 * @return The desired temperature as a double
	 */
	public double getDesiredTemp() {
		return desiredTemp;
	}

	/**
	 * Sets the desired temperature
	 * 
	 * @param desiredTemp
	 *            The value to set the desired temperature to
	 */
	public void setDesiredTemp(double desiredTemp) {
		this.desiredTemp = desiredTemp;
	}

	/**
	 * 
	 * @return The upper range of the desired temperature as a double
	 */
	public double getUpperRange() {
		return upperRange;
	}

	/**
	 * Sets the upper range of the desired temp
	 */
	public void setUpperRange() {
		this.upperRange = desiredTemp + 3;
	}

	/**
	 * 
	 * @return The lower range of the desired temperature as a double
	 */
	public double getLowerRange() {
		return lowerRange;
	}

	/**
	 * a method to set the lower range of the desired temp
	 */
	public void setLowerRange() {
		this.lowerRange = desiredTemp - 3;
	}

	/**
	 * 
	 * @return The furace state as a String
	 */
	public String getFurnaceState() {
		return furnaceState;
	}

	/**
	 * Sets the Furnace State
	 * 
	 * @param furnaceState
	 *            The value to set the furance state to
	 */
	public void setFurnaceState(String furnaceState) {
		this.furnaceState = furnaceState;
	}

	/**
	 * 
	 * @return The AC state as a String
	 */
	public String getacState() {
		return acState;
	}

	/**
	 * Sets the AC state
	 * 
	 * @param acState
	 *            the value to set the AC state to
	 */
	public void setacState(String acState) {
		this.acState = acState;
	}

	/**
	 * 
	 * @return The refresh rate as a long
	 */
	public long getSampleRateTemp() {
		return sampleRateTemp;
	}

	/**
	 * Sets the refresh rate for the temperature panel
	 * 
	 * @param sampleRateTemp
	 *            The value to set the rate to
	 */
	public void setSampleRateTemp(long sampleRateTemp) {
		this.sampleRateTemp = sampleRateTemp;
	}

	/**
	 * 
	 * @return The rate the furnace works, as a double
	 */
	public double getFurnaceRate() {
		return furnaceRate;
	}

	/**
	 * Sets the rate the furnace works
	 * 
	 * @param furnaceRate
	 *            The value to set the furnace rate to
	 */
	public void setFurnaceRate(double furnaceRate) {
		this.furnaceRate = furnaceRate;
	}

	/**
	 * 
	 * @return The rate at which the AC works as a double
	 */
	public double getacRate() {
		return acRate;
	}

	/**
	 * Sets the rate the AC works. sets it to a negative value.
	 * 
	 * @param acRate
	 *            The value to set the AC rate to
	 */
	public void setacRate(double acRate) {
		if (acRate > 0)
			this.acRate = acRate * -1;
	}

}
