package br.com.droid.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.droid.model.Planning;

public class PlanningDAO {

	public void addPlanning(Connection con, Planning plan) {
		String sql = "INSERT INTO planning(id,senha,duracao) VALUES (?,?,?)";
		
		try (PreparedStatement stm = con.prepareStatement(sql)) {

			stm.setString(1, plan.getId());
			stm.setString(2, plan.getSenha());
			stm.setString(3, plan.getTermino());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Planning buscar(Connection con, String id) {
		String sql = "select * from planning where id = ?";
		Planning plan = new Planning();

		try (PreparedStatement stm = con.prepareStatement(sql)) {
			stm.setString(1, id);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {				
				plan.setId(rs.getString("id"));
				plan.setSenha(rs.getString("senha"));
				plan.setTermino(rs.getString("duracao"));
			}
			rs.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return plan;
	}
}
