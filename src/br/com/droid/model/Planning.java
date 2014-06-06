package br.com.droid.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Planning {

	private String id;
	private String senha;
	private String duracao;

	public Planning() {

	}

	public Planning(String id, String senha, String duracao) {
		this.id = id;
		this.senha = senha;
		this.duracao = duracao;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
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
