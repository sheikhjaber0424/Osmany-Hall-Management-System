package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class in_out_Register {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					in_out_Register window = new in_out_Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public in_out_Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setTitle("IN/OUT Register");
		frame = new JFrame();
		frame.setBounds(100, 100, 857, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
