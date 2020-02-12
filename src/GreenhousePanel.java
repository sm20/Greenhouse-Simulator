import java.awt.*; //stuff like swing but also setPreferredSize, JPanel etc.
import java.awt.event.*; //To be able to add ActionListener, WindowListener interfaces/adapters etc.
import javax.swing.*; //stuff like JTextField, JButton, etc

/**
 * 
 * Class to create the GUI panel of the greenhouse as well as creating getter
 * and setter methods for instance variables, and attaching listeners to all of
 * the buttons of the GUI
 *
 */
public class GreenhousePanel extends JPanel {

	private JTextField extTempEffectField;
	private JTextField extTempField;
	private JTextField extSoilEffectField;
	private JTextField extSoilField;
	private JTextField extHumidityEffectField;
	private JTextField extHumidityField;

	private JButton startButton;
	private JButton stopButton;
	private JButton saveButton;
	private JButton loadButton;

	private double extTemp;

	/**
	 * Constructor that creates the GUI panel for the Greenhouse
	 */
	public GreenhousePanel() {

		// creates JPanels for each row
		setPreferredSize(new Dimension(250, 250));
		setBorder(BorderFactory.createTitledBorder("The Greenhouse"));

		JPanel extTempEffectPanel = new JPanel(new FlowLayout());
		extTempEffectField = new JTextField(5);
		extTempEffectPanel.add(extTempEffectField);

		JPanel extTempPanel = new JPanel(new FlowLayout());
		extTempField = new JTextField(5);
		extTempPanel.add(extTempField);

		JPanel extSoilEffectPanel = new JPanel(new FlowLayout());
		extSoilEffectField = new JTextField(5);
		extSoilEffectPanel.add(extSoilEffectField);

		JPanel extSoilPanel = new JPanel(new FlowLayout());
		extSoilField = new JTextField(5);
		extSoilPanel.add(extSoilField);

		JPanel extHumidityEffectPanel = new JPanel(new FlowLayout());
		extHumidityEffectField = new JTextField(5);
		extHumidityEffectPanel.add(extHumidityEffectField);

		JPanel extHumidityPanel = new JPanel(new FlowLayout());
		extHumidityField = new JTextField(5);
		extHumidityPanel.add(extHumidityField);

		JLabel extTempEffect = new JLabel("Ext. Temperature Effect (degrees/minute): ");
		JLabel extTempLabel = new JLabel("External Temperature (degrees): ");
		JLabel initSoilLabel = new JLabel("Ext. Soil Moisture Effect (%/minute): ");
		JLabel extSoilLabel = new JLabel("External Soil Moisture (%): ");
		JLabel initHumidityLabel = new JLabel("Ext. Humidity Effect (%/minute): ");
		JLabel extHumidityLabel = new JLabel("External Humidity (%): ");
		startButton = new JButton("START");
		stopButton = new JButton("STOP");
		startButton.setPreferredSize(new Dimension(75, 25));
		stopButton.setPreferredSize(new Dimension(75, 25));

		saveButton = new JButton("SAVE");
		loadButton = new JButton("LOAD");
		saveButton.setPreferredSize(new Dimension(75, 25));
		loadButton.setPreferredSize(new Dimension(75, 25));

		// Empty Space to make sure all components are close together instead of
		// spread out
		JLabel emptySpace = new JLabel("");

		// using gridbag layout to set each panel
		setLayout(new GridBagLayout());
		GridBagConstraints constraintsGreenhousePanel = new GridBagConstraints();

		// FIRST COLUMN //
		constraintsGreenhousePanel.anchor = GridBagConstraints.LINE_END;
		constraintsGreenhousePanel.weightx = 0.5;
		constraintsGreenhousePanel.weighty = 0.5;

		constraintsGreenhousePanel.gridx = 0;
		constraintsGreenhousePanel.gridy = 0;
		add(extTempEffect, constraintsGreenhousePanel);

		constraintsGreenhousePanel.gridx = 0;
		constraintsGreenhousePanel.gridy = 1;
		add(extTempLabel, constraintsGreenhousePanel);

		constraintsGreenhousePanel.gridx = 0;
		constraintsGreenhousePanel.gridy = 3;
		add(initSoilLabel, constraintsGreenhousePanel);

		constraintsGreenhousePanel.gridx = 0;
		constraintsGreenhousePanel.gridy = 4;
		add(extSoilLabel, constraintsGreenhousePanel);

		constraintsGreenhousePanel.gridx = 0;
		constraintsGreenhousePanel.gridy = 6;
		add(initHumidityLabel, constraintsGreenhousePanel);

		constraintsGreenhousePanel.gridx = 0;
		constraintsGreenhousePanel.gridy = 7;
		add(extHumidityLabel, constraintsGreenhousePanel);

		constraintsGreenhousePanel.gridx = 0;
		constraintsGreenhousePanel.gridy = 9;
		add(startButton, constraintsGreenhousePanel);

		constraintsGreenhousePanel.gridx = 0;
		constraintsGreenhousePanel.gridy = 10;
		add(stopButton, constraintsGreenhousePanel);

		//// SECOND COLUMN////
		constraintsGreenhousePanel.anchor = GridBagConstraints.LINE_START;

		constraintsGreenhousePanel.gridx = 1;
		constraintsGreenhousePanel.gridy = 0;
		add(extTempEffectPanel, constraintsGreenhousePanel);

		constraintsGreenhousePanel.gridx = 1;
		constraintsGreenhousePanel.gridy = 1;
		add(extTempPanel, constraintsGreenhousePanel);

		constraintsGreenhousePanel.gridx = 1;
		constraintsGreenhousePanel.gridy = 3;
		add(extSoilEffectPanel, constraintsGreenhousePanel);

		constraintsGreenhousePanel.gridx = 1;
		constraintsGreenhousePanel.gridy = 4;
		add(extSoilPanel, constraintsGreenhousePanel);

		constraintsGreenhousePanel.gridx = 1;
		constraintsGreenhousePanel.gridy = 6;
		add(extHumidityEffectPanel, constraintsGreenhousePanel);

		constraintsGreenhousePanel.gridx = 1;
		constraintsGreenhousePanel.gridy = 7;
		add(extHumidityPanel, constraintsGreenhousePanel);

		constraintsGreenhousePanel.gridx = 1;
		constraintsGreenhousePanel.gridy = 9;
		constraintsGreenhousePanel.insets = new Insets(10, 10, 10, 0);
		add(saveButton, constraintsGreenhousePanel);

		constraintsGreenhousePanel.gridx = 1;
		constraintsGreenhousePanel.gridy = 10;
		add(loadButton, constraintsGreenhousePanel);

		/// LAST ROW////
		constraintsGreenhousePanel.anchor = GridBagConstraints.FIRST_LINE_START;
		constraintsGreenhousePanel.weighty = 10;
		constraintsGreenhousePanel.gridx = 1;
		constraintsGreenhousePanel.gridy = 11;
		add(emptySpace, constraintsGreenhousePanel);

	}

