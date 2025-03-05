package br.com.senac.integrativeproject;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public static Connection getConexao(){
        try { Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","09072000");
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}