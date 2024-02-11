package Modelo;

public class Produtor {
    private String nome;
    private String endereco;
    private String cpf;
    private int telefone;
    private String email;
    private String ruralID;

    public Produtor(String nome, String endereco, String cpf, int telefone, String email, String ruralID) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.ruralID = ruralID;
    }

    public Produtor() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getRuralID() {
        return ruralID;
    }

    public void setRuralID(String ruralID) {
        this.ruralID = ruralID;
    }

    public String toString() {
        return "Nome: " + nome + "\nEndereco: " + endereco + "\nCPF: " + cpf + 
                "\nTelefone: " + telefone + "\nEmail: " + email + "\nRuralID: " + ruralID;
    }

}
