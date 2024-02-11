package Controle;

import Modelo.ItensVenda;
import SistemaGrafico.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItensVendaControle {
    public String incluiItensVenda(ItensVenda venda) {

        String retorno = "";
        String sql = "INSERT INTO itensVenda (vendaID, produtoID, quantidade, valorTotal, itensID) VALUES (?, ?, ?, ?, ?);";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1, venda.getVendaID());
            ps.setString(2, venda.getProdutoID());
            ps.setInt(3, venda.getQuantidade());
            ps.setDouble(4, venda.getValorTotal());
            ps.setString(5, venda.getItensID());

            if (ps.executeUpdate() > 0) {
                retorno = "Inclusão realizada ";
            } else {
                retorno = "Erro ao incluir";
            }
        } catch (Exception ex) {
            retorno = "Erro ao tentar incluir :" + ex.getMessage();
        }
        return retorno;
    }

    public String AlteraItensVenda(ItensVenda venda) {

        String retorno = "";
        String sql = "UPDATE itensVenda SET vendaID=?, produtoID=?, quantidade=?, valorTotal=? WHERE itensID=?;";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1, venda.getVendaID());
            ps.setString(2, venda.getProdutoID());
            ps.setInt(3, venda.getQuantidade());
            ps.setDouble(4, venda.getValorTotal());
            ps.setString(5, venda.getItensID());

            if (ps.executeUpdate() > 0) {
                retorno = "Alteração realizada ";
            } else {
                retorno = "Erro ao tentar alterar";
            }
        } catch (Exception ex) {
            retorno = "Erro Alteração " + ex.getMessage();

        }
        return retorno;
    }

    public String ExcluiItensVenda(String i) {
        String retorno = "";
        String sql = "delete from itensVenda where itensID=?";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1, i);
            if (ps.executeUpdate() > 0) {
                retorno = "Exclusão realizada ";
            } else {
                retorno = "Erro ao tentar excluir";
            }
        } catch (Exception ex) {
            retorno = "Erro Excluir " + ex.getMessage();

        }
        return retorno;
    }

    public int contalinhas() {
        int cont = 1;
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement("Select * from itensVenda");
            ResultSet rs = ps.executeQuery();
          while (rs.next()) {
                cont++;
            }
        } catch (Exception ex) {
            System.out.println("Erro " + ex.getMessage());
        }
        return cont;
    }

    public List<ItensVenda> ListarItensVenda() {
        List<ItensVenda> listac = new ArrayList<ItensVenda>();
        String sql = "select * from itensVenda";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ItensVenda venda = new ItensVenda();
                venda.setVendaID(rs.getString("vendaID"));
                venda.setProdutoID(rs.getString("produtoID"));
                venda.setQuantidade(rs.getInt("quantidade"));
                venda.setValorTotal(rs.getDouble("valorTotal"));
                venda.setItensID(rs.getString("itensID"));
                listac.add(venda);
            }

        } catch (Exception ex) {
            System.out.println("Erro " + ex.getMessage());
        }
        return listac;
    }
}
