package src.lista;

import src.Produto;

public class ListaLigada {
    public Node head;

    public ListaLigada() {
        this.head = null;
    }

    // Adiciona um produto ao final da lista
    public void adicionar(Produto produto) {
        Node novoNode = new Node(produto);
        if (head == null) {
            head = novoNode;
        } else {
            Node atual = head;
            while (atual.next != null) {
                atual = atual.next;
            }
            atual.next = novoNode;
        }
    }

    // Exibe todos os produtos da lista
    public void mostrar() {
        if (head == null) {
            System.out.println("Nenhum produto no estoque.");
        } else {
            Node atual = head;
            while (atual != null) {
                atual.produto.mostrarProduto();
                atual = atual.next;
            }
        }
    }

    // Ordena os produtos por nome (descrição)
    public void ordenarPorNome() {
        if (head == null || head.next == null) {
            return; // Lista vazia ou com um único elemento
        }

        boolean trocou;
        do {
            trocou = false;
            Node atual = head;
            Node anterior = null;

            while (atual.next != null) {
                Node proximo = atual.next;
                if (atual.produto.descricao.compareTo(proximo.produto.descricao) > 0) {
                    // Troca os produtos
                    if (anterior == null) {
                        head = proximo;
                    } else {
                        anterior.next = proximo;
                    }
                    atual.next = proximo.next;
                    proximo.next = atual;
                    trocou = true;
                }
                anterior = atual;
                atual = atual.next;
            }
        } while (trocou);
    }

    // Busca um produto pelo código
    public Produto buscarPorCodigo(int codigo) {
        Node atual = head;
        while (atual != null) {
            if (atual.produto.codigo == codigo) {
                return atual.produto;
            }
            atual = atual.next;
        }
        return null; // Produto não encontrado
    }
}
