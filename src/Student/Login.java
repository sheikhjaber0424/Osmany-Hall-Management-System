package Student;
import java.awt.image.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;



public class Login {
	
     
	private JFrame frame;
	private Connection conn ;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	void setLook()
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Login() {
		setLook();
		initialize();
		conn = sqliteConnection.dbConnector();
				
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(new Color(0, 0, 0));
		frame.setTitle("WELCOME");
		frame.getContentPane().setBackground(new Color(112, 128, 144));
		frame.setBackground(new Color(102, 205, 170));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 643, 78);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblOsmanyhall = new JLabel("OSMANY HALL");
		lblOsmanyhall.setFont(new Font("Tahoma", Font.ITALIC, 32));
		lblOsmanyhall.setForeground(new Color(0, 0, 128));
		lblOsmanyhall.setToolTipText("");
		lblOsmanyhall.setBackground(new Color(230, 230, 250));
		lblOsmanyhall.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblOsmanyhall);
		
		JLabel lblManagementSystem = new JLabel("MANAGEMENT SYSTEM");
		lblManagementSystem.setBackground(new Color(230, 230, 250));
		lblManagementSystem.setForeground(new Color(0, 0, 128));
		lblManagementSystem.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblManagementSystem);
		
		JLabel lblEnterUsernameAnd = new JLabel("Enter Username and Password");
		lblEnterUsernameAnd.setBackground(new Color(255, 255, 255));
		lblEnterUsernameAnd.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEnterUsernameAnd.setForeground(new Color(255, 255, 255));
		lblEnterUsernameAnd.setBounds(47, 269, 266, 26);
		frame.getContentPane().add(lblEnterUsernameAnd);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBounds(47, 306, 76, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(47, 334, 70, 14);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(127, 306, 121, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmit.setForeground(Color.DARK_GRAY);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String n1=textField.getText();
				String n2=passwordField.getText();
				
				if(n1.equals("admin")&& n2.equals("123"))
				{
					frame.dispose();
					Select s=new Select();
					s.selectmain(null);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Wrong username or password");
					
				}
			}
		});
		btnSubmit.setBounds(126, 373, 122, 27);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBackground(new Color(230, 230, 250));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClose.setForeground(Color.DARK_GRAY);
		btnClose.setBounds(532, 427, 89, 23);
		frame.getContentPane().add(btnClose);
		
		JLabel label = new JLabel("");
		label.setForeground(new Color(0, 128, 128));
		Image img=new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		label.setIcon(new ImageIcon(img));
		
		label.setBounds(323, 76, 320, 340);
		frame.getContentPane().add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(127, 333, 121, 20);
		frame.getContentPane().add(passwordField);
		
		
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				
			}
		});
		frame.setBounds(100, 100, 659, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


