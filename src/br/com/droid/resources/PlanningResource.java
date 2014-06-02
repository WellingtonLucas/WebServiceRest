package br.com.droid.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import br.com.droid.Banco;
import br.com.droid.exception.NoContentException;
import br.com.droid.model.CadastroPlanning;
import br.com.droid.model.Item;
import br.com.droid.model.Planning;
import br.com.droid.model.Voto;


@Path("/planning")
public class PlanningResource {
	
	@GET
	@Path("/index")
	@Produces("application/json")
	public String teste(){
		if(Banco.getBancoInstance() != null){
			return "Tem banco";
		}
		return "n tem banco";
	}
	
	
	@GET
	@Path("/buscarTodos")
	@Produces("application/json")
	public ArrayList<Planning> selTodos(){
		return Banco.getBancoInstance().getListaPlanning();
	}

	@GET
	@Path("/buscarTodosGSON")
	@Produces("application/json")
	public String selTodosGSON(){
		return new Gson().toJson(Banco.getBancoInstance().getListaPlanning());
	}
	
	@GET
	@Path("/itens/{id}")
	@Produces("application/json")
	public ArrayList<Item> getItens(@PathParam("id") String id){
		Planning p = Banco.getBancoInstance().buscarPlanning(id);
		//System.out.println("server id: "+p.getId());
		if(p == null){
			throw new NoContentException("Planning não encontrado!");
		}
		ArrayList<Item> itens = Banco.getBancoInstance().buscarItens(id);
		if(itens.isEmpty()){
			throw new NoContentException("Itens não existentes!");
		}
		
		return itens;
	}
	
	
	@POST
	@Path("/inserir")
	@Produces("application/json")
	@Consumes("application/json")
	public String inserirPlanning(CadastroPlanning cp) {
		Banco.getBancoInstance().inserirPlanning(cp.getP());
		Banco.getBancoInstance().inserirItens(cp.getItens());
		return "Sucesso";
	}
	
	@GET
	@Path("/item/{id}/voto/{valor}")
	@Produces("application/json")//precisa?
	public void votar(@PathParam("id") String id, @PathParam("valor") int valor){
		
		ArrayList<Item> itens = Banco.getBancoInstance().buscarItens(id);
		if(itens.isEmpty()){
			throw new NoContentException("Item não existente!");
		}
		else if(itens.size() == 1){
			//inserir o voto com o valor e o id
			Voto v = new Voto();
			v.setId_item(Integer.parseInt(id));
			v.setValor(valor);
			Banco.getBancoInstance().inserirVoto(v);
		}
		else throw new NoContentException("Item não encontrado!");
	}
}
