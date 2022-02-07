package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Register {
    
	private JFrame frame;
	private JTextField textField_ID;
	private String IN_OUT;
	private String Arrive;
	

	/**
	 * Launch the application.
	 */
	public static void REntermain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Connection conn=null;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private void initialize() {
		conn=sqliteConnection.dbConnector();
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(51, 102, 153));
		frame.getContentPane().setLayout(null);
		Connection conn = sqliteConnection.dbConnector();
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setForeground(new Color(255, 250, 205));
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudentId.setBounds(497, 70, 125, 29);
		frame.getContentPane().add(lblStudentId);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(255, 250, 205));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDate.setBounds(497, 98, 88, 44);
		frame.getContentPane().add(lblDate);
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(595, 110, 170, 20);
		frame.getContentPane().add(dateChooser);
		
		JButton btnSave = new JButton("SAVE ");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="insert into Register(ID,LastEnterTime,LastEnterDate)values(?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query);
				
					
					
					SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
					
					String date1=sdf1.format(dateChooser.getDate());
					
					
					
					
					Date date2=new Date();
					SimpleDateFormat sdf2=new SimpleDateFormat("hh.mm aa");
					String EnterTime=sdf2.format(date2);
					
					
					
					
					
					
					pst.setString(1,textField_ID.getText() );
			
					pst.setString(2, EnterTime);
					pst.setString(3, date1);
					
					
					
					
					
					 
																				
					pst.execute(); 
					
					JOptionPane.showMessageDialog(null,"DataSaved");
					pst.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
				
				
			}
		});
		btnSave.setForeground(Color.BLACK);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSave.setBackground(new Color(230, 230, 250));
		btnSave.setBounds(497, 214, 160, 44);
		frame.getContentPane().add(btnSave);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(596, 76, 169, 20);
		frame.getContentPane().add(textField_ID);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				RegisterOption ro=new RegisterOption();
				ro.ROmain(null);
			}
		});
		btnBack.setBounds(10, 26, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-dd");
					
					sdf3.format(dateChooser.getDate());
					
					
					
					
					Date date2=new Date();
					SimpleDateFormat sdf4=new SimpleDateFormat("hh.mm aa");
					
					

					String query="Update Register set ID='"+textField_ID.getText()+"',LastEnterTime='"+sdf4.format(date2)+"',LastEnterDate='"+sdf3.format(dateChooser.getDate())+"'where ID='"+textField_ID.getText()+"'";
					PreparedStatement pst=conn.prepareStatement(query);
					
					
					
					
					
					pst.execute(); 
					
					JOptionPane.showMessageDialog(null,"DataUpdated");
					pst.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnUpdate.setBackground(new Color(230, 230, 250));
		btnUpdate.setBounds(667, 214, 160, 44);
		frame.getContentPane().add(btnUpdate);
		
		
		
		
		frame.setTitle("CHECK IN");
		frame.setBounds(100, 100, 855, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
