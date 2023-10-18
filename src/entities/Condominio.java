package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Condominio {

	private List<Apartamento> apartamentos = new ArrayList<>();
	private List<Despesa> despesas = new ArrayList<>();

	public Condominio(List<Apartamento> apartamentos, List<Despesa> despesas) {
		super();
		this.apartamentos = apartamentos;
		this.despesas = despesas;
	}

	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}

	public List<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}
	
	@Override
	public String toString() {
		return "Condominio [apartamentos=" + apartamentos + ", despesas=" + despesas + "]";
	}

	public void calcularDespesasApartamentos() {
		int totalQuartos = 0;
		for(Apartamento ap : apartamentos) {
			totalQuartos = totalQuartos + ap.getQuartos();
		}
		
		// filtering only different then extra
		List<Despesa> despesasFiltradas = this.despesas.stream().filter(desp -> desp.getTipo() != TipoDespesa.EXTRA).collect(Collectors.toList());
		
		for(Apartamento ap : apartamentos) {
			for(Despesa d : despesasFiltradas) {
				double valorDespesa = d.getValor() / totalQuartos * ap.getQuartos();
				
				Despesa despesaAp = new Despesa(d.getReferencia(), valorDespesa, d.getTipo());
				ap.getDespesas().add(despesaAp);
			}
		}
	}
}
