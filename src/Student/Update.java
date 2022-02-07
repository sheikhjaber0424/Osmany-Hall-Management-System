package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Update {
	Connection conn=null;
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
	public static void updatemain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update window = new Update();
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
	public Update() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Update Information");
		frame.getContentPane().setBackground(new Color(47, 79, 79));
		frame.setBounds(100, 100, 870, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		conn=sqliteConnection.dbConnector();
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 854, 47);
		frame.getContentPane().add(panel);
		
		JLabel lblUpdateStudentInformation = new JLabel("UPDATE STUDENT INFORMATION");
		lblUpdateStudentInformation.setBackground(new Color(192, 192, 192));
		lblUpdateStudentInformation.setForeground(new Color(0, 0, 0));
		lblUpdateStudentInformation.setFont(new Font("Tahoma", Font.BOLD, 29));
		panel.add(lblUpdateStudentInformation);
		
		JLabel label = new JLabel("Hall ID");
		label.setForeground(new Color(255, 255, 255));
		label.setBackground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(71, 99, 125, 29);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(71, 135, 125, 29);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Dept");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(71, 169, 125, 29);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Room No.");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setBackground(new Color(240, 240, 240));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(71, 203, 125, 29);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Fathers Name");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(71, 237, 113, 29);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Mothers Name");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.setBackground(new Color(240, 240, 240));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(71, 274, 113, 29);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Contact Number");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(71, 314, 120, 29);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Blood Group");
		label_7.setForeground(new Color(255, 255, 255));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_7.setBounds(71, 350, 113, 29);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Address");
		label_8.setForeground(new Color(255, 255, 255));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_8.setBounds(71, 393, 113, 29);
		frame.getContentPane().add(label_8);
		
		textField = new JTextField();
		textField.setBackground(new Color(230, 230, 250));
		textField.setColumns(10);
		textField.setBounds(192, 105, 169, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(230, 230, 250));
		textField_1.setColumns(10);
		textField_1.setBounds(192, 141, 169, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(230, 230, 250));
		textField_2.setColumns(10);
		textField_2.setBounds(192, 175, 169, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(230, 230, 250));
		textField_3.setColumns(10);
		textField_3.setBounds(192, 209, 169, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(230, 230, 250));
		textField_4.setColumns(10);
		textField_4.setBounds(192, 243, 169, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(230, 230, 250));
		textField_5.setColumns(10);
		textField_5.setBounds(192, 280, 169, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(230, 230, 250));
		textField_6.setColumns(10);
		textField_6.setBounds(194, 320, 169, 20);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(230, 230, 250));
		textField_7.setColumns(10);
		textField_7.setBounds(194, 356, 169, 20);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setBackground(new Color(230, 230, 250));
		textField_8.setColumns(10);
		textField_8.setBounds(194, 399, 340, 20);
		frame.getContentPane().add(textField_8);
		
		JButton btnSaveUpdate = new JButton("SAVE");
		btnSaveUpdate.setBackground(new Color(176, 196, 222));
		btnSaveUpdate.setForeground(new Color(0, 0, 0));
		btnSaveUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="Update StudentInfo set ID='"+textField.getText()+"',Name='"+textField_1.getText()+"',Dept='"+textField_2.getText()+"',Room_No='"+textField_3.getText()+"',Fathers_Name='"+textField_4.getText()+"',Mothers_Name='"+textField_5.getText()+"',Contact_Number='"+textField_6.getText()+"',Blood_Group='"+textField_7.getText()+"',Address='"+textField_8.getText()+"'where ID='"+textField.getText()+"'";
					PreparedStatement pst=conn.prepareStatement(query);
					
					
					
					
					
					pst.execute(); 
					
					JOptionPane.showMessageDialog(null,"DataUpdated");
					pst.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				
				
			
		});
		btnSaveUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSaveUpdate.setBounds(502, 58, 150, 44);
		frame.getContentPane().add(btnSaveUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setBackground(new Color(176, 196, 222));
		btnBack.setFont(new Font("Cambria", Font.BOLD, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InformationTable in=new InformationTable();
				in.nmain(null);
			}
		});
		btnBack.setBounds(71, 58, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="delete from StudentInfo where ID='"+textField.getText()+"'  ";
					PreparedStatement pst=conn.prepareStatement(query);
					
					pst.execute(); 
					
					JOptionPane.showMessageDialog(null,"Data Deleted");
					pst.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
				
			
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDelete.setBackground(new Color(176, 196, 222));
		btnDelete.setBounds(673, 58, 150, 44);
		frame.getContentPane().add(btnDelete);
	}
}
