package Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.Produtor;
import SistemaGrafico.Conexao;

public class ProdutorControle {
    public String incluiProdutor(Produtor p) {

        String retorno = "";
        String sql = "INSERT INTO produtor (nome, enderaco, cpf, telefone, email, ruralID) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getEndereco());
            ps.setString(3, p.getCpf());
            ps.setInt(4,p.getTelefone());
            ps.setString(5,p.getEmail());
            ps.setString(6,p.getRuralID());

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

    public String AlteraProdutor(Produtor p) {

        String retorno = "";
        String sql = "UPDATE produtor SET nome=?, enderaco=?, cpf=?, telefone=?, email=? WHERE ruralID =?;";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getEndereco());
            ps.setString(3, p.getCpf());
            ps.setInt(4,p.getTelefone());
            ps.setString(5,p.getEmail());
            ps.setString(6,p.getRuralID());
            
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

    public String ExcluiProdutor(String i) {

        String retorno = "";
        String sql = "delete from produtor where ruralID=?";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1,i);
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
            PreparedStatement ps = Con.prepareStatement("Select * from produtor");
            ResultSet rs = ps.executeQuery();
          while (rs.next()) {
                cont++;
            }
        } catch (Exception ex) {
            System.out.println("Erro " + ex.getMessage());
        }
        return cont;
    }

    public List<Produtor> ListarProdutor() {
        List<Produtor> listapd = new ArrayList<Produtor>();
        String sql = "select * from produtor";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produtor pd = new Produtor();
                pd.setNome(rs.getString("nome"));
                pd.setEndereco(rs.getString("enderaco"));
                pd.setCpf(rs.getString("cpf"));
                pd.setTelefone(rs.getInt("telefone"));
                pd.setEmail(rs.getString("email"));
                pd.setRuralID(rs.getString("ruralID"));
                
                listapd.add(pd);
            }

        } catch (Exception ex) {
            System.out.println("Erro " + ex.getMessage());
        }
        return listapd;
    }
}
