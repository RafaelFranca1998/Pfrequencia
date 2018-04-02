package com.model;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private int frequencia;
// GETTERS E SETTERS	
//-------------------------------------------------------------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
//-------------------------------------------------------------------------------	
	@Override
	public String toString() {
		return "<<<<<Tabela Teste>>>>>"+"\n"+" id= " + id + "\n nome= " + nome + "\n email= " + email + "\n frequencia= " + frequencia ;
	}
	


}
