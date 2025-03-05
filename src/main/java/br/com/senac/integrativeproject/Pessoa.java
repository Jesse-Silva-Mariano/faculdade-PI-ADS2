package br.com.senac.integrativeproject;

public abstract class Pessoa {
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String endereco;
    protected int identificaçãoDocadastro;

    public Pessoa(String nome, String email, String telefone, String cpf,
                       String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getIdentificaçãoDocadastro() {
        return identificaçãoDocadastro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setIdentificaçãoDocadastro(int identificaçãoDocadastro) {
        this.identificaçãoDocadastro = identificaçãoDocadastro;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + " _Email: " + this.getEmail() + " _Telefone: " + this.getTelefone() +
                " _CPF: " + this.getCpf() + " _Endereço: " + this.getEndereco();
    }
}
