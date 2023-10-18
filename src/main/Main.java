package main;

import java.util.ArrayList;

import entities.Apartamento;
import entities.Condominio;
import entities.Despesa;
import entities.Proprietario;
import entities.TipoDespesa;
import entities.TipoOcupacao;

public class Main {

	public static void main(String[] args) {
		
		Proprietario pAngelo = new Proprietario("Angelo", "11912489212", new ArrayList<Apartamento>());
		Proprietario pBruno = new Proprietario("Bruno", "11935425323",  new ArrayList<Apartamento>());
		Proprietario pFelipe = new Proprietario("Felipe", "11912345655",  new ArrayList<Apartamento>());
		Proprietario pGabriel = new Proprietario("Gabriel", "11911111112",  new ArrayList<Apartamento>());
		
		Apartamento a101 = new Apartamento(101, 2, TipoOcupacao.PROPRIETARIO ,pAngelo, new ArrayList<Despesa>());
		Apartamento a102 = new Apartamento(102, 3, TipoOcupacao.PROPRIETARIO ,pAngelo, new ArrayList<Despesa>());		
		Apartamento a103 = new Apartamento(103, 3, TipoOcupacao.PROPRIETARIO ,pBruno, new ArrayList<Despesa>());		
		Apartamento a104 = new Apartamento(104, 4, TipoOcupacao.PROPRIETARIO ,pFelipe, new ArrayList<Despesa>());		
		Apartamento a105 = new Apartamento(105, 5, TipoOcupacao.PROPRIETARIO ,pGabriel, new ArrayList<Despesa>());		
		Apartamento a106 = new Apartamento(106, 3, TipoOcupacao.PROPRIETARIO ,pGabriel, new ArrayList<Despesa>());		

		pAngelo.getApartamentos().add(a101);
		pAngelo.getApartamentos().add(a102);
		pBruno.getApartamentos().add(a103);
		pFelipe.getApartamentos().add(a104);
		pGabriel.getApartamentos().add(a105);
		pGabriel.getApartamentos().add(a106);
		
		Condominio c = new Condominio(new ArrayList<Apartamento>(), new ArrayList<Despesa>());
		
		c.getApartamentos().add(a101);
		c.getApartamentos().add(a102);
		c.getApartamentos().add(a103);
		c.getApartamentos().add(a104);
		c.getApartamentos().add(a105);
		c.getApartamentos().add(a106);
		
		// o apartamento a105 fez uma festa no salão
		// agua com custo total de 500
		// luz com custo total de 600
		Despesa dAgua = new Despesa("out/23", 500, TipoDespesa.VARIAVEL);
		Despesa dLuz = new Despesa("out/23", 600, TipoDespesa.VARIAVEL);
		Despesa dSalao = new Despesa("out/23", 100, TipoDespesa.EXTRA);
		
		a105.getDespesas().add(dSalao);
		
		c.getDespesas().add(dAgua);
		c.getDespesas().add(dLuz);
		c.getDespesas().add(dSalao);
		
		System.out.println(c.getApartamentos());
		
		c.calcularDespesasApartamentos();
		
		System.out.println(c.getApartamentos());
	
		
	}

}
