package entities;

import java.time.YearMonth;

public class Despesa {
	
	private YearMonth reference;
	private double valor;
	private TipoDespesa tipo;
	
	

	public Despesa(YearMonth reference, double valor, TipoDespesa tipo) {
		super();
		this.reference = reference;
		this.valor = valor;
		this.tipo = tipo;
	}

	public YearMonth getReference() {
		return reference;
	}

	public void setReference(YearMonth reference) {
		this.reference = reference;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TipoDespesa getTipo() {
		return tipo;
	}

	public void setTipo(TipoDespesa tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "\nMês de Referencia= " + reference + "- Valor: R$" + valor + " - Tipo" + tipo;
	}
}
