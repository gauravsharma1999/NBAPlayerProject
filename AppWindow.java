import java.awt.Color;
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
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;

public class AppWindow {
	protected Shell shell;

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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
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
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(450, 300);
		shell.setText("SWT Application");

		Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setBounds(259, 114, 158, 38);
		Comparison.setStats();
		combo.setItems(Comparison.names);

		Combo combo_1 = new Combo(shell, SWT.READ_ONLY);
		combo_1.setBounds(10, 122, 158, 22);
		combo_1.setItems(Comparison.names);
		// combo_1.setEnabled(false);

		Label lblNbaPlayerComparison = new Label(shell, SWT.NONE);
		lblNbaPlayerComparison.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 17, SWT.NORMAL));
		lblNbaPlayerComparison.setBounds(97, 58, 238, 39);
		lblNbaPlayerComparison.setText("NBA Player Comparison Tool");

		Button btnCompare = new Button(shell, SWT.NONE);
		btnCompare.setBounds(170, 201, 94, 28);
		btnCompare.setText("Compare!");

		Label lblVs = new Label(shell, SWT.NONE);
		lblVs.setBounds(203, 126, 22, 14);
		lblVs.setText("VS.");

	}

}
