package br.com.droid.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.droid.model.Planning;

public class teste {

	public static void main(String[] args) {

		try (Connection con = new ConnectionFactory().getConnection()) {
			PlanningDAO plan = new PlanningDAO();
			Planning planin = new Planning();
			planin.setSenha("123");
			
			plan.addPlanning(con, planin);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
