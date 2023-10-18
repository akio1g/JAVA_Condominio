package entities;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Apartamento extends DataVencimento{

	private int number;
	private int quartos;
	private TipoOcupacao ocupacao;
	private Proprietario proprietario;
	private List<Despesa> despesas = new ArrayList<>();
	private Pagamento pagamento;

	
	public Apartamento(int number, int quartos, TipoOcupacao ocupacao, Proprietario proprietario,
			List<Despesa> despesas, int dataVencimento) {
		super(dataVencimento);
		this.number = number;
		this.quartos = quartos;
		this.ocupacao = ocupacao;
		this.proprietario = proprietario;
		this.despesas = despesas;
		this.pagamento = null;
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

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	// function to get total value (not usual)
	public double emitirPagamento(Month month, LocalDate diaPagamento, boolean payMultaNextMonth) {
		int diaPagamentoNum = diaPagamento.getDayOfMonth();
		boolean isLate = diaPagamentoNum > this.getDataVencimento();
		double total = 0;
		double valorMulta = 0;
		YearMonth refMulta = null;
		
		for(Despesa d : despesas) {
			if(d.getReference().getMonth() == month) {
				total = total + d.getValor();
				refMulta = d.getReference();
			}
		}
		
		if(isLate) {
			valorMulta = total * 0.02;

			Despesa dMulta = new Despesa(refMulta, valorMulta, TipoDespesa.EXTRA);
			
			if(payMultaNextMonth) {
				dMulta.setReference(refMulta.plusMonths(1));
				dMulta.setValor(total * 0.05);
			} else {
				total = total + valorMulta;
			}
			
			this.despesas.add(dMulta);
		}
		
		return total;
	}

	@Override
	public String toString() {
		return "Apartamento " + number + " - Quartos: " + quartos + "\nDespesas: " + despesas + "\nPagamento: " + pagamento;
	}
	
	
}

	