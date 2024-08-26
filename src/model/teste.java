package src.model;

import src.model.lista.ListaLigada;

public class teste {
    public static void main(String[] args) {
        ListaLigada pedidos = new ListaLigada();
        ProdutoVendavel doceLeite = new ProdutoVendavel(1,"doce feito de leite","Nestlé", 2, 2.5);
        pedidos.adicionar(doceLeite);
        System.out.println(pedidos.contar());
        pedidos.exibir();
    }
}
