package br.com.droid.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CadastroPlanning {
	private Planning p;
	private ArrayList<Item> itens;
	
	public Planning getP() {
		return p;
	}
	public void setP(Planning p) {
		this.p = p;
	}
	public ArrayList<Item> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	
}
