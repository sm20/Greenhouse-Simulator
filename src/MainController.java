import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * The class that contains the main controller to set the JFrame, give it a
 * title and close functionality, and set it to true so it is displayed
 * 
 * @Author Sajid Choudhry
 *
 */
public class MainController {

	/**
	 * Launch the application and create the GUI and set its size, title, and
	 * close action
	 */
	public static void main(String[] args) throws InterruptedException {

		//This works because MainFrameView extends JFrame, that is, it is a subclass of JFrame.
		//So the code here is an upcast, which assigns a subtype to a supertype
		JFrame frame = new MainFrameView("Greenhouse Simulation"); 
		frame.setSize(1750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
