import java.text.DecimalFormat;

/**
 * Class that directs communication between the Humidity view and model classes.
 * User inputs from the GUI are taken from the view class and passed to the
 * model class. There they are calculated and sent back to this class to be sent
 * to the view class to be shown to the user. It implements Runnable.
 * 
 *
 */
public class HumidityController implements Runnable {

	// creates the instance variables
	private GreenhousePanel greenPanel;
	private HumidityPanelView view;
	private HumiditySensorModel model;
	// A flag to deal with the loop in the run() method
	private boolean flag;

	/**
	 * Initializes the objects needed for calculations later in this class
	 * 
	 * @param greenPanel
	 *            A GreenhousePanel class object
	 * @param humidityView
	 *            A HumidityPanelView object
	 * @param humiditySensor
	 *            a HumiditySensorModel object
	 */
	public HumidityController(GreenhousePanel greenPanel, HumidityPanelView humidityView,
			HumiditySensorModel humiditySensor) {
		// sets the object references to whatever is instantiated in the
		// MAinFrame class
		this.greenPanel = greenPanel;
		this.view = humidityView;
		this.model = humiditySensor;

	}

	/**
	 * method that when called, ends the thread
	 */
	public void kill() {
		flag = false;
	}

	/**
	 * Override Method implemented from Runnable. It gets all the values from
	 * view and calculates them in model and sends them back to the view. This
	 * is done until desired ranges are reached in the program or the stop
	 * button is pressed to end the loop.
	 */
	// The thread runs inside here
	public void run() {

		DecimalFormat df = new DecimalFormat("#.00");
		DeviceManager humidityManager = new DeviceManager(view, model);

		double currentHumidity;
		double desiredHumidity;
		double upperRange;
		double lowerRange;
		long refRate;
		// Try-Catch to handle InterruptedException
		try {
			flag = true;
			while (flag == true) {
				// gets all the values from the view and sets them to the model
				model.setCurrentHumidity(Double.parseDouble(view.getCurrentResultLabel()));
				model.setDesiredHumidity(Double.parseDouble(view.getDesiredTextField()));
				model.setUpperRange(Double.parseDouble(view.getUpRangeField()));
				model.setLowerRange(Double.parseDouble(view.getLowRangeField()));
				model.setSampleRateHumidity(Long.parseLong(view.getSampleRateTextField()));
				model.setHumidifierRate(Double.parseDouble(view.getHumidityRateTextField()));
				model.setHumidityLossRate();

				model.setExtRate(Double.parseDouble(greenPanel.getExtHumidityEffectField()));
				model.setExtHumidity(Double.parseDouble(greenPanel.getExtHumidityField()));
				model.extHumidityEffect();

				// applies the devices in the Device Manager to determine and
				// change the current rate
				humidityManager.humidityDifference(model.getCurrentHumidity(), model.getDesiredHumidity(),
						model.getUpperRange(), model.getLowerRange());
				view.setHumidifierResultLabel(humidityManager.getHumidifierLabel());
				humidityManager.setHumidityRate(model.getExtRate(), model.getHumidifiereRate(),
						model.getHumidityLossRate());

				model.setSumRate(humidityManager.getHumidityRateChange());
				model.applySumRate();

				currentHumidity = model.getCurrentHumidity();
				desiredHumidity = model.getDesiredHumidity();
				upperRange = model.getUpperRange();
				lowerRange = model.getLowerRange();
				// Sets the current Rate back to the view
				view.setCurrentResultLabel(df.format(currentHumidity));
				// Sets the amount of time before the current is updated again
				refRate = (model.getSampleRateHumidity()) * 1000;
				Thread.sleep(refRate);
				// Ends the loop and thread if the current is within the desired
				// range and sets the device state to OFF
				if ((currentHumidity <= upperRange) && (currentHumidity >= lowerRange)) {
					flag = false;
					view.setHumidifierResultLabel("OFF");
				}
			}

		} catch (InterruptedException e) {
			return;
		}
	}

}
