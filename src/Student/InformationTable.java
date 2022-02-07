package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class InformationTable {

	private JFrame frame;
    
	/**
	 * Launch the application.
	 */
	public static void nmain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformationTable window = new InformationTable();
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
	public InformationTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Connection conn=null;
	private JTextField textField;
	private JTable table;
	private void initialize() {
		conn=sqliteConnection.dbConnector();
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(47, 79, 79));
		frame.setTitle("Student Information");
		frame.setBounds(100, 100, 961, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Connection conn = sqliteConnection.dbConnector();
		JButton btnLoadEmployeData = new JButton("Show Information");
		btnLoadEmployeData.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnLoadEmployeData.setForeground(new Color(0, 0, 0));
		btnLoadEmployeData.setBackground(new Color(176, 196, 222));
		btnLoadEmployeData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String query="select ID,Name,Room_No,Dept from StudentInfo";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnLoadEmployeData.setBounds(800, 114, 153, 38);
		frame.getContentPane().add(btnLoadEmployeData);
		
		JButton btnUpdate = new JButton("Add Record");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.setBackground(new Color(176, 196, 222));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				AddRecord Ad=new AddRecord();
				Ad.Addmain(null);
			}
		});
		btnUpdate.setBounds(800, 157, 153, 38);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBackground(new Color(176, 196, 222));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Login l=new Login();
				l.main(null);
			}
		});
		btnLogOut.setBounds(691, 11, 82, 23);
		frame.getContentPane().add(btnLogOut);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(176, 196, 222));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Select s=new Select();
				s.selectmain(null);
			}
		});
		btnBack.setBounds(623, 11, 66, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Update u=new Update();
				u.updatemain(null);
				
				
			}
		});
		btnUpdate_1.setForeground(Color.BLACK);
		btnUpdate_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnUpdate_1.setBackground(new Color(176, 196, 222));
		btnUpdate_1.setBounds(800, 201, 153, 38);
		frame.getContentPane().add(btnUpdate_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String query="select * from StudentInfo where ID=?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, textField.getText());
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					
					// TODO: handle exception
				}
			}
		});
		textField.setBounds(146, 45, 220, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setBackground(Color.WHITE);
		lblSearch.setBounds(81, 46, 88, 14);
		frame.getContentPane().add(lblSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 780, 474);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
