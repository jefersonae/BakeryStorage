package src.model;

public class ProdutoVendavel extends Produto{
    private double valorUnitario;

    public ProdutoVendavel(int cod, String descricao, String marca, int qnt, double valorUnitario) {
        super();
        this.setCod(cod);
        this.setDescricao(descricao);
        this.setMarca(marca);
        this.setQnt(qnt);
        this.valorUnitario = valorUnitario;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return super.toString()+"{" +
                "valorUnitario=" + valorUnitario +
                '}';
    }
}
