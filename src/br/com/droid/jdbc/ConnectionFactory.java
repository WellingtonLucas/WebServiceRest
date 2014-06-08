package br.com.droid.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String url = "jdbc:postgresql://localhost:5432/planpoker";
	private static final String usuario = "postgres";
	private static final String senha = "postgres";
	

	public Connection getConnection() {
		System.out.println("Conectando ao banco");
		Connection con = null;
		try {

			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url,usuario,senha);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}
}
