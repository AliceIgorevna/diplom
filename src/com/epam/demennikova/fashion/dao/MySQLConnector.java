package com.epam.demennikova.fashion.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnector {

	public static Connection getConnection() {
    	Connection conn = null;
    	
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "fashionDB";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "1234567890";
        
        try
        {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception ex) {
			//LOG.error("Can not create Connection to: " + url + dbName, ex);			
		}
		return conn;
    }
	public static void main(String[] args) {
		System.out.println(MySQLConnector.getConnection());
	}
}
