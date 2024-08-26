package src.model;

public abstract class Produto {
    private int cod;
    private String descricao;
    private String marca;
    private int qnt;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "cod=" + cod +
                ", descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}