package src;

import src.lista.ListaLigada;
import src.lista.Node;

public class Estoque {
    ListaLigada listaProdutos = new ListaLigada();

    public void adicionarProduto(Produto produto) {
        listaProdutos.adicionar(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    public void mostrarProdutos() {
        listaProdutos.mostrar();
    }

    public void ordenarProdutosPorNome() {
        listaProdutos.ordenarPorNome();
        System.out.println("Produtos ordenados por nome.");
    }

    public void reporEstoque(int codigo, int quantidade, double valorEntrada) {
        Produto produto = listaProdutos.buscarPorCodigo(codigo);
        if (produto != null) {
            produto.quantidadeEstoque += quantidade;
            produto.valorEntrada += produto.valorEntrada + valorEntrada;
            System.out.println("Estoque do produto " + produto.descricao + " atualizado.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void venderProduto(int codigo, int quantidade) {
        Produto produto = listaProdutos.buscarPorCodigo(codigo);
        if (produto != null) {
            if (produto.quantidadeEstoque >= quantidade) {
                produto.quantidadeEstoque -= quantidade;
                produto.quantidadeVendida += quantidade;
                produto.valorSaida += produto.valorUnitario* quantidade;
                System.out.println("Venda realizada com sucesso!");
            } else {
                System.out.println("Quantidade insuficiente no estoque.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void aplicarAlteracaoPrecos(double percentual) {
        Node atual = listaProdutos.head;
        while (atual != null) {
            atual.produto.valorSaida += atual.produto.valorSaida * (percentual / 100);
            atual = atual.next;
        }
        System.out.println("Alteração de preços aplicada.");
    }

    public void mostrarRelatorioVendas() {
        System.out.println("Relatório de Vendas:");
        Node atual = listaProdutos.head;
        while (atual != null) {
            Produto produto = atual.produto;
            if (produto.quantidadeVendida > 0) {
                System.out.println("Produto: " + produto.descricao);
                System.out.println("Quantidade Vendida: " + produto.quantidadeVendida);
                System.out.println("Total Vendido: R$ " + produto.valorSaida);
                System.out.println("--------------------------");
            }
            atual = atual.next;
        }
    }

    public void mostrarRelatorioEstoque() {
        System.out.println("Relatório de Estoque:");
        Node atual = listaProdutos.head;
        while (atual != null) {
            Produto produto = atual.produto;
            System.out.println("Produto: " + produto.descricao);
            System.out.println("Quantidade em Estoque: " + produto.quantidadeEstoque);
            System.out.println("--------------------------");
            atual = atual.next;
        }
    }
}
