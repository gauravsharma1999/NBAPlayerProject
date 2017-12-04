import javax.swing.JFrame;

public class gui extends JFrame {
	private gui2 currentPanel;
	
	public gui() {
		currentPanel = new gui2();
		
		setupFrame();
	}
	
	private void setupFrame() {
		this.setContentPane(currentPanel);
	}
}
