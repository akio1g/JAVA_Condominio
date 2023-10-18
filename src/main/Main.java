package main;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;

import entities.Apartamento;
import entities.Condominio;
import entities.Despesa;
import entities.Pagamento;
import entities.Proprietario;
import entities.TipoDespesa;
import entities.TipoOcupacao;

public class Main {

	public static void main(String[] args) {
		
		int dataC = 20;
		
		Proprietario pAngelo = new Proprietario("Angelo", "11912489212", new ArrayList<Apartamento>());
		Proprietario pBruno = new Proprietario("Bruno", "11935425323",  new ArrayList<Apartamento>());
		Proprietario pFelipe = new Proprietario("Felipe", "11912345655",  new ArrayList<Apartamento>());
		Proprietario pGabriel = new Proprietario("Gabriel", "11911111112",  new ArrayList<Apartamento>());
		
		Apartamento a101 = new Apartamento(101, 2, TipoOcupacao.PROPRIETARIO ,pAngelo, new ArrayList<Despesa>(),dataC);
		Apartamento a102 = new Apartamento(102, 3, TipoOcupacao.PROPRIETARIO ,pAngelo, new ArrayList<Despesa>(),dataC);		
		Apartamento a103 = new Apartamento(103, 3, TipoOcupacao.PROPRIETARIO ,pBruno, new ArrayList<Despesa>(),dataC);		
		Apartamento a104 = new Apartamento(104, 4, TipoOcupacao.PROPRIETARIO ,pFelipe, new ArrayList<Despesa>(),dataC);		
		Apartamento a105 = new Apartamento(105, 5, TipoOcupacao.PROPRIETARIO ,pGabriel, new ArrayList<Despesa>(),dataC);		
		Apartamento a106 = new Apartamento(106, 3, TipoOcupacao.PROPRIETARIO ,pGabriel, new ArrayList<Despesa>(),dataC);		

		pAngelo.getApartamentos().add(a101);
		pAngelo.getApartamentos().add(a102);
		pBruno.getApartamentos().add(a103);
		pFelipe.getApartamentos().add(a104);
		pGabriel.getApartamentos().add(a105);
		pGabriel.getApartamentos().add(a106);
		
		Condominio c = new Condominio(new ArrayList<Apartamento>(), new ArrayList<Despesa>(), dataC);
		
		c.getApartamentos().add(a101);
		c.getApartamentos().add(a102);
		c.getApartamentos().add(a103);
		c.getApartamentos().add(a104);
		c.getApartamentos().add(a105);
		c.getApartamentos().add(a106);
		
		// condominio custo total mes 300000 
		// o apartamento a105 fez uma festa no salão
		// agua com custo total de 500
		// luz com custo total de 600
		YearMonth referenceOctober2023 = YearMonth.of(2023, Month.OCTOBER);
		
		Despesa dCondominio = new Despesa(referenceOctober2023, 1000, TipoDespesa.CONDOMINIO);
		Despesa dAgua = new Despesa(referenceOctober2023, 500, TipoDespesa.VARIAVEL);
		Despesa dLuz = new Despesa(referenceOctober2023, 600, TipoDespesa.VARIAVEL);
		Despesa dSalao = new Despesa(referenceOctober2023, 100, TipoDespesa.EXTRA);
		
		a105.getDespesas().add(dSalao);
		
		c.getDespesas().add(dCondominio);
		c.getDespesas().add(dAgua);
		c.getDespesas().add(dLuz);
		c.getDespesas().add(dSalao);
		
		System.out.println("Despesa de cada apartamento dentro do condomínio:");
		System.out.println("Antes de Calcular:");
		c.showAllContent();
		System.out.println("-----------------------------------------------------------------------------------------------------");
		c.calcularDespesasApartamentos();
		
		c.showAllContent();
	
		// VENCIMENTOS NO DIA 20
		// PAGAMENTOS: 101 OK, 102 OK, 103 ATRASADO, 104 ATRASADO + MULTA MES Q VEM, 105 OK, 106 ATRASADO
		
		double valorPagamentoA101 = a101.emitirPagamento(referenceOctober2023.getMonth(), LocalDate.of(2023, 10, 20), false);
		double valorPagamentoA102 = a102.emitirPagamento(referenceOctober2023.getMonth(), LocalDate.of(2023, 10, 10), false);
		double valorPagamentoA103 = a103.emitirPagamento(referenceOctober2023.getMonth(), LocalDate.of(2023, 10, 24), false);
		double valorPagamentoA104 = a104.emitirPagamento(referenceOctober2023.getMonth(), LocalDate.of(2023, 10, 29), true);
		double valorPagamentoA105 = a105.emitirPagamento(referenceOctober2023.getMonth(), LocalDate.of(2023, 10, 14), false);
		double valorPagamentoA106 = a106.emitirPagamento(referenceOctober2023.getMonth(), LocalDate.of(2023, 10, 23), false);
		
		Pagamento p101 = new Pagamento(valorPagamentoA101, LocalDate.of(2023, 10, 20));
		Pagamento p102 = new Pagamento(valorPagamentoA102, LocalDate.of(2023, 10, 10));
		Pagamento p103 = new Pagamento(valorPagamentoA103, LocalDate.of(2023, 10, 24));
		Pagamento p104 = new Pagamento(valorPagamentoA104, LocalDate.of(2023, 10, 29));
		Pagamento p105 = new Pagamento(valorPagamentoA105, LocalDate.of(2023, 10, 14));
		Pagamento p106 = new Pagamento(valorPagamentoA106, LocalDate.of(2023, 10, 23));
		
		a101.setPagamento(p101);
		a102.setPagamento(p102);
		a103.setPagamento(p103);
		a104.setPagamento(p104);
		a105.setPagamento(p105);
		a106.setPagamento(p106);
		
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println(a101);
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println(a102);
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println(a103);
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println(a104);
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println(a105);
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println(a106);
	}

}
