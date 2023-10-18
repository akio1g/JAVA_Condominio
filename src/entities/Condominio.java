package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Condominio extends DataVencimento{

	private List<Apartamento> apartamentos = new ArrayList<>();
	private List<Despesa> despesas = new ArrayList<>();


	
	public Condominio(List<Apartamento> apartamentos, List<Despesa> despesas, int dataVencimento) {
		super(dataVencimento);
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

	public void showAllContent() {
		
		for(Apartamento ap : apartamentos) {
			String apName = "ap" + ap.getNumber();
			
			System.out.println(apName);
			for(Despesa d : ap.getDespesas()) {
				System.out.println(d);
			}
			System.out.println();
		}
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
				
				Despesa despesaAp = new Despesa(d.getReference(), valorDespesa, d.getTipo());
				ap.getDespesas().add(despesaAp);
			}
		}
	}


}
