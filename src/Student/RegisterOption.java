package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;

public class RegisterOption {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void ROmain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterOption window = new RegisterOption();
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
	public RegisterOption() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	Connection conn=null;
	private JTable table;
	private void initialize() {
		conn=sqliteConnection.dbConnector();
		
		frame = new JFrame();
		frame.setTitle("IN/OUT");
		frame.getContentPane().setBackground(new Color(0, 102, 153));
		frame.getContentPane().setLayout(null);
		Connection conn = sqliteConnection.dbConnector();
		
		JButton btnEnter = new JButton("CHECK IN");
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Register r1=new Register();
				r1.REntermain(null);
				
				
				
			}
		});
		btnEnter.setBounds(271, 81, 161, 23);
		frame.getContentPane().add(btnEnter);
		
		JButton btnExit = new JButton("CHECK OUT");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RegisterExit r2=new RegisterExit();
				r2.RExitmain(null);
				
			}
		});
		btnExit.setBounds(442, 81, 161, 23);
		frame.getContentPane().add(btnExit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Select se=new Select();
				se.selectmain(null);
			}
		});
		btnBack.setBackground(new Color(176, 196, 222));
		btnBack.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnRegisterList = new JButton("Register List");
		btnRegisterList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	try {
					
					String query="select ID,LastEnterTime,LastEnterDate,LastExitTime,LastExitDate from Register";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
				
				
			}
		});
		btnRegisterList.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegisterList.setBounds(100, 81, 161, 23);
		frame.getContentPane().add(btnRegisterList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(100, 129, 710, 332);
		frame.getContentPane().add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Login l=new Login();
				l.main(null);
			}
		});
		btnLogOut.setBounds(101, 11, 89, 23);
		frame.getContentPane().add(btnLogOut);
		frame.setBounds(100, 100, 859, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
