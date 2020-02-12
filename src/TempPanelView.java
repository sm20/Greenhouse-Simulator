import java.awt.*;
import javax.swing.*;

/**
 * 
 * Class that creates the GUI for the Temperature panel. Also containers the
 * getters and setters for all the instance varaibles of this class
 *
 */
public class TempPanelView extends JPanel {

	private JTextField desiredTextField;
	private JTextField sampleRateTextField;
	private JTextField furnaceRateTextField;
	private JTextField acRateTextField;

	private JTextField currentTempField;
	private JLabel furnaceResultLabel;
	private JLabel acResultLabel;

	/**
	 * Constructor that creates the GUI for dealing with the Temperature Panel
	 */
	public TempPanelView() {
		// Creates all the rows
		setPreferredSize(new Dimension(250, 250));
		setBorder(BorderFactory.createTitledBorder("Temperature"));

		JPanel desiredPanel = new JPanel(new FlowLayout());
		desiredTextField = new JTextField(5);
		JLabel desiredLabelEnd = new JLabel("+/- 3 degrees");
		desiredPanel.add(desiredTextField);
		desiredPanel.add(desiredLabelEnd);

		JPanel sampleRatePanel = new JPanel(new FlowLayout());
		sampleRateTextField = new JTextField(5);
		JLabel timeUnitsLabel = new JLabel("seconds");
		sampleRatePanel.add(sampleRateTextField);
		sampleRatePanel.add(timeUnitsLabel);

		JPanel furnaceRatePanel = new JPanel(new FlowLayout());
		furnaceRateTextField = new JTextField(5);
		JLabel timeUnitsLabel1 = new JLabel("degrees per second");
		furnaceRatePanel.add(furnaceRateTextField);
		furnaceRatePanel.add(timeUnitsLabel1);

		JPanel acRatePanel = new JPanel(new FlowLayout());
		acRateTextField = new JTextField(5);
		JLabel timeUnitsLabel2 = new JLabel("degrees per second");
		acRatePanel.add(acRateTextField);
		acRatePanel.add(timeUnitsLabel2);

		JLabel currentLabel = new JLabel("Current (degrees): ");
		JLabel desiredLabel = new JLabel("Desired: ");
		JLabel furnaceLabel = new JLabel("Furnace: ");
		JLabel acLabel = new JLabel("AC: ");
		JLabel sampleRateLabel = new JLabel("Refresh Rate: ");
		JLabel furnaceRateLabel = new JLabel("Heating Rate: ");
		JLabel acRateLabel = new JLabel("Cooling Rate: ");

		currentTempField = new JTextField(5);
		furnaceResultLabel = new JLabel("OFF");
		acResultLabel = new JLabel("OFF");

		JLabel emptySpace = new JLabel("");

		// Using GridBag Layout to assign panels and labels
		setLayout(new GridBagLayout());
		GridBagConstraints constraintsTempPanel = new GridBagConstraints();

		/// FIRST COLUMN///
		constraintsTempPanel.anchor = GridBagConstraints.LINE_END;
		constraintsTempPanel.weightx = 0.5;
		constraintsTempPanel.weighty = 0.5;

		constraintsTempPanel.gridx = 0;
		constraintsTempPanel.gridy = 0;
		add(currentLabel, constraintsTempPanel);

		constraintsTempPanel.gridx = 0;
		constraintsTempPanel.gridy = 1;
		add(desiredLabel, constraintsTempPanel);

		constraintsTempPanel.gridx = 0;
		constraintsTempPanel.gridy = 2;
		add(furnaceLabel, constraintsTempPanel);

		constraintsTempPanel.gridx = 0;
		constraintsTempPanel.gridy = 3;
		add(acLabel, constraintsTempPanel);

		constraintsTempPanel.gridx = 0;
		constraintsTempPanel.gridy = 4;
		add(sampleRateLabel, constraintsTempPanel);

		constraintsTempPanel.gridx = 0;
		constraintsTempPanel.gridy = 5;
		add(furnaceRateLabel, constraintsTempPanel);

		constraintsTempPanel.gridx = 0;
		constraintsTempPanel.gridy = 6;
		add(acRateLabel, constraintsTempPanel);

		//// SECOND COLUMN////
		constraintsTempPanel.anchor = GridBagConstraints.LINE_START;

		constraintsTempPanel.gridx = 1;
		constraintsTempPanel.gridy = 0;
		add(currentTempField, constraintsTempPanel);

		constraintsTempPanel.gridx = 1;
		constraintsTempPanel.gridy = 1;
		add(desiredPanel, constraintsTempPanel);

		constraintsTempPanel.gridx = 1;
		constraintsTempPanel.gridy = 2;
		add(furnaceResultLabel, constraintsTempPanel);

		constraintsTempPanel.gridx = 1;
		constraintsTempPanel.gridy = 3;
		add(acResultLabel, constraintsTempPanel);

		constraintsTempPanel.gridx = 1;
		constraintsTempPanel.gridy = 4;
		add(sampleRatePanel, constraintsTempPanel);

		constraintsTempPanel.gridx = 1;
		constraintsTempPanel.gridy = 5;
		add(furnaceRatePanel, constraintsTempPanel);

		constraintsTempPanel.gridx = 1;
		constraintsTempPanel.gridy = 6;
		add(acRatePanel, constraintsTempPanel);

		constraintsTempPanel.anchor = GridBagConstraints.FIRST_LINE_START;
		constraintsTempPanel.weighty = 10;
		constraintsTempPanel.gridx = 1;
		constraintsTempPanel.gridy = 7;
		add(emptySpace, constraintsTempPanel);

	}

	// Getter and Setter methods for the class
	/**
	 * 
	 * @return The desired temperature as a String
	 */
	public String getDesiredTextField() {
		return desiredTextField.getText();
	}

	/**
	 * 
	 * @return The refresh rate as a String
	 */
	public String getSampleRateTextField() {
		return sampleRateTextField.getText();
	}

	/**
	 * 
	 * @return The rate at which the furnace operates as a String
	 */
	public String getFurnaceRateTextField() {
		return furnaceRateTextField.getText();
	}

	/**
	 * 
	 * @return The rate at which the Air Conditioner operates as a String
	 */
	public String getacRateTextField() {
		return acRateTextField.getText();
	}

	/**
	 * 
	 * @return The current Temperature as a String
	 */
	public String getCurrentResultField() {
		return currentTempField.getText();
	}

	/**
	 * Sets the text for the state of the furnace
	 * 
	 * @param label
	 *            The value to set the furnaces current state to
	 */
	public void setFurnaceResultLabel(String label) {
		this.furnaceResultLabel.setText(label);
	}

	/**
	 * Sets the text for the Air conditioners current state
	 * 
	 * @param label
	 *            The value to set the current state of the air conditioner to
	 */
	public void setACResultLabel(String label) {
		this.acResultLabel.setText(label);
	}

	/**
	 * 
	 * @return The current state of the Furnace as a String
	 */
	public String getFurnaceResultLabel() {
		return furnaceResultLabel.getText();
	}

	/**
	 * 
	 * @return The current state of the Air conditioner as a String
	 */
	public String getacResultLabel() {
		return acResultLabel.getText();
	}

	/**
	 * Sets the text for the current temperature field
	 * 
	 * @param currentTempField
	 *            The value to set the current temperature to
	 */
	public void setCurrentResultField(String currentTempField) {
		this.currentTempField.setText(currentTempField);
	}

}
