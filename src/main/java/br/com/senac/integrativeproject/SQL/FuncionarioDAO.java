package br.com.senac.integrativeproject.SQL;

import br.com.senac.integrativeproject.Conexao;
import br.com.senac.integrativeproject.Funcionario;

import java.sql.*;
import java.util.ArrayList;

public class FuncionarioDAO {

    /**
     * Metodo para transferir as informações digitado pelo
     * usuário para os banco de dados.
     *
     * @param funcionario um atributo do tipo funcionario contendo
     *                    as informações.
     */
    public void inserir(Funcionario funcionario) {
        try {
            Connection con = Conexao.getConexao();
            try {
                PreparedStatement pstmt = con.prepareStatement("insert into tb_funcionario(id_func, " +
                        "cpf_func, nome_func, endereco_func, telefone_func, email_func, " +
                        "senha_func) values (?,?,?,?,?,?,?)");
                pstmt.setInt(1, funcionario.getIdentificaçãoDocadastro());
                pstmt.setString(2, funcionario.getCpf());
                pstmt.setString(3, funcionario.getNome());
                pstmt.setString(4, funcionario.getEndereco());
                pstmt.setString(5, funcionario.getTelefone());
                pstmt.setString(6, funcionario.getEmail());
                pstmt.setString(7, funcionario.getSenha());
                pstmt.executeUpdate();
            } finally {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que verifica o nome e a senha digitado pelo usuário e
     * compara com nome e a senha cadastrados no banco de dados.
     *
     * @param userName o nome do usuario digitado.
     * @param senha a senha do usuário digitado.
     * @return true se o nome e a senha coincidir com o nome e a
     * senhas cadastrados no banco de dados.
     */
    public boolean listar(String userName, String senha) {
        try {
            Connection con = Conexao.getConexao();
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select nome_func,senha_func from tb_funcionario");
                while (rs.next()) {
                    if (userName.equals(rs.getString("nome_func"))
                            && senha.equals(rs.getString("senha_func")))
                        return true;
                }

            } finally {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }


    /**
     * Método que cria uma lista de usuários cadastrados no
     * banco de dados.
     *
     * @return a lista dos usuários cadastrados no banco de dados.
     */
    public ArrayList<Funcionario> listar(){
        try {
            Connection con = Conexao.getConexao();
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select * from tb_funcionario");

                ArrayList<Funcionario> funcionario = new ArrayList<>();
                while(rs.next()){
                    funcionario.add(new Funcionario(rs.getString("nome_func"),
                            rs.getString("email_func"),rs.getString("telefone_func"),
                            rs.getString("cpf_func"),rs.getString("senha_func"),
                            rs.getString("endereco_func")));
                }
                return funcionario;
            } finally {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
