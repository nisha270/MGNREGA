package com.mgnrega.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class dbUtil {
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ResourceBundle rb=ResourceBundle.getBundle("dbdetails");
			return DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("pass"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
    
	public static void cloceConnection(Connection conn) throws SQLException {
		if(conn!=null)
			conn.close();
	}

}
