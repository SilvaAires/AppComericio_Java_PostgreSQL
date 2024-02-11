package Modelo;

public class ItensVenda {
    private String vendaID;
    private String produtoID;
    private int	quantidade;
    private double valorTotal;
    private String itensID;

    public ItensVenda(String vendaID, String produtoID, int quantidade, double valorTotal, String itensID) {
        this.vendaID = vendaID;
        this.produtoID = produtoID;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.itensID = itensID;
    }

    public ItensVenda() {
    }

    public String getVendaID() {
        return vendaID;
    }

    public void setVendaID(String vendaID) {
        this.vendaID = vendaID;
    }

    public String getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(String produtoID) {
        this.produtoID = produtoID;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getItensID() {
        return itensID;
    }

    public void setItensID(String itensID) {
        this.itensID = itensID;
    }

    public String toString() {
        return "VendaID: " + vendaID + "\nProdutoID: " + produtoID + 
                "\nQuantidade: " + quantidade + 
                "\nValorTotal: " + valorTotal + "\nItensID: " + itensID;
    }
}
