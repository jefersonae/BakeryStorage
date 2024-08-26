package src.model;

public enum Cargo {
    GERENTE(1),
    CAIXA(2),
    PADEIRO(3);

    private final int cod;

    Cargo(int i) {
        this.cod = i;
    }

    public int getCod() {
        return cod;
    }
}