package br.com.droid.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.droid.model.Item;

public class ItemDAO {

	public void addItem(Connection con, Item item) {
		String sql = "insert into voto (descricao, id_panning) values (?,?)";

		try (PreparedStatement stm = con.prepareStatement(sql)) {

			stm.setString(1, item.getDescricao());
			stm.setString(2, item.getId_plan());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Item> buscarItens(Connection con, String id_plan) {
		String sql = "select * from voto where id_planning = ?";		
		List<Item> lista = new ArrayList<>();
		
		try (PreparedStatement stm = con.prepareStatement(sql)) {
			stm.setString(1, id_plan);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				lista.add(new Item(rs.getInt("id"), rs.getString("descricao"), rs.getString("id_planning")));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
