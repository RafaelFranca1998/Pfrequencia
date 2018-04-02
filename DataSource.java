package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
//-------------------------------------------------------------------------------------
	private String hostName;
	private int port;
	private String dataBase;
	private String userName;
	private String password;

	private Connection connection;
	//-------------------------------------------------------------------------------------
	public DataSource() {
		hostName = "localhost";
		port = 3306;
		dataBase = "dbteste1";
		userName = "root";
		password = "32612421";
		
		try {
			String url = "jdbc:mysql://" + hostName + ":" + port + "/" + dataBase;
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Conexão Efetuada");
		} catch (SQLException e) {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public Connection getConnection() {
		return connection;
	}
	public void closeConnection() {
		try {
			connection.close();
			System.out.println("Conexão encerrada!!");
		} catch (SQLException e) {
			System.err.println("Não fechou " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Erro diverso " + e.getMessage());
		}
	}
//-------------------------------------------------------------------------------------
}