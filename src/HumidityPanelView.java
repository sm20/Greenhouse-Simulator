import java.awt.*;
import javax.swing.*;

/**
 * 
 * Class that creates the GUI for the HumidityPanel as well as contains the
 * getter and setter methods for all instance variables of the class
 *
 */
public class HumidityPanelView extends JPanel {

	private JTextField currentResultLabel;
	private JTextField desiredTextField;
	private JTextField upRangeField;
	private JTextField lowRangeField;
	private JLabel humidifierResultLabel;
	private JTextField sampleRateTextField;
	private JTextField humidityRateTextField;

	/**
	 * Constructor that Creates the GUI panel for dealing with the Humidity.
	 */
	public HumidityPanelView() {
		// Creates all the rows
		setPreferredSize(new Dimension(250, 250));
		setBorder(BorderFactory.createTitledBorder("Humidity"));

		JPanel desiredPanel = new JPanel(new FlowLayout());
		desiredTextField = new JTextField(5);
		JLabel upLimLabel = new JLabel(" Up Lim:");
		upRangeField = new JTextField(5);
		JLabel lowLimLabel = new JLabel(" Low Lim:");
		lowRangeField = new JTextField(5);
		desiredPanel.add(desiredTextField);
		desiredPanel.add(upLimLabel);
		desiredPanel.add(upRangeField);
		desiredPanel.add(lowLimLabel);
		desiredPanel.add(lowRangeField);

		JPanel sampleRatePanel = new JPanel(new FlowLayout());
		sampleRateTextField = new JTextField(5);
		JLabel timeUnitsLabel = new JLabel("seconds");
		sampleRatePanel.add(sampleRateTextField);
		sampleRatePanel.add(timeUnitsLabel);

		JPanel humidityRatePanel = new JPanel(new FlowLayout());
		humidityRateTextField = new JTextField(5);
		JLabel timeUnitsLabel1 = new JLabel("% per second");
		humidityRatePanel.add(humidityRateTextField);
		humidityRatePanel.add(timeUnitsLabel1);

		JLabel currentLabel = new JLabel("Current (%): ");
		JLabel desiredLabel = new JLabel("Desired (%): ");
		JLabel humidifierLabel = new JLabel("Humidifier: ");
		JLabel sampleRateLabel = new JLabel("Refresh Rate: ");
		JLabel humidifierRateLabel = new JLabel("Humidifier Rate: ");

		currentResultLabel = new JTextField(5);
		humidifierResultLabel = new JLabel("OFF");

		JLabel emptySpace = new JLabel("");

		// Using GridBag Layout to assign panels and labels
		setLayout(new GridBagLayout());
		GridBagConstraints constraintsHumidityPanel = new GridBagConstraints();

		/// FIRST COLUMN///
		constraintsHumidityPanel.anchor = GridBagConstraints.LINE_END;
		constraintsHumidityPanel.weightx = 0.5;
		constraintsHumidityPanel.weighty = 0.5;

		constraintsHumidityPanel.gridx = 0;
		constraintsHumidityPanel.gridy = 0;
		add(currentLabel, constraintsHumidityPanel);

		constraintsHumidityPanel.gridx = 0;
		constraintsHumidityPanel.gridy = 1;
		add(desiredLabel, constraintsHumidityPanel);

		constraintsHumidityPanel.gridx = 0;
		constraintsHumidityPanel.gridy = 2;
		add(humidifierLabel, constraintsHumidityPanel);

		constraintsHumidityPanel.gridx = 0;
		constraintsHumidityPanel.gridy = 3;
		add(sampleRateLabel, constraintsHumidityPanel);

		constraintsHumidityPanel.gridx = 0;
		constraintsHumidityPanel.gridy = 4;
		add(humidifierRateLabel, constraintsHumidityPanel);

		//// SECOND COLUMN////
		constraintsHumidityPanel.anchor = GridBagConstraints.LINE_START;

		constraintsHumidityPanel.gridx = 1;
		constraintsHumidityPanel.gridy = 0;
		add(currentResultLabel, constraintsHumidityPanel);

		constraintsHumidityPanel.gridx = 1;
		constraintsHumidityPanel.gridy = 1;
		add(desiredPanel, constraintsHumidityPanel);

		constraintsHumidityPanel.gridx = 1;
		constraintsHumidityPanel.gridy = 2;
		add(humidifierResultLabel, constraintsHumidityPanel);

		constraintsHumidityPanel.gridx = 1;
		constraintsHumidityPanel.gridy = 3;
		add(sampleRatePanel, constraintsHumidityPanel);

		constraintsHumidityPanel.gridx = 1;
		constraintsHumidityPanel.gridy = 4;
		add(humidityRatePanel, constraintsHumidityPanel);

		/// LAST ROW////
		constraintsHumidityPanel.anchor = GridBagConstraints.FIRST_LINE_START;
		constraintsHumidityPanel.weighty = 10;
		constraintsHumidityPanel.gridx = 1;
		constraintsHumidityPanel.gridy = 5;
		add(emptySpace, constraintsHumidityPanel);

	}

