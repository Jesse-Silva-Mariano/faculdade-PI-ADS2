package br.com.senac.integrativeproject;

public class Funcionario extends Pessoa{

    private String senha;
    public Funcionario(String nome, String email, String telefone, String cpf,
                       String senha, String endereco) {
        super(nome, email, telefone, cpf, endereco);
        this.senha = senha;
        identificaçãoDocadastro = (int)(Math.random() * 999999 ) + 1;
        identificaçãoDocadastro += 1000000;

    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {

        this.senha = senha;
    }

    @Override
    public String toString() {
        return  super.toString() + " _Senha: " + this.getSenha();
    }
}


