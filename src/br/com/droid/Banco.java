package br.com.droid;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.droid.jdbc.ConnectionFactory;
import br.com.droid.jdbc.ItemDAO;
import br.com.droid.jdbc.PlanningDAO;
import br.com.droid.jdbc.VotoDAO;
import br.com.droid.model.Item;
import br.com.droid.model.Planning;
import br.com.droid.model.Voto;

public class Banco {

	private static Banco instance;

	private PlanningDAO planningDAO;
	private ItemDAO itemDAO;
	private VotoDAO votoDAO;
	

	private Banco() {
		this.planningDAO = new PlanningDAO();
		this.itemDAO = new ItemDAO();
		this.votoDAO = new VotoDAO();
	}

	public static Banco getBancoInstance() throws SQLException {
		if (instance == null)
			instance = new Banco();
		return instance;
	}

	public String inserirPlanning(Planning planning) {
		try {
			Connection con = new ConnectionFactory().getConnection();
			planningDAO.addPlanning(con, planning);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Planning inserido no banco com sucesso!";
	}

	public Planning buscarPlanning(String id) {
		Planning pla = null;
		try {
			Connection con = new ConnectionFactory().getConnection();
			pla = planningDAO.buscar(con, id);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pla;
	}

	public ArrayList<Item> buscarItens(String id) {
		ArrayList<Item> lista = new ArrayList<>();
		try {
			Connection con = new ConnectionFactory().getConnection();
			lista = (ArrayList<Item>) itemDAO.buscarItens(con, id);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public void inserirItens(ArrayList<Item> itensNovos) {
		try {
			Connection con = new ConnectionFactory().getConnection();
			for (Item item : itensNovos) {
				itemDAO.addItem(con, item);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void inserirVoto(Voto v) {
		try {
			Connection con = new ConnectionFactory().getConnection();
			votoDAO.addVoto(con, v);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public int calcularTotal(int id_item){
		ArrayList<Voto> votos = new ArrayList<>();
		try {
			Connection con = new ConnectionFactory().getConnection();
			 votos = (ArrayList<Voto>) votoDAO.buscarVotos(con,
					id_item);
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int v1 = 0, v2 = 0, v3 = 0, v5 = 0, v8 = 0, v13 = 0, v21 = 0;
		for (Voto voto : votos) {
			if (voto.getValor() == 1) {
				v1++;
			} else if (voto.getValor() == 2) {
				v2++;
			} else if (voto.getValor() == 3) {
				v3++;
			} else if (voto.getValor() == 5) {
				v5++;
			} else if (voto.getValor() == 8) {
				v8++;
			} else if (voto.getValor() == 13) {
				v13++;
			} else if (voto.getValor() == 21) {
				v21++;
			}
		}
		if (v1 > v2 && v1 > v3 && v1 > v5 && v1 > v8 && v1 > v13 && v1 > 21) {
			return v1;
		} else if (v2 > v3 && v2 > v5 && v2 > v8 && v2 > v13 && v2 > 21) {
			return v2;
		} else if (v3 > v5 && v3 > v8 && v3 > v13 && v3 > 21) {
			return v3;
		} else if (v5 > v8 && v5 > v13 && v5 > 21) {
			return v5;
		} else if (v8 > v13 && v8 > 21) {
			return v8;
		} else if (v13 > v21) {
			return v13;
		} else {
			return v21;
		}
	}
}
