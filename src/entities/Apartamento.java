package entities;

import java.util.ArrayList;
import java.util.List;

public class Apartamento {

	private int number;
	private int quartos;
	private TipoOcupacao ocupacao;
	private Proprietario proprietario;
	private List<Despesa> despesas = new ArrayList<>();
	
	public Apartamento(int number, int quartos, TipoOcupacao ocupacao, Proprietario proprietario, ArrayList<Despesa> despesas) {
		super();
		this.number = number;
		this.quartos = quartos;
		this.ocupacao = ocupacao;
		this.proprietario = proprietario;
		this.despesas = despesas;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getQuartos() {
		return quartos;
	}

	public void setQuartos(int quartos) {
		this.quartos = quartos;
	}

	public TipoOcupacao getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(TipoOcupacao ocupacao) {
		this.ocupacao = ocupacao;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public List<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}

	@Override
	public String toString() {
		return "Apartamento [despesas=" + despesas + "]";
	}
}
