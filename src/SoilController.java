import java.text.DecimalFormat;

/**
 * Class that directs communication between the Soil view and model classes.
 * User inputs from the GUI are taken from the view class and passed to the
 * model class. There they are calculated and sent back to this class to be sent
 * to the view class to be shown to the user. It implements Runnable.
 * 
 *
 */
public class SoilController implements Runnable {
	// creates the instance variables
	private GreenhousePanel greenPanel;
	private SoilMoisturePanelView view;
	private SoilSensorModel model;
	// A flag to deal with the loop in the run() method
	private boolean flag;

	/**
	 * Initializes objects needed in the calculations later in the class
	 * 
	 * @param greenPanel
	 *            GreenhousePanel object
	 * @param soilPanel
	 *            SoilMoistureView object
	 * @param soilSensor
	 *            SoilSensorModel object
	 */
	public SoilController(GreenhousePanel greenPanel, SoilMoisturePanelView soilPanel, SoilSensorModel soilSensor) {
		// sets the object references to whatever is instantiated in the
		// MAinFrame class
		this.greenPanel = greenPanel;
		this.view = soilPanel;
		this.model = soilSensor;

	}

	/**
	 * method that when called, ends the thread
	 */
	public void kill() {
		flag = false;
	}

	/**
	 * Ovverride. Method implemented from Runnable. It gets all the values from
	 * view and calculates them in model and sends them back to the view. This
	 * is done until desired ranges are reached in the program or the stop
	 * button is pressed to end the loop.
	 */
	// The thread runs inside here
	public void run() {

		System.out.println("print from SoilControl");
		DecimalFormat df = new DecimalFormat("#.00");
		DeviceManager soilManager = new DeviceManager(view, model);

		double currentSoil;
		double desiredSoil;
		double upperRange;
		double lowerRange;
		long refRate;
		// Try-Catch to handle InterruptedException
		try {
			flag = true;
			while (flag == true) {
				// gets all the values from the view and sets them to the model
				model.setCurrentSoil(Double.parseDouble(view.getCurrentResultLabel()));
				model.setDesiredSoil(Double.parseDouble(view.getDesiredTextField()));
				model.setUpperRange(Double.parseDouble(view.getUpRangeField()));
				model.setLowerRange(Double.parseDouble(view.getLowRangeField()));
				model.setSampleRateSoil(Long.parseLong(view.getSampleRateTextField()));
				model.setSprinklerRate(Double.parseDouble(view.getSoilRateTextField()));
				model.setMoistureLossRate();

				model.setExtRate(Double.parseDouble(greenPanel.getExtSoilEffectField()));
				model.setExtSoil(Double.parseDouble(greenPanel.getExtSoilField()));
				model.extSoilEffect();
				// applies the devices in the Device Manager to determine and
				// change the current rate
				soilManager.soilDifference(model.getCurrentSoil(), model.getDesiredSoil(), model.getUpperRange(),
						model.getLowerRange());
				view.setSprinklerResultLabel(soilManager.getSprinklerLabel());
				soilManager.setSoilRate(model.getExtRate(), model.getSprinklereRate(), model.getMoistureLossRate());

				model.setSumRate(soilManager.getSoilRateChange());
				model.applySumRate();

				currentSoil = model.getCurrentSoil();
				desiredSoil = model.getDesiredSoil();
				upperRange = model.getUpperRange();
				lowerRange = model.getLowerRange();
				// Sets the current Rate back to the view
				view.setCurrentResultLabel(df.format(currentSoil));
				// Sets the amount of time before the current is updated again
				refRate = (model.getSampleRateSoil()) * 1000;
				Thread.sleep(refRate);

				// Ends the loop and thread if the current is within the desired
				// range and sets the device state to OFF
				if ((currentSoil <= upperRange) && (currentSoil >= lowerRange)) {
					flag = false;
					view.setSprinklerResultLabel("OFF");
				}

			}
		} catch (InterruptedException e) {
			return;
		}

	}

}