	// Getter and Setter methods for the class
	/**
	 * 
	 * @return The current humidity level as a String
	 */
	public String getCurrentResultLabel() {
		return currentResultLabel.getText();
	}

	/**
	 * sets the text for the current humidity field
	 * 
	 * @param currentResultLabel
	 *            The label to set the current humidity value to
	 */
	public void setCurrentResultLabel(String currentResultLabel) {
		this.currentResultLabel.setText(currentResultLabel);
	}

	/**
	 * 
	 * @return The desired humidity level as a String
	 */
	public String getDesiredTextField() {
		return desiredTextField.getText();
	}

	/**
	 * Sets the text for the desired humidity field
	 * 
	 * @param desiredTextField
	 *            The value that will go in the desired text field
	 */
	public void setDesiredTextField(String desiredTextField) {
		this.desiredTextField.setText(desiredTextField);
	}

	/**
	 * 
	 * @return The upper range entered by the user, as a String.
	 */
	public String getUpRangeField() {
		return upRangeField.getText();
	}

	/**
	 * Sets the upper range fields text
	 * 
	 * @param upRangeField
	 *            The value that will go in the upper range field
	 */
	public void setUpRangeField(String upRangeField) {
		this.upRangeField.setText(upRangeField);
	}

	/**
	 * 
	 * @return The lower range as a String
	 */
	public String getLowRangeField() {
		return lowRangeField.getText();
	}

	/**
	 * Sets the text that goes in the lower range field
	 * 
	 * @param lowRangeField
	 *            The value to set the lower range field to
	 */
	public void setLowRangeField(String lowRangeField) {
		this.lowRangeField.setText(lowRangeField);
	}

	/**
	 * 
	 * @return The result of the current state of the humidifier as a String
	 */
	public String getHumidifierResultLabel() {
		return humidifierResultLabel.getText();
	}

	/**
	 * Sets the text that goes in the humidifier current state field
	 * 
	 * @param humidifierResultLabel
	 *            The value of ON or OFF to set the humidifer current state to
	 */
	public void setHumidifierResultLabel(String humidifierResultLabel) {
		this.humidifierResultLabel.setText(humidifierResultLabel);
	}

	/**
	 * 
	 * @return The refresh rate as a string
	 */
	public String getSampleRateTextField() {
		return sampleRateTextField.getText();
	}

	/**
	 * Sets the refresh rate
	 * 
	 * @param sampleRateTextField
	 *            The text that will go in the refresh rate value
	 */
	public void setSampleRateTextField(String sampleRateTextField) {
		this.sampleRateTextField.setText(sampleRateTextField);
	}

	/**
	 * 
	 * @returnThe value by which the humidifier changes the humidity, as a
	 *            String
	 */
	public String getHumidityRateTextField() {
		return humidityRateTextField.getText();
	}

	/**
	 * Sets the value for the rate the humidifier runs
	 * 
	 * @param humidityRateTextField
	 *            The text that will go in for the humidifer rate value
	 */
	public void setHumidityRateTextField(String humidityRateTextField) {
		this.humidityRateTextField.setText(humidityRateTextField);
	}
}
