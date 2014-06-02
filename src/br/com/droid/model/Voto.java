package br.com.droid.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Voto {
	private int valor;
	private int id_item;
	private int id;

	public Voto() {

	}

	public Voto(int id, int valor, int id_item) {
		this.valor = valor;
		this.id_item = id_item;
		this.id = id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getId_item() {
		return id_item;
	}

	public void setId_item(int id_item) {
		this.id_item = id_item;
	}

}
