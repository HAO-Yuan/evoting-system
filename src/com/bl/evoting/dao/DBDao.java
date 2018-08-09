package com.bl.evoting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBDao {
	private  Connection conn = null;

	public DBDao() throws Exception {
		String url = "jdbc:mysql://localhost:3306/bl_evoting?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "123456";
		conn = null;
		// loading driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// singalton to return a database intance
		this.conn = DriverManager.getConnection(url, username, password);
	}

	
	//query method
	 public ResultSet query(String sql, Object... args) throws Exception {  
	        PreparedStatement ps = conn.prepareStatement(sql);  
	        for (int i = 0; i < args.length; i++) {  
	            ps.setObject(i + 1, args[i]);  
	        }  
	        return ps.executeQuery();  
	    }  
	
	 //insert method
	 public boolean insert(String sql, Object... args) throws Exception {  
	        PreparedStatement ps = conn.prepareStatement(sql);  
	        for (int i = 0; i < args.length; i++) {  
	            ps.setObject(i + 1, args[i]);  
	        }  
	        if (ps.executeUpdate() != 1) {  
	            return false;  
	        }  
	        return true;  
	    }  
	 
	 //modify method
	 public boolean modify(String sql, Object... args) throws Exception {  
	        PreparedStatement ps = conn.prepareStatement(sql);  
	        for (int i = 0; i < args.length; i++) {  
	            ps.setObject(i + 1, args[i]);  
	        }  
	        if (ps.executeUpdate() != 1) {  
	            return false;  
	        }  
	        return true;  
	    }  
	 
	//insert and get last id method
	 public ResultSet getLastId(String sql, Object... args) throws Exception {  
	        PreparedStatement ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);  
	        for (int i = 0; i < args.length; i++) {  
	            ps.setObject(i + 1, args[i]);  
	        }  
	        if (ps.executeUpdate() != 1) {  
	            return null;  
	        }  
	        return ps.getGeneratedKeys();  
	    }  
	 
	 //disconnect DB
	 protected void finalize() throws Exception {  
	        if (!conn.isClosed() || conn != null) {  
	            conn.close();  
	        }  
	    }  
}
