package entities;

import java.util.ArrayList;
import java.util.List;

public class Proprietario {
	private String nome;
	private String telefone;
	private List<Apartamento> apartamentos = new ArrayList<>();
	
	public Proprietario(String nome, String telefone, List<Apartamento> apartamentos) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.apartamentos = apartamentos;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}
	
	
}
