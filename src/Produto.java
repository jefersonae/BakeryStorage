package src;

public class Produto {
    public int codigo;
    public String descricao;
    String marca;
    double valorEntrada;
    double valorSaida;
    int quantidadeEstoque;
    int quantidadeVendida;

    public Produto(int codigo, String descricao, String marca, double valorEntrada, double valorSaida, int quantidadeEstoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.marca = marca;
        this.valorEntrada = valorEntrada;
        this.valorSaida = valorSaida;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeVendida = 0;
    }

    public void mostrarProduto() {
        System.out.println("Código: " + codigo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Marca: " + marca);
        System.out.println("Valor de Entrada: " + valorEntrada);
        System.out.println("Valor de Saída: " + valorSaida);
        System.out.println("Quantidade em Estoque: " + quantidadeEstoque);
        System.out.println("Quantidade Vendida: " + quantidadeVendida);
        System.out.println("--------------------------");
    }
}
