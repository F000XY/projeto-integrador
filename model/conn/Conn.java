package projetointegradorConn.model.conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conn {

    public static Connection getConexao() {
        try {
            String endereco = "jdbc:mysql://localhost:3306/ztech";
            String usuario = "root";
            String senha = "teste2024";

            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelecer a conexão
            Connection conectar = DriverManager.getConnection(endereco, usuario, senha);

            // Retorna a conexão estabelecida
            return conectar;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e);
        } catch (SQLException e) {
            System.out.println("Erro ao tentar conectar-se: " + e);
        }

        return null;
    }

}