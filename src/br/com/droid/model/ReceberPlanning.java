package br.com.droid.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReceberPlanning {
	private String id;
	private String senha;
	private ArrayList<Item> itens;
	private boolean encerrado;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSeha() {
		return senha;
	}
	public void setSeha(String seha) {
		this.senha = seha;
	}
	public ArrayList<Item> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	public boolean isEncerrado() {
		return encerrado;
	}
	public void setEncerrado(boolean encerrado) {
		this.encerrado = encerrado;
	}
}