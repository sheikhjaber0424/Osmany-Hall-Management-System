package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;

public class AddRecord {
	
	private JFrame frame;
	
	public void setVisible() {
		frame.setVisible(true);
	}
	/**
	 * Launch the application.
	 */
	public static void Addmain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRecord window = new AddRecord();
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
	
	
	public AddRecord() {
	
		initialize();
	}

	
    
	
	/**
	 * Initialize the contents of the frame.
	 */
	Connection conn=null;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JComboBox  comboBox;
	private String gender;
	private String n;
	private ImageIcon format=null;
	String filename=null;
	byte[] person_image=(byte[]) null;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Update Information");
		frame.setBounds(100, 100, 963, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		conn=sqliteConnection.dbConnector();
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblAddStudentRecord = new JLabel("ADD STUDENT INFORMATION");
		lblAddStudentRecord.setBackground(new Color(100, 149, 237));
		lblAddStudentRecord.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAddStudentRecord.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAddStudentRecord);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 79, 79));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(52, 86, 125, 29);
		panel_1.add(lblName);
		
		JLabel lblFathersName = new JLabel("Fathers Name");
		lblFathersName.setForeground(new Color(255, 255, 255));
		lblFathersName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFathersName.setBounds(52, 212, 113, 29);
		panel_1.add(lblFathersName);
		
		JLabel lblMothersName = new JLabel("Mothers Name");
		lblMothersName.setForeground(new Color(255, 255, 255));
		lblMothersName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMothersName.setBounds(52, 252, 113, 29);
		panel_1.add(lblMothersName);
		comboBox = new JComboBox();
		comboBox.addItem("CSE");
		comboBox.addItem("EECE");
		comboBox.addItem("ME");
		comboBox.addItem("CE");
		comboBox.addItem("PME");
		comboBox.addItem("BME");
		comboBox.addItem("NAME");
		comboBox.addItem("EWCE");
		comboBox.addItem("NSE");
		comboBox.addItem("AE");
		comboBox.addItem("IPE");
		comboBox.addItem("ARCHI");
		
		
		
		
		comboBox.setBounds(187, 134, 169, 20);
		panel_1.add(comboBox);
	
		
		JButton btnSaveRecord = new JButton("SAVE RECORD");
		btnSaveRecord.setBackground(new Color(230, 230, 250));
		btnSaveRecord.setForeground(new Color(0, 0, 0));
		btnSaveRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into StudentInfo(ID,Name,Dept,Room_No,Fathers_Name,Mothers_Name,Contact_Number,Blood_Group,Address,Gender,Image)values(?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query);
					
					String n=comboBox.getSelectedItem().toString();
							
					pst.setString(1,textField_7.getText() );
					pst.setString(2,textField.getText() );
					pst.setString(3, n);
					pst.setString(4, textField_2.getText());
					pst.setString(5, textField_3.getText());
					pst.setString(6, textField_4.getText());
					pst.setString(7, textField_5.getText());
					pst.setString(8, textField_6.getText());
					pst.setString(9, textField_8.getText());
					pst.setString(10, gender);
					pst.setBytes(11, person_image);
					
					
					
					pst.execute(); 
					
					JOptionPane.showMessageDialog(null,"DataSaved");
					pst.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnSaveRecord.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSaveRecord.setBounds(638, 10, 160, 44);
		panel_1.add(btnSaveRecord);
		
		JLabel lblDept = new JLabel("Dept");
		lblDept.setForeground(new Color(255, 255, 255));
		lblDept.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDept.setBounds(52, 128, 125, 29);
		panel_1.add(lblDept);
		
		JLabel lblRoomno = new JLabel("Room No.");
		lblRoomno.setForeground(new Color(255, 255, 255));
		lblRoomno.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRoomno.setBounds(52, 172, 125, 29);
		panel_1.add(lblRoomno);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setForeground(new Color(255, 255, 255));
		lblContactNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContactNumber.setBounds(52, 292, 125, 29);
		panel_1.add(lblContactNumber);
		
		textField = new JTextField();
		textField.setBounds(187, 92, 169, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(187, 178, 169, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(187, 218, 169, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(187, 258, 169, 20);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(187, 298, 169, 20);
		panel_1.add(textField_5);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setForeground(new Color(255, 255, 255));
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBloodGroup.setBounds(52, 332, 113, 29);
		panel_1.add(lblBloodGroup);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(187, 338, 169, 20);
		panel_1.add(textField_6);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBackground(new Color(230, 230, 250));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				InformationTable in=new InformationTable();
				in.nmain(null);
			}
		});
		btnBack.setBounds(52, 11, 89, 23);
		panel_1.add(btnBack);
		
		JLabel lblHallId = new JLabel("*Hall ID");
		lblHallId.setForeground(new Color(255, 255, 255));
		lblHallId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHallId.setBounds(52, 47, 125, 29);
		panel_1.add(lblHallId);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(187, 53, 169, 20);
		panel_1.add(textField_7);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(52, 372, 113, 29);
		panel_1.add(lblAddress);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(186, 378, 340, 20);
		panel_1.add(textField_8);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(52, 412, 113, 29);
		panel_1.add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBackground(Color.LIGHT_GRAY);
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gender="Male";
				rdbtnMale.setSelected(true);
				rdbtnMale.setSelected(false);
				
			}
		});
		rdbtnMale.setBounds(189, 417, 109, 23);
		panel_1.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBackground(Color.LIGHT_GRAY);
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gender="Female";
				
				rdbtnFemale.setSelected(true);
				rdbtnFemale.setSelected(false);
				
			}
		});
		rdbtnFemale.setBounds(300, 417, 109, 23);
		panel_1.add(rdbtnFemale);
		
		JLabel label = new JLabel("");
		label.setBounds(598, 65, 200, 173);
		panel_1.add(label);
		
		JButton btnAttach = new JButton("Attach");
		btnAttach.setBackground(Color.LIGHT_GRAY);
		btnAttach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser=new JFileChooser();
				chooser.showOpenDialog(null);
				File f=chooser.getSelectedFile();
				filename=f.getAbsolutePath();
				ImageIcon imageIcon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
				label.setIcon(imageIcon);
				try {
					File image=new File(filename);
					FileInputStream fix=new FileInputStream(image);
					ByteArrayOutputStream bos=new ByteArrayOutputStream();
					byte[] buf=new byte[1024];
						
					for(int number;(number=fix.read(buf))!=-1;)
					{
						bos.write(buf,0,number);
					}
					person_image=bos.toByteArray();
				} catch (Exception ek) {
					JOptionPane.showMessageDialog(null,ek);
					// TODO: handle exception
				}
				
			}
		});
		btnAttach.setBounds(687, 268, 89, 23);
		panel_1.add(btnAttach);
		
		
	
}
}
