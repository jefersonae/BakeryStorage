package src.model.lista;

import src.model.Produto;

public class ListaLigada {
    private No head;

    public ListaLigada() {
        this.head = null;
    }

    // Método para adicionar um produto ao final da lista
    public void adicionar(Produto produto) {
        No novoNo = new No(produto);
        if (head == null) {
            head = novoNo;
        } else {
            No atual = head;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
    }

    // Método para exibir todos os produtos da lista
    public void exibir() {
        No atual = head;
        while (atual != null) {
            System.out.println(atual.getProduto().toString());
            atual = atual.getProximo();
        }
    }

    // Método para remover um produto específico da lista
    public void remover(Produto produto) {
        if (head == null) return;

        if (head.getProduto().equals(produto)) {
            head = head.getProximo();
            return;
        }

        No atual = head;
        while (atual.getProximo() != null) {
            if (atual.getProximo().getProduto().equals(produto)) {
                atual.setProximo(atual.getProximo().getProximo());
                return;
            }
            atual = atual.getProximo();
        }
    }

    // Método para verificar se a lista está vazia
    public boolean estaVazia() {
        return head == null;
    }

    // Método para contar o número de elementos na lista
    public int contar() {
        int count = 0;
        No atual = head;
        while (atual != null) {
            count++;
            atual = atual.getProximo();
        }
        return count;
    }
}