package SistemaGrafico;

import Controle.ComercianteControle;
import Controle.ItensVendaControle;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import Controle.ProdutoControle;
import Controle.ProdutorControle;
import Controle.VendaControle;
import Modelo.Comerciante;
import Modelo.ItensVenda;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import Modelo.Produto;
import Modelo.Produtor;
import Modelo.Venda;

public class Relatorio {
    public static void main(String[] args) {
        Document documento = new Document();
        try {
            PdfWriter objpdf
                    = PdfWriter.getInstance(documento,
                            new FileOutputStream("relatorio.pdf"));
            documento.open();
            //informações do documento
            documento.addAuthor("Daniel Boemo");
            documento.addCreationDate();
            documento.addCreator("Sistema grafico");
            documento.addKeywords("tela,grafico,pdf");
            documento.addTitle("Relatorio teste");

            Paragraph paragrafo = new Paragraph();
            paragrafo.add("1 - Relação de produtos");
            documento.add(paragrafo);
            ProdutoControle prodC = new ProdutoControle();
            String linha = "";
            for (Produto produto : prodC.ListarProduto()) {
                linha += "_____________________";
                linha += "\nCódigo : " + produto.getProdutoID();
                linha += "\nDescrição : " + produto.getDescricao();
                linha += "\nNome : " + produto.getNome();
                linha += "\nValor : " + produto.getValor();
                linha += "\n_____________________";
                linha += "\n  ";
            }
            documento.add(new Paragraph(linha));

            Paragraph p = new Paragraph();
            p.add("2 - Relação de Venda");
            documento.add(p);
            VendaControle venda = new VendaControle();
            String l = "";
            for (Venda v : venda.ListarVenda()) {
                l += "_____________________";
                l += "\nData : " + v.getDataVendido();
                l += "\nEmpresaID : " + v.getEmpresaID();
                l += "\nHora : " + v.getHoraVendida();
                l += "\nRuralID : " + v.getRuralID();
                l += "\nVendaID : " + v.getVendaID();
                l += "\n_____________________";
                l += "\n  ";
            }
            documento.add(new Paragraph(l));

            Paragraph pp = new Paragraph();
            pp.add("3 - Relação de Produtor");
            documento.add(pp);
            ProdutorControle pro = new ProdutorControle();
            String lo = "";
            for (Produtor pe : pro.ListarProdutor()) {
                lo += "_____________________";
                lo += "\nCPF : " + pe.getCpf();
                lo += "\nEmail : " + pe.getEmail();
                lo += "\nEndereco : " + pe.getEndereco();
                lo += "\nNome : " + pe.getNome();
                lo += "\nRuralID : " + pe.getRuralID();
                lo += "\nTelefone : " + pe.getTelefone();
                lo += "\n_____________________";
                lo += "\n  ";
            }
            documento.add(new Paragraph(lo));

            Paragraph ppp = new Paragraph();
            ppp.add("4 - Relação de Comerciante");
            documento.add(ppp);
            ComercianteControle co = new ComercianteControle();
            String lol = "";
            for (Comerciante c : co.ListarComerciante()) {
                lol += "_____________________";
                lol += "\nCNPJ : " + c.getCnpj();
                lol += "\nCPF : " + c.getCpf();
                lol += "\nEmail : " + c.getEmail();
                lol += "\nEmpresaID : " + c.getEmpresaID();
                lol += "\nEndereco : " + c.getEnderaco();
                lol += "\nNome : " + c.getNome();
                lol += "\nTelefone : " + c.getTelefone();
                lol += "\n_____________________";
                lol += "\n  ";
            }
            documento.add(new Paragraph(lol));

            Paragraph pb = new Paragraph();
            pb.add("5 - Relação de ItensVenda");
            documento.add(pb);
            ItensVendaControle vd = new ItensVendaControle();
            String lu = "";
            for (ItensVenda iv : vd.ListarItensVenda()) {
                lu += "_____________________";
                lu += "\nItensID : " + iv.getItensID();
                lu += "\nProdutoID : " + iv.getProdutoID();
                lu += "\nVendaID : " + iv.getVendaID();
                lu += "\nQuantidade : " + iv.getQuantidade();
                lu += "\nValoR Total : " + iv.getValorTotal();
                lu += "\n_____________________";
                lu += "\n  ";
            }
            documento.add(new Paragraph(lu));

            documento.close();
            objpdf.close();
            abrearquivo("relatorio.pdf");
        } catch (Exception ex) {

        }

    }

