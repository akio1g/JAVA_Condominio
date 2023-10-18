package entities;

public enum TipoDespesa {
	FIXO(1),
    VARIAVEL(2),
	EXTRA(3),
	CONDOMINIO(4);

    private int valor;
    
    TipoDespesa(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
