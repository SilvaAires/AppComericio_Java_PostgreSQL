package SistemaGrafico;

import java.io.UnsupportedEncodingException;
import jexer.TAction;
import jexer.TApplication;
import jexer.TField;
import jexer.TTableWidget;
import jexer.TWindow;
import jexer.event.TMenuEvent;
import jexer.menu.TMenu;
import Modelo.Comerciante;
import Modelo.Produtor;
import Modelo.Produto;
import Modelo.Venda;
import Controle.ComercianteControle;
import Controle.ItensVendaControle;
import Controle.ProdutoControle;
import Controle.ProdutorControle;
import Controle.VendaControle;
import Modelo.ItensVenda;
import jexer.TList;
import jexer.TWidget;

public class SistemaGrafico extends TApplication {

    public SistemaGrafico() throws Exception {
        super(TApplication.BackendType.SWING);

        menu01();
        menu02();
        config();

    }

    public void menu01() {
        TMenu menucad = addMenu("&Cadastros");
        menucad.addItem(1001, "&Comerciante");
        menucad.addItem(1002, "&Produto");
        menucad.addItem(1003, "&Produtor");
        menucad.addItem(1004, "&Venda");
        menucad.addItem(1005, "&ItensVenda");
    }

    public void menu02() {
        TMenu menucad = addMenu("&Relatórios");
        menucad.addItem(2001, "&Comerciante");
        menucad.addItem(2002, "&Produto");
        menucad.addItem(2003, "&Produtor");
        menucad.addItem(2004, "&Venda");
        menucad.addItem(2005, "&ItensVenda");
    }

    public void config() {
        TMenu menucad = addMenu("&Ferramentas");
        menucad.addItem(3001, "&Excluir Comerciante");
        menucad.addItem(3002, "&Alterar Comerciante");
        menucad.addItem(3003, "&Excluir Venda");
        menucad.addItem(3004, "&Alterar Venda");
        menucad.addItem(3005, "&Excluir Produto");
        menucad.addItem(3006, "&Alterar Produto");
        menucad.addItem(3007, "&Excluir Produtor");
        menucad.addItem(3008, "&Alterar Produtor");
        menucad.addItem(3009, "&Excluir ItensVenda");
        menucad.addItem(3010, "&Alterar ItensVenda");
        menucad.addItem(3011, "&Imprimir");
        menucad.addItem(3000, "&Sair");
    }
    
    public void TelaListarItensVenda() {
        ItensVendaControle itemC = new ItensVendaControle();
        TWindow TListItem = new TWindow(this, "", 50, 20);
        TTableWidget tabItem
                = new TTableWidget(TListItem, 0, 2, 70, itemC.contalinhas());
        tabItem.setColumnLabel(0,"vendaID");
        tabItem.setColumnWidth(0, 9);
        tabItem.setColumnLabel(1,"produtoID");
        tabItem.setColumnWidth(1, 11);
        tabItem.setColumnLabel(2,"quantidade");
        tabItem.setColumnWidth(2, 12);
        tabItem.setColumnLabel(3,"valorTotal");
        tabItem.setColumnWidth(3, 12);
        tabItem.setColumnLabel(4,"itensID");
        tabItem.setColumnWidth(4, 10);
        tabItem.setColumnLabel(5," ");
        tabItem.setColumnWidth(5, 1);

        int i = 0;
        for (ItensVenda item : itemC.ListarItensVenda()) {
            tabItem.setCellText(0, i, "" + item.getVendaID());
            tabItem.setCellText(1, i, "" + item.getProdutoID());
            tabItem.setCellText(2, i, "" + item.getQuantidade());
            tabItem.setCellText(3, i, "" + item.getValorTotal());
            tabItem.setCellText(4, i, "" + item.getItensID());
            
            i++;
        }

    }
    
