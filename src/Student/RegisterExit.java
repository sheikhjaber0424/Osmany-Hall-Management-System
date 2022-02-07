package Student;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class RegisterExit {

	private JFrame frmCheckOut;
	private JTextField textField_ID;

	/**
	 * Launch the application.
	 */
	public static void RExitmain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterExit window = new RegisterExit();
					window.frmCheckOut.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterExit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * 
	 */
	Connection conn=null;
	
	
	private void initialize() {
		
		conn=sqliteConnection.dbConnector();
		frmCheckOut = new JFrame();
		frmCheckOut.setTitle("CHECK OUT");
		frmCheckOut.getContentPane().setBackground(new Color(51, 102, 153));
		frmCheckOut.getContentPane().setLayout(null);
		
		Connection conn = sqliteConnection.dbConnector();
		
		JLabel label = new JLabel("Student ID");
		label.setForeground(new Color(255, 250, 205));
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(488, 66, 125, 29);
		frmCheckOut.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Date");
		label_1.setForeground(new Color(255, 250, 205));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(488, 106, 88, 34);
		frmCheckOut.getContentPane().add(label_1);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(608, 72, 169, 20);
		frmCheckOut.getContentPane().add(textField_ID);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(608, 116, 170, 20);
		frmCheckOut.getContentPane().add(dateChooser);
		
		JButton button = new JButton("SAVE ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
					
					sdf1.format(dateChooser.getDate());
					
       				Date date2=new Date();
					SimpleDateFormat sdf2=new SimpleDateFormat("hh.mm aa");
					
					

					String query="Update Register set ID='"+textField_ID.getText()+"',LastExitTime='"+sdf2.format(date2)+"',LastExitDate='"+sdf1.format(dateChooser.getDate())+"'where ID='"+textField_ID.getText()+"'";
					PreparedStatement pst=conn.prepareStatement(query);
					
					
					
					
					
					pst.execute(); 
					
					JOptionPane.showMessageDialog(null,"DataUpdated");
					pst.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.BOLD, 17));
		button.setBackground(new Color(230, 230, 250));
		button.setBounds(488, 222, 160, 44);
		frmCheckOut.getContentPane().add(button);
		
		JButton button_2 = new JButton("Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCheckOut.dispose();
				RegisterOption ro=new RegisterOption();
				ro.ROmain(null);
			}
		});
		button_2.setBounds(10, 34, 89, 23);
		frmCheckOut.getContentPane().add(button_2);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
					
					sdf1.format(dateChooser.getDate());
					
       				Date date2=new Date();
					SimpleDateFormat sdf2=new SimpleDateFormat("hh.mm aa");
					
					

					String query="Update Register set ID='"+textField_ID.getText()+"',LastExitTime='"+sdf2.format(date2)+"',LastExitDate='"+sdf1.format(dateChooser.getDate())+"'where ID='"+textField_ID.getText()+"'";
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
		btnUpdate.setBounds(658, 222, 160, 44);
		frmCheckOut.getContentPane().add(btnUpdate);
		frmCheckOut.setResizable(false);
		frmCheckOut.setBounds(100, 100, 856, 499);
		frmCheckOut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
