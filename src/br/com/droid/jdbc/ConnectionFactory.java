package br.com.droid.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		try {

			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/planpoker", "postgres",
					"postgres");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
