import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import java.awt.Color;
import javax.swing.JLabel;

public class gui2 extends JPanel {
	private JButton testButton;
	private JTextArea testTextArea;
	private SpringLayout currentLayout;
	private JComboBox testComboBox;
	private JComboBox testComboBox2;
	private JLabel testLabel;
	private JLabel testLabel2;
	
	public gui2() {
		setBackground(Color.WHITE);
		
		testButton = new JButton("Compare!");
		testTextArea = new JTextArea();
		currentLayout = new SpringLayout();
		
		testComboBox = new JComboBox();

		testComboBox2 = new JComboBox();
		testLabel = new JLabel("VS");
		testLabel2 = new JLabel("NBA Player Comparison Tool");


		
		setupPanel();
	}
	
	private void setupPanel(){
		this.setLayout(currentLayout);
		this.add(testButton);
		this.add(testTextArea);
		this.add(testComboBox);
		this.add(testComboBox2);
		this.add(testLabel);
		this.add(testLabel2);
		currentLayout.putConstraint(SpringLayout.NORTH, testComboBox, 118, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, testComboBox, 10, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, testButton, -96, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, testButton, -168, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, testComboBox2, 118, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, testComboBox2, 287, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.EAST, testComboBox2, -6, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.EAST, testComboBox, -116, SpringLayout.WEST, testComboBox2);
		currentLayout.putConstraint(SpringLayout.NORTH, testLabel2, 10, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, testLabel2, 44, SpringLayout.NORTH, testTextArea);
		currentLayout.putConstraint(SpringLayout.EAST, testLabel2, -126, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, testLabel, 4, SpringLayout.NORTH, testComboBox);
		currentLayout.putConstraint(SpringLayout.WEST, testLabel, 49, SpringLayout.EAST, testComboBox);
		
	}
}
