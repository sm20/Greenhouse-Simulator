import java.awt.*;
import javax.swing.*;

/**
 * Class that creates the GUI for the Soil Moisture panel. Also containers the
 * getters and setters for all the instance varaibles of this class
 * 
 *
 */
public class SoilMoisturePanelView extends JPanel {

	private JTextField currentResultLabel;
	private JTextField desiredTextField;
	private JTextField upRangeField;
	private JTextField lowRangeField;
	private JLabel sprinklerResultLabel;
	private JTextField sampleRateTextField;
	private JTextField soilRateTextField;

	/**
	 * Constructor that creates the GUI panel for dealing with the Soil Moisture
	 */
	public SoilMoisturePanelView() {
		// Creates all the rows
		setPreferredSize(new Dimension(250, 250));
		setBorder(BorderFactory.createTitledBorder("Soil Moisture"));

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

		JPanel soilRatePanel = new JPanel(new FlowLayout());
		soilRateTextField = new JTextField(5);
		JLabel timeUnitsLabel1 = new JLabel("% per second");
		soilRatePanel.add(soilRateTextField);
		soilRatePanel.add(timeUnitsLabel1);

		JLabel currentLabel = new JLabel("Current (%): ");
		JLabel desiredLabel = new JLabel("Desired (%): ");
		JLabel sprinklerLabel = new JLabel("Sprinkler: ");
		JLabel sampleRateLabel = new JLabel("Refresh Rate: ");
		JLabel soilRateLabel = new JLabel("Saturation Rate: ");

		currentResultLabel = new JTextField(5);
		sprinklerResultLabel = new JLabel("OFF");

		JLabel emptySpace = new JLabel("");

		// Using GridBag Layout to assign panels and labels
		setLayout(new GridBagLayout());
		GridBagConstraints constraintsSoilPanel = new GridBagConstraints();

		/// FIRST COLUMN///
		constraintsSoilPanel.anchor = GridBagConstraints.LINE_END;
		constraintsSoilPanel.weightx = 0.5;
		constraintsSoilPanel.weighty = 0.5;

		constraintsSoilPanel.gridx = 0;
		constraintsSoilPanel.gridy = 0;
		add(currentLabel, constraintsSoilPanel);

		constraintsSoilPanel.gridx = 0;
		constraintsSoilPanel.gridy = 1;
		add(desiredLabel, constraintsSoilPanel);

		constraintsSoilPanel.gridx = 0;
		constraintsSoilPanel.gridy = 2;
		add(sprinklerLabel, constraintsSoilPanel);

		constraintsSoilPanel.gridx = 0;
		constraintsSoilPanel.gridy = 3;
		add(sampleRateLabel, constraintsSoilPanel);

		constraintsSoilPanel.gridx = 0;
		constraintsSoilPanel.gridy = 4;
		add(soilRateLabel, constraintsSoilPanel);

		//// SECOND COLUMN////
		constraintsSoilPanel.anchor = GridBagConstraints.LINE_START;

		constraintsSoilPanel.gridx = 1;
		constraintsSoilPanel.gridy = 0;
		add(currentResultLabel, constraintsSoilPanel);

		constraintsSoilPanel.gridx = 1;
		constraintsSoilPanel.gridy = 1;
		add(desiredPanel, constraintsSoilPanel);

		constraintsSoilPanel.gridx = 1;
		constraintsSoilPanel.gridy = 2;
		add(sprinklerResultLabel, constraintsSoilPanel);

		constraintsSoilPanel.gridx = 1;
		constraintsSoilPanel.gridy = 3;
		add(sampleRatePanel, constraintsSoilPanel);

		constraintsSoilPanel.gridx = 1;
		constraintsSoilPanel.gridy = 4;
		add(soilRatePanel, constraintsSoilPanel);

		constraintsSoilPanel.anchor = GridBagConstraints.FIRST_LINE_START;
		constraintsSoilPanel.weighty = 10;
		constraintsSoilPanel.gridx = 1;
		constraintsSoilPanel.gridy = 5;
		add(emptySpace, constraintsSoilPanel);
	}

	// Getter and Setter methods for the class
	/**
	 * 
	 * @return The current soil moisture level as a String
	 */
	public String getCurrentResultLabel() {
		return currentResultLabel.getText();
	}

	/**
	 * Sets the text for the current soil moisture value
	 * 
	 * @param currentResultLabel
	 *            The value to set the current soil moisture to
	 */
	public void setCurrentResultLabel(String currentResultLabel) {
		this.currentResultLabel.setText(currentResultLabel);
	}

	/**
	 * 
	 * @return The desired soil moisture level as a String
	 */
	public String getDesiredTextField() {
		return desiredTextField.getText();
	}

	/**
	 * Sets the text for the desired soil moisture level
	 * 
	 * @param desiredTextField
	 *            The value to set the desired soil moisture level to
	 */
	public void setDesiredTextField(String desiredTextField) {
		this.desiredTextField.setText(desiredTextField);
	}

	/**
	 * 
	 * @return The upper range of the desired soil moisture, as a String
	 */
	public String getUpRangeField() {
		return upRangeField.getText();
	}

	/**
	 * Sets the text value for the upper range of the desired soil moisture
	 * 
	 * @param upRangeField
	 */
	public void setUpRangeField(String upRangeField) {
		this.upRangeField.setText(upRangeField);
	}

	/**
	 * 
	 * @return The lower range of the desired soil moisture as a String.
	 */
	public String getLowRangeField() {
		return lowRangeField.getText();
	}

	/**
	 * Sets the text for the lower range of the desired soil moisture
	 * 
	 * @param lowRangeField
	 *            The value to set the lower range to
	 */
	public void setLowRangeField(String lowRangeField) {
		this.lowRangeField.setText(lowRangeField);
	}

	/**
	 * 
	 * @return The current state of the Sprinkler, as a String
	 */
	public String getSprinklerResultLabel() {
		return sprinklerResultLabel.getText();
	}

	/**
	 * Sets the text for the current state of the sprinkler
	 * 
	 * @param sprinklerResultLabel
	 *            The value to set the current sprinkler state to
	 */
	public void setSprinklerResultLabel(String sprinklerResultLabel) {
		this.sprinklerResultLabel.setText(sprinklerResultLabel);
	}

	/**
	 * 
	 * @return The refresh rate as a String
	 */
	public String getSampleRateTextField() {
		return sampleRateTextField.getText();
	}

	/**
	 * Sets the text for the refresh rate field
	 * 
	 * @param sampleRateTextField
	 *            The value to the refresh rate to
	 */
	public void setSampleRateTextField(String sampleRateTextField) {
		this.sampleRateTextField.setText(sampleRateTextField);
	}

	/**
	 * 
	 * @return The sprinkler rate as a String
	 */
	public String getSoilRateTextField() {
		return soilRateTextField.getText();
	}

	/**
	 * Sets the text for the sprinkler rate field
	 * 
	 * @param soilRateTextField
	 *            The value to set the sprinklers rate to
	 */
	public void setSoilRateTextField(String soilRateTextField) {
		this.soilRateTextField.setText(soilRateTextField);
	}
}
