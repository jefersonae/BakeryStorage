package src.lista;

import src.Produto;

public class Node {
    public Produto produto;
    public Node next;

    Node(Produto produto) {
        this.produto = produto;
        this.next = null;
    }
}
