package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Personal_info {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void pmain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personal_info window = new Personal_info();
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
	public Personal_info() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Connection conn=null;
	private JLabel lblSearchId;
	private JTextField textField_9;
	private JLabel lblNewLabel;
	private JTextField textField_10;
	private void initialize() {
		conn=sqliteConnection.dbConnector();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Personal Information");
		frame.getContentPane().setBackground(new Color(0, 102, 102));
		frame.getContentPane().setLayout(null);
		Connection conn = sqliteConnection.dbConnector();
		
		JLabel label = new JLabel("Hall ID");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(51, 66, 125, 29);
		frame.getContentPane().add(label);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(51, 96, 125, 29);
		frame.getContentPane().add(lblName);
		
		JLabel label_1 = new JLabel("Dept");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(51, 124, 125, 29);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Room No.");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(51, 155, 125, 29);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Fathers Name");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(51, 185, 113, 29);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Mothers Name");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(51, 215, 113, 29);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Contact Number");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(51, 246, 125, 29);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Blood Group");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(51, 277, 113, 29);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Address");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_7.setBounds(51, 317, 113, 29);
		frame.getContentPane().add(label_7);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Select s=new Select();
				s.selectmain(null);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(new Color(230, 230, 250));
		button.setBounds(10, 32, 89, 23);
		frame.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(186, 72, 169, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(186, 102, 169, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(186, 130, 169, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(186, 161, 169, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(186, 191, 169, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(186, 221, 169, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(186, 252, 169, 20);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(186, 283, 169, 20);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(186, 323, 325, 20);
		frame.getContentPane().add(textField_8);
		
		lblSearchId = new JLabel("Search ID");
		lblSearchId.setForeground(Color.WHITE);
		lblSearchId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearchId.setBounds(152, 26, 83, 29);
		frame.getContentPane().add(lblSearchId);
		
		JLabel label_img  = new JLabel("");
		label_img.setBounds(573, 66, 224, 154);
		frame.getContentPane().add(label_img);
		
		
		textField_9 = new JTextField();
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				
				try {
					
					String query="select * from StudentInfo where ID=?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, textField_9.getText());
				
					 
					
					
					
					ResultSet rs=pst.executeQuery();
					
					String add1=rs.getString("ID");
					textField.setText(add1);
					
					String add2=rs.getString("Name");
					textField_1.setText(add2);
					
					String add3=rs.getString("Dept");
					textField_2.setText(add3);
					
					String add4=rs.getString("Room_no");
					textField_3.setText(add4);
					
					String add5=rs.getString("Fathers_Name");
					textField_4.setText(add5);
					
					String add6=rs.getString("Mothers_Name");
					textField_5.setText(add6);
					
					String add7=rs.getString("Contact_Number");
					textField_6.setText(add7);
					
					String add8=rs.getString("Blood_Group");
					textField_7.setText(add8);
					
					String add9=rs.getString("Address");
					textField_8.setText(add9);
					
					String add10=rs.getString("Gender");
					textField_10.setText(add10);
					
					
					byte[] img=rs.getBytes("Image");
					ImageIcon imageIcon=new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(label_img.getWidth(),label_img.getHeight(), Image.SCALE_SMOOTH));		
					
					label_img.setIcon(imageIcon);
					
					pst.close();
				} catch (Exception e1) {
					
					
					// TODO: handle exception
				}
				
				
				
			}
		});
		textField_9.setBounds(245, 33, 110, 20);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(51, 348, 113, 29);
		frame.getContentPane().add(lblGender);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(186, 354, 169, 20);
		frame.getContentPane().add(textField_10);
		
		frame.setBounds(100, 100, 874, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
