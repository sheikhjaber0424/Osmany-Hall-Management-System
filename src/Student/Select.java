package Student;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Select {
    
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void selectmain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select window = new Select();
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
	public Select() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("FEATURES");
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(253, 245, 230));
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 814, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFeatures = new JLabel("Features");
		lblFeatures.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 42));
		lblFeatures.setBounds(541, 11, 247, 95);
		frame.getContentPane().add(lblFeatures);
		
		JButton btnStudentsList = new JButton("STUDENTS LIST");
		btnStudentsList.setBackground(new Color(255, 255, 204));
		btnStudentsList.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnStudentsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InformationTable in=new InformationTable();
				in.nmain(null);
			}
		});
		btnStudentsList.setBounds(519, 117, 269, 50);
		frame.getContentPane().add(btnStudentsList);
		
		JLabel label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/features.png")).getImage();
		label.setIcon(new ImageIcon(img));
		
		label.setBounds(0, 0, 393, 446);
		frame.getContentPane().add(label);
		
		JButton btnPersonalInformation = new JButton("PERSONAL INFORMATION");
		btnPersonalInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Personal_info p=new Personal_info();
				p.pmain(null);
			}
		});
		
		btnPersonalInformation.setBackground(new Color(255, 255, 204));
		btnPersonalInformation.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnPersonalInformation.setBounds(519, 178, 269, 50);
		frame.getContentPane().add(btnPersonalInformation);
		
		JButton btnInoutRegester = new JButton("IN-OUT REGISTER");
		btnInoutRegester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				RegisterOption ro=new RegisterOption();
				ro.ROmain(null);
				
			}
		});
		btnInoutRegester.setBackground(new Color(255, 255, 204));
		btnInoutRegester.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnInoutRegester.setBounds(519, 239, 269, 50);
		frame.getContentPane().add(btnInoutRegester);
	}
}
