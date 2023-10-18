package entities;

public class Despesa {
	
	private String referencia;
	private double valor;
	private TipoDespesa tipo;
	
	public Despesa(String referencia, double valor, TipoDespesa tipo) {
		super();
		this.referencia = referencia;
		this.valor = valor;
		this.tipo = tipo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
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
		return "Despesa [referencia=" + referencia + ", valor=" + valor + ", tipo=" + tipo + "]";
	}
}
