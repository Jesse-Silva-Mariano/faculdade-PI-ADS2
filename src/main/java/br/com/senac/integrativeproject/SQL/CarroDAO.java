package br.com.senac.integrativeproject.SQL;

import br.com.senac.integrativeproject.Conexao;
import br.com.senac.integrativeproject.Carro;

import java.sql.*;
import java.util.ArrayList;

public class CarroDAO {

    /**
     * Metodo para transferir as informações digitado pelo
     * usuário para os banco de dados.
     *
     * @param carro um atributo do tipo carro contendo
     *             as informações.
     */
    public void inserir(Carro carro) {
        try {
            Connection con = Conexao.getConexao();
            try {
                PreparedStatement pstmt = con.prepareStatement("insert into tb_carro(id_car, modelo_car, marca_car, " +
                        "ano_car, serial_car) values (?,?,?,?,?)");
                pstmt.setInt(1, carro.getIdentificaçãoSerial());
                pstmt.setString(2, carro.getMarca());
                pstmt.setString(3, carro.getModelo());
                pstmt.setString(4, carro.getAno());
                pstmt.setString(5, carro.getSerial());
                pstmt.executeUpdate();
            } finally {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que cria uma lista de carros cadastrados no
     * banco de dados.
     *
     * @return a lista dos carros cadastrados no banco de dados.
     */
    public ArrayList<Carro> listar(){
        try {
            Connection con = Conexao.getConexao();
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select * from tb_carro");

                ArrayList<Carro> carros = new ArrayList<>();
                while(rs.next()){
                    carros.add(new Carro(rs.getString("modelo_car"),rs.getString("marca_car"),
                            rs.getString("ano_car"),rs.getString("serial_car")));
                }
                    return carros;
            } finally {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
