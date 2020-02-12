import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TempController implements Runnable {

	private GreenhousePanel greenPanel;
	private TempPanelView view;
	private TempSensorModel model;

	private boolean flag;

	/**
	 * Initializes the objects needed for calculations later in this class
	 * 
	 * @param greenPanel
	 *            A GreenhousePanel class object
	 * @param tempPanel
	 *            A TempPanelView object
	 * @param tempSensor
	 *            a TempSensorModel object
	 */
	public TempController(GreenhousePanel greenPanel, TempPanelView tempPanel, TempSensorModel tempSensor) {
		// sets the object references to whatever is instantiated in the
		// MAinFrame class
		this.greenPanel = greenPanel;
		this.view = tempPanel;
		this.model = tempSensor;

	}

	/**
	 * method that when called, ends the thread
	 */
	public void kill() {
		flag = false;
	}

	/**
	 * Ovverride. Method implemented from Runnable. Runs when the thread is
	 * started. It gets all the values from view and calculates them in model
	 * and sends them back to the view. This is done until desired ranges are
	 * reached in the program or the stop button is pressed to end the loop.
	 */
	public void run() {

		System.out.println("print from TempControl");
		DecimalFormat df = new DecimalFormat("#.00");
		DeviceManager tempManager = new DeviceManager(view, model);
		// The thread runs inside here
		double currentTemp;
		double desiredTemp;
		double upperRange;
		double lowerRange;
		long refRate;

		// Try-Catch to handle InterruptedException
		try {

			flag = true;
			while (flag == true) {
				// gets all the values from the view and sets them to the model
				model.setCurrentTemp(Double.parseDouble(view.getCurrentResultField()));
				model.setDesiredTemp(Double.parseDouble(view.getDesiredTextField()));
				model.setUpperRange();
				model.setLowerRange();
				model.setSampleRateTemp(Long.parseLong(view.getSampleRateTextField()));
				model.setFurnaceRate(Double.parseDouble(view.getFurnaceRateTextField()));
				model.setacRate(Double.parseDouble(view.getacRateTextField()));

				model.setExtRate(Double.parseDouble(greenPanel.getExtTempEffectField()));
				model.setExtTemp(Double.parseDouble(greenPanel.getExtTempField()));
				model.extTempEffect();
				// applies the devices in the Device Manager to determine and
				// change the current rate
				tempManager.tempDifference(model.getCurrentTemp(), model.getDesiredTemp());
				view.setACResultLabel(tempManager.getAcLabel());
				view.setFurnaceResultLabel(tempManager.getFurnaceLabel());
				tempManager.setTempRate(model.getExtRate(), model.getacRate(), model.getFurnaceRate());
				model.setSumRate(tempManager.getRateChange());

				model.applySumRate();
				// Sets the current Rate back to the view
				currentTemp = model.getCurrentTemp();
				view.setCurrentResultField(df.format(currentTemp));

				desiredTemp = model.getDesiredTemp();
				upperRange = model.getUpperRange();
				lowerRange = model.getLowerRange();
				// Sets the amount of time before the current is updated again
				refRate = (model.getSampleRateTemp()) * 1000;
				Thread.sleep(refRate);
				// Ends the loop and thread if the current is within the desired
				// range and sets the device state to OFF
				if ((currentTemp <= upperRange) && (currentTemp >= lowerRange)) {
					flag = false;
					view.setACResultLabel("OFF");
					view.setFurnaceResultLabel("OFF");
				}

			}
		} catch (InterruptedException e) {
			return;
		}

	}

}
