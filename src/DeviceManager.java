/**
 * 
 * A class that acts as all the devices the GUI has to utilize to change the
 * values for the currents. It contains setter and getter methods for its
 * instance variables The devices include: AC, Furnace, Sprinkler, Humidifier
 *
 */
public class DeviceManager {

	// All the instance variables of this class
	private TempPanelView tempView;
	private TempSensorModel tempModel;
	private double tempDifference;
	private String furnaceLabel;
	private String acLabel;
	private double rateChange;

	private SoilMoisturePanelView soilView;
	private SoilSensorModel soilModel;
	private double soilDifference;
	private String sprinklerLabel;
	private double soilRateChange;

	private HumidityPanelView humidityView;
	private HumiditySensorModel humidityModel;
	private double humidityDifference;
	private String humidifierLabel;
	private double humidityRateChange;

	// Constructor for each of Temperature, Soil Moisture, Humidity devices
	/**
	 * Constructor to handle temperature devices. Instantiates objects from the
	 * Temperature view and model class
	 * 
	 * @param view
	 *            TempPanelView object
	 * @param model
	 *            TempSensorModel object
	 */
	public DeviceManager(TempPanelView view, TempSensorModel model) {

		this.tempView = view;
		this.tempModel = model;
	}

	/**
	 * Constructor to handle soil moisture devices. Instantiates objects from
	 * the Temperature view and model class
	 * 
	 * @param view
	 *            SoilMoisturePanelView object
	 * @param model
	 *            SoilSensorModel object
	 */
	public DeviceManager(SoilMoisturePanelView view, SoilSensorModel model) {
		this.soilView = view;
		this.soilModel = model;
	}

	/**
	 * Constructor to handle humidity devices. Instantiates objects from the
	 * Temperature view and model class
	 * 
	 * @param view
	 *            HumidityPanelView object
	 * @param model
	 *            HumiditySensorModel object
	 */
	public DeviceManager(HumidityPanelView view, HumiditySensorModel model) {
		this.humidityView = view;
		this.humidityModel = model;
	}

	/**
	 * Sets the states for the AC and Furnace based on whether the greenhouse
	 * needs to be cooled or heated
	 * 
	 * @param currentTemp
	 *            The value of the current temperature
	 * @param desiredTemp
	 *            The value of the desired temperature
	 */
	public void tempDifference(double currentTemp, double desiredTemp) {
		// Sets the AC and Furnace as ON or OFF based on whther the current
		// temperature is greater than or less than the desired temperature
		// range
		if ((currentTemp >= (desiredTemp + 3)) || (currentTemp <= (desiredTemp - 3))) {
			this.tempDifference = (desiredTemp - currentTemp);
			if (tempDifference < 0) {
				furnaceLabel = "OFF";
				acLabel = "ON";
			} else if (tempDifference > 0) {
				furnaceLabel = "ON";
				acLabel = "OFF";
			} else {
				furnaceLabel = "OFF";
				acLabel = "OFF";
			}
		} else {
			furnaceLabel = "OFF";
			acLabel = "OFF";
		}
	}

	/**
	 * The rate at which the current temperature will change based on the
	 * external temprature and the AC and furnace rates
	 * 
	 * @param extRate
	 *            The external temperature effect rate
	 * @param acRate
	 *            The rate the AC acts
	 * @param furnaceRate
	 *            The rate the furnace acts
	 */
	public void setTempRate(double extRate, double acRate, double furnaceRate) {
		// The rate at which the current will change based on whether the
		// difference between the desired and current temeprature is positive or
		// negative
		if (tempDifference < 0) {
			this.rateChange = extRate + acRate;

		} else if (tempDifference > 0) {
			this.rateChange = extRate + furnaceRate;

		} else {
			this.rateChange = 0;
		}

	}

	// getter methods for temperature related items
	/**
	 * 
	 * @return The state of the Furnace
	 */
	public String getFurnaceLabel() {
		return furnaceLabel;
	}

	/**
	 * 
	 * @return The state of the Air Conditioner
	 */
	public String getAcLabel() {
		return acLabel;
	}

	/**
	 * 
	 * @return The rate at which the current temperature will change as a double
	 */
	public double getRateChange() {
		return rateChange;
	}