    public static void abrearquivo(String arqpdf) {
        if (Desktop.isDesktopSupported()) {
            try {
                File meuarq = new File(arqpdf);
                Desktop.getDesktop().open(meuarq);
            } catch (Exception e) {
            }

        }
    }
    
    public void arq(){
        Document documento = new Document();
        try {
            PdfWriter objpdf
                    = PdfWriter.getInstance(documento,
                            new FileOutputStream("relatorio.pdf"));
            documento.open();
            //informações do documento
            documento.addAuthor("Daniel Boemo");
            documento.addCreationDate();
            documento.addCreator("Sistema grafico");
            documento.addKeywords("tela,grafico,pdf");
            documento.addTitle("Relatorio teste");

            Paragraph paragrafo = new Paragraph();
            paragrafo.add("1 - Relação de produtos");
            documento.add(paragrafo);
            ProdutoControle prodC = new ProdutoControle();
            String linha = "";
            for (Produto produto : prodC.ListarProduto()) {
                linha += "_____________________";
                linha += "\nCódigo : " + produto.getProdutoID();
                linha += "\nDescrição : " + produto.getDescricao();
                linha += "\nNome : " + produto.getNome();
                linha += "\nValor : " + produto.getValor();
                linha += "\n_____________________";
                linha += "\n  ";
            }
            documento.add(new Paragraph(linha));

            Paragraph p = new Paragraph();
            p.add("2 - Relação de Venda");
            documento.add(p);
            VendaControle venda = new VendaControle();
            String l = "";
            for (Venda v : venda.ListarVenda()) {
                l += "_____________________";
                l += "\nData : " + v.getDataVendido();
                l += "\nEmpresaID : " + v.getEmpresaID();
                l += "\nHora : " + v.getHoraVendida();
                l += "\nRuralID : " + v.getRuralID();
                l += "\nVendaID : " + v.getVendaID();
                l += "\n_____________________";
                l += "\n  ";
            }
            documento.add(new Paragraph(l));

            Paragraph pp = new Paragraph();
            pp.add("3 - Relação de Produtor");
            documento.add(pp);
            ProdutorControle pro = new ProdutorControle();
            String lo = "";
            for (Produtor pe : pro.ListarProdutor()) {
                lo += "_____________________";
                lo += "\nCPF : " + pe.getCpf();
                lo += "\nEmail : " + pe.getEmail();
                lo += "\nEndereco : " + pe.getEndereco();
                lo += "\nNome : " + pe.getNome();
                lo += "\nRuralID : " + pe.getRuralID();
                lo += "\nTelefone : " + pe.getTelefone();
                lo += "\n_____________________";
                lo += "\n  ";
            }
            documento.add(new Paragraph(lo));

            Paragraph ppp = new Paragraph();
            ppp.add("4 - Relação de Comerciante");
            documento.add(ppp);
            ComercianteControle co = new ComercianteControle();
            String lol = "";
            for (Comerciante c : co.ListarComerciante()) {
                lol += "_____________________";
                lol += "\nCNPJ : " + c.getCnpj();
                lol += "\nCPF : " + c.getCpf();
                lol += "\nEmail : " + c.getEmail();
                lol += "\nEmpresaID : " + c.getEmpresaID();
                lol += "\nEndereco : " + c.getEnderaco();
                lol += "\nNome : " + c.getNome();
                lol += "\nTelefone : " + c.getTelefone();
                lol += "\n_____________________";
                lol += "\n  ";
            }
            documento.add(new Paragraph(lol));

            Paragraph pb = new Paragraph();
            pb.add("5 - Relação de ItensVenda");
            documento.add(pb);
            ItensVendaControle vd = new ItensVendaControle();
            String lu = "";
            for (ItensVenda iv : vd.ListarItensVenda()) {
                lu += "_____________________";
                lu += "\nItensID : " + iv.getItensID();
                lu += "\nProdutoID : " + iv.getProdutoID();
                lu += "\nVendaID : " + iv.getVendaID();
                lu += "\nQuantidade : " + iv.getQuantidade();
                lu += "\nValoR Total : " + iv.getValorTotal();
                lu += "\n_____________________";
                lu += "\n  ";
            }
            documento.add(new Paragraph(lu));

            documento.close();
            objpdf.close();
            abrearquivo("relatorio.pdf");
        } catch (Exception ex) {

        }
    }

    /*public void abrearquivo01(String arqpdf) {
        if (Desktop.isDesktopSupported()) {
            try {
                File meuarq = new File(arqpdf);
                Desktop.getDesktop().open(meuarq);
            } catch (Exception e) {
            }

        }
    }*/

}
