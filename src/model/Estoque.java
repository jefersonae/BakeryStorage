package src.model;

import src.model.lista.ListaLigada;

public class Estoque {
    private final ListaLigada produtos;

    public Estoque() {
        this.produtos = new ListaLigada();
    }

    public void adicionarProduto(Produto produto) {
        produtos.adicionar(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remover(produto);
    }

    public void mostrarPedido() {
        System.out.println("Lista de Produtos no Pedido:");
        produtos.exibir();
    }

    public int contarProdutos() {
        return produtos.contar();
    }
}