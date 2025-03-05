package br.com.senac.integrativeproject;

public class Cliente  extends Pessoa{

    public Cliente(String nome, String email, String telefone,
                   String cpf, String endereco) {
        super(nome, email, telefone, cpf ,endereco);
        identificaçãoDocadastro = (int)(Math.random() * 999999 ) + 1;
        identificaçãoDocadastro += 2000000;
    }
}

