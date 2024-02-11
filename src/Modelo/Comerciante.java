package Modelo;

public class Comerciante {
    private String nome;
    private String enderaco;
    private String cpf;
    private int telefone;
    private String email;
    private String cnpj;
    private String empresaID;

    public Comerciante(String nome, String enderaco, String cpf, int telefone, String email, String cnpj, String empresaID) {
        this.nome = nome;
        this.enderaco = enderaco;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.cnpj = cnpj;
        this.empresaID = empresaID;
    }

    public Comerciante() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnderaco() {
        return enderaco;
    }

    public void setEnderaco(String enderaco) {
        this.enderaco = enderaco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmpresaID() {
        return empresaID;
    }

    public void setEmpresaID(String empresaID) {
        this.empresaID = empresaID;
    }

    public String toString() {
        return "Nome: " + nome + "\nEnderaco: " + enderaco + "\nCPF: " + cpf + 
                "\nTelefone: " + telefone + "\nEmail: " + email + "\nCNPJ: " + cnpj + "\nEmpresaID: " + empresaID;
    }
    
}
