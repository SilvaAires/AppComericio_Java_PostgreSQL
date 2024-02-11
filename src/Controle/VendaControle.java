package Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.Venda;
import SistemaGrafico.Conexao;

public class VendaControle {
    public String incluiVenda(Venda v) {

        String retorno = "";
        String sql = "INSERT INTO venda (empresaID, ruralID, dataVendido, horaVendida, vendaID) VALUES (?, ?, ?, ?, ?);";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1, v.getEmpresaID());
            ps.setString(2, v.getRuralID());
            ps.setString(3, v.getDataVendido());
            ps.setString(4, v.getHoraVendida());
            ps.setString(5, v.getVendaID());

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

    public String AlteraVenda(Venda v) {

        String retorno = "";
        String sql = "UPDATE venda SET empresaID=?, ruralID=?, dataVendido=?, horaVendida=? WHERE vendaID=?;";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1, v.getEmpresaID());
            ps.setString(2, v.getRuralID());
            ps.setString(3, v.getDataVendido());
            ps.setString(4, v.getHoraVendida());
            ps.setString(5, v.getVendaID());
            
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

    public String ExcluiVenda(String i) {

        String retorno = "";
        String sql = "delete from venda where vendaID=?";
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
            PreparedStatement ps = Con.prepareStatement("Select * from venda");
            ResultSet rs = ps.executeQuery();
          while (rs.next()) {
                cont++;
            }
        } catch (Exception ex) {
            System.out.println("Erro " + ex.getMessage());
        }
        return cont;
    }

    public List<Venda> ListarVenda() {
        List<Venda> listav = new ArrayList<Venda>();
        String sql = "select * from venda";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Venda v = new Venda();
                v.setEmpresaID(rs.getString("empresaID"));
                v.setRuralID(rs.getString("ruralID"));
                v.setDataVendido(rs.getString("dataVendido"));
                v.setHoraVendida(rs.getString("horaVendida"));
                v.setVendaID(rs.getString("vendaID"));
                listav.add(v);
            }

        } catch (Exception ex) {
            System.out.println("Erro " + ex.getMessage());
        }
        return listav;
    }
}