    public void TelaExcluirItensVenda() {
        TWindow TCadItem = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadItem.addLabel("Excluir item", 0, linha);
        linha += 2;

        TCadItem.addLabel("ItensID", 0, linha);
        TField ItensIDitem = new TField(TCadItem, 10, linha, 50, true);
        linha += 2;

        TCadItem.addButton("Excluir", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    ItensVenda item = new ItensVenda();
                    item.setItensID(ItensIDitem.getText());

                    ItensVendaControle itemC = new ItensVendaControle();
                    TCadItem.getApplication().messageBox("Excluir Item",
                            itemC.ExcluiItensVenda(item.getItensID()));

                } catch (Exception e) {
                    TCadItem.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }
    
    public void TelaCadastroItensVenda() {
        TWindow TCadItem = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadItem.addLabel("Cadastro de ItensVenda", 0, linha);
        linha += 2;

        TCadItem.addLabel("vendaID", 0, linha);
        TField vendaIDitem = new TField(TCadItem, 10, linha, 50, true);
        linha += 2;

        TCadItem.addLabel("produtoID", 0, linha);
        TField produtoIDitem = new TField(TCadItem, 10, linha, 50, true);
        linha += 2;

        TCadItem.addLabel("quantidade", 0, linha);
        TField quantidadeItem = new TField(TCadItem, 10, linha, 50, true);
        linha += 2;

        TCadItem.addLabel("valorTotal", 0, linha);
        TField valorTotalitem = new TField(TCadItem, 10, linha, 50, true);
        linha += 2;
        
        TCadItem.addLabel("itensID", 0, linha);
        TField itensIDitem = new TField(TCadItem, 10, linha, 50, true);
        linha += 2;

        TCadItem.addButton("Incluir", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    ItensVenda item = new ItensVenda();
                    item.setVendaID(vendaIDitem.getText());
                    item.setProdutoID(produtoIDitem.getText());
                    item.setQuantidade(Integer.parseInt(quantidadeItem.getText()));
                    item.setValorTotal(Double.parseDouble(valorTotalitem.getText()));
                    item.setItensID(itensIDitem.getText());

                    ItensVendaControle itemC = new ItensVendaControle();
                    TCadItem.getApplication().messageBox("Cadastro Item",
                            itemC.incluiItensVenda(item));

                } catch (Exception e) {
                    TCadItem.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }
    
    public void TelaAlterarItensVenda() {
        TWindow TCadItem = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadItem.addLabel("Alterar ItensVenda", 0, linha);
        linha += 2;

        TCadItem.addLabel("vendaID", 0, linha);
        TField vendaIDitem = new TField(TCadItem, 10, linha, 50, true);
        linha += 2;

        TCadItem.addLabel("produtoID", 0, linha);
        TField produtoIDitem = new TField(TCadItem, 10, linha, 50, true);
        linha += 2;

        TCadItem.addLabel("quantidade", 0, linha);
        TField quantidadeItem = new TField(TCadItem, 10, linha, 50, true);
        linha += 2;

        TCadItem.addLabel("valorTotal", 0, linha);
        TField valorTotalitem = new TField(TCadItem, 10, linha, 50, true);
        linha += 2;
        
        TCadItem.addLabel("itensID", 0, linha);
        TField itensIDitem = new TField(TCadItem, 10, linha, 50, true);
        linha += 2;

        TCadItem.addButton("Alterar", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    ItensVenda item = new ItensVenda();
                    item.setVendaID(vendaIDitem.getText());
                    item.setProdutoID(produtoIDitem.getText());
                    item.setQuantidade(Integer.parseInt(quantidadeItem.getText()));
                    item.setValorTotal(Double.parseDouble(valorTotalitem.getText()));
                    item.setItensID(itensIDitem.getText());

                    ItensVendaControle itemC = new ItensVendaControle();
                    TCadItem.getApplication().messageBox("Alterar Item",
                            itemC.AlteraItensVenda(item));

                } catch (Exception e) {
                    TCadItem.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }

    public void TelaListarProduto() {
        ProdutoControle prodC = new ProdutoControle();
        TWindow TListProd = new TWindow(this, "", 50, 20);
        TTableWidget tabProd
                = new TTableWidget(TListProd, 0, 2, 50, prodC.contalinhas());
        tabProd.setColumnLabel(0, "Nome");
        tabProd.setColumnWidth(0, 6);
        tabProd.setColumnLabel(1, "Valor");
        tabProd.setColumnWidth(1, 7);
        tabProd.setColumnLabel(2, "Descricao");
        tabProd.setColumnWidth(2, 11);
        tabProd.setColumnLabel(3, "ProdutoID");
        tabProd.setColumnWidth(3, 11);
        tabProd.setColumnLabel(4, " ");
        tabProd.setColumnWidth(4, 1);

        int i = 0;
        for (Produto prod : prodC.ListarProduto()) {
            tabProd.setCellText(0, i, "" + prod.getNome());
            tabProd.setCellText(1, i, "" + prod.getValor());
            tabProd.setCellText(2, i, "" + prod.getDescricao());
            tabProd.setCellText(3, i, "" + prod.getProdutoID());
            i++;
        }

    }
    
    public void TelaExcluirProduto() {
        TWindow TCadProd = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadProd.addLabel("Excluir produto", 0, linha);
        linha += 2;

        TCadProd.addLabel("ProdutoID", 0, linha);
        TField produtoIDprod = new TField(TCadProd, 10, linha, 50, true);
        linha += 2;

        TCadProd.addButton("Excluir", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    Produto produto = new Produto();
                    produto.setProdutoID(produtoIDprod.getText());

                    ProdutoControle prodC = new ProdutoControle();
                    TCadProd.getApplication().messageBox("Excluir Produto",
                            prodC.ExcluiProduto(produto.getProdutoID()));

                } catch (Exception e) {
                    TCadProd.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }

    public void TelaCadastroProduto() {
        TWindow TCadProd = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadProd.addLabel("Cadastro de produto", 0, linha);
        linha += 2;

        TCadProd.addLabel("nome", 0, linha);
        TField nomeprod = new TField(TCadProd, 10, linha, 50, true);
        linha += 2;

        TCadProd.addLabel("valor", 0, linha);
        TField valorprod = new TField(TCadProd, 10, linha, 50, true);
        linha += 2;

        TCadProd.addLabel("descricao", 0, linha);
        TField descricaoprod = new TField(TCadProd, 10, linha, 50, true);
        linha += 2;

        TCadProd.addLabel("produtoID", 0, linha);
        TField produtoIDprod = new TField(TCadProd, 10, linha, 50, true);
        linha += 2;

        TCadProd.addButton("Incluir", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    Produto produto = new Produto();
                    produto.setNome(nomeprod.getText());
                    produto.setValor(Double.parseDouble(valorprod.getText()));
                    produto.setDescricao(descricaoprod.getText());
                    produto.setProdutoID(produtoIDprod.getText());

                    ProdutoControle prodC = new ProdutoControle();
                    TCadProd.getApplication().messageBox("Cadastro Produto",
                            prodC.incluiProduto(produto));

                } catch (Exception e) {
                    TCadProd.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }
    
    public void TelaAlterarProduto() {
        TWindow TCadProd = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadProd.addLabel("Alterar produto", 0, linha);
        linha += 2;

        TCadProd.addLabel("nome", 0, linha);
        TField nomeprod = new TField(TCadProd, 10, linha, 50, true);
        linha += 2;

        TCadProd.addLabel("valor", 0, linha);
        TField valorprod = new TField(TCadProd, 10, linha, 50, true);
        linha += 2;

        TCadProd.addLabel("descricao", 0, linha);
        TField descricaoprod = new TField(TCadProd, 10, linha, 50, true);
        linha += 2;

        TCadProd.addLabel("produtoID", 0, linha);
        TField produtoIDprod = new TField(TCadProd, 10, linha, 50, true);
        linha += 2;

        TCadProd.addButton("Alterar", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    Produto produto = new Produto();
                    produto.setNome(nomeprod.getText());
                    produto.setValor(Double.parseDouble(valorprod.getText()));
                    produto.setDescricao(descricaoprod.getText());
                    produto.setProdutoID(produtoIDprod.getText());

                    ProdutoControle prodC = new ProdutoControle();
                    TCadProd.getApplication().messageBox("Alterar Produto",
                            prodC.AlteraProduto(produto));

                } catch (Exception e) {
                    TCadProd.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }

    public void TelaListarComerciante() {
        ComercianteControle comC = new ComercianteControle();
        TWindow TListComer = new TWindow(this, "", 50,20);
        TTableWidget tabComer
                = new TTableWidget(TListComer, 0,2, 80, comC.contalinhas());
        
        tabComer.setColumnLabel(0, "Nome");
        tabComer.setColumnLabel(1, "Endereço");
        tabComer.setColumnWidth(1, 10);
        tabComer.setColumnLabel(2, "CPF");
        tabComer.setColumnLabel(3, "Telefone");
        tabComer.setColumnWidth(3, 10);
        tabComer.setColumnLabel(4, "Email");
        tabComer.setColumnLabel(5, "CNPJ");
        tabComer.setColumnLabel(6, "EmpresaID");
        tabComer.setColumnWidth(6, 10);
        tabComer.setColumnLabel(7, " ");
        tabComer.setColumnWidth(7, 1);

        int i = 0;
        for (Comerciante com : comC.ListarComerciante()) {
            tabComer.setCellText(0, i, "" + com.getNome());
            tabComer.setCellText(1, i, "" + com.getEnderaco());
            tabComer.setCellText(2, i, "" + com.getCpf());
            tabComer.setCellText(3, i, "" + com.getTelefone());
            tabComer.setCellText(4, i, "" + com.getEmail());
            tabComer.setCellText(5, i, "" + com.getCnpj());
            tabComer.setCellText(6, i, "" + com.getEmpresaID());
            i++;
        }

    }
    
    public void TelaExcluirComerciante() {
        TWindow TCadPr = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadPr.addLabel("Excluir Comerciante", 0, linha);
        linha += 2;

        TCadPr.addLabel("EmpresaID", 0, linha);
        TField empresaIDCo = new TField(TCadPr, 10, linha, 50, true);
        linha += 2;

        TCadPr.addButton("Excluir", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    Comerciante co = new Comerciante();
                    co.setEmpresaID(empresaIDCo.getText());

                    ComercianteControle comC = new ComercianteControle();
                    TCadPr.getApplication().messageBox("Cadastro Comerciante",
                            comC.ExcluiComerciante(co.getEmpresaID()));
                    
                } catch (Exception e) {
                    TCadPr.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }

    public void TelaCadastroComerciante() {
        TWindow TCadCo = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadCo.addLabel("Cadastro de Comerciante", 0, linha);
        linha += 2;

        TCadCo.addLabel("nome", 0, linha);
        TField nomeCo = new TField(TCadCo, 10, linha, 50, true);
        linha += 2;

        TCadCo.addLabel("enderaco", 0, linha);
        TField enderacoCo = new TField(TCadCo, 10, linha, 50, true);
        linha += 2;

        TCadCo.addLabel("cpf", 0, linha);
        TField cpfCo = new TField(TCadCo, 10, linha, 50, true);
        linha += 2;

        TCadCo.addLabel("telefone", 0, linha);
        TField telefoneCo = new TField(TCadCo, 10, linha, 50, true);
        linha += 2;

        TCadCo.addLabel("email", 0, linha);
        TField emailCo = new TField(TCadCo, 10, linha, 50, true);
        linha += 2;

        TCadCo.addLabel("cnpj", 0, linha);
        TField cnpjCo = new TField(TCadCo, 10, linha, 50, true);
        linha += 2;

        TCadCo.addLabel("empresaID", 0, linha);
        TField empresaIDCo = new TField(TCadCo, 10, linha, 50, true);
        linha += 2;

        TCadCo.addButton("Incluir", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    Comerciante co = new Comerciante();
                    co.setNome(nomeCo.getText());
                    co.setEnderaco(enderacoCo.getText());
                    co.setCpf(cpfCo.getText());
                    co.setTelefone(Integer.parseInt(telefoneCo.getText()));
                    co.setEmail(emailCo.getText());
                    co.setCnpj(cnpjCo.getText());
                    co.setEmpresaID(empresaIDCo.getText());

                    ComercianteControle comC = new ComercianteControle();
                    TCadCo.getApplication().messageBox("Cadastro Comerciante",
                            comC.incluiComerciante(co));

                } catch (Exception e) {
                    TCadCo.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }
    
    public void TelaAlterarComerciante() {
        TWindow TCadCo = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadCo.addLabel("Alterar Comerciante", 0, linha);
        linha += 2;

        TCadCo.addLabel("nome", 0, linha);
        TField nomeCo = new TField(TCadCo, 10, linha, 50, true);
        linha += 2;

        TCadCo.addLabel("enderaco", 0, linha);
        TField enderacoCo = new TField(TCadCo, 10, linha, 50, true);
        linha += 2;

        TCadCo.addLabel("cpf", 0, linha);
        TField cpfCo = new TField(TCadCo, 10, linha, 50, true);
        linha += 2;

        TCadCo.addLabel("telefone", 0, linha);
        TField telefoneCo = new TField(TCadCo, 10, linha, 50, true);
        linha += 2;

        TCadCo.addLabel("email", 0, linha);
        TField emailCo = new TField(TCadCo, 10, linha, 50, true);
        linha += 2;

        TCadCo.addLabel("cnpj", 0, linha);
        TField cnpjCo = new TField(TCadCo, 10, linha, 50, true);
        linha += 2;

        TCadCo.addLabel("empresaID", 0, linha);
        TField empresaIDCo = new TField(TCadCo, 10, linha, 50, true);
        linha += 2;

        TCadCo.addButton("Alterar", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    Comerciante co = new Comerciante();
                    co.setNome(nomeCo.getText());
                    co.setEnderaco(enderacoCo.getText());
                    co.setCpf(cpfCo.getText());
                    co.setTelefone(Integer.parseInt(telefoneCo.getText()));
                    co.setEmail(emailCo.getText());
                    co.setCnpj(cnpjCo.getText());
                    co.setEmpresaID(empresaIDCo.getText());

                    ComercianteControle comC = new ComercianteControle();
                    TCadCo.getApplication().messageBox("Alterar Comerciante",
                            comC.AlteraComerciante(co));

                } catch (Exception e) {
                    TCadCo.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }

    public void TelaListarProdutor() {
        ProdutorControle prC = new ProdutorControle();
        TWindow TListProd = new TWindow(this, "", 50, 20);
        TTableWidget tabProd
                = new TTableWidget(TListProd, 0, 2, 70, prC.contalinhas());
        tabProd.setColumnLabel(0, "Nome");
        tabProd.setColumnWidth(0, 10);
        tabProd.setColumnLabel(1, "Endereço");
        tabProd.setColumnWidth(1, 10);
        tabProd.setColumnLabel(2, "CPF");
        tabProd.setColumnWidth(2, 5);
        tabProd.setColumnLabel(3, "Telefone");
        tabProd.setColumnWidth(3, 10);
        tabProd.setColumnLabel(4, "Email");
        tabProd.setColumnWidth(4, 7);
        tabProd.setColumnLabel(5, "ruralID");
        tabProd.setColumnWidth(5, 9);
        tabProd.setColumnLabel(6, " ");
        tabProd.setColumnWidth(6, 1);

        int i = 0;
        for (Produtor pr : prC.ListarProdutor()) {
            tabProd.setCellText(0, i, "" + pr.getNome());
            tabProd.setCellText(1, i, "" + pr.getEndereco());
            tabProd.setCellText(2, i, "" + pr.getCpf());
            tabProd.setCellText(3, i, "" + pr.getTelefone());
            tabProd.setCellText(4, i, "" + pr.getEmail());
            tabProd.setCellText(5, i, "" + pr.getRuralID());
            i++;
        }
    }
    
    public void TelaExcluirProdutor() {
        TWindow TCadPr = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadPr.addLabel("Excluir de Produtor", 0, linha);
        linha += 2;

        TCadPr.addLabel("RuralID", 0, linha);
        TField ruralIDPr = new TField(TCadPr, 10, linha, 50, true);
        linha += 2;

        TCadPr.addButton("Excluir", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    Produtor pr = new Produtor();
                    pr.setRuralID(ruralIDPr.getText());
                    
                    ProdutorControle prC = new ProdutorControle();
                    TCadPr.getApplication().messageBox("Exclui Produtor",
                            prC.ExcluiProdutor(pr.getRuralID()));

                } catch (Exception e) {
                    TCadPr.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }

    public void TelaCadastroProdutor() {
        TWindow TCadPr = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadPr.addLabel("Cadastro de Produtor", 0, linha);
        linha += 2;

        TCadPr.addLabel("nome", 0, linha);
        TField nomePr = new TField(TCadPr, 10, linha, 50, true);
        linha += 2;

        TCadPr.addLabel("enderaco", 0, linha);
        TField enderacoPr = new TField(TCadPr, 10, linha, 50, true);
        linha += 2;

        TCadPr.addLabel("cpf", 0, linha);
        TField cpfPr = new TField(TCadPr, 10, linha, 50, true);
        linha += 2;

        TCadPr.addLabel("telefone", 0, linha);
        TField telefonePr = new TField(TCadPr, 10, linha, 50, true);
        linha += 2;

        TCadPr.addLabel("email", 0, linha);
        TField emailPr = new TField(TCadPr, 10, linha, 50, true);
        linha += 2;

        TCadPr.addLabel("ruralID", 0, linha);
        TField ruralIDPr = new TField(TCadPr, 10, linha, 50, true);
        linha += 2;

        TCadPr.addButton("Incluir", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    Produtor pr = new Produtor();
                    pr.setNome(nomePr.getText());
                    pr.setEndereco(enderacoPr.getText());
                    pr.setCpf(cpfPr.getText());
                    pr.setTelefone(Integer.parseInt(telefonePr.getText()));
                    pr.setEmail(emailPr.getText());
                    pr.setRuralID(ruralIDPr.getText());

                    ProdutorControle prC = new ProdutorControle();
                    TCadPr.getApplication().messageBox("Cadastro Produtor",
                            prC.incluiProdutor(pr));

                } catch (Exception e) {
                    TCadPr.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }
    
    public void TelaAlterarProdutor() {
        TWindow TCadPr = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadPr.addLabel("Alterar Produtor", 0, linha);
        linha += 2;

        TCadPr.addLabel("nome", 0, linha);
        TField nomePr = new TField(TCadPr, 10, linha, 50, true);
        linha += 2;

        TCadPr.addLabel("enderaco", 0, linha);
        TField enderacoPr = new TField(TCadPr, 10, linha, 50, true);
        linha += 2;

        TCadPr.addLabel("cpf", 0, linha);
        TField cpfPr = new TField(TCadPr, 10, linha, 50, true);
        linha += 2;

        TCadPr.addLabel("telefone", 0, linha);
        TField telefonePr = new TField(TCadPr, 10, linha, 50, true);
        linha += 2;

        TCadPr.addLabel("email", 0, linha);
        TField emailPr = new TField(TCadPr, 10, linha, 50, true);
        linha += 2;

        TCadPr.addLabel("ruralID", 0, linha);
        TField ruralIDPr = new TField(TCadPr, 10, linha, 50, true);
        linha += 2;

        TCadPr.addButton("Alterar", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    Produtor pr = new Produtor();
                    pr.setNome(nomePr.getText());
                    pr.setEndereco(enderacoPr.getText());
                    pr.setCpf(cpfPr.getText());
                    pr.setTelefone(Integer.parseInt(telefonePr.getText()));
                    pr.setEmail(emailPr.getText());
                    pr.setRuralID(ruralIDPr.getText());

                    ProdutorControle prC = new ProdutorControle();
                    TCadPr.getApplication().messageBox("Alterar Produtor",
                            prC.AlteraProdutor(pr));

                } catch (Exception e) {
                    TCadPr.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }

    public void TelaListarVenda() {
        VendaControle vC = new VendaControle();
        TWindow TListVenda = new TWindow(this, "", 70, 20);
        TTableWidget tabVenda
                = new TTableWidget(TListVenda, 0, 2, 60, vC.contalinhas());
        tabVenda.setColumnLabel(0, "EmpresID");
        tabVenda.setColumnWidth(0, 10);
        tabVenda.setColumnLabel(1, "RuralID");
        tabVenda.setColumnWidth(1, 9);
        tabVenda.setColumnLabel(2, "Data");
        tabVenda.setColumnWidth(2, 6);
        tabVenda.setColumnLabel(3, "Hora");
        tabVenda.setColumnWidth(3, 6);
        tabVenda.setColumnLabel(4, "VendaID");
        tabVenda.setColumnWidth(4, 9);
        tabVenda.setColumnLabel(5, "");
        tabVenda.setColumnWidth(5, 1);

        int i = 0;
        for (Venda v : vC.ListarVenda()) {
            tabVenda.setCellText(0, i, "" + v.getEmpresaID());
            tabVenda.setCellText(1, i, "" + v.getRuralID());
            tabVenda.setCellText(2, i, "" + v.getDataVendido());
            tabVenda.setCellText(3, i, "" + v.getHoraVendida());
            tabVenda.setCellText(4, i, "" + v.getVendaID());
            i++;
        }
    }
    
    public void TelaExcluirVenda() {
        TWindow TCadVd = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadVd.addLabel("Excluir Venda", 0, linha);
        linha += 2;

        TCadVd.addLabel("VendaID", 0, linha);
        TField vendaIDPr = new TField(TCadVd, 10, linha, 50, true);
        linha += 2;

        TCadVd.addButton("Excluir", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    Venda v = new Venda();
                    v.setVendaID(vendaIDPr.getText());

                    VendaControle vdC = new VendaControle();
                    TCadVd.getApplication().messageBox("Excluir Venda",
                            vdC.ExcluiVenda(v.getVendaID()));

                } catch (Exception e) {
                    TCadVd.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }

    public void TelaCadastroVenda() {
        TWindow TCadVd = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadVd.addLabel("Cadastro de Venda", 0, linha);
        linha += 2;

        TCadVd.addLabel("empresaID", 0, linha);
        TField empresaIDPr = new TField(TCadVd, 13, linha, 50, true);
        linha += 2;

        TCadVd.addLabel("ruralID", 0, linha);
        TField ruralIDPr = new TField(TCadVd, 13, linha, 50, true);
        linha += 2;

        TCadVd.addLabel("dataVendido", 0, linha);
        TField dataVendidoPr = new TField(TCadVd, 13, linha, 50, true);
        linha += 2;

        TCadVd.addLabel("horaVendida", 0, linha);
        TField horaVendidaPr = new TField(TCadVd, 13, linha, 50, true);
        linha += 2;

        TCadVd.addLabel("vendaID", 0, linha);
        TField vendaIDPr = new TField(TCadVd, 13, linha, 50, true);
        linha += 2;

        TCadVd.addButton("Incluir", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    Venda v = new Venda();
                    v.setEmpresaID(empresaIDPr.getText());
                    v.setRuralID(ruralIDPr.getText());
                    v.setDataVendido(dataVendidoPr.getText());
                    v.setHoraVendida(horaVendidaPr.getText());
                    v.setVendaID(vendaIDPr.getText());

                    VendaControle vdC = new VendaControle();
                    TCadVd.getApplication().messageBox("Cadastro Venda",
                            vdC.incluiVenda(v));

                } catch (Exception e) {
                    TCadVd.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }
    
    public void TelaAlterarVenda() {
        TWindow TCadVd = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadVd.addLabel("Alterar Venda", 0, linha);
        linha += 2;

        TCadVd.addLabel("empresaID", 0, linha);
        TField empresaIDPr = new TField(TCadVd, 13, linha, 50, true);
        linha += 2;

        TCadVd.addLabel("ruralID", 0, linha);
        TField ruralIDPr = new TField(TCadVd, 13, linha, 50, true);
        linha += 2;

        TCadVd.addLabel("dataVendido", 0, linha);
        TField dataVendidoPr = new TField(TCadVd, 13, linha, 50, true);
        linha += 2;

        TCadVd.addLabel("horaVendida", 0, linha);
        TField horaVendidaPr = new TField(TCadVd, 13, linha, 50, true);
        linha += 2;

        TCadVd.addLabel("vendaID", 0, linha);
        TField vendaIDPr = new TField(TCadVd, 13, linha, 50, true);
        linha += 2;

        TCadVd.addButton("Alterar", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    Venda v = new Venda();
                    v.setEmpresaID(empresaIDPr.getText());
                    v.setRuralID(ruralIDPr.getText());
                    v.setDataVendido(dataVendidoPr.getText());
                    v.setHoraVendida(horaVendidaPr.getText());
                    v.setVendaID(vendaIDPr.getText());

                    VendaControle vdC = new VendaControle();
                    TCadVd.getApplication().messageBox("Alterar Venda",
                            vdC.AlteraVenda(v));

                } catch (Exception e) {
                    TCadVd.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }
    
     public void TelaImprimir() {
        TWindow TCadVd = new TWindow(this, "", 50, 25);
        int linha = 0;

        TCadVd.addLabel("Imprimir PDF Relatório", 0, linha);
        linha += 2;

        TCadVd.addButton("Confirmar", 20, linha, new TAction() {
            @Override
            public void DO() {
                try {
                    Relatorio r = new Relatorio();
                    r.arq();
                    //r.abrearquivo01("relatorio.pdf");
                    //VendaControle vdC = new VendaControle();
                    /*TCadVd.getApplication().messageBox("Alterar Venda",
                            vdC.AlteraVenda(v));*/

                } catch (Exception e) {
                    TCadVd.getApplication().messageBox("Erro",
                            e.getMessage());

                }
            }
        });

    }

    public boolean onMenu(TMenuEvent evento) {
        switch (evento.getId()) {
            /*menucad.addItem(1001, "&Comerciante");
        menucad.addItem(1002, "&Produto");
        menucad.addItem(1003, "&Produtor");
        menucad.addItem(1004, "&Venda");*/
            case 1001:
                TelaCadastroComerciante();
                return true;
            case 1002:
                TelaCadastroProduto();
                return true;
            case 1003:
                TelaCadastroProdutor();
                return true;
            case 1004:
                TelaCadastroVenda();
                return true;
            case 1005:
                TelaCadastroItensVenda();
                return true;
                //------
            case 2001:
                TelaListarComerciante();
                return true;
            case 2002:
                TelaListarProduto();
                return true;
            case 2003:
                TelaListarProdutor();
                return true;
            case 2004:
                TelaListarVenda();
                return true;
            case 2005:
                TelaListarItensVenda();
                return true;
                //------
            case 3000:
                //Sair
                exit();
                return true;
            case 3001:
                TelaExcluirComerciante();
                return true;
            case 3002:
                TelaAlterarComerciante();
                return true;
            case 3003:
                TelaExcluirVenda();
                return true;
            case 3004:
                TelaAlterarVenda();
                return true;
            case 3005:
                TelaExcluirProduto();
                return true;
            case 3006:
                TelaAlterarProduto();
                return true;
            case 3007:
                TelaExcluirProdutor();
                return true;
            case 3008:
                TelaAlterarProdutor();
                return true;
            case 3009:
                TelaExcluirItensVenda();
                return true;
            case 3010:
                TelaAlterarItensVenda();
                return true;
            case 3011:
                TelaImprimir();
                return true;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        SistemaGrafico app = new SistemaGrafico();
        app.run();
    }

}