	/**
	 * Sets the sprinkler state based on the current soil moisture and the the
	 * desired soil moisture
	 * 
	 * @param currentSoil
	 *            The current soil moisture levels
	 * @param desiredSoil
	 *            The desired soil moisture levels
	 * @param upperRange
	 *            The upper range of the desired soil moisture
	 * @param lowerRange
	 *            The lower range of the desired soil moisture
	 */
	public void soilDifference(double currentSoil, double desiredSoil, double upperRange, double lowerRange) {
		// Sets the soil label as ON or OFF depending on the if the current
		// temperature is greater than or less than the desired range
		if ((currentSoil >= (upperRange)) || (currentSoil <= (lowerRange))) {
			this.soilDifference = (desiredSoil - currentSoil);
			if (soilDifference < 0) {
				sprinklerLabel = "OFF";

			} else if (soilDifference > 0) {
				sprinklerLabel = "ON";

			} else {
				sprinklerLabel = "OFF";

			}
		} else {
			sprinklerLabel = "OFF";

		}
	}

	/**
	 * Sets the rate at which the current soil moisture will change based on the
	 * external moisture rate and the sprinkler rate
	 * 
	 * @param extRate
	 *            The external moisture effect rate
	 * @param sprinklerRate
	 *            The sprinkler rate
	 * @param moistureLossRate
	 *            The rate at which soil moisture is lost
	 */
	public void setSoilRate(double extRate, double sprinklerRate, double moistureLossRate) {
		// Sets the rate at which the soil moisture will change depending on if
		// the difference between current and desired is positive or negative
		if (soilDifference > 0) {
			this.soilRateChange = extRate + sprinklerRate;

		} else if (soilDifference < 0) {
			this.soilRateChange = extRate + moistureLossRate;
		}
	}

	// getter methods for soil moisture related objects
	/**
	 * 
	 * @return The state of the sprinkler as a String
	 */
	public String getSprinklerLabel() {
		return sprinklerLabel;
	}

	/**
	 * 
	 * @return The rate at which the current soil moisture changes as a double
	 */
	public double getSoilRateChange() {
		return soilRateChange;
	}

	/**
	 * Sets the state for the humidifier based on current and desired values
	 * 
	 * @param currentHumidity
	 *            The current humidity
	 * @param desiredHumidity
	 *            The desired humidity
	 * @param upperRange
	 *            The upper range for the desired humidity
	 * @param lowerRange
	 *            The lower range for the desired humidity
	 */

	public void humidityDifference(double currentHumidity, double desiredHumidity, double upperRange,
			double lowerRange) {
		// Sets the humidifier state based on the difference between the current
		// and desired range of humidity
		if ((currentHumidity >= (upperRange)) || (currentHumidity <= (lowerRange))) {
			this.humidityDifference = (desiredHumidity - currentHumidity);
			if (humidityDifference < 0) {
				humidifierLabel = "OFF";

			} else if (humidityDifference > 0) {
				humidifierLabel = "ON";

			} else {
				humidifierLabel = "OFF";

			}
		} else {
			humidifierLabel = "OFF";

		}
	}

	/**
	 * Sets the rate at which the humidifier acts on the current humidity based
	 * on the external humidity and the rate the humidifier is set at
	 * 
	 * @param extRate
	 *            External humidity rate
	 * @param humidifierRate
	 *            Humidifier rate
	 * @param humidityLossRate
	 *            Rat at which humidity is lost from the greenhouse
	 */
	public void setHumidityRate(double extRate, double humidifierRate, double humidityLossRate) {
		// Sets the rate of change of teh current humidity based on the humidity
		// difference
		if (humidityDifference > 0) {
			this.humidityRateChange = extRate + humidifierRate;

		} else if (humidityDifference < 0) {
			this.humidityRateChange = extRate + humidityLossRate;
		}
	}

	// getter methods for humidity related objects
	/**
	 * 
	 * @return The state of the humidifier as a String
	 */
	public String getHumidifierLabel() {
		return humidifierLabel;
	}

	/**
	 * 
	 * @return The rate at which current humidity changes as a double
	 */
	public double getHumidityRateChange() {
		return humidityRateChange;
	}

}
