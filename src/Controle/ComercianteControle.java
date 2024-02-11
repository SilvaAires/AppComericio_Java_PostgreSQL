package Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.Comerciante;
import SistemaGrafico.Conexao;

public class ComercianteControle {
    public String incluiComerciante(Comerciante com) {

        String retorno = "";
        String sql = "INSERT INTO comerciante (nome, enderaco, cpf, telefone, email, cnpj, empresaID) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1, com.getNome());
            ps.setString(2, com.getEnderaco());
            ps.setString(3, com.getCpf());
            ps.setInt(4, com.getTelefone());
            ps.setString(5, com.getEmail());
            ps.setString(6, com.getCnpj());
            ps.setString(7, com.getEmpresaID());

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

    public String AlteraComerciante(Comerciante com) {

        String retorno = "";
        String sql = "UPDATE comerciante SET nome=?, enderaco=?, cpf=?, telefone=?, email=?, cnpj=? WHERE empresaID=?;";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1, com.getNome());
            ps.setString(2, com.getEnderaco());
            ps.setString(3, com.getCpf());
            ps.setInt(4, com.getTelefone());
            ps.setString(5, com.getEmail());
            ps.setString(6, com.getCnpj());
            ps.setString(7, com.getEmpresaID());

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

    public String ExcluiComerciante(String i) {
        String retorno = "";
        String sql = "delete from comerciante where empresaID=?";
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
            PreparedStatement ps = Con.prepareStatement("Select * from comerciante");
            ResultSet rs = ps.executeQuery();
          while (rs.next()) {
                cont++;
            }
        } catch (Exception ex) {
            System.out.println("Erro " + ex.getMessage());
        }
        return cont;
    }

    public List<Comerciante> ListarComerciante() {
        List<Comerciante> listac = new ArrayList<Comerciante>();
        String sql = "select * from comerciante";
        try {
            Connection Con = Conexao.Abrirconexao();
            PreparedStatement ps = Con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comerciante com = new Comerciante();
                com.setNome(rs.getString("nome"));
                com.setEnderaco(rs.getString("enderaco"));
                com.setCpf(rs.getString("cpf"));
                com.setTelefone(rs.getInt("telefone"));
                com.setEmail(rs.getString("email"));
                com.setCnpj(rs.getString("cnpj"));
                com.setEmpresaID(rs.getString("empresaID"));
                listac.add(com);
            }

        } catch (Exception ex) {
            System.out.println("Erro " + ex.getMessage());
        }
        return listac;
    }
}
