package br.com.droid.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.droid.model.Planning;

public class PlanningDAO {

	public void addPlanning(Connection con, Planning plan) {
		String sql = "insert into planning (senha) values (?)";

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, plan.getSenha());
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Planning buscar(Connection con, String id) {
		String sql = "select * from planning where id = ?";
		Planning plan = new Planning();

		try (PreparedStatement stm = con.prepareStatement(sql)) {
			stm.setString(1, id);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				plan.setId(rs.getString("id"));
				plan.setSenha(rs.getString("senha"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plan;
	}
}
