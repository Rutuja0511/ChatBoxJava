package NewChat;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

import com.mysql.jdbc.ResultSetMetaData;

import java.util.Vector;


public class DB {
	Connection con= null;
	java.sql.PreparedStatement pst;
	public static Connection dbconnect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/chatsignup","root","rutu05p");
			return conn;
		}
		catch(Exception e2) {
			System.out.println(e2);
			return null;
		}
	}
	

}
