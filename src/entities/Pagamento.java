package entities;

import java.time.LocalDate;

public class Pagamento {
	private double valorPago;
	private LocalDate dataPagamento;
	
	public Pagamento(double valorPago, LocalDate dataPagamento) {
		super();
		this.valorPago = valorPago;
		this.dataPagamento = dataPagamento;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	@Override
	public String toString() {
		return "R$" + valorPago + " - Pago dia: " + dataPagamento;
	}
	
	
}
