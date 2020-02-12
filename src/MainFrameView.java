import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 * Class that instantiates all the classes, creates the GUI and adds the panels
 * to the GUI. It also deals with the Buttons when they are pressed. It starts
 * and ends threads
 *
 */
public class MainFrameView extends JFrame {

	private GreenhousePanel greenhousePanel;

	private Thread thread1, thread2, thread3;

	/**
	 * Sets the layout of the GUI, instantiates all the classes and threads, and
	 * contains the class that listens for button presses
	 * 
	 * @param Sets
	 *            the title of the JFrame
	 */
	public MainFrameView(String title) {

		super(title);//JFrame's constructor simply sets the frames title.
		
		
		// creates container and adds each panel to them
		//If the class did not extend JFrame, would have to write frame.getContentPane();
		Container c = getContentPane();
		// Sets the layout each panel will go in as a grid layout
		setLayout(new GridLayout(0, 4));

		// instantiating all the panels
		greenhousePanel = new GreenhousePanel();

		TempPanelView tempPanel = new TempPanelView();
		TempSensorModel tempSensor = new TempSensorModel();
		TempController tempController = new TempController(greenhousePanel, tempPanel, tempSensor);

		SoilMoisturePanelView soilMoisturePanel = new SoilMoisturePanelView();
		SoilSensorModel soilSensor = new SoilSensorModel();
		SoilController soilController = new SoilController(greenhousePanel, soilMoisturePanel, soilSensor);

		HumidityPanelView humidityPanel = new HumidityPanelView();
		HumiditySensorModel humiditySensor = new HumiditySensorModel();
		HumidityController humidityController = new HumidityController(greenhousePanel, humidityPanel, humiditySensor);
		
		c.add(tempPanel);
		c.add(humidityPanel);
		c.add(soilMoisturePanel);
		c.add(greenhousePanel);

		// creating threads
		thread1 = new Thread(tempController);
		thread2 = new Thread(soilController);
		thread3 = new Thread(humidityController);
		/**
		 * 
		 * Responds to Button presses for START, STOP, LOAD, SAVE
		 *
		 */
		class ButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {

				// Start starts each thread
				String buttonPress = e.getActionCommand();
				if (buttonPress == "START") {
					System.out.println("Print from main");
					thread1.start();
					thread2.start();
					thread3.start();
					// Stop stops all threads and then instantiates each thread
					// again for when the threads are restarted
				} else if (buttonPress == "STOP") {
					tempController.kill();
					thread1 = new Thread(tempController);
					soilController.kill();
					thread2 = new Thread(soilController);
					humidityController.kill();
					thread3 = new Thread(humidityController);
				}

				else if (buttonPress == "SAVE")
					;
				else if (buttonPress == "LOAD")
					;

			}
		}

		greenhousePanel.addButtonListeners(new ButtonListener());


		



	}

}
