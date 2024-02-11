package Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.Produto;
import SistemaGrafico.Conexao;

public class ProdutoControle {

    public String incluiProduto(Produto pro) {

        String retorno = "";
        String sql = "INSERT INTO produto (nome, valor, descricao, produtoID) VALUES (?, ?, ?, ?);";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1, pro.getNome());
            ps.setDouble(2, pro.getValor());
            ps.setString(3, pro.getDescricao());
            ps.setString(4, pro.getProdutoID());
            
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

    public String AlteraProduto(Produto pro) {

        String retorno = "";
        String sql = "UPDATE produto SET nome=?, valor=?, descricao=? WHERE produtoID=?;";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1, pro.getNome());
            ps.setDouble(2, pro.getValor());
            ps.setString(3, pro.getDescricao());
            ps.setString(4, pro.getProdutoID());
            
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

    public String ExcluiProduto(String i) {

        String retorno = "";
        String sql = "delete from produto where produtoID=?";
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
            PreparedStatement ps = Con.prepareStatement("Select * from produto");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cont++;
            }
        } catch (Exception ex) {
            System.out.println("Erro " + ex.getMessage());
        }
        return cont;
    }

    public List<Produto> ListarProduto() {
        List<Produto> listap = new ArrayList<Produto>();
        String sql = "select * from produto";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto pro = new Produto();
                pro.setNome(rs.getString("nome"));
                pro.setValor(rs.getDouble("valor"));
                pro.setDescricao(rs.getString("descricao"));
                pro.setProdutoID(rs.getString("produtoID"));
                
                listap.add(pro);
            }

        } catch (Exception ex) {
            System.out.println("Erro " + ex.getMessage());
        }
        return listap;
    }
}
