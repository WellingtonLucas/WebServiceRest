package br.com.droid.resources;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.droid.Banco;
import br.com.droid.exception.NoContentException;
import br.com.droid.model.CadastroPlanning;
import br.com.droid.model.Item;
import br.com.droid.model.Planning;
import br.com.droid.model.ReceberPlanning;
import br.com.droid.model.Voto;

@Path("/planning")
public class PlanningResource {

	@GET
	@Path("/autenticar/{id}/{senha}")
	@Produces("application/json")
	public String autenticacao(@PathParam("id") String id,
			@PathParam("senha") String senha) throws SQLException {
		// pegar a senha do panning com esse id
		Planning plan = Banco.getBancoInstance().buscarPlanning(id);
		if (plan != null) {
			if (senha == plan.getSenha()) {
				return "autenticado";
			}
		}
		return "reprovado";
	}

	@GET
	@Path("/index")
	@Produces("application/json")
	public String teste() throws SQLException {
		if (Banco.getBancoInstance() != null) {
			return "Tem banco";
		}
		return "n tem banco";
	}

	@GET
	@Path("/itens/{id}/{hora}")
	@Produces("application/json")
	public ReceberPlanning getItens(@PathParam("id") String id,
			@PathParam("hora") String hora) throws SQLException{
		Planning p = Banco.getBancoInstance().buscarPlanning(id);
		ReceberPlanning rePlan = new ReceberPlanning();
		ArrayList<Item> itens = Banco.getBancoInstance().buscarItens(id);
		
		rePlan.setId(id);
		if (!encerrado(p, hora)) {
			// System.out.println("server id: "+p.getId());
			rePlan.setEncerrado(false);			
		}else{
			rePlan.setEncerrado(true);
		}
		rePlan.setItens(itens);
		return rePlan;
	}

	private boolean encerrado(Planning p, String hora) {
		System.out.println(p.getTermino());
		String[] termino = p.getTermino().split(":");
		String[] ho = hora.split(":");

		int term_hora = Integer.parseInt(termino[0]);
		int term_min = Integer.parseInt(termino[1]);
		int hora_hora = Integer.parseInt(ho[0]);
		int hora_min = Integer.parseInt(ho[1]);

		if (hora_hora > term_hora) {
			return true;
		} else if (hora_hora == term_hora && hora_min > term_min) {
			return true;
		}
		return false;
	}

	@POST
	@Path("/inserir")
	@Produces("application/json")
	@Consumes("application/json")
	public String inserirPlanning(CadastroPlanning cp) throws SQLException {
		Banco.getBancoInstance().inserirPlanning(cp.getP());
		Banco.getBancoInstance().inserirItens(cp.getItens());
		return "Sucesso";
	}

	@GET
	@Path("/item/{id}/voto/{valor}")
	@Produces("application/json")
	// precisa?
	public void votar(@PathParam("id") String id, @PathParam("valor") int valor)
			throws SQLException {

		ArrayList<Item> itens = Banco.getBancoInstance().buscarItens(id);
		if (itens.isEmpty()) {
			throw new NoContentException("Item nao existente!");
		} else if (itens.size() == 1) {
			// inserir o voto com o valor e o id
			Voto v = new Voto();
			v.setId_item(Integer.parseInt(id));
			v.setValor(valor);
			Banco.getBancoInstance().inserirVoto(v);
		} else
			throw new NoContentException("Item nao encontrado!");
	}

	/*
	 * @GET
	 * 
	 * @Path("/buscarTodos")
	 * 
	 * @Produces("application/json") public ArrayList<Planning> selTodos(){
	 * return Banco.getBancoInstance().getListaPlanning(); }
	 * 
	 * @GET
	 * 
	 * @Path("/buscarTodosGSON")
	 * 
	 * @Produces("application/json") public String selTodosGSON(){ return new
	 * Gson().toJson(Banco.getBancoInstance().getListaPlanning()); }
	 */
}
