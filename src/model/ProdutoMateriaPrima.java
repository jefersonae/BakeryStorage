package src.model;

public class ProdutoMateriaPrima extends Produto{
    private double custoUnitario;

    public ProdutoMateriaPrima(int cod, String descricao, String marca, int qnt, double custoUnitario) {
        super();
        this.setCod(cod);
        this.setDescricao(descricao);
        this.setMarca(marca);
        this.setQnt(qnt);
        this.custoUnitario = custoUnitario;
    }

    public double getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(double custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    @Override
    public String toString() {
        return super.toString()+"{" +
                "custoUnitario=" + custoUnitario +
                '}';
    }
}
