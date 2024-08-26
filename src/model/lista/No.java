package src.model.lista;

import src.model.Produto;

public class No {
    private Produto produto;
    private No proximo;

    public No(Produto produto) {
        this.produto = produto;
        this.proximo = null;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
