package com.dao;

public class TesteConexao {
	public static void main(String[] args) {
		DataSource ds = new DataSource();
		
		ds.getConnection();
		ds.closeConnection();;
	}
}
