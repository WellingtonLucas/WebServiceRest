package br.com.droid.jdbc;	

import java.sql.Connection;
import java.sql.SQLException;

import br.com.droid.model.Item;
import br.com.droid.model.Voto;

public class Teste {

	public static void main(String[] args) {

		try (Connection con = new ConnectionFactory().getConnection()) {
			PlanningDAO plan = new PlanningDAO();
			//Planning planin = new Planning();
			//planin.setSenha("123");
			//planin.setId("4");
			//planin.setDuracao("7");
			//plan.addPlanning(con, planin);
			System.out.println(plan.buscar(con, "1").getId());
			//Item item = new Item();
			//item.setDescricao("Cadastro de cliente");
			//item.setId_plan("2");
			ItemDAO it = new ItemDAO();
			//it.addItem(con, item);
			for (Item item2 : it.buscarItens(con, "1")) {
				System.out.println(item2.getDescricao());
			}
			 //Voto voto = new Voto();
			 //voto.setId_item(1);
			 //voto.setValor(13);
			 VotoDAO vtd = new VotoDAO();
			 //vtd.addVoto(con, voto);
			 for (Voto vt : vtd.buscarVotos(con, 1)) {
				System.out.println(vt.getValor());
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
