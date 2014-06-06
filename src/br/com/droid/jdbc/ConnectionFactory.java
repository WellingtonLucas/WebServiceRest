package br.com.droid.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String url = "jdbc:postgresql://localhost:5432/planpoker";
	private static final String usuario = "postgres";
	private static final String senha = "postgres";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, usuario, senha);

	}

}
