package com.cadmedicamento.negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	
	private final String driver = "org.postgresql.Driver";
	private final String usuario = "postgres";
	private final String senha = "123";
	
	private final String url = "jdbc:postgresql://localhost:5432/dbmedicamento";
	private Connection con = null;
	
	public Connection getConexao() {
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	
	

}
