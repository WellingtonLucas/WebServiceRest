package br.com.droid.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.droid.model.Voto;

public class VotoDAO {

	public void addVoto(Connection con, Voto voto) {
		String sql = "insert into voto (valor,id_item) values (?,?)";

		try (PreparedStatement stm = con.prepareStatement(sql)) {

			stm.setInt(1, voto.getValor());
			stm.setInt(2, voto.getId_item());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Voto> buscarVotos(Connection con, int id_item) {
		String sql = "select * from voto where id_item = ?";
		List<Voto> lista = new ArrayList<>();

		try (PreparedStatement stm = con.prepareStatement(sql)) {
			stm.setInt(1, id_item);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				lista.add(new Voto(rs.getInt("id"), rs.getInt("valor"), rs
						.getInt("id_item")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
