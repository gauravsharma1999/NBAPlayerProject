import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AppWindow implements ActionListener {
	protected Shell screen1;
	protected Shell screen2;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AppWindow window = new AppWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * 
	 * @throws IOException
	 */
	public void open() throws IOException {
		Display display = Display.getDefault();
		createContents();
		screen1.open();
		screen1.layout();
		while (!screen1.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * 
	 * @throws IOException
	 */
	protected void createContents() throws IOException {
		screen1 = new Shell();
		screen1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		screen1.setSize(1000, 1000);
		screen1.setText("SWT Application");

		Combo combo = new Combo(screen1, SWT.READ_ONLY);
		combo.setBounds(794, 77, 170, 38);
		Comparison.setStats();
		combo.setItems(Comparison.names);

		Combo combo_1 = new Combo(screen1, SWT.READ_ONLY);
		combo_1.setBounds(43, 85, 170, 22);
		combo_1.setItems(Comparison.names);
		// combo_1.setEnabled(false);

		Label lblNbaPlayerComparison = new Label(screen1, SWT.NONE);
		lblNbaPlayerComparison.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 26, SWT.NORMAL));
		lblNbaPlayerComparison.setBounds(325, 10, 340, 39);
		lblNbaPlayerComparison.setText("NBA Player Comparison Tool");

		Button btnCompare = new Button(screen1, SWT.NONE);
		btnCompare.setBounds(413, 163, 158, 46);
		btnCompare.setText("Compare!");
		MouseListener listener;
		btnCompare.addMouseListener(listener);
		
		
		Label lblVs = new Label(screen1, SWT.NONE);
		lblVs.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 21, SWT.NORMAL));
		lblVs.setBounds(474, 78, 40, 27);
		lblVs.setText("VS.");
	}
	// btnCompare.addMouseListener(new MouseListener

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void mouseReleased(MouseEvent e) {
		screen1.close();
		screen2.open();
	}

}