	// Setter and Getter methods for instance variables
	/**
	 * 
	 * @return The external temperature effect rate as a String
	 */
	public String getExtTempEffectField() {
		if (!extTempEffectField.getText().equals(""))
			return extTempEffectField.getText();
		else {
			extTempEffectField.setText("0");
			return extTempEffectField.getText();
		}
	}

	/**
	 * 
	 * @return The external temperature level as a String
	 */
	public String getExtTempField() {
		return extTempField.getText();
	}

	/**
	 * 
	 * @return The external soil moisture effect rate as a String
	 */
	public String getExtSoilEffectField() {
		return extSoilEffectField.getText();
	}

	/**
	 * 
	 * @return The external soil moisture level as a String
	 */
	public String getExtSoilField() {
		return extSoilField.getText();
	}

	/**
	 * 
	 * @return The external humidity effect rate as a String
	 */
	public String getExtHumidityEffectField() {
		return extHumidityEffectField.getText();
	}

	/**
	 * 
	 * @return The external humidity level as a String
	 */
	public String getExtHumidityField() {
		return extHumidityField.getText();
	}

	/**
	 * Attaches listeners to all the buttons
	 * 
	 * @param listen
	 *            An ActionListener object
	 */
	//To use ActionListener and .addActionListener, you need to import java.awt.event.*; first
	public void addButtonListeners(ActionListener listen) {
		startButton.addActionListener(listen);
		stopButton.addActionListener(listen);
		saveButton.addActionListener(listen);
		loadButton.addActionListener(listen);
	}

}
