package br.com.senac.integrativeproject.SQL;

import br.com.senac.integrativeproject.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorDeVendasDAO {

    /**
     * Método que verifica o nome e a senha digitado pelo usuário e
     * compara com nome e a senha cadastrados no banco de dados.
     *
     * @param userName o nome do usuario digitado.
     * @param senha a senha do usuário digitado.
     * @return true se o nome e a senha coincidir com o nome e a
     * senha cadastrados no banco de dados.
     */
    public boolean listar(String userName, String senha) {
        try {
            Connection con = Conexao.getConexao();
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select nome_gest,senha_gest from tb_gestor");
                while (rs.next()) {
                    if (userName.equals(rs.getString("nome_gest"))
                            && senha.equals(rs.getString("senha_gest")))
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
     * Método que verifica somente a senha digitado pelo usuário e
     * compara as senha cadastrados no banco de dados.
     *
     * @param senha a senha do usuário digitado.
     * @return true se a senha coincidir com a senha
     * cadastrados no banco de dados.
     */
    public boolean listar(String senha) {
        try {
            Connection con = Conexao.getConexao();
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select senha_gest from tb_gestor");
                while (rs.next()) {
                    if (senha.equals(rs.getString("senha_gest")))
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
}
