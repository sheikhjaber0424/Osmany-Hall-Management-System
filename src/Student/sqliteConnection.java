


package Student;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class sqliteConnection{
	Connection conn ;
	
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\DIU\\eclipse-workspace\\AddRecord\\src\\EmployeeData.sqlite");
			
			return conn;
 		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error : "+e);
			return null;
		}
		// TODO Auto-generated method stub
		//return null;
	}
 
	
	
}
	