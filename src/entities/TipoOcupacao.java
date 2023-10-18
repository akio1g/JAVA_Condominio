package entities;

public enum TipoOcupacao {
	PROPRIETARIO(1),
    INQUILINO(2),
	VAZIO(3);

    private int valor;
    
    TipoOcupacao(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
