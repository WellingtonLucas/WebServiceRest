package br.com.droid;

import java.util.ArrayList;

import br.com.droid.model.Item;
import br.com.droid.model.Planning;
import br.com.droid.model.Voto;

public class Banco {

	private static Banco instance;
	private ArrayList<Planning> listaPlanning;
	private ArrayList<Item> itens;
	private ArrayList<Voto> votos;
	private int id_item;
	
	private Banco() {
		itens = new ArrayList<>();
		votos = new ArrayList<>();
		listaPlanning = new ArrayList<Planning>();
		Planning p = new Planning();
		p.setId("a");
		p.setSenha("1234");
		inserirPlanning(p);
		id_item = 0;
		p.setId("b");
		p.setSenha("12345");
		inserirPlanning(p);
	}
	
	public static Banco getBancoInstance(){
		if(instance==null)
			instance = new Banco();
		return instance;
	}
	
	public ArrayList<Planning> getListaPlanning(){
		return listaPlanning;
	}
	
	public String inserirPlanning(Planning planning){
		listaPlanning.add(planning);
		return "Planning inserido no banco com sucesso!";
	}
	
	public Planning buscarPlanning(String id){
		Planning p = new Planning();
		for (int i = 0; i < listaPlanning.size(); i++) {
			
			p = listaPlanning.get(i);
			System.out.println("id:"+p.getId());
			if (p.getId() == id){
				break;
			}
		}
		return p;
	}

	public ArrayList<Item> buscarItens(String id) {
		ArrayList<Item> itensPlan = new ArrayList<Item>();
		for (int i = 0; i < itens.size(); i++) {
			if (itens.get(i).getId_plan() == id){
				itensPlan.add(itens.get(i));
				break;
			}
		}
		return itensPlan;
	}
	
	public void inserirItens(ArrayList<Item> itensNovos){
		for (Item item : itensNovos) {
			item.setId(id_item);
			itens.add(item);
			id_item++;
		}
		
	}
	
	public void inserirVoto(Voto v){
		votos.add(v);
	}
	
	public ArrayList<Voto> calcularTotal(String id_planing){
		//TODO
		return null;
	}
}
