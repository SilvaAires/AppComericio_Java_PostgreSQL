package Modelo;

public class Produto {
    private String nome;
    private double valor;
    private String descricao;
    private String produtoID;

    public Produto(String nome, double valor, String descricao, String produtoID) {
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.produtoID = produtoID;
    }

    public Produto() {
    }

    public String getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(String produtoID) {
        this.produtoID = produtoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return "Nome: " + nome + "\nValor: " + valor + "\nDescricao: " + descricao + "\nProdutoID: " + produtoID;
    }
    
}
