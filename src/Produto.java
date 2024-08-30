package src;

public class Produto {
    public int codigo;
    public String descricao;
    String marca;
    double valorEntrada;
    double valorUnitario;
    int quantidadeEstoque;
    int quantidadeVendida;
    double valorSaida;

    public Produto(int codigo, String descricao, String marca, double valorEntrada, double valorUnitario, int quantidadeEstoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.marca = marca;
        this.valorEntrada = valorEntrada;
        this.valorUnitario = valorUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeVendida = 0;
        this.valorSaida = 0;
    }

    public void mostrarProduto() {
        System.out.println("Código: " + codigo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Marca: " + marca);
        System.out.println("Valor de Compra: " + valorEntrada);
        System.out.println("Valor Unitário: " + valorUnitario);
        System.out.println("Valor em vendas: " + valorSaida);
        System.out.println("Quantidade em Estoque: " + quantidadeEstoque);
        System.out.println("Quantidade Vendida: " + quantidadeVendida);
        System.out.println("--------------------------");
    }
}
