package br.com.droid.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Planning {

	private String id;
	private String senha;

	public Planning() {

	}

	public Planning(String id, String senha) {
		this.id = id;
		this.senha = senha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
